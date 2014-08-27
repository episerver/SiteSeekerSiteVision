package siteseeker.search;

import org.junit.Before;
import org.junit.Test;
import siteseeker.SimpleRequestParameters;
import siteseeker.web.RequestParameters;
import siteseeker.web.SearchUrl;
import siteseeker.ws.SearchResponse;

import static org.junit.Assert.*;

public class TestSearcherFacade {

    public static final String VERSION = "SiteSeeker for SiteVision, version 2.4.0, revision 1.19, 2012-01-17 15:09:21+01:00";
    public SearcherFacade searcherFacade;


    @Before
    public void setup() throws Exception {
        givenAConnection();
    }

    private void givenAConnection() throws Exception {
        WSConnectionInfo con = new WSConnectionInfo("http://siteseeker-knowledgebase.siteseeker.se/ws/siteseeker-knowledgebase", "ws", "gnus5/dopier");
        searcherFacade = new SearcherFacade(con, "sv", VERSION);
    }

    @Test
    public void testConstruction() throws Exception {
        assertNotNull(searcherFacade);
    }

    @Test
    public void testEmptySearch() throws Exception {
        SearchResponse response = whenISearchFor("");
        assertNotNull(response);
        assertEquals("Ingen fr", response.getMessage().substring(0,8));
        assertFalse(response.isOk());
    }

    @Test
    public void testSimpleSearch() throws Exception {
        SearchResponse response = whenISearchFor("*");
        assertNotNull(response);
        assertTrue(response.isOk());
        assertTrue(response.getNHits() > 0);
    }

    private SearchResponse whenISearchFor(String query) {
        SimpleRequestParameters requestParams = new SimpleRequestParameters();
        requestParams.setParameter(RequestParameters.QUERY, query);
        SearchParameters parameters = new SearchUrl("", "", requestParams, "");
        return searcherFacade.search(parameters, "", "");
    }

}
