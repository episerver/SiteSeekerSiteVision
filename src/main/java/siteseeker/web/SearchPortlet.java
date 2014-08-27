package siteseeker.web;

import javax.jcr.Node;
import javax.jcr.NodeIterator;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.MalformedURLException;
import java.util.Enumeration;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Locale;

import javax.portlet.ActionResponse;
import javax.portlet.ActionRequest;
import javax.portlet.PortletConfig;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.VelocityContext;

import org.apache.commons.logging.LogFactory;

import siteseeker.search.SearcherFacade;
import siteseeker.search.SearchIndexInfo;
import siteseeker.search.WSConnectionInfo;
import siteseeker.util.TimeLogger;
import siteseeker.ws.SearchResponse;
import siteseeker.web.lang.ResourceBundleWrapper;

import senselogic.sitevision.api.Utils;
import senselogic.sitevision.api.property.PropertyUtil;
import senselogic.sitevision.api.client.ClientUtil;
import senselogic.sitevision.api.context.PortletContextUtil; 
import senselogic.sitevision.api.node.NodeTreeUtil;

/**
 * A search portlet that uses the SiteSeeker web service.
 *
 * @author B. Andrist
 * @version $Revision$
 */
public class SearchPortlet extends SiteVisionDispatcher {

  private String versionInfo;
  private PortletContext portletContext;
  private VelocityTemplateManager viewTemplateManager;
  private VelocityTemplateManager configTemplateManager;
  
  // Initialize portlet instance
  // Load default templates from .vm-files
  public void init(PortletConfig cfg) throws PortletException {
    super.init(cfg);
    LogFactory.getLog(getClass()).debug("init START");
    portletContext = cfg.getPortletContext();
    try {
      VelocityEngine engine = VelocityTemplateManager.getVelocityEngine(portletContext);
      viewTemplateManager = new VelocityTemplateManager(engine, "search-page", "search-page.vm");
      viewTemplateManager.addTemplate("form",          "form.vm");
      viewTemplateManager.addTemplate("advanced-form", "advanced-form.vm");
      viewTemplateManager.addTemplate("best-bets",     "best-bets.vm");
      viewTemplateManager.addTemplate("hits",          "hits.vm");
      viewTemplateManager.addTemplate("page-numbers",  "page-numbers.vm");    
      viewTemplateManager.addTemplate("overview",      "overview.vm");    
      configTemplateManager = new VelocityTemplateManager(engine, "config", "config.vm");
    } catch (IOException e) {
      LogFactory.getLog(getClass()).error
        ("Failed to load Velocity templates:" + e);
    } catch (Exception e) {
      LogFactory.getLog(getClass()).error
        ("Error configuring the VelocityEngine: " + e.getMessage());
    }
    
    // Fetch version information from disk
    try {
        if(versionInfo==null) {
            fetchVersionInfoFromDisk();
        }
        portletContext.setAttribute("versionInfo", versionInfo);
    } catch (IOException e) {
      LogFactory.getLog(getClass()).error("Error getting version info: " + e);
    }
    LogFactory.getLog(getClass()).debug("Version info: " + versionInfo);
    LogFactory.getLog(getClass()).debug("init END");
  }

    private void fetchVersionInfoFromDisk() throws IOException {
        InputStream in = getClass().getClassLoader().getResourceAsStream("version.txt");
        versionInfo = SearchPortlet.getFileContent(in);
    }

    public void setVersionInfo(String versionInfo) {
        this.versionInfo = versionInfo;
    }

