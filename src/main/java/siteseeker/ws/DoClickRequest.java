
package siteseeker.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for doClickRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="doClickRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="userIdentifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="responseId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="hitNr" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="mode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "doClickRequest", propOrder = {
    "version",
    "url",
    "userIdentifier",
    "responseId",
    "hitNr",
    "mode"
})
public class DoClickRequest {

    protected int version;
    @XmlElement(required = true)
    protected String url;
    @XmlElement(required = true)
    protected String userIdentifier;
    protected int responseId;
    protected int hitNr;
    protected int mode;

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
     * Gets the value of the url property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the value of the url property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrl(String value) {
        this.url = value;
    }

    /**
     * Gets the value of the userIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserIdentifier() {
        return userIdentifier;
    }

    /**
     * Sets the value of the userIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserIdentifier(String value) {
        this.userIdentifier = value;
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
     * Gets the value of the mode property.
     * 
     */
    public int getMode() {
        return mode;
    }

    /**
     * Sets the value of the mode property.
     * 
     */
    public void setMode(int value) {
        this.mode = value;
    }

}
