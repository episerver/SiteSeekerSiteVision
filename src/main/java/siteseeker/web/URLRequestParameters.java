package siteseeker.web;

/**
 * This class returns the names of the available request parameters
 * in the search portlet. An instance of this class is always
 * put in the VelocityContext for the search page. 
 */
public class URLRequestParameters {

  private String prefix;

  public URLRequestParameters(String prefix) {
    this.prefix = prefix;
  }
  public String getQuery() {
    return RequestParameters.QUERY;
  }
  public String getSortOrder() {
    return prefix + RequestParameters.SORT_ORDER;
  }
  public String getLanguage() {
    return prefix + RequestParameters.LANGUAGE;
  }
  public String getAge() {
    return prefix + RequestParameters.AGE;
  }
  public String getFileFormat() {
    return prefix + RequestParameters.FILE_FORMAT;
  }
  public String getNHitsPerBatch() {
    return prefix + RequestParameters.N_HITS_PER_BATCH;
  }
  public String getBatchNumber() {
    return prefix + RequestParameters.BATCH_NUMBER;
  }
  public String getCategories() {
    return prefix + RequestParameters.CATEGORIES;
  }
}

