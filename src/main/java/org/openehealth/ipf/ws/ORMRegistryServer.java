package org.openehealth.ipf.ws;

import org.openehealth.ipf.ws.impl.ORMRegistryImpl;
import javax.xml.ws.Endpoint;

/**
 * Created by IntelliJ IDEA.
 * User: 100026806
 * Date: 04.01.11
 * Time: 09:38
 * To change this template use File | Settings | File Templates.
 */
public class ORMRegistryServer {

    private static final String SERVER_URL = "http://0.0.0.0:8082/ormservice";

    private Endpoint endpoint;

    ORMRegistryServer() throws Exception {
        ORMRegistry registry = new ORMRegistryImpl();
        System.out.println("Starting ORM Server");
        endpoint = Endpoint.publish(SERVER_URL, registry);
        System.out.println("Server ready");

    }

    public Endpoint getEndpoint() {
        return endpoint;
    }

    public void setEndpoint() {
        this.endpoint = endpoint;
    }

}