    // Render the search page. All search requests are handled here.
  protected void doView(RenderRequest renderRequest, 
                        RenderResponse renderResponse)
    throws PortletException, IOException {
    LogFactory.getLog(getClass()).debug("doView START (portletId = " + getPortletId(renderRequest) + ")");
    TimeLogger timer = new TimeLogger(LogFactory.getLog(getClass()));
    renderResponse.setContentType("text/html; charset=UTF-8");
    LogFactory.getLog(getClass()).debug(renderResponse.getCharacterEncoding());
    
    // Parse search parameters and construct a search url
    // representing the current state of the search page
    String remoteAddress = getClientIpAddress(renderRequest);
    PortletPreferences preferences = renderRequest.getPreferences();
    // Remove parameter sv.url from url to disable portlet instance specific requests.
    String portletUrl = renderResponse.createRenderURL().toString().replaceFirst("\\?sv\\.url=[^&]+", "");
    String portletUrlPrefix = "s" + getPortletShortId(renderRequest) + "_";
    SearchUrl searchUrl = 
      new SearchUrl(portletUrlPrefix, portletUrl,
                    new PortletRequestParameters(renderRequest),
                    remoteAddress); 
    if (handleDiagnosticQueries(searchUrl, renderResponse, preferences)) {
      return;
    }
    // Send query with params to SiteSeeker 
    SearchResponse searchResponse = null;
    VelocityContext ctx = null;
    SearchIndexInfo info = null;
    String queryExtension = preferences.getValue("queryExtension", "");

    // If a query, then always do a search request. 
    // If the auto query preference does not exist, it defaults to "on". If it is set, it has the value "on". Else it is an empty string.
    // If the value is "on" we do a search request.
    if ( ! "".equals(searchUrl.getQuery()) || "on".equals(preferences.getValue("autoQuery", "on")) ) {
      try {
        String interfaceLanguage = renderRequest.getLocale().getLanguage();
        LogFactory.getLog(getClass()).debug("Using interface language: '" + interfaceLanguage + "'");
        SearcherFacade facade = getSearcherFacade(portletContext, renderRequest, interfaceLanguage);
        searchResponse = facade.search(searchUrl, queryExtension, remoteAddress);
        info = facade.getSearchIndexInfo();
        LogFactory.getLog(getClass()).debug("Got SearchIndexInfo: " + info);
      } catch (MalformedURLException e) {
        LogFactory.getLog(getClass()).debug("MalformedURLException: " + e);
        if (portletIsInPreviewMode(renderRequest)) {
          ResourceBundleWrapper rbw = createResourceBundleWrapper("warnings", renderRequest.getLocale());
          printError(rbw.get("warning-wrongurl"), renderResponse, preferences, e);
        }
        return;
      } catch (PortletNotConfiguredException e) {
        LogFactory.getLog(getClass()).debug("PortletNotConfiguredException: " + e);
        if (portletIsInPreviewMode(renderRequest)) {
          printNotConfigured(renderResponse, preferences, e);
        }
        return;
      } catch (Exception e) {
        if (portletIsInPreviewMode(renderRequest)) {
          LogFactory.getLog(getClass()).error("Error while searching: " + 
                e + ": " + 
                SearchPortlet.getStackTrace(e));
          ResourceBundleWrapper rbw = createResourceBundleWrapper("warnings", renderRequest.getLocale());
          printError(rbw.get("warning-unknownerror"), renderResponse, preferences, e);
        }
        return;
      }
      timer.logCurrentTime("search");

      if ("siteseeker:version".equals(searchUrl.getQuery())) {
        renderResponse.getWriter().println("<p><strong>");
        renderResponse.getWriter().println(versionInfo);
        renderResponse.getWriter().println("</strong></p>");
        renderResponse.getWriter().println(searchResponse.getMessage());
        return;
      }

      ctx = createVelocityContext(searchUrl, portletUrl, searchResponse, info, renderRequest, queryExtension, portletUrlPrefix);
    } else {
      ctx = createVelocityContext(searchUrl, portletUrl, null, info, renderRequest, queryExtension, portletUrlPrefix);
    }
    viewTemplateManager.render(preferences, ctx, renderResponse.getWriter());
    timer.logCurrentTime("renderTemplate");
    LogFactory.getLog(getClass()).debug("doView END");
  }
  private static String getStackTrace(Throwable t) {
    final java.io.Writer result = new java.io.StringWriter();
    final java.io.PrintWriter printWriter = new java.io.PrintWriter(result);
    t.printStackTrace(printWriter);
    return result.toString();
  }

  private String getPortletId(RenderRequest request) {
    // Retrieve an Utils instance from the SiteVision Utility API
    Utils utils = (Utils) request.getAttribute("sitevision.utils");
    // Get an unique id based on the namespace of the portlet
    PortletContextUtil ctxUtil = utils.getPortletContextUtil();
    String portletId = ctxUtil.getPortletNamespace("");
    return portletId;
  }
  private String getClientIpAddress(RenderRequest request) {
    // Retrieve SiteVision Utility API
    Utils sitevisionUtils = (Utils)request.getAttribute("sitevision.utils"); 
    ClientUtil clientUtil = sitevisionUtils.getClientUtil();
    String clientIp = clientUtil.getClientAddress();
    return clientIp;
  }

