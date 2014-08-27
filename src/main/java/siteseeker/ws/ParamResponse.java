
package siteseeker.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ParamResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ParamResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ok" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="notUpdated" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="time" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="cats" type="{urn:siteseeker}ArrayOfCategory" minOccurs="0"/>
 *         &lt;element name="bets" type="{urn:siteseeker}ArrayOfBet" minOccurs="0"/>
 *         &lt;element name="docs" type="{urn:siteseeker}ArrayOfDocType" minOccurs="0"/>
 *         &lt;element name="dates" type="{urn:siteseeker}DateInfo" minOccurs="0"/>
 *         &lt;element name="ages" type="{urn:siteseeker}ArrayOfAge" minOccurs="0"/>
 *         &lt;element name="langs" type="{urn:siteseeker}ArrayOfLang" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParamResponse", propOrder = {
    "ok",
    "notUpdated",
    "time",
    "cats",
    "bets",
    "docs",
    "dates",
    "ages",
    "langs"
})
public class ParamResponse {

    protected boolean ok;
    protected boolean notUpdated;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar time;
    @XmlElementRef(name = "cats", namespace = "urn:siteseeker", type = JAXBElement.class)
    protected JAXBElement<ArrayOfCategory> cats;
    @XmlElementRef(name = "bets", namespace = "urn:siteseeker", type = JAXBElement.class)
    protected JAXBElement<ArrayOfBet> bets;
    @XmlElementRef(name = "docs", namespace = "urn:siteseeker", type = JAXBElement.class)
    protected JAXBElement<ArrayOfDocType> docs;
    @XmlElementRef(name = "dates", namespace = "urn:siteseeker", type = JAXBElement.class)
    protected JAXBElement<DateInfo> dates;
    @XmlElementRef(name = "ages", namespace = "urn:siteseeker", type = JAXBElement.class)
    protected JAXBElement<ArrayOfAge> ages;
    @XmlElementRef(name = "langs", namespace = "urn:siteseeker", type = JAXBElement.class)
    protected JAXBElement<ArrayOfLang> langs;

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
     * Gets the value of the notUpdated property.
     * 
     */
    public boolean isNotUpdated() {
        return notUpdated;
    }

    /**
     * Sets the value of the notUpdated property.
     * 
     */
    public void setNotUpdated(boolean value) {
        this.notUpdated = value;
    }

    /**
     * Gets the value of the time property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTime() {
        return time;
    }

    /**
     * Sets the value of the time property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTime(XMLGregorianCalendar value) {
        this.time = value;
    }

    /**
     * Gets the value of the cats property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfCategory }{@code >}
     *     
     */
    public JAXBElement<ArrayOfCategory> getCats() {
        return cats;
    }

    /**
     * Sets the value of the cats property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfCategory }{@code >}
     *     
     */
    public void setCats(JAXBElement<ArrayOfCategory> value) {
        this.cats = ((JAXBElement<ArrayOfCategory> ) value);
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
     * Gets the value of the docs property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfDocType }{@code >}
     *     
     */
    public JAXBElement<ArrayOfDocType> getDocs() {
        return docs;
    }

    /**
     * Sets the value of the docs property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfDocType }{@code >}
     *     
     */
    public void setDocs(JAXBElement<ArrayOfDocType> value) {
        this.docs = ((JAXBElement<ArrayOfDocType> ) value);
    }

    /**
     * Gets the value of the dates property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DateInfo }{@code >}
     *     
     */
    public JAXBElement<DateInfo> getDates() {
        return dates;
    }

    /**
     * Sets the value of the dates property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DateInfo }{@code >}
     *     
     */
    public void setDates(JAXBElement<DateInfo> value) {
        this.dates = ((JAXBElement<DateInfo> ) value);
    }

    /**
     * Gets the value of the ages property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfAge }{@code >}
     *     
     */
    public JAXBElement<ArrayOfAge> getAges() {
        return ages;
    }

    /**
     * Sets the value of the ages property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfAge }{@code >}
     *     
     */
    public void setAges(JAXBElement<ArrayOfAge> value) {
        this.ages = ((JAXBElement<ArrayOfAge> ) value);
    }

    /**
     * Gets the value of the langs property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfLang }{@code >}
     *     
     */
    public JAXBElement<ArrayOfLang> getLangs() {
        return langs;
    }

    /**
     * Sets the value of the langs property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfLang }{@code >}
     *     
     */
    public void setLangs(JAXBElement<ArrayOfLang> value) {
        this.langs = ((JAXBElement<ArrayOfLang> ) value);
    }

}
