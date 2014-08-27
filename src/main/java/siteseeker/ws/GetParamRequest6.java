
package siteseeker.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getParamRequest6 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getParamRequest6">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:siteseeker}getParamRequest">
 *       &lt;sequence>
 *         &lt;element name="getAges" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getParamRequest6", propOrder = {
    "getAges"
})
public class GetParamRequest6
    extends GetParamRequest
{

    protected boolean getAges;

    /**
     * Gets the value of the getAges property.
     * 
     */
    public boolean isGetAges() {
        return getAges;
    }

    /**
     * Sets the value of the getAges property.
     * 
     */
    public void setGetAges(boolean value) {
        this.getAges = value;
    }

}