  private VelocityContext createVelocityContext(
      SearchUrl searchUrl,
      String portletUrl,
      SearchResponse searchResponse,
      SearchIndexInfo searchIndexInfo,
      RenderRequest renderRequest,
			String queryExtension, String portletUrlPrefix) {
    LogFactory.getLog(getClass()).debug("DEBUG: createVelocityContext");
    String portletId = getPortletId(renderRequest);
    // Fill velocity context with the search response
    VelocityContext context = new VelocityContext();
    context.put("sessionId", searchUrl.getSessionId());
    context.put("portletId", portletId);	
    ///    context.put("paramPrefix", portletUrlPrefix);
    context.put("uiLanguage", renderRequest.getLocale().getLanguage());
    context.put("url", portletUrl);
    context.put("requestParameters", new URLRequestParameters(portletUrlPrefix));
    context.put("util", new SearchPortletUtil());
    if (searchResponse != null) {
      context.put("message", searchResponse.getMessage());
      context.put("query", StringEscapeUtils.escapeHtml(searchUrl.getQuery()));
      //            context.put("searchPortletUtil", new SearchPortletUtil());

      String uiLanguage = renderRequest.getLocale().getLanguage();
      String uniquePortletId = portletId + uiLanguage;
      String extension = "".equals(searchUrl.getQuery()) ? queryExtension : "";
      FilterBuilder builder = new FilterBuilder(searchIndexInfo, searchResponse, searchUrl);
      context.put("languages", builder.buildLanguages());
      context.put("fileFormats", builder.buildFileFormats());
      context.put("ages", builder.buildAges());
      context.put("categoryGroups", builder.buildCategoryGroups());
      context.put("sortOrders", builder.buildSortOrders());
      context.put("searchPageId",searchUrl.getSearchPageId());
      context.put("bestBets", builder.buildBestBets());
      context.put("spellingSuggestions", builder.buildSpellingSuggestions());
      context.put("hits", builder.buildHits(uniquePortletId, uiLanguage, extension));
      context.put("pageLinks", builder.buildPageLinks());
    } else {
      context.put("message", "");
      context.put("query", "");
    }
    
    context.put("lang", new ResourceBundleWrapper
                (ResourceBundle.getBundle("siteseeker.web.lang.search", 
                                          renderRequest.getLocale())));
    addVelocityTools(context);
    return context;
  }

  // Process actions (form submits) from config mode 
  // (because we always use doView (HTTP GET) for the search page)
  public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
    throws PortletException, IOException {
    if (StringUtils.isNotEmpty(actionRequest.getParameter("cancel"))) {
      LogFactory.getLog(getClass()).debug("processAction - cancel");
      actionResponse.setPortletMode(PortletMode.VIEW);
      return;
    }

    LogFactory.getLog(getClass()).debug("processAction START");
    logAllParameters(actionRequest);

    if (hasWritePermission(actionRequest)) {
      PortletPreferences preferences = actionRequest.getPreferences();

      viewTemplateManager.updateCustomTemplateInfo(actionRequest, preferences);
      // TODO: Validate form data
      String queryExtension = actionRequest.getParameter("query-extension");
      if (queryExtension != null)
        preferences.setValue("queryExtension", queryExtension);
      String autoQuery = actionRequest.getParameter("auto-query");
      if (autoQuery != null)
        preferences.setValue("autoQuery", "on");
      else
        preferences.setValue("autoQuery", "");
      String wsUrl = actionRequest.getParameter("ws-url");
      if (wsUrl != null)
        preferences.setValue("wsUrl", wsUrl);
      String wsUsername = actionRequest.getParameter("ws-username");
      if (wsUsername != null)
        preferences.setValue("wsUsername", wsUsername);
      String wsPassword = actionRequest.getParameter("ws-password");
      if (!WSConnectionInfo.HIDDEN_PASSWORD.equals(wsPassword)) {
        preferences.setValue("wsPassword", wsPassword);
      }
      preferences.store(); // Save preferences
    }

    LogFactory.getLog(getClass()).debug("processAction - save and close");
    actionResponse.setPortletMode(PortletMode.VIEW); 
    LogFactory.getLog(getClass()).debug("processAction END");
  }

