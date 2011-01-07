package org.openehealth.ipf.ws

import org.apache.camel.model.ProcessorDefinition
import org.openehealth.ipf.modules.hl7.HL7v2Exception
import org.openehealth.ipf.modules.hl7.AckTypeCode

class SampleModelExtension {

     static extensions = {
         
         ProcessorDefinition.metaClass.toOrmRegistryEndpoint = {String operationName ->
             delegate.to('cxf:' +
                     'http://localhost:8082/ormservice' +
                     '?serviceClass=org.openehealth.ipf.ws.ORMRegistry' +
                     "&defaultOperationName=$operationName" +
                     '&wsdlURL=wsdl/ORMRegistry.wsdl' +
                     '&serviceName={http://gehcit.com/platform/cws/ORMRegistry}ORMRegistry_Service' +
                     '&portName={http://gehcit.com/platform/cws/ORMRegistry}ORMRegistry_Port_Soap12' +
                     '&dataFormat=POJO')
         }


         ProcessorDefinition.metaClass.nak = { String cause, int code, String destination ->
             delegate
			    .process {
				  it.out.body =
					it.in.body.nak(
			    		new HL7v2Exception(cause, code),
			    		AckTypeCode.AR)
			    }
	    	 .to(destination)
         }

         ProcessorDefinition.metaClass.nak = { int code, String destination ->
            delegate
			   .process {
                  def e = new HL7v2Exception(it.properties.CamelCauseException.cause.cause.message, code)
				  it.out.body =
					it.in.body.nak(
			    		e,
			    		AckTypeCode.AR)
			   }
               .to(destination)
         }

         ProcessorDefinition.metaClass.ack = {  ->
            delegate
			   .process {
				it.out.body =
					it.in.body.ack()
			   }
            .convertBodyTo(String.class)
         }

         ProcessorDefinition.metaClass.checkMessageType = { messageType, triggerEvent, version, okDestination, failDestination  ->
            delegate
             .choice()
            	.when { it.in.body.eventType != messageType }
            		.nak('Unsupported message type', 200, failDestination)
            	.when { !(triggerEvent.contains(it.in.body.triggerEvent)) }
            		.nak('Unsupported event code', 201, failDestination)
                .when { it.in.body.version != version }
            		.nak('Unsupported version', 203, failDestination)
            	.otherwise()
            		.to(okDestination)
	     }

     }
}
