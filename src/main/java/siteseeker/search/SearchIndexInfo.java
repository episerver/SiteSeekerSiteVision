package siteseeker.search;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Enumeration;
import java.util.Properties;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;

import org.apache.commons.logging.LogFactory;

import siteseeker.ws.*;

public class SearchIndexInfo {

  private Map<Integer, SearchFilter> languageMap;
  private List<SearchFilter> languageList;
  private Map<Integer, SearchFilter> fileFormatMap;
  private List<SearchFilter> fileFormatList;
  private Map<Integer, SearchFilter> ageMap;
  private List<SearchFilter> ageList;
  private Map<Integer, SearchFilter> categoryMap;
  private Map<Integer, CategoryGroup> categoryGroupMap;
  private List<CategoryGroup> categoryGroupList;
  private GregorianCalendar lastUpdated;
  private int nIndexedPages;

  public SearchIndexInfo(ParamResponse response) {
    update(response);
  }

  public boolean isValid(GregorianCalendar indexLastModified) {
    return ((lastUpdated.compareTo(indexLastModified)) >= 0);
  }

  public synchronized void update(ParamResponse response) {
    lastUpdated = response.getTime().toGregorianCalendar();
    languageMap = new HashMap<Integer, SearchFilter>();
    languageList = new ArrayList<SearchFilter>();
    SearchFilter anyFilter = new SearchFilter("any", "language", -2, 0); // Add meta filter "any"
    languageList.add(anyFilter);
    languageMap.put(anyFilter.getId(), anyFilter);
    List<Lang> langs = response.getLangs().getValue().getLang();
    int nHitsAnyLanguage = 0;
    for (Lang lang : langs) {
        SearchFilter sf = new SearchFilter(lang.getKey(),
                                           "language",
                                           lang.getId(),
                                           lang.getNrHits());
        languageMap.put(lang.getId(), sf);
        languageList.add(sf);
	nHitsAnyLanguage += sf.getNHits();
    }
    anyFilter.setNHits(nHitsAnyLanguage); // Set nHits for "any" filter 
    anyFilter.setIsSelected(true);

    fileFormatMap = new HashMap<Integer, SearchFilter>();
    fileFormatList = new ArrayList<SearchFilter>();
    List<DocType> docTypes = response.getDocs().getValue().getDocType();
    for (DocType docType : docTypes) {
        SearchFilter sf = new SearchFilter(docType.getKey(),
                                           "doctype",
                                           docType.getId(), 
                                           docType.getNrHits());
        
        fileFormatMap.put(docType.getId(), sf);
        fileFormatList.add(sf);
        if (docType.getId() == 0) {
            setNIndexedPages(docType.getNrHits());
      }
    }
    if (fileFormatList.size() > 0 && fileFormatList.get(0) != null) {
	fileFormatList.get(0).setIsSelected(true);
    }
    ageMap = new HashMap<Integer, SearchFilter>();
    ageList = new ArrayList<SearchFilter>();
    List<Age> ages = response.getAges().getValue().getAge();
    for (Age age : ages) {
        SearchFilter sf = new SearchFilter(age.getKey(),
                                           "age",
                                           age.getId(), 
                                           age.getNrHits());
        ageMap.put(age.getId(), sf);
        ageList.add(sf);
    }
    if (ageList.size() > 0 && ageList.get(0) != null) {
	ageList.get(0).setIsSelected(true);
    }

    categoryMap = new HashMap<Integer, SearchFilter>();
    categoryGroupMap = new HashMap<Integer, CategoryGroup>();
    categoryGroupList = new ArrayList<CategoryGroup>();
    List<Category> categories = response.getCats().getValue().getCategory();
    for (Category c : categories) {
      LogFactory.getLog(getClass()).debug
          ("Adding category with id: " + c.getId());
      SearchFilter sf = new SearchFilter(c.getName(), c.getGroupName(), c.getId(), c.getNDocs());
      categoryMap.put(c.getId(), sf);
      CategoryGroup group = categoryGroupMap.get(c.getGroupId());
      if (group == null) {
          group = new CategoryGroup(c.getGroupName(), c.getGroupId());
          categoryGroupMap.put(group.getId(), group);
          categoryGroupList.add(group);
      }
      group.addCategory(sf);
    }
  }
    
    public List<SearchFilter> getLanguages() {
        return languageList;
    }

  public SearchFilter getLanguageFilter(int id) {
      SearchFilter sf = languageMap.get(id);
      if (sf != null) {
          return sf;
      } else {
          LogFactory.getLog(getClass()).error
              ("Could not find language with id: " + id);
          return new SearchFilter("Unknown");
      }
  }
    
    public List<SearchFilter> getFileFormats() {
        return fileFormatList;
    }

  public SearchFilter getFileFormatFilter(int id) {
    SearchFilter sf = fileFormatMap.get(id);
    if (sf != null) {
      return sf;
    } else {
      LogFactory.getLog(getClass()).error
        ("Could not find file format with id: " + id);
      return new SearchFilter("Unknown");
    }
  }

    public List<SearchFilter> getAges() {
        return ageList;
    }

  public SearchFilter getAgeFilter(int id) {
    SearchFilter sf = ageMap.get(id);
    if (sf != null) {
      return sf;
    } else {
      LogFactory.getLog(getClass()).error
        ("Could not find age with id: " + id);
      return new SearchFilter("Unknown");
    }
  }

  public SearchFilter getCategoryFilter(int id) {
    SearchFilter sf = categoryMap.get(id);
    if (sf != null) {
      return sf;
    } else if (id == 0) {
        return null;
    } else {
	LogFactory.getLog(getClass()).error
	    ("Could not find category with id: " + id);
	return new SearchFilter("Unknown");
    }
  }
    private void setNIndexedPages(int n) {
      nIndexedPages = n;
  }
  public int getNIndexedPages() {
    return nIndexedPages;
  }

    public List<CategoryGroup> getCategoryGroups() {
        return categoryGroupList;
    }

  public CategoryGroup getCategoryGroup(int id) {
    CategoryGroup group = categoryGroupMap.get(id);
    if (group != null) {
      return group;
    } else {
      LogFactory.getLog(getClass()).error
        ("Could not find category group with id: " + id);
      return new CategoryGroup("Unknown", -1);
    }
  }
}