  // Render config mode
  protected void doConfig(RenderRequest renderRequest, RenderResponse renderResponse)
    throws PortletException, IOException {
    LogFactory.getLog(getClass()).debug("doConfig START");
    renderResponse.setContentType("text/html; charset=UTF-8");
    if (hasWritePermission(renderRequest)) {
      PortletPreferences preferences = renderRequest.getPreferences();
      VelocityContext context = new VelocityContext();
      context.put("templates", viewTemplateManager.getCustomTemplates(preferences));
      context.put("url", renderResponse.createActionURL().toString());
      context.put("encoder", new HTMLEncoder());
      context.put("queryExtension", preferences.getValue("queryExtension", ""));
      context.put("autoQuery", preferences.getValue("autoQuery", "on"));
      context.put("portletId", getPortletId(renderRequest));
      String password = preferences.getValue("wsPassword", "");
      if (StringUtils.isNotEmpty(password)) {
        password = WSConnectionInfo.HIDDEN_PASSWORD;
      }
      context.put("connection", 
                  new WSConnectionInfo(preferences.getValue("wsUrl", ""),
                                       preferences.getValue("wsUsername", ""),
                                       password));
      context.put("lang", new ResourceBundleWrapper
                  (ResourceBundle.getBundle("siteseeker.web.lang.editmode", 
                                            renderRequest.getLocale())));
      if (isPageExcludedFromIndexing(renderRequest)) {
        LogFactory.getLog(getClass()).debug("DEBUG: do not write warning");
      } else {
        String warningStr="WARNING_PAGE_VISIBLE_TO_SEARCH_ENGINES";
        context.put("warning",warningStr);
      }
      try {
        configTemplateManager.render(null, context, renderResponse.getWriter());
      } catch (Exception e) {
        LogFactory.getLog(getClass()).error("Failed to render config template: " + e);
      }
    } else {
      renderResponse.getWriter().println("<strong>You are not allowed to update the portlet configuration</strong>");
    }
    LogFactory.getLog(getClass()).debug("doConfig END");
  }
  protected static String getFileContent(InputStream in) 
    throws IOException {
    LogFactory.getLog(SearchPortlet.class).debug("getFileContent");
    StringBuilder sb = new StringBuilder(1024);
    BufferedReader reader = new BufferedReader(new InputStreamReader(in,"UTF-8"));
    String line;
    while((line = reader.readLine()) != null) {
      sb.append(line + "\n");
    }
    reader.close();
    return sb.toString();
  }
  private boolean isPageExcludedFromIndexing(PortletRequest request) {
    // robotsIndex   	javax.jcr.PropertyType.BOOLEAN
    // displayName   	javax.jcr.PropertyType.STRING
    try {
      Utils sitevisionUtils = (Utils)request.getAttribute("sitevision.utils"); 
      PortletContextUtil context = sitevisionUtils.getPortletContextUtil();
      javax.jcr.Node page = context.getCurrentPage();
      PropertyUtil propertyUtil = sitevisionUtils.getPropertyUtil();
      String displayName = propertyUtil.getString(page,"displayName");
      if (page != null) {
        if (propertyUtil.getBoolean(page,"robotsIndex") ){
          LogFactory.getLog(getClass()).debug("DEBUG: (page " + displayName + ") robotsIndex = TRUE, the page may be indexed by a web robot" );
          return false;
        }else{
          LogFactory.getLog(getClass()).debug("DEBUG: (page " + displayName + ") robotsIndex = FALSE, the page may NOT be indexed by a web robot" );
          return true;
        }
      }
    } catch (Exception e) {
      LogFactory.getLog(getClass()).debug(e);
    }
    return false; 
  }

