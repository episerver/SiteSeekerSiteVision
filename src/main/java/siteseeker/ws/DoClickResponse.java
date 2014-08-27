
package siteseeker.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ClickResponse" type="{urn:siteseeker}ClickResponse"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "clickResponse"
})
@XmlRootElement(name = "doClickResponse")
public class DoClickResponse {

    @XmlElement(name = "ClickResponse", required = true)
    protected ClickResponse clickResponse;

    /**
     * Gets the value of the clickResponse property.
     * 
     * @return
     *     possible object is
     *     {@link ClickResponse }
     *     
     */
    public ClickResponse getClickResponse() {
        return clickResponse;
    }

    /**
     * Sets the value of the clickResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClickResponse }
     *     
     */
    public void setClickResponse(ClickResponse value) {
        this.clickResponse = value;
    }

}
