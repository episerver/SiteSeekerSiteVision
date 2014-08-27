
package siteseeker.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for doSearchRequest5 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="doSearchRequest5">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:siteseeker}doSearchRequest3">
 *       &lt;sequence>
 *         &lt;element name="parameters" type="{urn:siteseeker}SearchParameter" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "doSearchRequest5", propOrder = {
    "parameters"
})
@XmlSeeAlso({
    DoSearchRequest6 .class
})
public class DoSearchRequest5
    extends DoSearchRequest3
{

    protected List<SearchParameter> parameters;

    /**
     * Gets the value of the parameters property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parameters property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParameters().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SearchParameter }
     * 
     * 
     */
    public List<SearchParameter> getParameters() {
        if (parameters == null) {
            parameters = new ArrayList<SearchParameter>();
        }
        return this.parameters;
    }

}
