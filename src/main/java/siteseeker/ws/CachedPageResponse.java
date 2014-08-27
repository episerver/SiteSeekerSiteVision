
package siteseeker.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CachedPageResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CachedPageResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nmarks" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="page" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="query" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dcIdentifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ok" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="thumbnail" type="{urn:siteseeker}Thumbnail" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CachedPageResponse", propOrder = {
    "nmarks",
    "page",
    "query",
    "type",
    "dcIdentifier",
    "ok",
    "message",
    "thumbnail"
})
public class CachedPageResponse {

    protected int nmarks;
    @XmlElement(required = true)
    protected String page;
    @XmlElement(required = true)
    protected String query;
    @XmlElement(required = true)
    protected String type;
    @XmlElement(required = true)
    protected String dcIdentifier;
    protected boolean ok;
    @XmlElement(required = true)
    protected String message;
    @XmlElementRef(name = "thumbnail", namespace = "urn:siteseeker", type = JAXBElement.class)
    protected JAXBElement<Thumbnail> thumbnail;

    /**
     * Gets the value of the nmarks property.
     * 
     */
    public int getNmarks() {
        return nmarks;
    }

    /**
     * Sets the value of the nmarks property.
     * 
     */
    public void setNmarks(int value) {
        this.nmarks = value;
    }

    /**
     * Gets the value of the page property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPage() {
        return page;
    }

    /**
     * Sets the value of the page property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPage(String value) {
        this.page = value;
    }

    /**
     * Gets the value of the query property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuery() {
        return query;
    }

    /**
     * Sets the value of the query property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuery(String value) {
        this.query = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the dcIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcIdentifier() {
        return dcIdentifier;
    }

    /**
     * Sets the value of the dcIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcIdentifier(String value) {
        this.dcIdentifier = value;
    }

    /**
     * Gets the value of the ok property.
     * 
     */
    public boolean isOk() {
        return ok;
    }

    /**
     * Sets the value of the ok property.
     * 
     */
    public void setOk(boolean value) {
        this.ok = value;
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Gets the value of the thumbnail property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Thumbnail }{@code >}
     *     
     */
    public JAXBElement<Thumbnail> getThumbnail() {
        return thumbnail;
    }

    /**
     * Sets the value of the thumbnail property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Thumbnail }{@code >}
     *     
     */
    public void setThumbnail(JAXBElement<Thumbnail> value) {
        this.thumbnail = ((JAXBElement<Thumbnail> ) value);
    }

}
