
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
 *         &lt;element name="ParamResponse" type="{urn:siteseeker}ParamResponse"/>
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
    "paramResponse"
})
@XmlRootElement(name = "getParamResponse")
public class GetParamResponse {

    @XmlElement(name = "ParamResponse", required = true)
    protected ParamResponse paramResponse;

    /**
     * Gets the value of the paramResponse property.
     * 
     * @return
     *     possible object is
     *     {@link ParamResponse }
     *     
     */
    public ParamResponse getParamResponse() {
        return paramResponse;
    }

    /**
     * Sets the value of the paramResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParamResponse }
     *     
     */
    public void setParamResponse(ParamResponse value) {
        this.paramResponse = value;
    }

}
