
package org.openehealth.ipf.ws.stub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReviseORMResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReviseORMResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="status" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://gehcit.com/platform/cws/types/coreMessageTypes}CS">
 *               &lt;enumeration value="SUCCESS"/>
 *               &lt;enumeration value="FAILURE"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="errordescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReviseORMResponse", namespace = "http://gehcit.com/platform/cws/orm/types", propOrder = {
    "status",
    "errordescription"
})
public class ReviseORMResponse {

    protected String status;
    protected String errordescription;

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the errordescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrordescription() {
        return errordescription;
    }

    /**
     * Sets the value of the errordescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrordescription(String value) {
        this.errordescription = value;
    }


    public String toString() {
        return "Revise ORM Return Status " + this.getStatus() + " description: " + this.getErrordescription();
    }

}
