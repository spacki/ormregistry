package org.openehealth.ipf.ws.impl;


import org.openehealth.ipf.ws.ORMRegistry;
import org.openehealth.ipf.ws.stub.*;

import javax.jws.WebParam;

/**
 * Created by IntelliJ IDEA.
 * User: 100026806
 * Date: 04.01.11
 * Time: 09:40
 * To change this template use File | Settings | File Templates.
 */
public class ORMRegistryImpl implements ORMRegistry {

    ObjectFactory of = new ObjectFactory();


    @Override
    public ReviseORMResponse reviseORMRequest(@WebParam(partName = "body",
                                                        name = "ReviseORMRequest",
                                                        targetNamespace = "http://gehcit.com/platform/cws/orm/types") ReviseORMRequest body) {

        ReviseORMResponse response = of.createReviseORMResponse();
        response.setStatus("ReviseOrmResponse OK");
        response.setErrordescription("RevisePatientResponse No error");
        System.out.println("Submitted ORM Request " + body.getOrder());
        return response;
    }

    @Override
    public DeleteORMResponse deleteORMRequest(@WebParam(partName = "body",
                                                        name = "DeleteORMRequest",
                                                        targetNamespace = "http://gehcit.com/platform/cws/orm/types") DeleteORMRequest body) {
        DeleteORMResponse response = new DeleteORMResponse();
        response.setStatus("DeleteOrmResponse OK");
        response.setErrordescription("DeleteOrmResponse No Error");
        System.out.println("Delete ORM Request " + body.getOrder());
        return response;
    }
}
