package org.openehealth.ipf.ws

import org.apache.camel.Exchange
import org.apache.camel.Processor
import org.openehealth.ipf.ws.stub.DeleteORMRequest
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
import org.openehealth.ipf.ws.stub.GPHospitalDomainNameDetail
import org.openehealth.ipf.ws.hospital.HospitalServiceImpl

/**
 * Created by IntelliJ IDEA.
 * User: 100026806
 * Date: 10.01.11
 * Time: 17:49
 * To change this template use File | Settings | File Templates.
 */
class DeleteORM implements Processor {

  private static final transient Log LOG = LogFactory.getLog(DeleteORM.class)

  void process(Exchange exchange) {
     def msg = exchange.in.body
     DeleteORMRequest deleteORMRequest = new DeleteORMRequest()
     HospitalServiceImpl hospitalService = new HospitalServiceImpl()
     def hospital = hospitalService.getHospitalByDomainId(msg.PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1.PID[3][4][2].value);
     if (hospital != null) {
             LOG.debug("Hospital: " + hospital)
     }
     GPHospitalDomainNameDetail hospitalName = new GPHospitalDomainNameDetail()
     hospitalName.hospitalDomainName = hospital.domainName   //msg.PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1.PID[3][4][1].value
     hospitalName.hospitalDomainId   = hospital.domainId  //msg.PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1.PID[3][4][2].value
     deleteORMRequest.hospitalDomainName = hospitalName
     deleteORMRequest.order = msg.ORCRQDRQ1NTEOBXNTEBLG.OBR[19].value
     //deleteORMRequest.hospitalDomainId = msg.PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1.PID[3][4][2].value
     deleteORMRequest.acNoValue = msg.ORCRQDRQ1NTEOBXNTEBLG.OBR[18].value
     LOG.debug("Delete request Parameter")
     LOG.debug("Hospital Domain Id: "+ deleteORMRequest.hospitalDomainName.hospitalDomainId)
     LOG.debug("OrderId: " + deleteORMRequest.order)
     LOG.debug("Accession Number: " + deleteORMRequest.acNoValue)
     exchange.out.body = deleteORMRequest

  }

}
