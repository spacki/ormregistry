package org.openehealth.ipf.ws.util

import org.apache.camel.Processor
import org.apache.camel.Exchange
import ca.uhn.hl7v2.model.v231.message.ADT_A01
import org.openehealth.ipf.modules.hl7dsl.MessageAdapter
import org.openehealth.ipf.ws.OrmConfiguration
import org.openehealth.ipf.ws.PrefixLookup

/**
 * Created by IntelliJ IDEA.
 * User: 100026806
 * Date: 15.02.11
 * Time: 15:53
 * To change this template use File | Settings | File Templates.
 */
class Orm2AdtConverter implements  Processor{

  void process(Exchange exchange) {
    def msg = exchange.in.body
    ADT_A01 adtMsg = new ADT_A01()
    MessageAdapter adtAdapter = new MessageAdapter(adtMsg)
    adtAdapter.MSH = msg.MSH
    adtAdapter.MSH[9][1] = 'ADT'
    adtAdapter.MSH[9][2] = 'A01'
    adtAdapter.EVN[2]=Convert.getEventDateTime()
    adtAdapter.PID = msg.PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1.PID
    def prefixMap = PrefixLookup.prefixMap
    def prefix = prefixMap.get(msg.PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1.PID[3][4][2].value);
    adtAdapter.PID[3][1] = prefix + "_" + msg.PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1.PID[3][1].value
    adtAdapter.PID[3][4][1] = OrmConfiguration.sourceName;
    adtAdapter.PID[3][4][2] = OrmConfiguration.sourceID;
    adtAdapter.PV1 = msg.PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1.PV1PV2.PV1
    exchange.out.body = adtAdapter
  }
}