  private void addVelocityTools(VelocityContext context) {
    context.put("number", new org.apache.velocity.tools.generic.NumberTool());
    context.put("alternator", new org.apache.velocity.tools.generic.AlternatorTool());
    context.put("context", new org.apache.velocity.tools.generic.ContextTool());
    context.put("conversion",new org.apache.velocity.tools.generic.ConversionTool());
    context.put("date", new org.apache.velocity.tools.generic.DateTool());
    context.put("comparisonDate", new org.apache.velocity.tools.generic.ComparisonDateTool());
    context.put("display", new org.apache.velocity.tools.generic.DisplayTool());
    context.put("escape", new org.apache.velocity.tools.generic.EscapeTool());
    context.put("field", new org.apache.velocity.tools.generic.FieldTool());
    context.put("loop", new org.apache.velocity.tools.generic.LoopTool());
    context.put("link", new org.apache.velocity.tools.generic.LinkTool());
    context.put("list", new org.apache.velocity.tools.generic.ListTool());
    context.put("math", new org.apache.velocity.tools.generic.MathTool());
    context.put("number", new org.apache.velocity.tools.generic.NumberTool());
    context.put("render", new org.apache.velocity.tools.generic.RenderTool());
    context.put("resource", new org.apache.velocity.tools.generic.ResourceTool());
    context.put("sort", new org.apache.velocity.tools.generic.SortTool());
    context.put("xml", new org.apache.velocity.tools.generic.XmlTool());
  }

  private void findChildNodesByPortletName(String name, javax.jcr.Node node, PropertyUtil propertyUtil, List<javax.jcr.Node> foundNodes) 
    throws javax.jcr.RepositoryException {
    javax.jcr.NodeIterator nodes = node.getNodes();
    while (nodes.hasNext()) {
      javax.jcr.Node n = nodes.nextNode();
      if (n.getPrimaryNodeType().isNodeType("sv:portlet")) {
        if (name.equals(propertyUtil.getString(n, "portletName"))) {
          foundNodes.add(n);
        } 
      } else {
        findChildNodesByPortletName(name, n, propertyUtil, foundNodes);
      }
    }
  }

  private javax.jcr.Node getPageContentNode(javax.jcr.Node page)
    throws javax.jcr.RepositoryException {
    javax.jcr.NodeIterator nodes = page.getNodes();
    while (nodes.hasNext()) {
      javax.jcr.Node n = nodes.nextNode();
      if (n.getPrimaryNodeType().isNodeType("sv:pageContent")) {
        return n;
      }		
    }
    return null;
  }

  private int getPortletShortId(PortletRequest request) {
    try {
      Utils sitevisionUtils = (Utils)request.getAttribute("sitevision.utils"); 
      PortletContextUtil context = sitevisionUtils.getPortletContextUtil();
      Node page = context.getCurrentPage();
      PropertyUtil propertyUtil = sitevisionUtils.getPropertyUtil();
      Node portlet = context.getCurrentPortlet();
      Node pageContentNode = getPageContentNode(page);
      if (pageContentNode != null) {
        List<Node> portlets = new ArrayList<Node>();
        findChildNodesByPortletName("siteseeker-search", 
                                    pageContentNode, 
                                    propertyUtil, portlets);
        int id = 0;
        for (Node p : portlets) {
          if (p.equals(portlet)) {
            return id;
          }
          id++;
        }
      }
    } catch (Exception e) {
      LogFactory.getLog(getClass()).error(e);
    }
    return 0; 
  }

  private void logAllParameters(PortletRequest request) {
    for (Enumeration names = request.getParameterNames(); 
         names.hasMoreElements(); ) {
      String name = (String)names.nextElement();
      String value = request.getParameter(name);
      LogFactory.getLog(getClass()).debug("name: " + name +
                                          ", value: " + ((value.length() > 20)?(value.substring(0, 20) + "..."):value));
    }
  }

  private WSConnectionInfo getConnectionInfo(PortletPreferences preferences) {
    return new WSConnectionInfo(preferences.getValue("wsUrl", ""),
                                preferences.getValue("wsUsername", ""),
                                preferences.getValue("wsPassword", ""));
  }

  private SearcherFacade getSearcherFacade(PortletContext context, 
                                           RenderRequest request, 
                                           String lang) 
    throws Exception, PortletNotConfiguredException {
    WSConnectionInfo con = getConnectionInfo(request.getPreferences());
    if (StringUtils.isEmpty(con.getUrl()))
      throw new PortletNotConfiguredException();
    synchronized(context) {
      SearcherFacade facade = (SearcherFacade)context.getAttribute("searcherFacade" + lang + con.getUrl());
      if (facade == null) {
        facade = new SearcherFacade(con, lang, versionInfo);
        context.setAttribute("searcherFacade" + lang + con.getUrl(), facade);
      }
      context.setAttribute(getPortletId(request) + lang, facade);
      return facade;
    }

  }

