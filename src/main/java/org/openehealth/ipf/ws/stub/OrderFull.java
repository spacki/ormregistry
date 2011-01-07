
package org.openehealth.ipf.ws.stub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 *             Defines a list of examination details for a patient.
 *          
 * 
 * <p>Java class for OrderFull complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrderFull">
 *   &lt;complexContent>
 *     &lt;extension base="{http://gehcit.com/platform/cws/types/coreMessageTypes}MessageElement">
 *       &lt;sequence>
 *         &lt;element name="hospitalDomainName" type="{http://gehcit.com/platform/cws/types/coreMessageTypes}GPHospitalDomainNameDetail"/>
 *         &lt;element name="localpatientIdentifier" type="{http://gehcit.com/platform/cws/types/coreMessageTypes}GPPatientIdentifier"/>
 *         &lt;element name="orderID" type="{http://gehcit.com/platform/cws/types/coreMessageTypes}ID"/>
 *         &lt;element name="accessionNumber" type="{http://gehcit.com/platform/cws/types/coreMessageTypes}GPOrderAccessionNumber"/>
 *         &lt;element name="patientName" type="{http://gehcit.com/platform/cws/types/coreMessageTypes}GPPatientNameDetail"/>
 *         &lt;element name="patientIdentifier" type="{http://gehcit.com/platform/cws/types/coreMessageTypes}GPPatientIdentifier"/>
 *         &lt;element name="genderCode" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://gehcit.com/platform/cws/types/coreMessageTypes}CS">
 *               &lt;enumeration value="F"/>
 *               &lt;enumeration value="M"/>
 *               &lt;enumeration value="U"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="birthDate" type="{http://gehcit.com/platform/cws/types/coreMessageTypes}TS"/>
 *         &lt;element name="orderStudyInstanceUID" type="{http://gehcit.com/platform/cws/types/coreMessageTypes}ID" minOccurs="0"/>
 *         &lt;element name="scheduledVisitDate" type="{http://gehcit.com/platform/cws/types/coreMessageTypes}TS" minOccurs="0"/>
 *         &lt;element name="orderDesc" type="{http://gehcit.com/platform/cws/types/coreMessageTypes}ST256" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrderFull", namespace = "http://gehcit.com/platform/cws/orm/types/ormInformation", propOrder = {
    "hospitalDomainName",
    "localpatientIdentifier",
    "orderID",
    "accessionNumber",
    "patientName",
    "patientIdentifier",
    "genderCode",
    "birthDate",
    "orderStudyInstanceUID",
    "scheduledVisitDate",
    "orderDesc"
})
public class OrderFull
    extends MessageElement
{

    @XmlElement(required = true)
    protected GPHospitalDomainNameDetail hospitalDomainName;
    @XmlElement(required = true)
    protected GPPatientIdentifier localpatientIdentifier;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String orderID;
    @XmlElement(required = true)
    protected GPOrderAccessionNumber accessionNumber;
    @XmlElement(required = true)
    protected GPPatientNameDetail patientName;
    @XmlElement(required = true)
    protected GPPatientIdentifier patientIdentifier;
    protected String genderCode;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String birthDate;
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String orderStudyInstanceUID;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String scheduledVisitDate;
    protected String orderDesc;

    /**
     * Gets the value of the hospitalDomainName property.
     * 
     * @return
     *     possible object is
     *     {@link GPHospitalDomainNameDetail }
     *     
     */
    public GPHospitalDomainNameDetail getHospitalDomainName() {
        return hospitalDomainName;
    }

    /**
     * Sets the value of the hospitalDomainName property.
     * 
     * @param value
     *     allowed object is
     *     {@link GPHospitalDomainNameDetail }
     *     
     */
    public void setHospitalDomainName(GPHospitalDomainNameDetail value) {
        this.hospitalDomainName = value;
    }

    /**
     * Gets the value of the localpatientIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link GPPatientIdentifier }
     *     
     */
    public GPPatientIdentifier getLocalpatientIdentifier() {
        return localpatientIdentifier;
    }

    /**
     * Sets the value of the localpatientIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link GPPatientIdentifier }
     *     
     */
    public void setLocalpatientIdentifier(GPPatientIdentifier value) {
        this.localpatientIdentifier = value;
    }

    /**
     * Gets the value of the orderID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderID() {
        return orderID;
    }

    /**
     * Sets the value of the orderID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderID(String value) {
        this.orderID = value;
    }

    /**
     * Gets the value of the accessionNumber property.
     * 
     * @return
     *     possible object is
     *     {@link GPOrderAccessionNumber }
     *     
     */
    public GPOrderAccessionNumber getAccessionNumber() {
        return accessionNumber;
    }

    /**
     * Sets the value of the accessionNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link GPOrderAccessionNumber }
     *     
     */
    public void setAccessionNumber(GPOrderAccessionNumber value) {
        this.accessionNumber = value;
    }

    /**
     * Gets the value of the patientName property.
     * 
     * @return
     *     possible object is
     *     {@link GPPatientNameDetail }
     *     
     */
    public GPPatientNameDetail getPatientName() {
        return patientName;
    }

    /**
     * Sets the value of the patientName property.
     * 
     * @param value
     *     allowed object is
     *     {@link GPPatientNameDetail }
     *     
     */
    public void setPatientName(GPPatientNameDetail value) {
        this.patientName = value;
    }

    /**
     * Gets the value of the patientIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link GPPatientIdentifier }
     *     
     */
    public GPPatientIdentifier getPatientIdentifier() {
        return patientIdentifier;
    }

    /**
     * Sets the value of the patientIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link GPPatientIdentifier }
     *     
     */
    public void setPatientIdentifier(GPPatientIdentifier value) {
        this.patientIdentifier = value;
    }

    /**
     * Gets the value of the genderCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGenderCode() {
        return genderCode;
    }

    /**
     * Sets the value of the genderCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGenderCode(String value) {
        this.genderCode = value;
    }

    /**
     * Gets the value of the birthDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * Sets the value of the birthDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBirthDate(String value) {
        this.birthDate = value;
    }

    /**
     * Gets the value of the orderStudyInstanceUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderStudyInstanceUID() {
        return orderStudyInstanceUID;
    }

    /**
     * Sets the value of the orderStudyInstanceUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderStudyInstanceUID(String value) {
        this.orderStudyInstanceUID = value;
    }

    /**
     * Gets the value of the scheduledVisitDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScheduledVisitDate() {
        return scheduledVisitDate;
    }

    /**
     * Sets the value of the scheduledVisitDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScheduledVisitDate(String value) {
        this.scheduledVisitDate = value;
    }

    /**
     * Gets the value of the orderDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderDesc() {
        return orderDesc;
    }

    /**
     * Sets the value of the orderDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderDesc(String value) {
        this.orderDesc = value;
    }

}
