package siteseeker.search;

import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.UUID;
import java.util.GregorianCalendar;

import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.BindingProvider;

import org.apache.commons.lang.StringUtils;

import org.apache.commons.logging.LogFactory;

import siteseeker.ws.*;
import siteseeker.util.*;

/**
 * 
 * @author B. Andrist
 *
 */
public class SearcherFacade {

  private static URL wsdlUrl = null;
  private static ParamResponse getParams = null;
  private static SiteSeeker siteSeekerService = null;

  private String id;
  private GregorianCalendar indexLastModified;
  private SearchIndexInfo searchIndexInfo;
  private WSConnectionInfo connectionInfo;
  private String interfaceLang;
  private String version;

  public SearcherFacade(WSConnectionInfo connectionInfo, 
      String interfaceLang, 
      String interfaceVersion) 
    throws Exception {
    id = UUID.randomUUID().toString();
    this.connectionInfo = connectionInfo;
    this.interfaceLang = interfaceLang;
    this.version = interfaceVersion;
    GetParamRequest6 request = 
      createGetParamRequestParameter(null);
    searchIndexInfo = new SearchIndexInfo(performGetParamRequest(request));
    indexLastModified = new GregorianCalendar(1970, 1, 1);
  }

  public String getId() { return id; }

  public SearchResponse search(SearchParameters searchParams,
      String queryExtenstion, String remoteAddress) {
    DoSearchRequest6 request = createDoSearchRequestParameter(searchParams,
        queryExtenstion, remoteAddress);

    TimeLogger timer = new TimeLogger(LogFactory.getLog(getClass()));
    SearchResponse response = performDoSearchRequest(request);
    timer.logCurrentTime("Perform WS search");
    if (response.getIndexLastModified() != null) {
      indexLastModified = response.getIndexLastModified().getValue().getT().toGregorianCalendar();
    }
    return response;
  }

  /**
   * Execute a log request for SiteSeeker. 
   * @return boolean status of click logging
   */
  public boolean logClick(int hitNo, int mode, int responseId, 
      String hitUrl, String userIdentifier) {
    DoClickRequest request = 
      createDoClickRequest(hitNo, mode, responseId, 
          hitUrl, userIdentifier);
    return getSiteSeekerWSConnection().doClick(request).isOk();
  }

  public synchronized SearchIndexInfo getSearchIndexInfo() {
    if (!searchIndexInfo.isValid(indexLastModified)) {
      LogFactory.getLog(getClass()).info
        ("SearchIndexInfo is outdated, need to fetch from index");
      GetParamRequest6 request = createGetParamRequestParameter(null);
      searchIndexInfo.update(performGetParamRequest(request));
    }
    return searchIndexInfo;
  }

  public CachedPageResponse performGetCachedPageRequest(int responseId, String hitUrl, String userIdentifier, String queryStr) {
    SiteSeekerPortType tSiteSeeker = getSiteSeekerWSConnection();
    CachedPageResponse tResponse = null;

    GetCachedPageRequest3 request = 
      createGetCachedPageRequest(responseId, hitUrl, userIdentifier,queryStr);
    LogFactory.getLog(getClass()).debug("CUDEBUG responseId:" + responseId + " hitUrl:" + hitUrl + " userIdentifier:" + userIdentifier + " queryStr " + queryStr );
    tResponse = tSiteSeeker.getCachedPage(request);
    return tResponse;
  }

  /*
   * Helper methods 
   */
  // connect to web service
  private SiteSeekerPortType getSiteSeekerWSConnection() {
    wsdlUrl = getSiteSeekerWSDLUrl();
    siteSeekerService = new SiteSeeker(wsdlUrl);
    LogFactory.getLog(getClass()).debug("Connecting using wsdl url: " + wsdlUrl);
    int timeout = 10;
    SiteSeekerPortType siteSeeker =  siteSeekerService.getSiteSeeker();
    Map<java.lang.String,java.lang.Object> context = ((BindingProvider)siteSeeker).getRequestContext();
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

  // create request objects
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
    sp.add(createSearchParameter("interfaceVersion", version));
    sp.add(createSearchParameter("interfaceKey", "SiteVision - " + interfaceLang));
    sp.add(createSearchParameter("metaAttributes", "true"));
    sp.add(createSearchParameter("enableAges", "true"));
    sp.add(createSearchParameter("matchingAttachmentsOnly", "false"));
    if (nonInteractive)
      sp.add(createSearchParameter("nonInteractive", "true"));

    tSearchRequest.setVersion(7);
    return tSearchRequest;
  }

  private SearchParameter createSearchParameter(String key, String value) {
    SearchParameter param = new SearchParameter();
    param.setKey(key);
    param.setValue(value);
    return param;
  }


  // create do click argument object
  private DoClickRequest createDoClickRequest(int hitNo, int mode, 
      int responseId, String hitUrl,
      String userIdentifier) {
    DoClickRequest clickRequest = new DoClickRequest();
    clickRequest.setHitNr(hitNo);
    clickRequest.setMode(mode);
    clickRequest.setResponseId(responseId);
    clickRequest.setUrl(hitUrl);
    clickRequest.setUserIdentifier(userIdentifier);
    return clickRequest;
  }

  // create get cached page argument object
  private GetCachedPageRequest3 createGetCachedPageRequest(int responseId, String hitUrl, String userIdentifier, String queryStr) {
    GetCachedPageRequest3 getCachedPageRequest = new GetCachedPageRequest3();
    getCachedPageRequest.setResponseId(responseId);
    getCachedPageRequest.setUrl(hitUrl);
    getCachedPageRequest.setUserIdentifier(userIdentifier);
    getCachedPageRequest.setQuery(queryStr);


    return getCachedPageRequest;
  }

  // create get parameter argument object
  private GetParamRequest6 createGetParamRequestParameter(XMLGregorianCalendar timeOfLastQuery) {
    GetParamRequest6 request = new GetParamRequest6();
    request.setGetBestBets(false);
    request.setGetCategories(true);
    request.setGetDates(true);
    request.setGetDoctypes(true);
    request.setGetLanguages(true);
    request.setGetAges(true);
    request.setIlang(interfaceLang);
    request.setLastQuery(timeOfLastQuery);
    request.setVersion(4);
    return request;
  }

  /**
   * Helper methods
   */

  // perform service calls
  // execute do search call
  private SearchResponse performDoSearchRequest(DoSearchRequest6 request) {
    return getSiteSeekerWSConnection().doSearch(request);
  }
  // execute do click call
  private ClickResponse performDoClickRequest(DoClickRequest request) {
    return getSiteSeekerWSConnection().doClick(request);
  }
  // execute get parameter call
  private ParamResponse performGetParamRequest(GetParamRequest request) {
    return getSiteSeekerWSConnection().getParam(request);
  }
  private synchronized URL getSiteSeekerWSDLUrl() {
    URL url = null;
    url = getClass().getClassLoader().getResource("siteseeker/ws/SiteSeeker.wsdl");
    return url;
  }
}