  private boolean handleDiagnosticQueries(SearchUrl searchUrl, 
                                          RenderResponse renderResponse,
                                          PortletPreferences preferences)
    throws IOException {
    String q = searchUrl.getQuery();
    /*if ("siteseeker:print-templates".equals(q)) {
      renderResponse.getWriter().println("<h2>Search templates</h2><br/>");
      for (CustomVelocityTemplateInfo tmpl : viewTemplateManager.getCustomTemplates(preferences)) {
        renderResponse.getWriter().println("<h3>" + tmpl.getName() + " (" 
                                           + (tmpl.getUseCustom()? "custom": "default") 
                                           + ")</h3>");
        String template = StringEscapeUtils.escapeXml(tmpl.getContent());
        template = appendLineNumbers(template);
        renderResponse.getWriter().println("<pre>" + template + "</pre>");
      }
      return true;
    } else */if ("siteseeker:module-version".equals(q)) {
      renderResponse.getWriter().println("<p>");
      renderResponse.getWriter().println(versionInfo);
      renderResponse.getWriter().println("</p>");
      return true;
    }

    return false;
  }

  private boolean portletIsInPreviewMode(RenderRequest request) {
    Utils sitevisionUtils = (Utils)request.getAttribute("sitevision.utils"); 
    PortletContextUtil context = sitevisionUtils.getPortletContextUtil();
    return (context.getCurrentVersion() == PortletContextUtil.OFFLINE_VERSION);
  }

  private void printError(String message,
                          RenderResponse renderResponse,
                          PortletPreferences preferences, 
                          Exception exception) 
    throws IOException {
    ResourceBundleWrapper rbw = createResourceBundleWrapper("warnings", renderResponse.getLocale());
    renderResponse.getWriter().println("<h2>" + rbw.get("warning-searchnotexecuted") + "</h2>");
    renderResponse.getWriter().println("<p>(" + message + ")</p>");
    renderResponse.getWriter().println("<p> " + rbw.get("warning-error") + ":"  + exception + "</>");
    renderResponse.getWriter().println("<p> " + rbw.get("warning-message") + ": " + exception.getMessage() + "</p>");
  }

  private void printNotConfigured(RenderResponse renderResponse,
                                  PortletPreferences preferences, 
                                  Exception exception) 
    throws IOException {
    ResourceBundleWrapper rbw = createResourceBundleWrapper("warnings", renderResponse.getLocale());
    renderResponse.getWriter().println("<h2>" + rbw.get("warning-searchmodulenotconfigured") + "</h2>");
    renderResponse.getWriter().println("<p>" + rbw.get("warning-searchmodulehowtoconfigure") + "</p>");
    renderResponse.getWriter().println("<p><em>" + rbw.get("warning-removepopupblock") + "</em></p>");
  }

  public static final String appendLineNumbers(String s){
    StringBuffer sb = new StringBuffer();
    int n = s.length();
    int lineNumber = 1;
    sb.append(lineNumber++ + " :");
    for (int i = 0; i < n; i++) {
      char c = s.charAt(i);
      sb.append(c);
      if (c == '\n') {
        sb.append(lineNumber++ + ": ");
      }
    }
    return sb.toString();
  }

  private ResourceBundleWrapper createResourceBundleWrapper(String resource, Locale locale){ 
    return  new ResourceBundleWrapper(ResourceBundle.getBundle("siteseeker.web.lang." + resource,locale));
  }

}

class PortletRequestParameters implements RequestParameters {

  private PortletRequest request;

  public PortletRequestParameters(PortletRequest request) {
    this.request = request;
  }
  public String getValue(String name) {
    return request.getParameter(name);
  }
  public String[] getValues(String name) {
    return request.getParameterValues(name);
  }
  @SuppressWarnings({"unchecked"})
  public java.util.Enumeration<String> getParameterNames() {
    return request.getParameterNames();
  }
}

