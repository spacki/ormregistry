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
                              'direct:mdm-t02-checked', ERROR_ROUTE)

        from('direct:mdm-t02-checked')
            .onException(Exception.class)
                .handled(true)
                .nak(207, ERROR_ROUTE)
                .end()
//            .validate().ghl7().profile(bean(ValidationContext.class))
            .to('direct:mdm-t02-validated')

        from('direct:mdm-t02-validated')
            .process {
                println "Message ID is ${it.in.body.MSH[10]}"
                def patientID = it.in.body.PID[3].value
                println "Patient ID is $patientID"
            }
            .ack()

      from('direct:inputDelete')
                 .toOrmRegistryEndpoint('deleteORMRequest')

      from('direct:inputRevise')
                 .toOrmRegistryEndpoint('reviseORMRequest')

      from(ERROR_ROUTE)
            .convertBodyTo(String.class)
    		.to('file:target/output')

    }
    
}
