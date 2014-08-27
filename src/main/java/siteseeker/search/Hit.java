package siteseeker.search;

import java.io.Serializable;

import java.util.List;
import java.util.ArrayList;
import javax.xml.datatype.XMLGregorianCalendar;
import org.apache.commons.logging.LogFactory;

public class Hit implements Serializable {

  public static final long serialVersionUID = 1L;

  private siteseeker.ws.Hit wsHit;
  private String cacheUrl;
  private SearchFilter fileFormat;
  private List<SearchFilter> categories;
  private List<Hit> attachments;
  private MetaAttribute metaAttribute;

  /**
   * Get typed meta data.
   *
   * Using this class, you can access specific typed meta data from the template. From
   * velocity, you can for instance print the value of the "price" meta data by:
   *
   *   #if ( $hit.meta.price )
   *     $hit.meta.price
   *   #end
   * 
   * The return value is a string, so if you want to use integer or floating point operations,
   * you must type cast it. For instance:
   *
   *   #if ( $hit.meta.price.integer > 100 )
   *     $hit.meta.price
   *   #end
   */
  public class MetaAttribute {
    private String value;

    /**
     * Find the value of the meta data of the given name.
     *
     * This method will search through the list of meta datas of the current hit and
     * look for one of the given name. If found, the value will be stored in the private
     * member 'value' and a reference to this object will be returned. As the
     * name of this method is get(), it can be accessed from velocity in a quite
     * nice looking way. For example:
     *
     *   $hit.meta.price
     *
     * will call .get("price").
     *
     * @param name The name of the meta data parameter to find.
     * @return If the requested meta attribute is found, the method will return a
     *         reference to the object, thus the .toString() will be implicitly called. 
     *         This opens for the posibility of explicitly calling another method,
     *         like .getInteger() for instance. If the requested meta data is not found,
     *         null will be returned.
     */
    public MetaAttribute get(String name) {
      if ( wsHit.getMetaAttributes() != null ) {
        for ( siteseeker.ws.MetaAttr m : wsHit.getMetaAttributes().getValue().getMetaAttribute() ) {
          if ( m.getName().toLowerCase().equals(name.toLowerCase()) ) {
            this.value = m.getValue();
            return this;
          }
        }
      }
      return null;
    }
    
    /**
     * Return the value of the requested meta data parameter as a text string.
     *
     * @return Return the value of the meta data earlier prepared by the get() method.
     */
    public String toString() {
      return value;
    }

    /**
     * Return the value of the requested meta data parameter as an integer.
     *
     * @return Return the value of the meta data earlier prepared by the get() method.
     *         If the data cannot be converted to an integer, null will be returned.
     */
    public Integer getInteger() {
      try {
        return Integer.parseInt(value);
      } catch ( NumberFormatException e ) {
        return null;
      }
    }

    /**
     * Return the value of the requested meta data parameter as a float.
     *
     * @return Return the value of the meta data earlier prepared by the get() method.
     *         If the data cannot be converted to a float, null will be returned.
     */
    public Float getFloat() {
      try {
        return Float.parseFloat(value);
      } catch ( NumberFormatException e ) {
        return null;
      }
    }
  }

  public Hit(siteseeker.ws.Hit wsHit) {
    this.wsHit = wsHit;
  }

  /**
   * Create a new instance of the MetaAttribute class.
   *
   * On calling this method, an instance of the MetaAttribute class will be returned.
   * This is useful from velocity, as you can use this in a nice looking way for
   * accessing member methods. For instance,
   *
   *   $hit.meta
   *
   * will call this method and make its members accessible. Further,
   *
   *   $hit.meta.price
   *
   * will actually call .getMeta().get("price") on the hit object.
   *
   * @return Returns a new instance of the MetaAttribute class.
   *
   */
  public MetaAttribute getMeta() {
    return new MetaAttribute();
  }

  public int getPageId() {
    return wsHit.getPageId();
  }
  public String getTitle() {
    if (wsHit.getTitle() != null)
      return wsHit.getTitle();
    return "";
  }
  public String getTitleNoFormatting() {
    return getTitle().replaceAll("\\<.*?\\>", "");
  }
  public String getSortDate() {
    return wsHit.getModDate().toString();
  }
  public boolean getIsInFrame() {
    return wsHit.isInFrame();
  }
  public int getRank() {
    return wsHit.getRank();
  }
  public int getNumber() {
    return wsHit.getHitNr() + 1;
  }
  // Query dependent summary of the document
  public String getDynamicSnippet() {
    return wsHit.getDescription();
  }
  // "eri-desc"-content in page (static content)
  public String getStaticSnippet() {
    return wsHit.getSpecialText();
  }
  public String getMetaDescription() {
    return wsHit.getMetaDescription();
  }
  public int getSize() {
    return wsHit.getSize();
  }
  public String getHumanReadableSize() {
    int bytesize = wsHit.getSize();
    if(bytesize < 1024 ){
      String humanReadable = String.valueOf(bytesize) + " bytes";
      return humanReadable;
    }
    bytesize/=1024;
    if(bytesize < 1024 ){
      String humanReadable = String.valueOf(bytesize) + " kB";
      return humanReadable;
    }
    bytesize/=1024;
    if(bytesize < 1024 ){
      String humanReadable = String.valueOf(bytesize) + " MB";
      return humanReadable;
    }
    String humanReadable = String.valueOf(bytesize) + " GB";
    return humanReadable;	
  }
  public String getUrl() {
    return wsHit.getSourceLink();
  }
  public String getCacheUrl() {
    return cacheUrl;
  }
  public String getContextLink() {
    return wsHit.getContextLink();
  }
  public void setCacheUrl(String cacheUrl) {
    this.cacheUrl = cacheUrl;
  }
  public SearchFilter getFileFormat() {
    return fileFormat;
  }
  public void setFileFormat(SearchFilter fileFormat) {
    this.fileFormat = fileFormat;
  }
  public List<Integer> getCategoryIds() {
    return wsHit.getCategoryIds();
  }
  public XMLGregorianCalendar getModDate() {
    return wsHit.getModDate();
  }
  public String getYearMonthDay() {
    String fullDateString = wsHit.getModDate().toString();
    int dayEndIndex=fullDateString.indexOf("T");
    return fullDateString.substring(0,dayEndIndex); 
  }
  public void setCategories(List<SearchFilter> catlist) {
    this.categories = catlist;
  }
  public List<SearchFilter> getCategories() {
    return categories;
  }
  public void setAttachments(List<Hit> attachments) {
    this.attachments = attachments;
  }
  public List<Hit> getAttachments() {
    return attachments;
  }
}
