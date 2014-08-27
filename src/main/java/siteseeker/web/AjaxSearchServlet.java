package siteseeker.web;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.LogFactory;
import siteseeker.search.SearcherFacade;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet to serve ajax searches and click tracking
 *
 * @author Bjorn A.
 */
@SuppressWarnings("serial")
public class AjaxSearchServlet extends HttpServlet {

    public static final String PARAM_NAME_CLICK = "as_rc";
    private ServletContext context;

    public void init(ServletConfig cfg) throws ServletException {
        super.init(cfg);
        context = cfg.getServletContext();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String id = request.getParameter(RequestParameters.SEARCHER_ID);
            String clickParameter = request.getParameter(PARAM_NAME_CLICK);

            if ("y".equals(clickParameter) && !StringUtils.isEmpty(id)) {
                SearcherFacade facade = (SearcherFacade) context.getAttribute(id);
                if (facade == null) {
                    LogFactory.getLog(getClass()).error("No SearcherFacade found with id '" + id + "'");
                    writeEmptyResult(response);
                } else {
                    response.setContentType("text/html");
                    registerClick(request, facade);
                }
            } else {
                writeEmptyResult(response);
            }
        } catch (Throwable e) {
            String msg = "Error performing search: " + e.getMessage();
            LogFactory.getLog(getClass()).error(msg);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, msg);
        }
    }

    private void writeEmptyResult(HttpServletResponse response) throws IOException {
        java.io.PrintWriter writer = response.getWriter();
        writer.println("AjaxSearchServlet!");
    }

    private void registerClick(HttpServletRequest request, SearcherFacade facade)
            throws Exception {
        String remoteAddress = request.getRemoteAddr();
        SearchUrl searchUrl = new SearchUrl("", "", new ServletRequestParameters(request), remoteAddress);
        String sessionId = searchUrl.getSessionId();
        int responseId = searchUrl.getResponseId();
        int hitNo = searchUrl.getHitNumber();
        int clickMode = searchUrl.getClickMode();
        String hitUrl = searchUrl.getHitUrl();
        facade.logClick(hitNo, clickMode, responseId, hitUrl, sessionId);
    }
}

class ServletRequestParameters implements RequestParameters {

    private HttpServletRequest request;

    public ServletRequestParameters(HttpServletRequest request) {
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
