
package siteseeker.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Attachments complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Attachments">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nAttachments" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="attachments" type="{urn:siteseeker}Hit" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Attachments", propOrder = {
    "nAttachments",
    "attachments"
})
public class Attachments {

    protected int nAttachments;
    @XmlElement(nillable = true)
    protected List<Hit> attachments;

    /**
     * Gets the value of the nAttachments property.
     * 
     */
    public int getNAttachments() {
        return nAttachments;
    }

    /**
     * Sets the value of the nAttachments property.
     * 
     */
    public void setNAttachments(int value) {
        this.nAttachments = value;
    }

    /**
     * Gets the value of the attachments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attachments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttachments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Hit }
     * 
     * 
     */
    public List<Hit> getAttachments() {
        if (attachments == null) {
            attachments = new ArrayList<Hit>();
        }
        return this.attachments;
    }

}
