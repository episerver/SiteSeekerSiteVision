package siteseeker.web;

import java.io.Serializable;

/**
 * This class holds data for generating page links which is used for paginating the search result.
 * A page link has a <c>ClickUrl</c> pointing at the result page with the page number defined by the <c>PageNumber</c> propery.
 */
public class PageLink implements Serializable {

  public static final long serialVersionUID = 1L;

  private String clickUrl;
  private int pageNumber;
  private boolean isSelected;
  private boolean isHidden;

  /**
   * An instance of a <c>PageLink</c> representing a hidden page link in the pager.
   * A hidden page link is usually displayed as dots (...) in the pager view.
   */
  public static PageLink HIDDEN = new PageLink(-1, "", false, true);

  /**
   * Constructs a new <c>PageLink</c>
   * @param pageNumber - The page number, first page has page number 1
   * @param url - The URL pointing at the search result page
   * @param isSelected - If this page is currently selected/viewed in the pager
   * @param isHidden - If this page is hidden in the pager
   */
  public PageLink(int pageNumber, String url, boolean isSelected, boolean isHidden) {
    this.pageNumber = pageNumber;
    this.clickUrl = url;
    this.isHidden = isHidden;
    this.isSelected = isSelected;
  }

  /**
   * Constructs a new <c>PageLink</c>
   * @param pageNumber - The page number, first page has page number 1
   * @param url - The URL pointing at the search result page
   * @param isSelected - If this page is currently selected/viewed in the pager
   */
  public PageLink(int pageNumber, String url, boolean isSelected) {
    this(pageNumber, url, isSelected, false);
  }

  /**
   * The number of the search result page that this link points at. First page has page number number 1.
   */
  public int getPageNumber() {
    return pageNumber;
  }

  /**
   * The URL pointing at the result page.
   */
  public String getClickUrl() {
    return clickUrl;
  }

  /**
   * Determines if this page link points at the currently viewed/selected page.
   */
  public boolean getIsSelected() {
    return isSelected;
  }

  /**
   * Determines if this page link is hidden in the pager.
   * A hidden page link is usually displayed as dots (...) in the pager view.
   */
  public boolean getIsHidden() {
    return isHidden;
  }
}
