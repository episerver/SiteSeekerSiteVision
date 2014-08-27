
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
 *         &lt;element name="SearchResponse" type="{urn:siteseeker}ShortSearchResponse"/>
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
    "searchResponse"
})
@XmlRootElement(name = "doShortSearchResponse")
public class DoShortSearchResponse {

    @XmlElement(name = "SearchResponse", required = true)
    protected ShortSearchResponse searchResponse;

    /**
     * Gets the value of the searchResponse property.
     * 
     * @return
     *     possible object is
     *     {@link ShortSearchResponse }
     *     
     */
    public ShortSearchResponse getSearchResponse() {
        return searchResponse;
    }

    /**
     * Sets the value of the searchResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShortSearchResponse }
     *     
     */
    public void setSearchResponse(ShortSearchResponse value) {
        this.searchResponse = value;
    }

}
