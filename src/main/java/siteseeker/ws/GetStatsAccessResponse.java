
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
 *         &lt;element name="StatsAccessResponse" type="{urn:siteseeker}StatsAccessResponse"/>
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
    "statsAccessResponse"
})
@XmlRootElement(name = "getStatsAccessResponse")
public class GetStatsAccessResponse {

    @XmlElement(name = "StatsAccessResponse", required = true)
    protected StatsAccessResponse statsAccessResponse;

    /**
     * Gets the value of the statsAccessResponse property.
     * 
     * @return
     *     possible object is
     *     {@link StatsAccessResponse }
     *     
     */
    public StatsAccessResponse getStatsAccessResponse() {
        return statsAccessResponse;
    }

    /**
     * Sets the value of the statsAccessResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatsAccessResponse }
     *     
     */
    public void setStatsAccessResponse(StatsAccessResponse value) {
        this.statsAccessResponse = value;
    }

}
