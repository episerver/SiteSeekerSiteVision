
package siteseeker.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for doSearchRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="doSearchRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="query" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ilang" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="category" type="{urn:siteseeker}FilterArray" minOccurs="0"/>
 *         &lt;element name="language" type="{urn:siteseeker}FilterNum" minOccurs="0"/>
 *         &lt;element name="format" type="{urn:siteseeker}FilterNum" minOccurs="0"/>
 *         &lt;element name="stemming" type="{urn:siteseeker}FilterBool" minOccurs="0"/>
 *         &lt;element name="date" type="{urn:siteseeker}DateRange" minOccurs="0"/>
 *         &lt;element name="sortOrder" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="batchNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="hitsIds" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="nHits" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "doSearchRequest", propOrder = {
    "query",
    "ilang",
    "category",
    "language",
    "format",
    "stemming",
    "date",
    "sortOrder",
    "batchNumber",
    "hitsIds",
    "nHits",
    "version"
})
@XmlSeeAlso({
    DoSearchRequest3 .class
})
public class DoSearchRequest {

    @XmlElement(required = true)
    protected String query;
    @XmlElement(required = true)
    protected String ilang;
    @XmlElementRef(name = "category", namespace = "urn:siteseeker", type = JAXBElement.class)
    protected JAXBElement<FilterArray> category;
    @XmlElementRef(name = "language", namespace = "urn:siteseeker", type = JAXBElement.class)
    protected JAXBElement<FilterNum> language;
    @XmlElementRef(name = "format", namespace = "urn:siteseeker", type = JAXBElement.class)
    protected JAXBElement<FilterNum> format;
    @XmlElementRef(name = "stemming", namespace = "urn:siteseeker", type = JAXBElement.class)
    protected JAXBElement<FilterBool> stemming;
    @XmlElementRef(name = "date", namespace = "urn:siteseeker", type = JAXBElement.class)
    protected JAXBElement<DateRange> date;
    protected int sortOrder;
    protected int batchNumber;
    @XmlElement(type = Integer.class)
    protected List<Integer> hitsIds;
    protected int nHits;
    protected int version;

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
     * Gets the value of the ilang property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIlang() {
        return ilang;
    }

    /**
     * Sets the value of the ilang property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIlang(String value) {
        this.ilang = value;
    }

    /**
     * Gets the value of the category property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FilterArray }{@code >}
     *     
     */
    public JAXBElement<FilterArray> getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FilterArray }{@code >}
     *     
     */
    public void setCategory(JAXBElement<FilterArray> value) {
        this.category = ((JAXBElement<FilterArray> ) value);
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FilterNum }{@code >}
     *     
     */
    public JAXBElement<FilterNum> getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FilterNum }{@code >}
     *     
     */
    public void setLanguage(JAXBElement<FilterNum> value) {
        this.language = ((JAXBElement<FilterNum> ) value);
    }

    /**
     * Gets the value of the format property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FilterNum }{@code >}
     *     
     */
    public JAXBElement<FilterNum> getFormat() {
        return format;
    }

    /**
     * Sets the value of the format property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FilterNum }{@code >}
     *     
     */
    public void setFormat(JAXBElement<FilterNum> value) {
        this.format = ((JAXBElement<FilterNum> ) value);
    }

    /**
     * Gets the value of the stemming property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FilterBool }{@code >}
     *     
     */
    public JAXBElement<FilterBool> getStemming() {
        return stemming;
    }

    /**
     * Sets the value of the stemming property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FilterBool }{@code >}
     *     
     */
    public void setStemming(JAXBElement<FilterBool> value) {
        this.stemming = ((JAXBElement<FilterBool> ) value);
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DateRange }{@code >}
     *     
     */
    public JAXBElement<DateRange> getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DateRange }{@code >}
     *     
     */
    public void setDate(JAXBElement<DateRange> value) {
        this.date = ((JAXBElement<DateRange> ) value);
    }

    /**
     * Gets the value of the sortOrder property.
     * 
     */
    public int getSortOrder() {
        return sortOrder;
    }

    /**
     * Sets the value of the sortOrder property.
     * 
     */
    public void setSortOrder(int value) {
        this.sortOrder = value;
    }

    /**
     * Gets the value of the batchNumber property.
     * 
     */
    public int getBatchNumber() {
        return batchNumber;
    }

    /**
     * Sets the value of the batchNumber property.
     * 
     */
    public void setBatchNumber(int value) {
        this.batchNumber = value;
    }

    /**
     * Gets the value of the hitsIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hitsIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHitsIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getHitsIds() {
        if (hitsIds == null) {
            hitsIds = new ArrayList<Integer>();
        }
        return this.hitsIds;
    }

    /**
     * Gets the value of the nHits property.
     * 
     */
    public int getNHits() {
        return nHits;
    }

    /**
     * Sets the value of the nHits property.
     * 
     */
    public void setNHits(int value) {
        this.nHits = value;
    }

    /**
     * Gets the value of the version property.
     * 
     */
    public int getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     */
    public void setVersion(int value) {
        this.version = value;
    }

}
