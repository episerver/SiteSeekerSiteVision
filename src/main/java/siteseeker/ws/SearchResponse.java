
package siteseeker.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SearchResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SearchResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="query" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ok" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="nHits" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="first" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nHitsBatch" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="batchNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nBatch" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="hits" type="{urn:siteseeker}ArrayOfHit" minOccurs="0"/>
 *         &lt;element name="imageHits" type="{urn:siteseeker}ArrayOfHit" minOccurs="0"/>
 *         &lt;element name="cats" type="{urn:siteseeker}ArrayOfHitCategory" minOccurs="0"/>
 *         &lt;element name="matchingCats" type="{urn:siteseeker}ArrayOfHitCategory" minOccurs="0"/>
 *         &lt;element name="languages" type="{urn:siteseeker}ArrayOfHitPartition" minOccurs="0"/>
 *         &lt;element name="docTypes" type="{urn:siteseeker}ArrayOfHitPartition" minOccurs="0"/>
 *         &lt;element name="ages" type="{urn:siteseeker}ArrayOfHitPartition" minOccurs="0"/>
 *         &lt;element name="bets" type="{urn:siteseeker}ArrayOfBet" minOccurs="0"/>
 *         &lt;element name="spells" type="{urn:siteseeker}ArrayOfSpell" minOccurs="0"/>
 *         &lt;element name="responseId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="indexLastModified" type="{urn:siteseeker}Time" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchResponse", propOrder = {
    "query",
    "message",
    "ok",
    "nHits",
    "first",
    "nHitsBatch",
    "batchNumber",
    "nBatch",
    "hits",
    "imageHits",
    "cats",
    "matchingCats",
    "languages",
    "docTypes",
    "ages",
    "bets",
    "spells",
    "responseId",
    "indexLastModified"
})
public class SearchResponse {

    @XmlElement(required = true)
    protected String query;
    @XmlElement(required = true)
    protected String message;
    protected boolean ok;
    protected int nHits;
    protected int first;
    protected int nHitsBatch;
    protected int batchNumber;
    protected int nBatch;
    @XmlElementRef(name = "hits", namespace = "urn:siteseeker", type = JAXBElement.class)
    protected JAXBElement<ArrayOfHit> hits;
    @XmlElementRef(name = "imageHits", namespace = "urn:siteseeker", type = JAXBElement.class)
    protected JAXBElement<ArrayOfHit> imageHits;
    @XmlElementRef(name = "cats", namespace = "urn:siteseeker", type = JAXBElement.class)
    protected JAXBElement<ArrayOfHitCategory> cats;
    @XmlElementRef(name = "matchingCats", namespace = "urn:siteseeker", type = JAXBElement.class)
    protected JAXBElement<ArrayOfHitCategory> matchingCats;
    @XmlElementRef(name = "languages", namespace = "urn:siteseeker", type = JAXBElement.class)
    protected JAXBElement<ArrayOfHitPartition> languages;
    @XmlElementRef(name = "docTypes", namespace = "urn:siteseeker", type = JAXBElement.class)
    protected JAXBElement<ArrayOfHitPartition> docTypes;
    @XmlElementRef(name = "ages", namespace = "urn:siteseeker", type = JAXBElement.class)
    protected JAXBElement<ArrayOfHitPartition> ages;
    @XmlElementRef(name = "bets", namespace = "urn:siteseeker", type = JAXBElement.class)
    protected JAXBElement<ArrayOfBet> bets;
    @XmlElementRef(name = "spells", namespace = "urn:siteseeker", type = JAXBElement.class)
    protected JAXBElement<ArrayOfSpell> spells;
    protected int responseId;
    @XmlElementRef(name = "indexLastModified", namespace = "urn:siteseeker", type = JAXBElement.class)
    protected JAXBElement<Time> indexLastModified;

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
     * Gets the value of the first property.
     * 
     */
    public int getFirst() {
        return first;
    }

    /**
     * Sets the value of the first property.
     * 
     */
    public void setFirst(int value) {
        this.first = value;
    }

    /**
     * Gets the value of the nHitsBatch property.
     * 
     */
    public int getNHitsBatch() {
        return nHitsBatch;
    }

