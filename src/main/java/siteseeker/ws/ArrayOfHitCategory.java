
package siteseeker.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfHitCategory complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfHitCategory">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HitCategory" type="{urn:siteseeker}HitCategory" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfHitCategory", propOrder = {
    "hitCategory"
})
public class ArrayOfHitCategory {

    @XmlElement(name = "HitCategory", nillable = true)
    protected List<HitCategory> hitCategory;

    /**
     * Gets the value of the hitCategory property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hitCategory property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHitCategory().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HitCategory }
     * 
     * 
     */
    public List<HitCategory> getHitCategory() {
        if (hitCategory == null) {
            hitCategory = new ArrayList<HitCategory>();
        }
        return this.hitCategory;
    }

}
