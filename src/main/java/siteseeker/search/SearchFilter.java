package siteseeker.search;

import java.io.Serializable;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;

/**
 * Describes a search filter used for filtering 
 * a search result.
 */
public class SearchFilter implements Serializable {

  public static final long serialVersionUID = 1L;

  private String name;
  private int id;
  private String clickUrl;
  private int nHits;
  private int nPages;
  private boolean isSelected;
  private String groupName;

  /**
   * Constructs a new <code>FilterDTO</code>.
   *
   * @param name The name of the search filter.
   * @param groupName The name of the search filter group this filter belongs to.
   * @param nHits The number of documents that matches this search filter.
   * @param url The URL to be used for selecting this filter.
   * @param isSelected Indicates wheter this filter is selected.
   */
  public SearchFilter(String name) {
    this(name, "", -1, -1);
  }
  public SearchFilter(String name, String groupName, int id, int nPages) {
    this.name = name;
    this.groupName = groupName;
    this.id = id;
    this.nPages = nPages;
    this.isSelected = false;

    if (StringUtils.isEmpty(this.name)) {
      this.name = "any";
    } 
  }
  public SearchFilter(SearchFilter sf) {
    this.name = sf.getName();
    this.groupName = sf.getGroupName();
    this.id = sf.getId();
    this.nPages = sf.getNPages();
    this.isSelected = false;
  }


  /**
   * The name of the search filter.
   *
   * This string contains no XML entities, i.e. &amp; (ampersand) is not
   * encoded. The string must be XML encoded before being written to a (X)HTML document.
   */
  public String getName() { return name; }

  public String getGroupName() { return groupName; }

  /**
   * The SiteSeeker-specific ID for this search filter.
   **/ 
  public int getId() { return id; }

  /**
   * Indicates wheter this filter is selected.
   */
  public boolean getIsSelected() { return isSelected; }

  /**
   * Indicates wheter this filter is selected.
   */
  public void setIsSelected(boolean isSelected) { this.isSelected = isSelected; }

  /**
   * The number of documents that matches this search filter.
   */
  public int getNHits() { return nHits; }
  public void setNHits(int n) { nHits = n; }

  public int getNPages() { return nPages; }

  /**
   * Url to apply this filter.
   *
   * This String contains no XML entities, i.e. &amp; (ampersand) is not
   * encoded. Suitable for the <code>NavigateUrl</code> property in asp:HyperLink.
   */
  public String getClickUrl() { return clickUrl; }    
  public void setClickUrl(String url) { this.clickUrl = url; }

  public String toString() {
    return "id: " + id 
      + ", name: " + name
      + ", groupName: " + groupName
      + ", nHits: " + nHits
      + ", nPages: " + nPages
      + ", isSelected: " + isSelected;
  }
}
