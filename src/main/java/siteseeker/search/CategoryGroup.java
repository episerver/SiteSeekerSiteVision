package siteseeker.search;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import org.apache.commons.lang.StringEscapeUtils;

/**
 * Describes a search filter used for filtering 
 * a search result.
 */
public class CategoryGroup implements Serializable {

  public static final long serialVersionUID = 1L;

  private String name;
  private int id;
  private List<SearchFilter> categories;

  /**
   * Constructs a new <code>CategoryGroup</code>.
  * @param name The name of the search filter.
  * @param nHits The number of documents that matches this search filter.
  * @param url The URL to be used for selecting this filter.
  * @param isSelected Indicates wheter this filter is selected.
  */
  public CategoryGroup(String name, int id) {
    this.name = name;
    this.id = id;
    categories = new ArrayList<SearchFilter>();
  }

  /**
   * The name of the search filter.
   *
   * This string contains no XML entities, i.e. &amp; (ampersand) is not
   * encoded. The string must be XML encoded before being written to a (X)HTML document.
   */
  public String getName() { return name; }
  
  /**
   * The SiteSeeker-specific ID for this search filter.
   *
   * This property is commonly only used in the search form, and not
   * in the overview or elsewhere.
   */
  public int getId() { return id; }

  public void addCategory(SearchFilter category) {
    categories.add(category);
  }
  public List<SearchFilter> getCategories() {
    return categories;
  }

  /**
   * Returns the number of categories in this group that contains one or more hits.
   *
   * This is useful when listing the category groups, if you want to exclude groups which do
   * not contain any categories with hits that match the current search.  
   *
   * @return Number of categories with hits for the current search.
   */
  public int getNCategoriesWithHits() {
    int n = 0;
    for (SearchFilter category : categories) {
      if (category.getNHits() > 0) {
        n++;
      }
    }
    return n;
  }
}
