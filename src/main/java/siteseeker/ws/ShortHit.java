
package siteseeker.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ShortHit complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ShortHit">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sourceLink" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dcIdentifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pageId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="inFrame" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="doctypeId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="categoryIds" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="modDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="size" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="langId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="hitNr" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="rank" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ShortHit", propOrder = {
    "title",
    "sourceLink",
    "dcIdentifier",
    "pageId",
    "inFrame",
    "doctypeId",
    "categoryIds",
    "modDate",
    "size",
    "langId",
    "hitNr",
    "rank"
})
public class ShortHit {

    @XmlElement(required = true)
    protected String title;
    @XmlElement(required = true)
    protected String sourceLink;
    @XmlElement(required = true)
    protected String dcIdentifier;
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

}
