package siteseeker.search;

import java.util.Set;

public interface SearchParameters {
    public String getQuery();
    public String getSessionId();
    public boolean getSpelling();
    public int getLanguage();
    public int getAge();
    public int getFileFormat();
    public int getSortOrder();
    public int getResponseId();
    public int getNHitsPerBatch();
    public int getBatchNumber();
    public int getHitNumber();
    public int getClickMode();
    public String getHitUrl();
    public boolean getUseStemming();
    public Set<Integer> getCategorySet();
}
