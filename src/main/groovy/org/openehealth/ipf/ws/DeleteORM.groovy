package org.openehealth.ipf.ws

import org.apache.camel.Exchange
import org.apache.camel.Processor
import org.openehealth.ipf.ws.stub.DeleteORMRequest

/**
 * Created by IntelliJ IDEA.
 * User: 100026806
 * Date: 10.01.11
 * Time: 17:49
 * To change this template use File | Settings | File Templates.
 */
class DeleteORM implements Processor {

  void process(Exchange exchange) {
     def msg = exchange.in.body
     println "++++++++++++++++++++++++++++++++++++++Liebesgruesse aus Moskau++++++++++++++++++++++++++++++++++++++++++++++++++"
     //println "Message ID is ${it.in.body.MSH[10]}"
     println "Message ID is ${msg.MSH[10]}"
     println "ORC1 should cancel" + msg.ORCRQDRQ1NTEOBXNTEBLG.ORC[1]
     def patientID = msg.PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1.PID[3].value
     println "Patient ID is $patientID"
     def accessionNbr = msg.ORCRQDRQ1NTEOBXNTEBLG.OBR[3][1]
     println "AccesionNumber: " + accessionNbr
     // StudyInstanceUID wir benötigt
     def StudyInstanceUID = msg.ORCRQDRQ1NTEOBXNTEBLG.ZDS[1][1].value
     println("StudyInstanceUID: " + StudyInstanceUID)
     DeleteORMRequest deleteORMRequest = new DeleteORMRequest()
     deleteORMRequest.order = accessionNbr
     deleteORMRequest.hospitalDomainId = "domainId"
     deleteORMRequest.acNoValue = accessionNbr
     exchange.out.body = deleteORMRequest

  }

}
