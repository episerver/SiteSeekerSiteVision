
package siteseeker.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HitCategory complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HitCategory">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nameHighlighted" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nDocs" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="groupId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="groupName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nHits" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nHitsInBatch" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HitCategory", propOrder = {
    "id",
    "name",
    "nameHighlighted",
    "nDocs",
    "groupId",
    "groupName",
    "nHits",
    "nHitsInBatch"
})
public class HitCategory {

    protected int id;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String nameHighlighted;
    protected int nDocs;
    protected int groupId;
    @XmlElement(required = true)
    protected String groupName;
    protected int nHits;
    @XmlElementRef(name = "nHitsInBatch", namespace = "urn:siteseeker", type = JAXBElement.class)
    protected JAXBElement<Integer> nHitsInBatch;

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
     * Gets the value of the nameHighlighted property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameHighlighted() {
        return nameHighlighted;
    }

    /**
     * Sets the value of the nameHighlighted property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameHighlighted(String value) {
        this.nameHighlighted = value;
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
     * Gets the value of the groupId property.
     * 
     */
    public int getGroupId() {
        return groupId;
    }

    /**
     * Sets the value of the groupId property.
     * 
     */
    public void setGroupId(int value) {
        this.groupId = value;
    }

    /**
     * Gets the value of the groupName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * Sets the value of the groupName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupName(String value) {
        this.groupName = value;
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

    /**
     * Gets the value of the nHitsInBatch property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getNHitsInBatch() {
        return nHitsInBatch;
    }

    /**
     * Sets the value of the nHitsInBatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setNHitsInBatch(JAXBElement<Integer> value) {
        this.nHitsInBatch = ((JAXBElement<Integer> ) value);
    }

}
