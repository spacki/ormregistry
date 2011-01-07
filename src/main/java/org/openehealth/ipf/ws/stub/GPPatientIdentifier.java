
package org.openehealth.ipf.ws.stub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 *             This message element that describes an identifier issued from a identification domain.
 *          
 * 
 * <p>Java class for GPPatientIdentifier complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GPPatientIdentifier">
 *   &lt;complexContent>
 *     &lt;extension base="{http://gehcit.com/platform/cws/types/coreMessageTypes}MessageElement">
 *       &lt;sequence>
 *         &lt;element name="domainId" type="{http://gehcit.com/platform/cws/types/coreMessageTypes}OID"/>
 *         &lt;element name="idValue" type="{http://gehcit.com/platform/cws/types/coreMessageTypes}ID"/>
 *         &lt;element name="idTypeCode" type="{http://gehcit.com/platform/cws/types/coreMessageTypes}CS" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GPPatientIdentifier", propOrder = {
    "domainId",
    "idValue",
    "idTypeCode"
})
public class GPPatientIdentifier
    extends MessageElement
{

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String domainId;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String idValue;
    protected String idTypeCode;

    /**
     * Gets the value of the domainId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDomainId() {
        return domainId;
    }

    /**
     * Sets the value of the domainId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDomainId(String value) {
        this.domainId = value;
    }

    /**
     * Gets the value of the idValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdValue() {
        return idValue;
    }

    /**
     * Sets the value of the idValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdValue(String value) {
        this.idValue = value;
    }

    /**
     * Gets the value of the idTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdTypeCode() {
        return idTypeCode;
    }

    /**
     * Sets the value of the idTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdTypeCode(String value) {
        this.idTypeCode = value;
    }

}
