
package org.openehealth.ipf.ws.stub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *             A simple person name, with family and given names only.
 *          
 * 
 * <p>Java class for GPPatientNameDetail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GPPatientNameDetail">
 *   &lt;complexContent>
 *     &lt;extension base="{http://gehcit.com/platform/cws/types/coreMessageTypes}MessageElement">
 *       &lt;sequence>
 *         &lt;element name="firstName" type="{http://gehcit.com/platform/cws/types/coreMessageTypes}ST64"/>
 *         &lt;element name="lastName" type="{http://gehcit.com/platform/cws/types/coreMessageTypes}ST64"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GPPatientNameDetail", propOrder = {
    "firstName",
    "lastName"
})
public class GPPatientNameDetail
    extends MessageElement
{

    @XmlElement(required = true)
    protected String firstName;
    @XmlElement(required = true)
    protected String lastName;

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

}
