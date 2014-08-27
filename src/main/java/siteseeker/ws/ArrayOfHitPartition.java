
package siteseeker.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfHitPartition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfHitPartition">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HitPartition" type="{urn:siteseeker}HitPartition" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfHitPartition", propOrder = {
    "hitPartition"
})
public class ArrayOfHitPartition {

    @XmlElement(name = "HitPartition", nillable = true)
    protected List<HitPartition> hitPartition;

    /**
     * Gets the value of the hitPartition property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hitPartition property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHitPartition().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HitPartition }
     * 
     * 
     */
    public List<HitPartition> getHitPartition() {
        if (hitPartition == null) {
            hitPartition = new ArrayList<HitPartition>();
        }
        return this.hitPartition;
    }

}
