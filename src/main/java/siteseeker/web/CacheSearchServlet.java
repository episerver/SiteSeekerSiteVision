package siteseeker.web;

import java.io.IOException;
import java.io.StringWriter;

import java.util.ResourceBundle;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import siteseeker.ws.CachedPageResponse;
import siteseeker.search.SearcherFacade;
import siteseeker.web.lang.ResourceBundleWrapper;


/**
 * Servlet to serve cached pages
 *
 */
@SuppressWarnings("serial")
public class CacheSearchServlet extends HttpServlet {

  private ServletContext servletContext;

  /**
   * {@inheritDoc}
   */
  public void init(ServletConfig cfg) throws ServletException {
    super.init(cfg);
    LogFactory.getLog(getClass()).debug("init START");
    servletContext = cfg.getServletContext();
    LogFactory.getLog(getClass()).debug("init START");
  }
    
  /**
   * {@inheritDoc}
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    doGet(request, response);
  }

  /**
   * {@inheritDoc}
   */
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    LogFactory.getLog(getClass()).debug("doGet START");
    String versionInfo = (String)servletContext.getAttribute("versionInfo");
    LogFactory.getLog(getClass()).debug("versionInfo: " + versionInfo);
    try {
      LogFactory.getLog(getClass()).debug("getCachedPage");
      String id = request.getParameter(RequestParameters.SEARCHER_ID);
      if (!StringUtils.isEmpty(id)) {
        SearcherFacade facade = (SearcherFacade)servletContext.getAttribute(id);
        if (facade == null) {
          LogFactory.getLog(getClass()).error("No SearcherFacade found with id '" + id + "'");
          return;
        }
        response.setHeader("Content-Type", "text/html");
        getCachedPage(request, facade, response.getWriter());
        return;
      }
	    
    } catch (Throwable e) {
      e.printStackTrace(response.getWriter());
      return;
    }
  }    

  private String generateCachedPageHead(VelocityEngine engine, VelocityContext context) {
    try {
      VelocityTemplateManager templateManager = new VelocityTemplateManager(engine, "kwic-head", "kwic-head.vm");
      StringWriter writer = new StringWriter();
	    
      templateManager.render(null, context, writer);
      String head = writer.toString();
      return writer.toString();
    } catch (Exception e) {
      LogFactory.getLog(getClass()).error("Error: " + e);
    }
    return "";
  }

  private String generateCachedPageBody(VelocityEngine engine, VelocityContext context) {
    try {
      VelocityTemplateManager templateManager = new VelocityTemplateManager(engine, "kwic-body", "kwic-body.vm");
      StringWriter writer = new StringWriter();
	    
      templateManager.render(null, context, writer);
      String head = writer.toString();
      return writer.toString();
    } catch (Exception e) {
      LogFactory.getLog(getClass()).error("Error: " + e);
    }
    return "";
  }

  private void getCachedPage(HttpServletRequest request, SearcherFacade facade, java.io.PrintWriter writer) 
    throws Exception {

    String remoteAddress = request.getRemoteAddr();
    SearchUrl searchUrl = new SearchUrl("", request.getParameter(RequestParameters.HIT_URL), new ServletRequestParameters(request), remoteAddress);
    String sessionId = searchUrl.getSessionId();
    int responseId = searchUrl.getResponseId();
    String hitUrl = searchUrl.getHitUrl();
    String queryStr = searchUrl.getQuery();
    String queryStrEncoded = StringEscapeUtils.escapeHtml(queryStr);
	

    String baseURL = request.getContextPath() + request.getPathInfo() + request.getQueryString();
    String localeStr = request.getParameter(RequestParameters.LANGUAGE);
    CachedPageResponse cachedPageResponse = facade.performGetCachedPageRequest(responseId, hitUrl, sessionId, queryStr);
    Locale loc = new Locale(localeStr);
    LogFactory.getLog(getClass()).debug("CUDEBUG: locale = " + localeStr);
	
    VelocityContext headcontext = new VelocityContext();
    headcontext.put("firstAnchor","#kwic0");
    headcontext.put("lastAnchor","#kwic"+(cachedPageResponse.getNmarks()-1));
    headcontext.put("lang", new ResourceBundleWrapper(ResourceBundle.getBundle("siteseeker.web.lang.search",loc)));
	
    String head = generateCachedPageHead(VelocityTemplateManager.getVelocityEngine(servletContext), headcontext);

    VelocityContext bodyContext = new VelocityContext();
    bodyContext.put("docUrl", hitUrl);
    bodyContext.put("description", "Inga ord som matchar <strong>" + queryStrEncoded + "</strong> markerades.");
    bodyContext.put("disclaimer", "Sidan kan ha uppdaterats sedan s&ouml;kmotorn h&auml;mtade den. Du kan alltid g&aring; till den <a href=\""+hitUrl+"\" target=\"_self\">senaste versionen av sidan</a>.");
    bodyContext.put("lang", new ResourceBundleWrapper(ResourceBundle.getBundle("siteseeker.web.lang.search",loc)));
    bodyContext.put("nmarks", cachedPageResponse.getNmarks());
    bodyContext.put("query", queryStrEncoded);
	
    String body = generateCachedPageBody(VelocityTemplateManager.getVelocityEngine(servletContext), bodyContext);
	
    String pagestr=cachedPageResponse.getPage();

    StringBuffer pagestrbuf = new StringBuffer(pagestr);
    String kwichead = "{KWIC-HEAD}";
    String kwicbody = "{KWIC-BODY}";
    int starthead = pagestrbuf.indexOf(kwichead);
    int stophead = pagestrbuf.lastIndexOf(kwichead)+kwichead.length();
    int startbody = pagestrbuf.indexOf(kwicbody);
    int stopbody = pagestrbuf.lastIndexOf(kwicbody)+kwicbody.length();
    LogFactory.getLog(getClass()).debug("CUDEBUG starthead: " + starthead + " stophead: " +  stophead );
    LogFactory.getLog(getClass()).debug("CUDEBUG startbody: " + startbody + " stopbody: " +  stopbody );
	
    if(starthead>=0){
      pagestrbuf.replace(pagestrbuf.indexOf(kwichead),pagestrbuf.indexOf(kwichead)+kwichead.length(),head);
      pagestrbuf.replace(pagestrbuf.indexOf(kwicbody),pagestrbuf.indexOf(kwicbody)+kwicbody.length(),body);
    }else{
      pagestr=cachedPageResponse.getPage();
    }
    writer.println(pagestrbuf.toString());
	
  }
}

