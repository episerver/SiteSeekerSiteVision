
package siteseeker.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Spell complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Spell">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="spell" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="htmlspell" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="autoCorrect" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Spell", propOrder = {
    "spell",
    "htmlspell",
    "autoCorrect"
})
public class Spell {

    @XmlElement(required = true)
    protected String spell;
    @XmlElement(required = true)
    protected String htmlspell;
    protected boolean autoCorrect;

    /**
     * Gets the value of the spell property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpell() {
        return spell;
    }

    /**
     * Sets the value of the spell property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpell(String value) {
        this.spell = value;
    }

    /**
     * Gets the value of the htmlspell property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHtmlspell() {
        return htmlspell;
    }

    /**
     * Sets the value of the htmlspell property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHtmlspell(String value) {
        this.htmlspell = value;
    }

    /**
     * Gets the value of the autoCorrect property.
     * 
     */
    public boolean isAutoCorrect() {
        return autoCorrect;
    }

    /**
     * Sets the value of the autoCorrect property.
     * 
     */
    public void setAutoCorrect(boolean value) {
        this.autoCorrect = value;
    }

}
