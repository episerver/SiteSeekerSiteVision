package siteseeker.web;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import senselogic.sitevision.api.Utils;
import senselogic.sitevision.api.client.ClientUtil;
import senselogic.sitevision.api.context.PortletContextUtil;

import javax.portlet.*;
import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestSearchPortlet {

    public PortletConfig portletConfig;
    public PortletContext portletContext;
    // Ugly workaround, since the Portlet keeps state in statics and cannot be reinitialized in a running process
    public static SearchPortlet searchPortlet;
    public StringWriter responseContent;
    public String validSession;

    @Test
    public void testInit() throws PortletException, IOException {
        givenASearchPortlet();
        whenIRequestTheSearchPage();
        thenTheResponseShouldContain("<!--eri-no-index-->");
        thenTheResponseShouldContain("<form method=\"get\" action=\"http://127.0.0.1/portlet\">");
    }

    private void givenASearchPortlet() throws FileNotFoundException, PortletException {
        // Ugly workaround, since the Portlet keeps state in statics and cannot be reinitialized in a running process
        if (searchPortlet == null) {
            VelocityTemplateManager.addStream("advanced-form.vm", new FileInputStream("src/main/resources/advanced-form.vm"));
            VelocityTemplateManager.addStream("best-bets.vm", new FileInputStream("src/main/resources/best-bets.vm"));
            VelocityTemplateManager.addStream("config.vm", new FileInputStream("src/main/resources/config.vm"));
            VelocityTemplateManager.addStream("form.vm", new FileInputStream("src/main/resources/form.vm"));
            VelocityTemplateManager.addStream("hits.vm", new FileInputStream("src/main/resources/hits.vm"));
            VelocityTemplateManager.addStream("kwic-body.vm", new FileInputStream("src/main/resources/kwic-body.vm"));
            VelocityTemplateManager.addStream("kwic-head.vm", new FileInputStream("src/main/resources/kwic-head.vm"));
            VelocityTemplateManager.addStream("overview.vm", new FileInputStream("src/main/resources/overview.vm"));
            VelocityTemplateManager.addStream("page-numbers.vm", new FileInputStream("src/main/resources/page-numbers.vm"));
            VelocityTemplateManager.addStream("search-page.vm", new FileInputStream("src/main/resources/search-page.vm"));
            searchPortlet = new SearchPortlet();
            searchPortlet.setVersionInfo("SiteSeeker for SiteVision, version 2.4.0, revision 1.19, 2012-01-17 15:09:21+01:00");
            searchPortlet.getClass().getClassLoader();
            portletConfig = mock(PortletConfig.class);
            portletContext = mock(PortletContext.class);
            when(portletConfig.getPortletContext()).thenReturn(portletContext);
            searchPortlet.init(portletConfig);
        }
    }

    private void whenIRequestTheSearchPage() throws IOException, PortletException {
        Map<String, String> emptyParameters = new HashMap<String, String>();
        whenIRequestTheSearchPageWithParameters(emptyParameters);
    }

    private void whenIRequestTheSearchPageWithParameters(final Map<String, String> parameterValues) throws IOException, PortletException {
        RenderRequest renderRequest = mock(RenderRequest.class);
        RenderResponse renderResponse = mock(RenderResponse.class);
        Utils utils = mock(Utils.class);
        PortletContextUtil contextUtil = mock(PortletContextUtil.class);
        when(utils.getPortletContextUtil()).thenReturn(contextUtil);
        ClientUtil clientUtil = mock(ClientUtil.class);
        when(clientUtil.getClientAddress()).thenReturn("127.0.0.1");
        when(utils.getClientUtil()).thenReturn(clientUtil);
        when(contextUtil.getPortletNamespace("")).thenReturn("PORTLETID");
        when(renderRequest.getAttribute("sitevision.utils")).thenReturn(utils);
        when(renderRequest.getLocale()).thenReturn(new Locale("sv", "SE"));
        PortletURL portletURL = mock(PortletURL.class);
        when(portletURL.toString()).thenReturn("http://127.0.0.1/portlet");
        when(renderRequest.getParameterNames()).thenReturn(Collections.enumeration(parameterValues.keySet()));
        when(renderRequest.getParameterValues(Mockito.anyString())).thenAnswer(new Answer<String[]>() {
            public String[] answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object[] args = invocationOnMock.getArguments();
                return new String[]{parameterValues.get((String) args[0])};
            }
        });
        when(renderRequest.getParameter(Mockito.anyString())).thenAnswer(new Answer<String>() {
            public String answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object[] args = invocationOnMock.getArguments();
                return parameterValues.get((String) args[0]);
            }
        });
        when(renderRequest.getPreferences()).thenReturn(mock(PortletPreferences.class));
        when(renderResponse.createRenderURL()).thenReturn(portletURL);
        StringWriter stringWriter = new StringWriter();
        when(renderResponse.getWriter()).thenReturn(new PrintWriter(stringWriter));
        searchPortlet.doView(renderRequest, renderResponse);
        responseContent = stringWriter;
    }

    private void thenTheResponseShouldContain(String expected) {
        Assert.assertTrue(responseContent.toString().contains(expected));
    }

    @Test
    public void testXssVulnerabilityOnSessionId() throws PortletException, IOException {
        givenASearchPortlet();
        givenIHaveAValidSession();
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("sid", "1','1','en');alert('XSS');alert('" + validSession);
        whenIRequestTheSearchPageWithParameters(params);
        thenTheResponseShouldNotContain("alert");
    }

    private void givenIHaveAValidSession() throws IOException, PortletException {
        Map<String, String> emptyParameters = new HashMap<String, String>();
        whenIRequestTheSearchPageWithParameters(emptyParameters);
        validSession = responseContent.toString().split("name=\"sid\" value=\"")[1].split("\"")[0];
    }

    private void thenTheResponseShouldNotContain(String unexpected) {
        Assert.assertFalse(responseContent.toString().contains(unexpected));
    }
}
