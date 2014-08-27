package siteseeker.web;

import org.apache.commons.lang.StringUtils;
import siteseeker.search.SearchParameters;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;
import java.util.regex.Pattern;

public class SearchUrl implements SearchParameters, Serializable {

    public static final long serialVersionUID = 1L;

    private String prefix;
    private UrlBuilder currentUrl;
    private Set<Integer> categoryIds;
    private static final String CACHE_BASE_URL = "/siteseeker-search/SiteSeekerCacheServlet";

    public SearchUrl(String prefix,
                     String baseUrl,
                     RequestParameters requestParams,
                     String remoteAddress) {
        this.prefix = prefix;
        this.currentUrl = new UrlBuilder(baseUrl, RequestParameters.QUERY,
                RequestParameters.SESSION_ID);
        Enumeration<String> e = requestParams.getParameterNames();
        while (e.hasMoreElements()) {
            String key = e.nextElement();
            if (!RequestParameters.SESSION_ID.equals(key)) {
                for (String value : requestParams.getValues(key)) {
                    currentUrl.appendParameter(key, value);
                }
            }
        }
        SearchSession session =
                new SearchSession(remoteAddress,
                        requestParams.getValue(RequestParameters.SESSION_ID));
        currentUrl.setParameter(RequestParameters.SESSION_ID, session.toString());
    }


    // common parameters
    public String getQuery() {
        String q = currentUrl.getParameterValue(RequestParameters.QUERY);
        if (q == null) {
            return "";
        } else {
            return q;
        }
    }

    public String getSessionId() {
        String sessionIdParameter = currentUrl.getParameterValue(RequestParameters.SESSION_ID);
        return (sessionIsOnValidFormat(sessionIdParameter) ? sessionIdParameter : null);
    }

    private boolean sessionIsOnValidFormat(String sessionIdParameter) {
        return Pattern.compile("[a-zA-Z0-9:]+").matcher(sessionIdParameter).matches();
    }

    public Set<Integer> getCategorySet() {
        if (categoryIds == null) {
            List<String> categories =
                    currentUrl.getParameterValues(prefix + RequestParameters.CATEGORIES);
            categoryIds = new TreeSet<Integer>();
            if (categories != null) {
                for (String category : categories) {
                    try {
                        categoryIds.add(Integer.parseInt(category));
                    } catch (NumberFormatException nfe) {
                        // Ignore category id if we can't parse it
                    }
                }
            }
        }
        return categoryIds;
    }

    public String getSearchPageId() {
        return currentUrl.getParameterValue(prefix + RequestParameters.SEARCH_PAGE_ID);
    }

    public boolean getSpelling() {
        return getBoolValue(currentUrl.getParameterValue(RequestParameters.SPELLING), false);
    }

    public boolean getUseStemming() {
        return getBoolValue(currentUrl.getParameterValue(prefix + RequestParameters.USE_STEMMING), true);
    }

    public int getLanguage() {
        return getIntValue(currentUrl.getParameterValue(prefix + RequestParameters.LANGUAGE), -2);
    }

    public String getUILanguage() {
        return currentUrl.getParameterValue(RequestParameters.UI_LANGUAGE);
    }

    public int getAge() {
        return getIntValue(currentUrl.getParameterValue(prefix + RequestParameters.AGE), 0);
    }

    public int getFileFormat() {
        return getIntValue(currentUrl.getParameterValue(prefix + RequestParameters.FILE_FORMAT), 0);
    }

    public int getSortOrder() {
        return getIntValue(currentUrl.getParameterValue(prefix + RequestParameters.SORT_ORDER), 1);     // Default sort order = 1 (relevance)
    }

    public int getResponseId() {
        return getIntValue(currentUrl.getParameterValue(prefix + RequestParameters.RESPONSE_ID), 0);
    }

    public int getNHitsPerBatch() {
        return getIntValue(currentUrl.getParameterValue(prefix + RequestParameters.N_HITS_PER_BATCH), 10);
    }

