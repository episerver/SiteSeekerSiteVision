package siteseeker.ws;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import siteseeker.SimpleRequestParameters;
import siteseeker.search.SearchParameters;
import siteseeker.web.SearchUrl;

import javax.xml.ws.BindingProvider;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;
import static siteseeker.RequestBuilder.searchRequest;

public class TestSiteSeeker {

    public SiteSeekerPortType siteSeeker;

    @Test
    public void testCreate() throws Exception {
        givenASiteSeekerConnection();
        Assert.assertNotNull(siteSeeker);
    }

    private void givenASiteSeekerConnection() throws MalformedURLException {
        siteSeeker = connect("http://siteseeker-knowledgebase.siteseeker.se/ws/siteseeker-knowledgebase", "ws", "gnus5/dopier");
    }

    private SiteSeekerPortType connect(String url, String username, String password) throws MalformedURLException {
        URL wsdlUrl = new URL("file:src/main/java/siteseeker/ws/SiteSeeker.wsdl");
        SiteSeeker siteSeekerService = new SiteSeeker(wsdlUrl);
        SiteSeekerPortType siteSeeker = siteSeekerService.getSiteSeeker();
        Map<String, Object> context = ((BindingProvider) siteSeeker).getRequestContext();
        context.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);
        context.put(BindingProvider.USERNAME_PROPERTY, username);
        context.put(BindingProvider.PASSWORD_PROPERTY, password);
        return siteSeeker;
    }

    @Test
    public void testSearch() throws Exception {
        givenASiteSeekerConnection();
        String query = "*";
        SearchResponse response = whenISearchFor(query);
        assertTrue(response.getNHits() > 10);
        assertEquals(10, response.getNHitsBatch());
    }

    private SearchResponse whenISearchFor(String query) {
        return searchResultsFor(searchRequest().withQuery(query).parameters());
    }

    private SearchResponse searchResultsFor(SimpleRequestParameters requestParameters) {
        SearchParameters searchParameters = new SearchUrl("", "", requestParameters, "");
        DoSearchRequest6 request = createDoSearchRequestParameter(searchParameters, "", "");
        return siteSeeker.doSearch(request);
    }

    @Test
    public void testEmptySearch() throws Exception {
        givenASiteSeekerConnection();
        String query = "";
        SearchResponse response = whenISearchFor(query);
        assertNotNull(response);
        assertEquals("Ingen fr", response.getMessage().substring(0,8));
        assertFalse(response.isOk());
    }

    private DoSearchRequest6 createDoSearchRequestParameter(SearchParameters params,
                                                            String queryExtenstion,
                                                            String remoteAddress) {
        ObjectFactory wsFactory = new ObjectFactory();
        DoSearchRequest6 tSearchRequest = new DoSearchRequest6();
        tSearchRequest.setBatchNumber(params.getBatchNumber());
        tSearchRequest.setNHits(params.getNHitsPerBatch());
        String query = params.getQuery();
        boolean nonInteractive = query.equals("");
        if (StringUtils.isNotEmpty(queryExtenstion)) {
            query = query + " " + queryExtenstion;
        }
        tSearchRequest.setQuery(query);
        tSearchRequest.setSortOrder(params.getSortOrder());
        FilterBool useStemming = new FilterBool();
        useStemming.setV(params.getUseStemming());
        tSearchRequest.setStemming(wsFactory.createDoSearchRequestStemming(useStemming));
        FilterNum age = new FilterNum();
        age.setV(params.getAge());
        tSearchRequest.setAge(wsFactory.createDoSearchRequest6Age(age));
        FilterNum lang = new FilterNum();
        lang.setV(params.getLanguage());
        tSearchRequest.setLanguage(wsFactory.createDoSearchRequestLanguage(lang));
        FilterNum format = new FilterNum();
        format.setV(params.getFileFormat());
        tSearchRequest.setFormat(wsFactory.createDoSearchRequestFormat(format));
        tSearchRequest.setUserIdentifier(params.getSessionId());
        tSearchRequest.setSpellSuggestion(params.getSpelling());
        String interfaceLang = "sv";
        tSearchRequest.setIlang(interfaceLang);
        Set<Integer> categories = params.getCategorySet();
        if (categories != null && !categories.isEmpty()) {
            FilterArray filter = new FilterArray();
            for (Integer i : categories) {
                filter.getV().add(i);
            }
            tSearchRequest.setCategory(wsFactory.createDoSearchRequestCategory(filter));
        }

        List<SearchParameter> sp = tSearchRequest.getParameters();
        sp.add(createSearchParameter("emptyItemsInOverview", "true"));
        sp.add(createSearchParameter("anyFiltersInOverview", "true"));
        sp.add(createSearchParameter("clientIpAddress", remoteAddress));
        sp.add(createSearchParameter("interfaceVersion", "SiteSeeker for SiteVision, version 2.4.0, revision 1.19, 2012-01-17 15:09:21+01:00"));
        sp.add(createSearchParameter("interfaceKey", "SiteVision - " + interfaceLang));
        sp.add(createSearchParameter("metaAttributes", "true"));
        sp.add(createSearchParameter("enableAges", "true"));
        sp.add(createSearchParameter("matchingAttachmentsOnly", "false"));
        if (nonInteractive) {
            sp.add(createSearchParameter("nonInteractive", "true"));
        }

        tSearchRequest.setVersion(7);
        return tSearchRequest;
    }

    private SearchParameter createSearchParameter(String key, String value) {
        SearchParameter param = new SearchParameter();
        param.setKey(key);
        param.setValue(value);
        return param;
    }


}
