
package siteseeker.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HitPartition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HitPartition">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nDocs" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nHits" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HitPartition", propOrder = {
    "id",
    "name",
    "nDocs",
    "nHits"
})
public class HitPartition {

    protected int id;
    @XmlElement(required = true)
    protected String name;
    protected int nDocs;
    protected int nHits;

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the nDocs property.
     * 
     */
    public int getNDocs() {
        return nDocs;
    }

    /**
     * Sets the value of the nDocs property.
     * 
     */
    public void setNDocs(int value) {
        this.nDocs = value;
    }

    /**
     * Gets the value of the nHits property.
     * 
     */
    public int getNHits() {
        return nHits;
    }

    /**
     * Sets the value of the nHits property.
     * 
     */
    public void setNHits(int value) {
        this.nHits = value;
    }

}
