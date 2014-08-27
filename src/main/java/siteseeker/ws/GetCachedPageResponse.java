
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
 *         &lt;element name="CachedPageResponse" type="{urn:siteseeker}CachedPageResponse"/>
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
    "cachedPageResponse"
})
@XmlRootElement(name = "getCachedPageResponse")
public class GetCachedPageResponse {

    @XmlElement(name = "CachedPageResponse", required = true)
    protected CachedPageResponse cachedPageResponse;

    /**
     * Gets the value of the cachedPageResponse property.
     * 
     * @return
     *     possible object is
     *     {@link CachedPageResponse }
     *     
     */
    public CachedPageResponse getCachedPageResponse() {
        return cachedPageResponse;
    }

    /**
     * Sets the value of the cachedPageResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link CachedPageResponse }
     *     
     */
    public void setCachedPageResponse(CachedPageResponse value) {
        this.cachedPageResponse = value;
    }

}