    public int getBatchNumber() {
        return getIntValue(currentUrl.getParameterValue(prefix + RequestParameters.BATCH_NUMBER), 1);
    }

    public int getHitNumber() {
        return getIntValue(currentUrl.getParameterValue(prefix + RequestParameters.HIT_NUMBER), 0);
    }

    public int getClickMode() {
        return getIntValue(currentUrl.getParameterValue(RequestParameters.CLICK_MODE), 0);
    }

    public String getHitUrl() {
        return currentUrl.getParameterValue(RequestParameters.HIT_URL);
    }

    public String buildSortOrderUrl(int selectedSortOrder) {
        return buildFilterUrl(RequestParameters.SORT_ORDER, selectedSortOrder);
    }

    public String buildLanguageUrl(int selectedLanguage) {
        return buildFilterUrl(RequestParameters.LANGUAGE, selectedLanguage);
    }

    public String buildFileFormatUrl(int selectedFileFormat) {
        return buildFilterUrl(RequestParameters.FILE_FORMAT, selectedFileFormat);
    }

    public String buildAgeUrl(int selectedAge) {
        return buildFilterUrl(RequestParameters.AGE, selectedAge);
    }

    public String buildPageLinkUrl(int batchNumber) {
        return buildFilterUrl(RequestParameters.BATCH_NUMBER, batchNumber);
    }

    public String buildCategoryUrl(final Integer selectedCategory) {
        return currentUrl.buildUrl(new UrlModifier() {
            public boolean remove(String key) {
                return (key.equals(prefix + RequestParameters.CATEGORIES) ||
                        key.equals(prefix + RequestParameters.BATCH_NUMBER));
            }

            public UrlParameter[] insert() {
                return new UrlParameter[]
                        {new UrlParameter(prefix + RequestParameters.CATEGORIES,
                                selectedCategory.toString())};
            }
        });
    }

    public String buildSpellingUrl(final String alternateQuery) {
        return currentUrl.buildUrl(new UrlModifier() {
            public boolean remove(String key) {
                return (RequestParameters.QUERY.equals(key) ||
                        RequestParameters.SPELLING.equals(key));
            }

            public UrlParameter[] insert() {
                return new UrlParameter[]
                        {new UrlParameter(RequestParameters.QUERY, alternateQuery),
                                new UrlParameter(RequestParameters.SPELLING, Boolean.toString(true))};
            }
        });
    }

    private String buildFilterUrl(String paramName, int selectedId) {
        SearchFilterModifier modifier =
                new SearchFilterModifier(prefix, paramName, Integer.toString(selectedId));
        return currentUrl.buildUrl(modifier);
    }

