
package org.openehealth.ipf.ws.stub;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *             A base type for all message element types in the Common Service Model that provides mechanisms for implementation-specific server context and arbitrary message payload extension.
 *          
 * 
 * <p>Java class for MessageElement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MessageElement">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="serverContext" type="{http://gehcit.com/platform/cws/types/coreMessageTypes}ST" minOccurs="0"/>
 *         &lt;element name="extension" type="{http://gehcit.com/platform/cws/types/coreMessageTypes}Extension" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MessageElement", propOrder = {
    "serverContext",
    "extension"
})
@XmlSeeAlso({
    OrderFull.class,
    GPOrderAccessionNumber.class,
    GPPatientIdentifier.class,
    GPPatientNameDetail.class,
    GPHospitalDomainNameDetail.class
})
public abstract class MessageElement {

    protected String serverContext;
    protected List<Extension> extension;

    /**
     * Gets the value of the serverContext property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServerContext() {
        return serverContext;
    }

    /**
     * Sets the value of the serverContext property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServerContext(String value) {
        this.serverContext = value;
    }

    /**
     * Gets the value of the extension property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the extension property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExtension().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Extension }
     * 
     * 
     */
    public List<Extension> getExtension() {
        if (extension == null) {
            extension = new ArrayList<Extension>();
        }
        return this.extension;
    }

}
