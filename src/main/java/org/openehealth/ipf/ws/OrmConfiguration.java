package org.openehealth.ipf.ws;

/**
 * Created by IntelliJ IDEA.
 * User: 100026806
 * Date: 09.02.11
 * Time: 09:02
 * To change this template use File | Settings | File Templates.
 */
public class OrmConfiguration {

    public static String sourceID;
    public static String sourceName;
    public static String webServiceURL;
    public static String wsdl;
    public static String ormInputURL;
    public static String adtEhcpURL;

    public String getSourceID() {
        return sourceID;
    }

    public void setSourceID(String sourceID) {
        OrmConfiguration.sourceID = sourceID;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        OrmConfiguration.sourceName = sourceName;
    }

    public String getWebServiceURL() {
        return webServiceURL;
    }

    public void setWebServiceURL(String webServiceURL) {
        OrmConfiguration.webServiceURL = webServiceURL;
    }

    public String getWsdl() {
        return wsdl;
    }

    public void setWsdl(String wsdl) {
        OrmConfiguration.wsdl = wsdl;
    }

    public String getOrmInputURL() {
        return ormInputURL;
    }

    public void setOrmInputURL(String ormInputURL) {
        OrmConfiguration.ormInputURL = ormInputURL;
    }

    public String getAdtEhcpURL() {
        return adtEhcpURL;
    }

    public void setAdtEhcpURL(String adtEhcpURL) {
        OrmConfiguration.adtEhcpURL = adtEhcpURL;
    }
}
