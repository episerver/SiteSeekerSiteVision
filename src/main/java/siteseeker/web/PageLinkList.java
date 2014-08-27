package siteseeker.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * A <code>SearchResultPageLinkList</code> represents a pager for paginating hits in the result
 * A pager allows the user to select which page (i.e. batch of hits) to be displayed.
 * The number of hits to be returned in each batch can be set in the @see siteseeker.ws.DoSearchRequest.
 */
public class PageLinkList implements Serializable, Iterable<PageLink> {

  public static final long serialVersionUID = 1L;

  private ArrayList<PageLink> pageLinks;
  private int numVisiblePageLinks;
  private int pageNumber;
  private int nPages;
  private SearchUrl url;

  /**
   * Constructs a new <code>PageLinkList</code>.
   * @param connector - The current search response.
   */
  public PageLinkList(SearchUrl currentUrl, int pageNumber, int nPages, int nVisiblePageLinks) {
    pageLinks = new ArrayList<PageLink>();

    this.pageNumber = pageNumber;
    this.nPages = nPages;
    this.url = currentUrl;
    this.numVisiblePageLinks = nVisiblePageLinks;
  }

  /**
   * @return <code>true</code> if the current page/batch number is greater than 1, i.e. previous page(s) exist.
   */
  public boolean getHasPrevious()    {
    return (pageNumber > 1);
  }

  /**
   * @return <code>true</code> if the search result contains batches with batch numbers greater than the current page number.
   */
  public boolean getHasNext()     {
    return (pageNumber < nPages);
  }

  /**
   * The URL to the previous page/batch (current page number - 1).
   * If a next page does not exist, this method returns <code>null</code>.
   */
  public String getPreviousUrl() {
    if (getHasPrevious())
      return createUrl(pageNumber - 1);
    else
      return null;
  }

  /**
   * The URL to the next page/batch (current page number + 1).
   * If a next page does not exist, this method returns <code>null</code>.
   */
  public String getNextUrl() {
    if (getHasNext()) {
      return createUrl(pageNumber + 1);
    } else {
      return null;
    }
  }

  /**
   * The number of visible page links in the pager.
   * Hidden page links will appear in the pager if the number of batches for the current <code>SearchResponse</code> exceed the number of visible page links.
   */
  public int getNumVisiblePageLinks() {
    return numVisiblePageLinks;
  }

  /**
   * The list of page links
   * @return list
   */
  public List<PageLink> getLinks() {
    return pageLinks;
  }

  public Iterator<PageLink> iterator() {
    return pageLinks.iterator();
  }

  /**
   * Adds a page link to this pager.
   * @param batchNumber - The batch/page number for the page link to add.
   */
  public void add(int batchNumber) {
    if (batchNumber == -1) {
      pageLinks.add(PageLink.HIDDEN);
    } else {
      pageLinks.add(new PageLink(batchNumber, createUrl(batchNumber),
                                 pageNumber == batchNumber));
    }
  }    

  /**
   * Creates the list of page links.
   */
  public void createPageLinks() {
    int listLength = numVisiblePageLinks - 1; // Maximum number of visible links in page list
    int centerIndex = listLength / 2;
    int currentIndex = pageNumber - 1;
    if (listLength > nPages) {
      listLength = nPages;
    }
    int fp = currentIndex - centerIndex;
    if (fp < 0) {
      fp = 0;
    }
    int lp = fp + listLength;
    if (lp > nPages) {
      lp = nPages;
      fp = (nPages < listLength) ? 0 : (nPages - listLength);
    }
    for (int i = 0; i < nPages; i++) {
      if (i < fp) {
        if ((i - fp) == -1) {
          this.add(-1);
        }
      } else if (i > lp) {
        if ((lp - i) == -1) {
          this.add(-1);
        }
      } else {
        this.add(i+1);
      }
    }
  }

  private String createUrl(int batchNumber) {
    return url.buildPageLinkUrl(batchNumber);
  }

  public int getSize() {
    return pageLinks.size();
  }
    
}
