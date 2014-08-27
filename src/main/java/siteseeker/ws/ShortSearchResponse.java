
package siteseeker.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ShortSearchResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ShortSearchResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ok" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="nHits" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="hits" type="{urn:siteseeker}ArrayOfShortHit" minOccurs="0"/>
 *         &lt;element name="bets" type="{urn:siteseeker}ArrayOfBet" minOccurs="0"/>
 *         &lt;element name="spells" type="{urn:siteseeker}ArrayOfSpell" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ShortSearchResponse", propOrder = {
    "message",
    "ok",
    "nHits",
    "hits",
    "bets",
    "spells"
})
public class ShortSearchResponse {

    @XmlElement(required = true)
    protected String message;
    protected boolean ok;
    protected int nHits;
    @XmlElementRef(name = "hits", namespace = "urn:siteseeker", type = JAXBElement.class)
    protected JAXBElement<ArrayOfShortHit> hits;
    @XmlElementRef(name = "bets", namespace = "urn:siteseeker", type = JAXBElement.class)
    protected JAXBElement<ArrayOfBet> bets;
    @XmlElementRef(name = "spells", namespace = "urn:siteseeker", type = JAXBElement.class)
    protected JAXBElement<ArrayOfSpell> spells;

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
     * Gets the value of the hits property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfShortHit }{@code >}
     *     
     */
    public JAXBElement<ArrayOfShortHit> getHits() {
        return hits;
    }

    /**
     * Sets the value of the hits property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfShortHit }{@code >}
     *     
     */
    public void setHits(JAXBElement<ArrayOfShortHit> value) {
        this.hits = ((JAXBElement<ArrayOfShortHit> ) value);
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

}
