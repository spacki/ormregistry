package org.openehealth.ipf.ws


import org.springframework.test.context.ContextConfiguration
import org.junit.runner.RunWith
import org.junit.Test
import org.apache.camel.ProducerTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.apache.camel.CamelContext
import org.openehealth.ipf.ws.stub.ObjectFactory
import static junit.framework.Assert.*
import org.junit.Before
import org.junit.After
import org.junit.Ignore
import org.springframework.core.io.Resource
import org.springframework.core.io.ClassPathResource
import org.openehealth.ipf.ws.stub.DeleteORMRequest
import org.openehealth.ipf.ws.stub.ReviseORMRequest
import org.openehealth.ipf.ws.ORMRegistryServer
import org.openehealth.ipf.modules.hl7dsl.MessageAdapters;
import org.apache.commons.io.IOUtils;



/**
 * Created by IntelliJ IDEA.
 * User: 100026806
 * Date: 04.01.11
 * Time: 09:59
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner)
@ContextConfiguration(locations = [
    '/context.xml'])
class SampleRouteTest {

    @Autowired ProducerTemplate template
    @Autowired CamelContext context

    ORMRegistryServer server;
    ObjectFactory of = new ObjectFactory()

     @Before
      void setUp(){
        server = new ORMRegistryServer()
    }

     @After
     void tearDown(){
       server.getEndpoint().stop()
    }

    @Test        @Ignore
    void testDirectInputChecked() throws Exception     {
       def msg =  MessageAdapters.load("orm_o01.txt")
       println "Message: " + msg
       template.sendBody("direct:orm-o01-checked", msg)
       //def response = MessageAdapters.load("HL7V1.1.hl7")
       //def response = IOUtils.toString(getClass().getResourceAsStream("HL7V1.1.hl7"));
       //def response = MessageAdapters.load("orm_o01.txt")
       //println "Test checked: " + response
    }


    @Test
    void routeTestReviseOrmRequest() {
      ReviseORMRequest ror = of.createReviseORMRequest()
      ror.setOrder of.createOrderFull()
      def response = template.requestBody("direct:inputRevise", ror)
      assertNotNull response
      assertEquals("ReviseOrmResponse OK",response.status[0])
      assertEquals("RevisePatientResponse No error",response.errordescription[0] )
    }

    @Test
    void routeTestDeleteOrmRequest() {
       DeleteORMRequest dor = of.createDeleteORMRequest()
       dor.setOrder("1234")
       def response = template.requestBody("direct:inputDelete", dor)
       assertNotNull response
       assertEquals("DeleteOrmResponse OK",response.status[0])
       assertEquals("DeleteOrmResponse No Error",response.errordescription[0] )

    }


}
