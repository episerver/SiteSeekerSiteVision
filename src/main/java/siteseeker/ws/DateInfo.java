
package siteseeker.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for DateInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DateInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="s" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="e" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="unknownDateExists" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DateInfo", propOrder = {
    "s",
    "e",
    "unknownDateExists"
})
public class DateInfo {

    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar s;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar e;
    protected boolean unknownDateExists;

    /**
     * Gets the value of the s property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getS() {
        return s;
    }

    /**
     * Sets the value of the s property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setS(XMLGregorianCalendar value) {
        this.s = value;
    }

    /**
     * Gets the value of the e property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getE() {
        return e;
    }

    /**
     * Sets the value of the e property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setE(XMLGregorianCalendar value) {
        this.e = value;
    }

    /**
     * Gets the value of the unknownDateExists property.
     * 
     */
    public boolean isUnknownDateExists() {
        return unknownDateExists;
    }

    /**
     * Sets the value of the unknownDateExists property.
     * 
     */
    public void setUnknownDateExists(boolean value) {
        this.unknownDateExists = value;
    }

}
