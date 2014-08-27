package siteseeker.search;

import junit.framework.Assert;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import siteseeker.ws.*;

import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.BindingProvider;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

public class TestSearchIndexInfo {

    public SiteSeeker siteSeekerService;
    private WSConnectionInfo connectionInfo = new WSConnectionInfo("http://siteseeker-knowledgebase.siteseeker.se/ws/siteseeker-knowledgebase", "ws", "gnus5/dopier");;
    public SearchIndexInfo searchIndexInfo;

    @Test
    public void testCreate() throws MalformedURLException {
        givenASearchIndexInfo();
        whenIUpdate();
        assertNotNull(searchIndexInfo.getAges());
        assertNotNull(searchIndexInfo.getFileFormats());
        assertNotNull(searchIndexInfo.getLanguages());
        assertNotNull(searchIndexInfo.getCategoryGroups());
        assertNotNull(searchIndexInfo.getLanguageFilter(1));
        assertNotNull(searchIndexInfo.getAgeFilter(1));
        assertNotNull(searchIndexInfo.getCategoryFilter(1));
        assertNotNull(searchIndexInfo.getCategoryGroup(1));
        assertNotNull(searchIndexInfo.getFileFormatFilter(1));
        assertTrue(searchIndexInfo.getNIndexedPages()>0);
    }

    private void whenIUpdate() throws MalformedURLException {
        searchIndexInfo.update(performGetParamRequest(createGetParamRequestParameter(null)));
    }

    private void givenASearchIndexInfo() throws MalformedURLException {
        GetParamRequest6 request =
                createGetParamRequestParameter(null);
        searchIndexInfo = new SearchIndexInfo(performGetParamRequest(request));
    }

    private GetParamRequest6 createGetParamRequestParameter(XMLGregorianCalendar timeOfLastQuery) {
        GetParamRequest6 request = new GetParamRequest6();
        request.setGetBestBets(false);
        request.setGetCategories(true);
        request.setGetDates(true);
        request.setGetDoctypes(true);
        request.setGetLanguages(true);
        request.setGetAges(true);
        request.setIlang("sv");
        request.setLastQuery(timeOfLastQuery);
        request.setVersion(4);
        return request;
    }

    private ParamResponse performGetParamRequest(GetParamRequest request) throws MalformedURLException {
        return getSiteSeekerWSConnection().getParam(request);
    }

    private SiteSeekerPortType getSiteSeekerWSConnection() throws MalformedURLException {
        URL wsdlUrl = new URL("file:src/main/java/siteseeker/ws/SiteSeeker.wsdl");
        siteSeekerService = new SiteSeeker(wsdlUrl);
        LogFactory.getLog(getClass()).debug("Connecting using wsdl url: " + wsdlUrl);
        int timeout = 10;
        SiteSeekerPortType siteSeeker = siteSeekerService.getSiteSeeker();
        Map<String, Object> context = ((BindingProvider) siteSeeker).getRequestContext();
        context.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, connectionInfo.getUrl());
        context.put("com.sun.xml.ws.connect.timeout", new Integer(timeout));
        context.put("com.sun.xml.ws.request.timeout", new Integer(timeout));
        if (StringUtils.isNotEmpty(connectionInfo.getUsername()) &&
                StringUtils.isNotEmpty(connectionInfo.getPassword())) {
            context.put(BindingProvider.USERNAME_PROPERTY, connectionInfo.getUsername());
            context.put(BindingProvider.PASSWORD_PROPERTY, connectionInfo.getPassword());
        }
        return siteSeeker;
    }

}