    private int getIntValue(String stringToParse, int defaultValue) {
        try {
            return Integer.parseInt(stringToParse);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    private boolean getBoolValue(String stringToParse, boolean defaultValue) {
        if (StringUtils.isEmpty(stringToParse)) {
            return defaultValue;
        }
        return Boolean.parseBoolean(stringToParse);
    }

    private String[] getStringArray(String stringToParse) {
        if (stringToParse != null) {
            return stringToParse.split(":");
        }
        return null;
    }

    public static String urlEncode(String stringToEncode) {
        try {
            return URLEncoder.encode(stringToEncode, "UTF-8");
        } catch (UnsupportedEncodingException uee) {
            // a do nothing, just return the incomming value
            return stringToEncode;
        }
    }

    public String buildCacheUrl(final String portletIdentifier, final String language, final String url, final int number, final String queryExtension) {
        return currentUrl.buildUrl(new UrlModifier() {
            public boolean remove(String key) {
                return RequestParameters.QUERY.equals(key);
            }

            public UrlParameter[] insert() {
                return new UrlParameter[]
                        {new UrlParameter(RequestParameters.HIT_URL, url),
                                new UrlParameter(RequestParameters.HIT_NUMBER, Integer.toString(number)),
                                new UrlParameter(RequestParameters.SEARCHER_ID, portletIdentifier),
                                new UrlParameter(RequestParameters.LANGUAGE, language),
                                new UrlParameter(RequestParameters.QUERY, getQuery() + queryExtension)};
            }
        }, CACHE_BASE_URL);
    }

}

class UrlParameter {
    private String name;
    private String value;

    public UrlParameter(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}


class UrlModifier {
    public boolean remove(String name) {
        return false;
    }

    public UrlParameter[] insert() {
        return null;
    }
}

class SearchFilterModifier extends UrlModifier {
    private UrlParameter parameter;
    private String prefix;

    public SearchFilterModifier(String prefix, String name, String value) {
        this.prefix = prefix;
        this.parameter = new UrlParameter(prefix + name, value);
    }

    public boolean remove(String name) {
        return (parameter.getName().equals(name) ||
                name.equals(prefix + RequestParameters.BATCH_NUMBER));
    }

    public UrlParameter[] insert() {
        return new UrlParameter[]{parameter};
    }
}


class UrlBuilder {
    private Map<String, List<String>> parameters;
    private String defaultBaseUrl;
    private String firstParameterName = "";
    private String lastParameterName = "";


    public UrlBuilder(String baseUrl, String firstParameter, String lastParameter) {
        this.defaultBaseUrl = baseUrl;
        this.parameters = new HashMap<String, List<String>>();
        this.firstParameterName = firstParameter;
        this.lastParameterName = lastParameter;
    }

    public void appendParameter(String name, String value) {
        List<String> values = parameters.get(name);
        if (values == null) {
            values = new ArrayList<String>();
            parameters.put(name, values);
        }
        values.add(value);
    }

    public void setParameter(String name, String value) {
        parameters.remove(name);
        if (value != null) {
            List<String> values = new ArrayList<String>();
            values.add(value);
            parameters.put(name, values);
        }
    }

    public String getParameterValue(String name) {
        List<String> values = parameters.get(name);
        if (values != null) {
            return values.get(0);
        }
        return null;
    }

    public List<String> getParameterValues(String name) {
        return parameters.get(name);
    }

    public String buildUrl(UrlModifier modifier) {
        return this.buildUrl(modifier, this.defaultBaseUrl);
    }

    public String buildUrl(UrlModifier modifier, String baseUrl) {
        StringBuffer url = new StringBuffer();

        if (!modifier.remove(firstParameterName)) {
            addParameterToBuffer(url, firstParameterName);
        }

        // Insert parameters from UrlModifier
        UrlParameter[] params = modifier.insert();
        if (params != null) {
            for (UrlParameter param : params) {
                appendToBuffer(url, param);
            }
        }

        for (String key : parameters.keySet()) {
            if (key.equals(firstParameterName) ||
                    key.equals(lastParameterName)) {
                continue;  // Don't add first and last parameters twice
            }
            if (!modifier.remove(key)) {
                addParameterToBuffer(url, key);
            }
        }

        if (!modifier.remove(lastParameterName)) {
            addParameterToBuffer(url, lastParameterName);
        }

        return baseUrl + ((baseUrl.indexOf('?') != -1) ? "&amp;" : "?") + url.toString();
    }

    private void addParameterToBuffer(StringBuffer url, String key) {
        List<String> values = parameters.get(key);
        if (values != null) {
            for (String value : values)
                appendToBuffer(url, key, value);
        }
    }

    private void appendToBuffer(StringBuffer sb, String n, String v) {
        if (sb.length() > 0) {
            sb.append("&amp;");
        }
        sb.append(n);
        sb.append("=");
        sb.append(SearchUrl.urlEncode(v));
    }

    private void appendToBuffer(StringBuffer sb, UrlParameter param) {
        appendToBuffer(sb, param.getName(), param.getValue());
    }
}
