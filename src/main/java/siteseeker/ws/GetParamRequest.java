
package siteseeker.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for getParamRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getParamRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="lastQuery" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="ilang" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="getCategories" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="getBestBets" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="getDoctypes" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="getDates" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="getLanguages" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getParamRequest", propOrder = {
    "version",
    "lastQuery",
    "ilang",
    "getCategories",
    "getBestBets",
    "getDoctypes",
    "getDates",
    "getLanguages"
})
@XmlSeeAlso({
    GetParamRequest6 .class
})
public class GetParamRequest {

    protected int version;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastQuery;
    @XmlElement(required = true)
    protected String ilang;
    protected boolean getCategories;
    protected boolean getBestBets;
    protected boolean getDoctypes;
    protected boolean getDates;
    protected boolean getLanguages;

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

    /**
     * Gets the value of the lastQuery property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastQuery() {
        return lastQuery;
    }

    /**
     * Sets the value of the lastQuery property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastQuery(XMLGregorianCalendar value) {
        this.lastQuery = value;
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
     * Gets the value of the getCategories property.
     * 
     */
    public boolean isGetCategories() {
        return getCategories;
    }

    /**
     * Sets the value of the getCategories property.
     * 
     */
    public void setGetCategories(boolean value) {
        this.getCategories = value;
    }

    /**
     * Gets the value of the getBestBets property.
     * 
     */
    public boolean isGetBestBets() {
        return getBestBets;
    }

    /**
     * Sets the value of the getBestBets property.
     * 
     */
    public void setGetBestBets(boolean value) {
        this.getBestBets = value;
    }

    /**
     * Gets the value of the getDoctypes property.
     * 
     */
    public boolean isGetDoctypes() {
        return getDoctypes;
    }

    /**
     * Sets the value of the getDoctypes property.
     * 
     */
    public void setGetDoctypes(boolean value) {
        this.getDoctypes = value;
    }

    /**
     * Gets the value of the getDates property.
     * 
     */
    public boolean isGetDates() {
        return getDates;
    }

    /**
     * Sets the value of the getDates property.
     * 
     */
    public void setGetDates(boolean value) {
        this.getDates = value;
    }

    /**
     * Gets the value of the getLanguages property.
     * 
     */
    public boolean isGetLanguages() {
        return getLanguages;
    }

    /**
     * Sets the value of the getLanguages property.
     * 
     */
    public void setGetLanguages(boolean value) {
        this.getLanguages = value;
    }

}
