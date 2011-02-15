package org.openehealth.ipf.ws

import org.apache.camel.Processor
import org.apache.camel.Exchange
import org.openehealth.ipf.ws.stub.ReviseORMRequest
import org.openehealth.ipf.ws.stub.OrderFull
import org.openehealth.ipf.ws.stub.GPOrderAccessionNumber
import org.openehealth.ipf.ws.stub.GPPatientNameDetail
import org.openehealth.ipf.ws.stub.GPHospitalDomainNameDetail
import org.openehealth.ipf.ws.stub.GPPatientIdentifier
import org.openehealth.ipf.ws.util.Convert
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory

/**
 * Created by IntelliJ IDEA.
 * User: 100026806
 * Date: 10.01.11
 * Time: 20:32
 * To change this template use File | Settings | File Templates.
 */

class ReviseORM implements  Processor {

  private static final transient Log LOG = LogFactory.getLog(ReviseORM.class);



  void process(Exchange exchange) {
     def msg = exchange.in.body
     ReviseORMRequest reviseORMRequest = new ReviseORMRequest()
     OrderFull orderFull = new OrderFull()
     GPHospitalDomainNameDetail hospitalName = new GPHospitalDomainNameDetail()
     hospitalName.hospitalDomainName = msg.PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1.PID[3][4][1].value
     hospitalName.hospitalDomainId   = msg.PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1.PID[3][4][2].value
     orderFull.hospitalDomainName = hospitalName
    //LocalPatientIdentifier
     GPPatientIdentifier localPatientIdentifier = new GPPatientIdentifier()
     localPatientIdentifier.domainId = msg.PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1.PID[3][4][2].value
     localPatientIdentifier.idTypeCode =  msg.PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1.PID[3][4][3].value
     localPatientIdentifier.idValue = msg.PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1.PID[3][1].value
     orderFull.localpatientIdentifier = localPatientIdentifier
     //GlobalPatientIdentifier
     GPPatientIdentifier globalPatientIdentifier = new GPPatientIdentifier()
     globalPatientIdentifier.domainId = OrmConfiguration.sourceID;
     //println "Patient DomainID: " + globalPatientIdentifier.domainId
     globalPatientIdentifier.setIdTypeCode('ISO')
     def prefixMap = PrefixLookup.prefixMap
     def prefix = prefixMap.get(msg.PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1.PID[3][4][2].value);
     globalPatientIdentifier.idValue = prefix + "_" + msg.PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1.PID[3][1].value
     orderFull.patientIdentifier = globalPatientIdentifier
     GPPatientNameDetail patientName = new GPPatientNameDetail()
     patientName.firstName = msg.PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1.PID[5][2].value
     patientName.lastName  = msg.PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1.PID[5][1][1].value
     orderFull.patientName = patientName
     GPOrderAccessionNumber accessionNumber = new GPOrderAccessionNumber()
     accessionNumber.acNoValue = msg.ORCRQDRQ1NTEOBXNTEBLG.OBR[18].value
     orderFull.accessionNumber = accessionNumber
     // direct from Message
     orderFull.birthDate = Convert.convert(msg.PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1.PID[7].value)
     orderFull.genderCode = msg.PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1.PID[8].value
     orderFull.scheduledVisitDate = Convert.convertDateTime(msg.ORCRQDRQ1NTEOBXNTEBLG.ORC[7][4].value)
     orderFull.orderDesc = msg.ORCRQDRQ1NTEOBXNTEBLG.OBR[4][2].value
     orderFull.orderID = msg.ORCRQDRQ1NTEOBXNTEBLG.OBR[3].value
     orderFull.orderStudyInstanceUID = msg.ORCRQDRQ1NTEOBXNTEBLG.ZDS[1][1].value
     reviseORMRequest.order = orderFull
     LOG.debug("Revise Request Parameter")
     LOG.debug('Hospital Domain ID: ' + orderFull.hospitalDomainName.getHospitalDomainId())
     LOG.debug('Hospital Domain Name:' + orderFull.hospitalDomainName.getHospitalDomainName())
     LOG.debug('Local Patient ID: ' + orderFull.localpatientIdentifier.getIdValue())
     LOG.debug('Global Patient ID: ' + orderFull.patientIdentifier.getIdValue())
     LOG.debug('Patient Name: ' + orderFull.patientName.getLastName() + '^' + orderFull.patientName.getFirstName())
     LOG.debug('Patient Birthdate: ' + orderFull.getBirthDate())
     LOG.debug('Patient Gender: ' + orderFull.getGenderCode())
     LOG.debug('AccessionNumber: ' + orderFull.accessionNumber.getAcNoValue())
     LOG.debug('Scheduled Visit Date: ' + orderFull.getScheduledVisitDate())
     LOG.debug('Order ID: ' + orderFull.getOrderID());
     LOG.debug('Order Description: ' + orderFull.getOrderDesc())
     LOG.debug('Study Instance UID: ' + orderFull.getOrderStudyInstanceUID())
     exchange.out.body = reviseORMRequest
  }
}
