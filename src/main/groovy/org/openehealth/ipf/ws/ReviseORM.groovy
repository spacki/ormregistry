package org.openehealth.ipf.ws

import org.apache.camel.Processor
import org.apache.camel.Exchange
import org.openehealth.ipf.ws.stub.ReviseORMRequest
import org.openehealth.ipf.ws.stub.OrderFull
import org.openehealth.ipf.ws.stub.GPOrderAccessionNumber
import org.openehealth.ipf.ws.stub.GPPatientNameDetail
import org.openehealth.ipf.ws.stub.GPHospitalDomainNameDetail
import org.openehealth.ipf.ws.stub.GPPatientIdentifier

/**
 * Created by IntelliJ IDEA.
 * User: 100026806
 * Date: 10.01.11
 * Time: 20:32
 * To change this template use File | Settings | File Templates.
 */

class ReviseORM implements  Processor {



  void process(Exchange exchange) {
     def msg = exchange.in.body
     ReviseORMRequest reviseORMRequest = new ReviseORMRequest()
     OrderFull orderFull = new OrderFull()
     GPHospitalDomainNameDetail hospitalName = new GPHospitalDomainNameDetail()
     println "Hospital Domain Name: " +   msg.PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1.PID[3][4][1].value
     hospitalName.hospitalDomainName = msg.PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1.PID[3][4][1].value
     hospitalName.hospitalDomainId   = "domainID"
     orderFull.hospitalDomainName = hospitalName
     GPPatientIdentifier patientIdentifier = new GPPatientIdentifier()
     println "Patient DomainID: " + msg.PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1.PID[3][4][1].value
     patientIdentifier.setDomainId(msg.PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1.PID[3][4][1].value)
     println "Type Code: " + msg.PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1.PID[3][4][2].value
     patientIdentifier.setIdTypeCode(msg.PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1.PID[3][4][2].value)
     println "Patient Identifier: " + msg.PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1.PID[3][1].value
     patientIdentifier.idValue = msg.PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1.PID[3][1].value
     orderFull.patientIdentifier
     GPPatientNameDetail patientName = new GPPatientNameDetail()
     def first = msg.PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1.PID[5][2].value
     def last  = msg.PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1.PID[5][1][1].value
     patientName.lastName = last
     patientName.firstName = first
     println "patient name " + last + "^" + first
     orderFull.patientName
     GPOrderAccessionNumber accessionNumber = new GPOrderAccessionNumber()
     println "accession number: " + msg.ORCRQDRQ1NTEOBXNTEBLG.OBR[20].value
     accessionNumber.acNoValue = msg.ORCRQDRQ1NTEOBXNTEBLG.OBR[20].value
     orderFull.accessionNumber

     // direct from Message
     println "Patient BirthDate: " + msg.PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1.PID[7].value
     orderFull.birthDate = msg.PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1.PID[7].value
     println "Patient GenderCode: " +    msg.PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1.PID[8].value
     orderFull.genderCode = msg.PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1.PID[8].value
     println "scheduled Date: " +  msg.ORCRQDRQ1NTEOBXNTEBLG.ORC[7][4].value
     orderFull.scheduledVisitDate = msg.ORCRQDRQ1NTEOBXNTEBLG.ORC[7][4].value
     println "Order Description: " + msg.ORCRQDRQ1NTEOBXNTEBLG.OBR[31].value
     orderFull.orderDesc = msg.ORCRQDRQ1NTEOBXNTEBLG.OBR[31].value
     println "Order ID: " +  msg.ORCRQDRQ1NTEOBXNTEBLG.OBR[3].value
     orderFull.orderID = msg.ORCRQDRQ1NTEOBXNTEBLG.OBR[3].value
     println "Study Instance UID: " +  msg.ORCRQDRQ1NTEOBXNTEBLG.ZDS[1][1].value
     orderFull.orderStudyInstanceUID = msg.ORCRQDRQ1NTEOBXNTEBLG.ZDS[1][1].value

     reviseORMRequest.order = orderFull
     exchange.out.body = reviseORMRequest



  }


}
