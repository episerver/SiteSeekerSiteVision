
package siteseeker.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for doSearchRequest6 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="doSearchRequest6">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:siteseeker}doSearchRequest5">
 *       &lt;sequence>
 *         &lt;element name="age" type="{urn:siteseeker}FilterNum" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "doSearchRequest6", propOrder = {
    "age"
})
public class DoSearchRequest6
    extends DoSearchRequest5
{

    @XmlElementRef(name = "age", namespace = "urn:siteseeker", type = JAXBElement.class)
    protected JAXBElement<FilterNum> age;

    /**
     * Gets the value of the age property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FilterNum }{@code >}
     *     
     */
    public JAXBElement<FilterNum> getAge() {
        return age;
    }

    /**
     * Sets the value of the age property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FilterNum }{@code >}
     *     
     */
    public void setAge(JAXBElement<FilterNum> value) {
        this.age = ((JAXBElement<FilterNum> ) value);
    }

}
