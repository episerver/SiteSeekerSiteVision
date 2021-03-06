
package siteseeker.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for doSearchRequest3 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="doSearchRequest3">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:siteseeker}doSearchRequest">
 *       &lt;sequence>
 *         &lt;element name="userIdentifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="responseId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="spellSuggestion" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="userTokens" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "doSearchRequest3", propOrder = {
    "userIdentifier",
    "responseId",
    "spellSuggestion",
    "userTokens"
})
@XmlSeeAlso({
    DoSearchRequest5 .class
})
public class DoSearchRequest3
    extends DoSearchRequest
{

    @XmlElement(required = true)
    protected String userIdentifier;
    protected int responseId;
    protected boolean spellSuggestion;
    @XmlElement(required = true)
    protected String userTokens;

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
     * Gets the value of the spellSuggestion property.
     * 
     */
    public boolean isSpellSuggestion() {
        return spellSuggestion;
    }

    /**
     * Sets the value of the spellSuggestion property.
     * 
     */
    public void setSpellSuggestion(boolean value) {
        this.spellSuggestion = value;
    }

    /**
     * Gets the value of the userTokens property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserTokens() {
        return userTokens;
    }

    /**
     * Sets the value of the userTokens property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserTokens(String value) {
        this.userTokens = value;
    }

}