    /**
     * Sets the value of the nHitsBatch property.
     * 
     */
    public void setNHitsBatch(int value) {
        this.nHitsBatch = value;
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
     * Gets the value of the nBatch property.
     * 
     */
    public int getNBatch() {
        return nBatch;
    }

    /**
     * Sets the value of the nBatch property.
     * 
     */
    public void setNBatch(int value) {
        this.nBatch = value;
    }

    /**
     * Gets the value of the hits property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfHit }{@code >}
     *     
     */
    public JAXBElement<ArrayOfHit> getHits() {
        return hits;
    }

    /**
     * Sets the value of the hits property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfHit }{@code >}
     *     
     */
    public void setHits(JAXBElement<ArrayOfHit> value) {
        this.hits = ((JAXBElement<ArrayOfHit> ) value);
    }

    /**
     * Gets the value of the imageHits property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfHit }{@code >}
     *     
     */
    public JAXBElement<ArrayOfHit> getImageHits() {
        return imageHits;
    }

    /**
     * Sets the value of the imageHits property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfHit }{@code >}
     *     
     */
    public void setImageHits(JAXBElement<ArrayOfHit> value) {
        this.imageHits = ((JAXBElement<ArrayOfHit> ) value);
    }

    /**
     * Gets the value of the cats property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfHitCategory }{@code >}
     *     
     */
    public JAXBElement<ArrayOfHitCategory> getCats() {
        return cats;
    }

    /**
     * Sets the value of the cats property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfHitCategory }{@code >}
     *     
     */
    public void setCats(JAXBElement<ArrayOfHitCategory> value) {
        this.cats = ((JAXBElement<ArrayOfHitCategory> ) value);
    }

    /**
     * Gets the value of the matchingCats property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfHitCategory }{@code >}
     *     
     */
    public JAXBElement<ArrayOfHitCategory> getMatchingCats() {
        return matchingCats;
    }

    /**
     * Sets the value of the matchingCats property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfHitCategory }{@code >}
     *     
     */
    public void setMatchingCats(JAXBElement<ArrayOfHitCategory> value) {
        this.matchingCats = ((JAXBElement<ArrayOfHitCategory> ) value);
    }

    /**
     * Gets the value of the languages property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfHitPartition }{@code >}
     *     
     */
    public JAXBElement<ArrayOfHitPartition> getLanguages() {
        return languages;
    }

    /**
     * Sets the value of the languages property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfHitPartition }{@code >}
     *     
     */
    public void setLanguages(JAXBElement<ArrayOfHitPartition> value) {
        this.languages = ((JAXBElement<ArrayOfHitPartition> ) value);
    }

    /**
     * Gets the value of the docTypes property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfHitPartition }{@code >}
     *     
     */
    public JAXBElement<ArrayOfHitPartition> getDocTypes() {
        return docTypes;
    }

    /**
     * Sets the value of the docTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfHitPartition }{@code >}
     *     
     */
    public void setDocTypes(JAXBElement<ArrayOfHitPartition> value) {
        this.docTypes = ((JAXBElement<ArrayOfHitPartition> ) value);
    }

    /**
     * Gets the value of the ages property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfHitPartition }{@code >}
     *     
     */
    public JAXBElement<ArrayOfHitPartition> getAges() {
        return ages;
    }

    /**
     * Sets the value of the ages property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfHitPartition }{@code >}
     *     
     */
    public void setAges(JAXBElement<ArrayOfHitPartition> value) {
        this.ages = ((JAXBElement<ArrayOfHitPartition> ) value);
    }

    /**
     * Gets the value of the bets property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfBet }{@code >}
     *     
     */
    public JAXBElement<ArrayOfBet> getBets() {
        return bets;
    }

    /**
     * Sets the value of the bets property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfBet }{@code >}
     *     
     */
    public void setBets(JAXBElement<ArrayOfBet> value) {
        this.bets = ((JAXBElement<ArrayOfBet> ) value);
    }

    /**
     * Gets the value of the spells property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfSpell }{@code >}
     *     
     */
    public JAXBElement<ArrayOfSpell> getSpells() {
        return spells;
    }

    /**
     * Sets the value of the spells property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfSpell }{@code >}
     *     
     */
    public void setSpells(JAXBElement<ArrayOfSpell> value) {
        this.spells = ((JAXBElement<ArrayOfSpell> ) value);
    }

    /**
     * Gets the value of the responseId property.
     * 
     */
    public int getResponseId() {
        return responseId;
    }

    /**
     * Sets the value of the responseId property.
     * 
     */
    public void setResponseId(int value) {
        this.responseId = value;
    }

    /**
     * Gets the value of the indexLastModified property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Time }{@code >}
     *     
     */
    public JAXBElement<Time> getIndexLastModified() {
        return indexLastModified;
    }

    /**
     * Sets the value of the indexLastModified property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Time }{@code >}
     *     
     */
    public void setIndexLastModified(JAXBElement<Time> value) {
        this.indexLastModified = ((JAXBElement<Time> ) value);
    }

}
