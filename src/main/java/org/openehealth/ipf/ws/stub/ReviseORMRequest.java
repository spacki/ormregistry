
package org.openehealth.ipf.ws.stub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReviseORMRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReviseORMRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="order" type="{http://gehcit.com/platform/cws/orm/types/ormInformation}OrderFull"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReviseORMRequest", namespace = "http://gehcit.com/platform/cws/orm/types", propOrder = {
    "order"
})
public class ReviseORMRequest {

    @XmlElement(required = true)
    protected OrderFull order;

    /**
     * Gets the value of the order property.
     * 
     * @return
     *     possible object is
     *     {@link OrderFull }
     *     
     */
    public OrderFull getOrder() {
        return order;
    }

    /**
     * Sets the value of the order property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderFull }
     *     
     */
    public void setOrder(OrderFull value) {
        this.order = value;
    }

}
