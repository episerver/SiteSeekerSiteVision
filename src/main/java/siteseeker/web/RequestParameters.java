package siteseeker.web;

public interface RequestParameters {
  public static final String QUERY = "query";
  public static final String SPELLING = "s";
  public static final String SORT_ORDER = "so";
  public static final String RESPONSE_ID = "rid";
  public static final String SESSION_ID = "sid";
  public static final String SEARCH_PAGE_ID = "spid";
  public static final String LANGUAGE = "l";
  public static final String AGE = "a";
  public static final String FILE_FORMAT = "ff";
  public static final String N_HITS_PER_BATCH = "nh";
  public static final String BATCH_NUMBER = "bn";
  public static final String HIT_NUMBER = "hn";
  public static final String CATEGORIES = "c";
  public static final String CLICK_MODE = "cm";
  public static final String HIT_URL = "hu";
  public static final String USE_STEMMING = "st";
  public static final String UI_LANGUAGE = "uil";
  public static final String SEARCHER_ID = "si";
  public String getValue(String name);
  public String[] getValues(String name);
  public java.util.Enumeration<String> getParameterNames();
}

