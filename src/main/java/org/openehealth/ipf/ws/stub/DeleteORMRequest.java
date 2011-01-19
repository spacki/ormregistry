
package org.openehealth.ipf.ws.stub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for DeleteORMRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeleteORMRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="order" type="{http://gehcit.com/platform/cws/types/coreMessageTypes}ID"/>
 *         &lt;element name="hospitalDomainId" type="{http://gehcit.com/platform/cws/types/coreMessageTypes}ST64"/>
 *         &lt;element name="acNoValue" type="{http://gehcit.com/platform/cws/types/coreMessageTypes}ID"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeleteORMRequest", namespace = "http://gehcit.com/platform/cws/orm/types", propOrder = {
    "order",
    "hospitalDomainId",
    "acNoValue"
})
public class DeleteORMRequest {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String order;
    @XmlElement(required = true)
    protected String hospitalDomainId;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String acNoValue;

    /**
     * Gets the value of the order property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrder() {
        return order;
    }

    /**
     * Sets the value of the order property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrder(String value) {
        this.order = value;
    }

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
