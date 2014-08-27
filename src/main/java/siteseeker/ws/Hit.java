
package siteseeker.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Hit complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Hit">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="metaDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="specialText" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sourceLink" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sourceLinkHighlighted" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contextLink" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dcIdentifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="teaserImageUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pageId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="inFrame" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="doctypeId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="categoryIds" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="modDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="size" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="langId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="hitNr" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="rank" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="metaAttributes" type="{urn:siteseeker}ArrayOfMetaAttr" minOccurs="0"/>
 *         &lt;element name="matchesQuery" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="attachments" type="{urn:siteseeker}Attachments" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Hit", propOrder = {
    "title",
    "description",
    "metaDescription",
    "specialText",
    "sourceLink",
    "sourceLinkHighlighted",
    "contextLink",
    "dcIdentifier",
    "teaserImageUrl",
    "pageId",
    "inFrame",
    "doctypeId",
    "categoryIds",
    "modDate",
    "size",
    "langId",
    "hitNr",
    "rank",
    "metaAttributes",
    "matchesQuery",
    "attachments"
})
public class Hit {

    @XmlElement(required = true)
    protected String title;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(required = true)
    protected String metaDescription;
    @XmlElement(required = true)
    protected String specialText;
    @XmlElement(required = true)
    protected String sourceLink;
    @XmlElementRef(name = "sourceLinkHighlighted", namespace = "urn:siteseeker", type = JAXBElement.class)
    protected JAXBElement<String> sourceLinkHighlighted;
    @XmlElement(required = true)
    protected String contextLink;
    @XmlElement(required = true)
    protected String dcIdentifier;
    @XmlElementRef(name = "teaserImageUrl", namespace = "urn:siteseeker", type = JAXBElement.class)
    protected JAXBElement<String> teaserImageUrl;
    protected int pageId;
    protected boolean inFrame;
    protected int doctypeId;
    @XmlElement(type = Integer.class)
    protected List<Integer> categoryIds;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar modDate;
    protected int size;
    protected int langId;
    protected int hitNr;
    protected int rank;
    @XmlElementRef(name = "metaAttributes", namespace = "urn:siteseeker", type = JAXBElement.class)
    protected JAXBElement<ArrayOfMetaAttr> metaAttributes;
    @XmlElementRef(name = "matchesQuery", namespace = "urn:siteseeker", type = JAXBElement.class)
    protected JAXBElement<Boolean> matchesQuery;
    @XmlElementRef(name = "attachments", namespace = "urn:siteseeker", type = JAXBElement.class)
    protected JAXBElement<Attachments> attachments;

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the metaDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMetaDescription() {
        return metaDescription;
    }

    /**
     * Sets the value of the metaDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMetaDescription(String value) {
        this.metaDescription = value;
    }

    /**
     * Gets the value of the specialText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecialText() {
        return specialText;
    }

    /**
     * Sets the value of the specialText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecialText(String value) {
        this.specialText = value;
    }

    /**
     * Gets the value of the sourceLink property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceLink() {
        return sourceLink;
    }

    /**
     * Sets the value of the sourceLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceLink(String value) {
        this.sourceLink = value;
    }

    /**
     * Gets the value of the sourceLinkHighlighted property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSourceLinkHighlighted() {
        return sourceLinkHighlighted;
    }

    /**
     * Sets the value of the sourceLinkHighlighted property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSourceLinkHighlighted(JAXBElement<String> value) {
        this.sourceLinkHighlighted = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the contextLink property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContextLink() {
        return contextLink;
    }

    /**
     * Sets the value of the contextLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContextLink(String value) {
        this.contextLink = value;
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
     * Gets the value of the teaserImageUrl property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTeaserImageUrl() {
        return teaserImageUrl;
    }

    /**
     * Sets the value of the teaserImageUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTeaserImageUrl(JAXBElement<String> value) {
        this.teaserImageUrl = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the pageId property.
     * 
     */
    public int getPageId() {
        return pageId;
    }

    /**
     * Sets the value of the pageId property.
     * 
     */
    public void setPageId(int value) {
        this.pageId = value;
    }

    /**
     * Gets the value of the inFrame property.
     * 
     */
    public boolean isInFrame() {
        return inFrame;
    }

    /**
     * Sets the value of the inFrame property.
     * 
     */
    public void setInFrame(boolean value) {
        this.inFrame = value;
    }

    /**
     * Gets the value of the doctypeId property.
     * 
     */
    public int getDoctypeId() {
        return doctypeId;
    }

    /**
     * Sets the value of the doctypeId property.
     * 
     */
    public void setDoctypeId(int value) {
        this.doctypeId = value;
    }

    /**
     * Gets the value of the categoryIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the categoryIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCategoryIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getCategoryIds() {
        if (categoryIds == null) {
            categoryIds = new ArrayList<Integer>();
        }
        return this.categoryIds;
    }

    /**
     * Gets the value of the modDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getModDate() {
        return modDate;
    }

    /**
     * Sets the value of the modDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setModDate(XMLGregorianCalendar value) {
        this.modDate = value;
    }

    /**
     * Gets the value of the size property.
     * 
     */
    public int getSize() {
        return size;
    }

    /**
     * Sets the value of the size property.
     * 
     */
    public void setSize(int value) {
        this.size = value;
    }

    /**
     * Gets the value of the langId property.
     * 
     */
    public int getLangId() {
        return langId;
    }

    /**
     * Sets the value of the langId property.
     * 
     */
    public void setLangId(int value) {
        this.langId = value;
    }

    /**
     * Gets the value of the hitNr property.
     * 
     */
    public int getHitNr() {
        return hitNr;
    }

    /**
     * Sets the value of the hitNr property.
     * 
     */
    public void setHitNr(int value) {
        this.hitNr = value;
    }

    /**
     * Gets the value of the rank property.
     * 
     */
    public int getRank() {
        return rank;
    }

    /**
     * Sets the value of the rank property.
     * 
     */
    public void setRank(int value) {
        this.rank = value;
    }

    /**
     * Gets the value of the metaAttributes property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfMetaAttr }{@code >}
     *     
     */
    public JAXBElement<ArrayOfMetaAttr> getMetaAttributes() {
        return metaAttributes;
    }

    /**
     * Sets the value of the metaAttributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfMetaAttr }{@code >}
     *     
     */
    public void setMetaAttributes(JAXBElement<ArrayOfMetaAttr> value) {
        this.metaAttributes = ((JAXBElement<ArrayOfMetaAttr> ) value);
    }

    /**
     * Gets the value of the matchesQuery property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getMatchesQuery() {
        return matchesQuery;
    }

    /**
     * Sets the value of the matchesQuery property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setMatchesQuery(JAXBElement<Boolean> value) {
        this.matchesQuery = ((JAXBElement<Boolean> ) value);
    }

    /**
     * Gets the value of the attachments property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Attachments }{@code >}
     *     
     */
    public JAXBElement<Attachments> getAttachments() {
        return attachments;
    }

    /**
     * Sets the value of the attachments property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Attachments }{@code >}
     *     
     */
    public void setAttachments(JAXBElement<Attachments> value) {
        this.attachments = ((JAXBElement<Attachments> ) value);
    }

}
