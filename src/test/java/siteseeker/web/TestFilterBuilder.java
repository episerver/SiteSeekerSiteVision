package siteseeker.web;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import siteseeker.search.BestBet;
import siteseeker.search.SearchFilter;
import siteseeker.search.SearchIndexInfo;
import siteseeker.ws.ArrayOfBet;
import siteseeker.ws.Bet;
import siteseeker.ws.SearchResponse;

import javax.xml.bind.JAXBElement;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestFilterBuilder {

    public FilterBuilder filterBuilder;
    public SearchResponse response;
    public List<BestBet> bestBets;
    public SearchIndexInfo searchIndexInfo;
    public SearchFilter languageFilter;

    @Test
    public void testEmptyBestBets() {
        givenAFilterBuilder();
        whenIBuildBestBets();
        thenTheNumberOfBestBetsShouldBe(0);
    }

    private void givenAFilterBuilder() {
        filterBuilder = new FilterBuilder(searchIndexInfo, response, null);
    }

    private void whenIBuildBestBets() {
        bestBets = filterBuilder.buildBestBets();
    }

    private void thenTheNumberOfBestBetsShouldBe(int expected) {
        assertEquals(expected, bestBets.size());
    }

    @Test
    public void testBestBets() {
        givenAnIndexInfo();
        givenASearchResponseWithABet();
        givenAFilterBuilder();
        whenIBuildBestBets();
        thenTheNumberOfBestBetsShouldBe(1);
        thenThereShouldBeALanguageFilter();
    }

    private void thenThereShouldBeALanguageFilter() {
        Assert.assertEquals(languageFilter, bestBets.get(0).getLanguage());
    }

    private void givenAnIndexInfo() {
        searchIndexInfo = mock(SearchIndexInfo.class);
        languageFilter = new SearchFilter("");
        when(searchIndexInfo.getLanguageFilter(Mockito.anyInt())).thenReturn(languageFilter);
    }

    private void givenASearchResponseWithABet() {
        response = mock(SearchResponse.class);
        Bet bet = mock(Bet.class);
        JAXBElement jaxbElement = mock(JAXBElement.class);
        ArrayOfBet arrayOfBet = mock(ArrayOfBet.class);
        Mockito.when(jaxbElement.getValue()).thenReturn(arrayOfBet);
        Mockito.when(response.getBets()).thenReturn(jaxbElement);
        Mockito.when(arrayOfBet.getBet()).thenReturn(Arrays.asList(bet));
    }

}
