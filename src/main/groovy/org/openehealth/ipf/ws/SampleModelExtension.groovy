package org.openehealth.ipf.ws

import org.apache.camel.model.ProcessorDefinition
import org.openehealth.ipf.modules.hl7.HL7v2Exception
import org.openehealth.ipf.modules.hl7.AckTypeCode
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory

class SampleModelExtension {

     private static final transient Log LOG = LogFactory.getLog(SampleModelExtension.class)

     static extensions = {
         /*
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
         */

       ProcessorDefinition.metaClass.toOrmRegistryEndpoint = {String operationName ->
             delegate.to('cxf:' +
                     OrmConfiguration.webServiceURL +
                     //'http://localhost:8083/ARHIFWebServices_11/ORMRegistry_Service' +
                     '?serviceClass=org.openehealth.ipf.ws.ORMRegistry' +
                     "&defaultOperationName=$operationName" +
                     '&wsdlURL=' + OrmConfiguration.wsdl +
                     //'&wsdlURL=http://localhost:8082/ARHIFWebServices_11/ORMRegistry_Service?wsdl' +
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
            		.process {LOG.error('unsupported message type should: ' + messageType + " but is: " + it.in.body.eventType )}
                    .nak('Unsupported message type', 200, failDestination)
                    .output('unsupported message type', null)
            	.when { !(triggerEvent.contains(it.in.body.triggerEvent)) }
            		.process{LOG.error('unsupported event type should: ' + triggerEvent + ' but is: ' + it.in.body.triggerEvent)}
                    .nak('Unsupported event code', 201, failDestination)
                    .output('unsupported event code', null)
                .when { it.in.body.version != version }
                    .process{LOG.error('unsupported HL7 version should: ' + version + ' but is: ' + it.in.body.version)}
            		.nak('Unsupported version', 203, failDestination)
                    .output('unsupported version',null)
            	.otherwise()
            		.to(okDestination)
	     }

         ProcessorDefinition.metaClass.output = { String message, Closure c ->
            return delegate.process {
                def payload = c ? c(it.in.body) : it.in.body
                LOG.debug("\n${'-' * 20} ${message} ${'-' * 20}\n${payload}")
            }
         }

         ProcessorDefinition.metaClass.output = { String message  ->
            return delegate.process {
                //def payload = c ? c(it.in.body) : it.in.body
                LOG.debug("${'-' * 20} ${message} ${'-' * 20}")
            }
         }

     }
}
