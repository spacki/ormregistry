
package org.openehealth.ipf.ws.stub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 *             This message element that describes the Accession Number of Order.
 *          
 * 
 * <p>Java class for GPOrderAccessionNumber complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GPOrderAccessionNumber">
 *   &lt;complexContent>
 *     &lt;extension base="{http://gehcit.com/platform/cws/types/coreMessageTypes}MessageElement">
 *       &lt;sequence>
 *         &lt;element name="acNoValue" type="{http://gehcit.com/platform/cws/types/coreMessageTypes}ID"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GPOrderAccessionNumber", propOrder = {
    "acNoValue"
})
public class GPOrderAccessionNumber
    extends MessageElement
{

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String acNoValue;

    /**
     * Gets the value of the acNoValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcNoValue() {
        return acNoValue;
    }

    /**
     * Sets the value of the acNoValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcNoValue(String value) {
        this.acNoValue = value;
    }

}
