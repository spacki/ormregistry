
package org.openehealth.ipf.ws.stub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GPHospitalDomainNameDetail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GPHospitalDomainNameDetail">
 *   &lt;complexContent>
 *     &lt;extension base="{http://gehcit.com/platform/cws/types/coreMessageTypes}MessageElement">
 *       &lt;sequence>
 *         &lt;element name="hospitalDomainId" type="{http://gehcit.com/platform/cws/types/coreMessageTypes}ST64"/>
 *         &lt;element name="hospitalDomainName" type="{http://gehcit.com/platform/cws/types/coreMessageTypes}ST64"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GPHospitalDomainNameDetail", propOrder = {
    "hospitalDomainId",
    "hospitalDomainName"
})
public class GPHospitalDomainNameDetail
    extends MessageElement
{

    @XmlElement(required = true)
    protected String hospitalDomainId;
    @XmlElement(required = true)
    protected String hospitalDomainName;

    /**
     * Gets the value of the hospitalDomainId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHospitalDomainId() {
        return hospitalDomainId;
    }

    /**
     * Sets the value of the hospitalDomainId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHospitalDomainId(String value) {
        this.hospitalDomainId = value;
    }

    /**
     * Gets the value of the hospitalDomainName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHospitalDomainName() {
        return hospitalDomainName;
    }

    /**
     * Sets the value of the hospitalDomainName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHospitalDomainName(String value) {
        this.hospitalDomainName = value;
    }

}
