
package org.openehealth.ipf.ws.stub;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 *             A CSM message metadata structure that holds a set of one or more name/value pair items unique to the extension identified by the extension id.
 *          
 * 
 * <p>Java class for Extension complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Extension">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="extensionId" type="{http://gehcit.com/platform/cws/types/coreMessageTypes}OID"/>
 *         &lt;element name="item" type="{http://gehcit.com/platform/cws/types/coreMessageTypes}ExtensionItem" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Extension", propOrder = {
    "extensionId",
    "item"
})
public class Extension {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String extensionId;
    @XmlElement(required = true)
    protected List<ExtensionItem> item;

    /**
     * Gets the value of the extensionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtensionId() {
        return extensionId;
    }

    /**
     * Sets the value of the extensionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtensionId(String value) {
        this.extensionId = value;
    }

    /**
     * Gets the value of the item property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the item property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExtensionItem }
     * 
     * 
     */
    public List<ExtensionItem> getItem() {
        if (item == null) {
            item = new ArrayList<ExtensionItem>();
        }
        return this.item;
    }

}
