package org.openehealth.ipf.ws

import org.apache.camel.spring.SpringRouteBuilder
import org.apache.camel.Exchange
import org.apache.camel.Processor
import org.openehealth.ipf.modules.hl7.message.MessageUtils
import static org.openehealth.ipf.platform.camel.core.util.Exchanges.resultMessage
import org.openehealth.ipf.modules.hl7.AckTypeCode;

class SampleRouteBuilder extends SpringRouteBuilder {

    private static final ERROR_ROUTE = 'direct:error'

    void configure() {

        from("mina:tcp://0.0.0.0:8413?sync=true&codec=#hl7codec")
            .to('direct:input1')

        from('direct:input1')
            .unmarshal().ghl7()
            .checkMessageType('ORM', 'O01', '2.3.1',
                              'direct:orm-o01-checked', ERROR_ROUTE)

        from('direct:orm-o01-checked')
            .onException(Exception.class)
                .handled(true)
                .nak(207, ERROR_ROUTE)
                .end()
//            .validate().ghl7().profile(bean(ValidationContext.class))
            .to('direct:orm-o01-validated')

        from('direct:orm-o01-validated')
             /*
            .process {
                println "Message ID is ${it.in.body.MSH[10]}"
                def patientID = it.in.body.PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1.PID[3].value
                println "Patient ID is $patientID"
                def accessionNbr = it.in.body.ORCRQDRQ1NTEOBXNTEBLG.OBR[3][1]
                println "AccesionNumber: " + accessionNbr
               // StudyInstanceUID wir benötigt
               def StudyInstanceUID = it.in.body.ORCRQDRQ1NTEOBXNTEBLG.ZDS[1][1].value
               println("StudyInstanceUID: " + StudyInstanceUID)
            }  */
           // .processRef('deleteORM')
            .inOnly().to('seda:valid')
            .ack()

        // -------------------------------------------------------------
        //  Dequeue, transform and process request
        // -------------------------------------------------------------
        from('seda:valid')
           .choice()
           .when {it.in.body.ORCRQDRQ1NTEOBXNTEBLG.ORC[1].value == 'CA'}
                .process { println "Order Delete: :\n" + it.in.body}
                .processRef('deleteORM')
                .to('direct:inputDelete')
           .otherwise()
                .process { println "Revise Order :\n" + it.in.body}
                .processRef('reviseORM')
                .to('direct:inputRevise')



        from('direct:inputDelete')
                 .toOrmRegistryEndpoint('deleteORMRequest')

        from('direct:inputRevise')
                 .toOrmRegistryEndpoint('reviseORMRequest')

        from(ERROR_ROUTE)
            .convertBodyTo(String.class)
    		.to('file:target/output')

    }
    
}
