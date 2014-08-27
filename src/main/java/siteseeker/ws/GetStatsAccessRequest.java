
package siteseeker.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getStatsAccessRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getStatsAccessRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ilang" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getStatsAccessRequest", propOrder = {
    "version",
    "ilang"
})
public class GetStatsAccessRequest {

    protected int version;
    @XmlElement(required = true)
    protected String ilang;

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

}
