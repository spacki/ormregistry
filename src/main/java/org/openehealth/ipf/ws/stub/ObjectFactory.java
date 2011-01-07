
package org.openehealth.ipf.ws.stub;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.openehealth.ipf.ws.stub package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ReviseORMRequest_QNAME = new QName("http://gehcit.com/platform/cws/orm/types", "ReviseORMRequest");
    private final static QName _DeleteORMRequest_QNAME = new QName("http://gehcit.com/platform/cws/orm/types", "DeleteORMRequest");
    private final static QName _DeleteORMResponse_QNAME = new QName("http://gehcit.com/platform/cws/orm/types", "DeleteORMResponse");
    private final static QName _ReviseORMResponse_QNAME = new QName("http://gehcit.com/platform/cws/orm/types", "ReviseORMResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.openehealth.ipf.ws.stub
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReviseORMRequest }
     * 
     */
    public ReviseORMRequest createReviseORMRequest() {
        return new ReviseORMRequest();
    }

    /**
     * Create an instance of {@link ReviseORMResponse }
     * 
     */
    public ReviseORMResponse createReviseORMResponse() {
        return new ReviseORMResponse();
    }

    /**
     * Create an instance of {@link GPOrderAccessionNumber }
     * 
     */
    public GPOrderAccessionNumber createGPOrderAccessionNumber() {
        return new GPOrderAccessionNumber();
    }

    /**
     * Create an instance of {@link GPHospitalDomainNameDetail }
     * 
     */
    public GPHospitalDomainNameDetail createGPHospitalDomainNameDetail() {
        return new GPHospitalDomainNameDetail();
    }

    /**
     * Create an instance of {@link Extension }
     * 
     */
    public Extension createExtension() {
        return new Extension();
    }

    /**
     * Create an instance of {@link GPPatientNameDetail }
     * 
     */
    public GPPatientNameDetail createGPPatientNameDetail() {
        return new GPPatientNameDetail();
    }

    /**
     * Create an instance of {@link OrderFull }
     * 
     */
    public OrderFull createOrderFull() {
        return new OrderFull();
    }

    /**
     * Create an instance of {@link ExtensionItem }
     * 
     */
    public ExtensionItem createExtensionItem() {
        return new ExtensionItem();
    }

    /**
     * Create an instance of {@link GPPatientIdentifier }
     * 
     */
    public GPPatientIdentifier createGPPatientIdentifier() {
        return new GPPatientIdentifier();
    }

    /**
     * Create an instance of {@link DeleteORMRequest }
     * 
     */
    public DeleteORMRequest createDeleteORMRequest() {
        return new DeleteORMRequest();
    }

    /**
     * Create an instance of {@link DeleteORMResponse }
     * 
     */
    public DeleteORMResponse createDeleteORMResponse() {
        return new DeleteORMResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReviseORMRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gehcit.com/platform/cws/orm/types", name = "ReviseORMRequest")
    public JAXBElement<ReviseORMRequest> createReviseORMRequest(ReviseORMRequest value) {
        return new JAXBElement<ReviseORMRequest>(_ReviseORMRequest_QNAME, ReviseORMRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteORMRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gehcit.com/platform/cws/orm/types", name = "DeleteORMRequest")
    public JAXBElement<DeleteORMRequest> createDeleteORMRequest(DeleteORMRequest value) {
        return new JAXBElement<DeleteORMRequest>(_DeleteORMRequest_QNAME, DeleteORMRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteORMResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gehcit.com/platform/cws/orm/types", name = "DeleteORMResponse")
    public JAXBElement<DeleteORMResponse> createDeleteORMResponse(DeleteORMResponse value) {
        return new JAXBElement<DeleteORMResponse>(_DeleteORMResponse_QNAME, DeleteORMResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReviseORMResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gehcit.com/platform/cws/orm/types", name = "ReviseORMResponse")
    public JAXBElement<ReviseORMResponse> createReviseORMResponse(ReviseORMResponse value) {
        return new JAXBElement<ReviseORMResponse>(_ReviseORMResponse_QNAME, ReviseORMResponse.class, null, value);
    }

}
