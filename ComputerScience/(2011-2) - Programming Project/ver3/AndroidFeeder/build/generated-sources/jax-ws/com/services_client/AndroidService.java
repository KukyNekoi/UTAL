
package com.services_client;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.5-b04 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "AndroidService", targetNamespace = "http://services.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface AndroidService {


    /**
     * 
     * @param range
     * @param from
     * @return
     *     returns java.util.List<java.lang.Object>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "requestNotices", targetNamespace = "http://services.com/", className = "com.services_client.RequestNotices")
    @ResponseWrapper(localName = "requestNoticesResponse", targetNamespace = "http://services.com/", className = "com.services_client.RequestNoticesResponse")
    @Action(input = "http://services.com/AndroidService/requestNoticesRequest", output = "http://services.com/AndroidService/requestNoticesResponse")
    public List<Object> requestNotices(
        @WebParam(name = "from", targetNamespace = "")
        int from,
        @WebParam(name = "range", targetNamespace = "")
        int range);

    /**
     * 
     * @param type
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "requestNoticesListByType", targetNamespace = "http://services.com/", className = "com.services_client.RequestNoticesListByType")
    @ResponseWrapper(localName = "requestNoticesListByTypeResponse", targetNamespace = "http://services.com/", className = "com.services_client.RequestNoticesListByTypeResponse")
    @Action(input = "http://services.com/AndroidService/requestNoticesListByTypeRequest", output = "http://services.com/AndroidService/requestNoticesListByTypeResponse")
    public int requestNoticesListByType(
        @WebParam(name = "type", targetNamespace = "")
        int type);

    /**
     * 
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "requestNoticesList", targetNamespace = "http://services.com/", className = "com.services_client.RequestNoticesList")
    @ResponseWrapper(localName = "requestNoticesListResponse", targetNamespace = "http://services.com/", className = "com.services_client.RequestNoticesListResponse")
    @Action(input = "http://services.com/AndroidService/requestNoticesListRequest", output = "http://services.com/AndroidService/requestNoticesListResponse")
    public int requestNoticesList();

    /**
     * 
     * @param range
     * @param from
     * @param type
     * @return
     *     returns java.lang.String
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "requestFilteredNotices", targetNamespace = "http://services.com/", className = "com.services_client.RequestFilteredNotices")
    @ResponseWrapper(localName = "requestFilteredNoticesResponse", targetNamespace = "http://services.com/", className = "com.services_client.RequestFilteredNoticesResponse")
    @Action(input = "http://services.com/AndroidService/requestFilteredNoticesRequest", output = "http://services.com/AndroidService/requestFilteredNoticesResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://services.com/AndroidService/requestFilteredNotices/Fault/Exception")
    })
    public String requestFilteredNotices(
        @WebParam(name = "type", targetNamespace = "")
        int type,
        @WebParam(name = "from", targetNamespace = "")
        int from,
        @WebParam(name = "range", targetNamespace = "")
        int range)
        throws Exception_Exception
    ;

    /**
     * 
     * @return
     *     returns java.util.List<java.lang.Object>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "test", targetNamespace = "http://services.com/", className = "com.services_client.Test")
    @ResponseWrapper(localName = "testResponse", targetNamespace = "http://services.com/", className = "com.services_client.TestResponse")
    @Action(input = "http://services.com/AndroidService/testRequest", output = "http://services.com/AndroidService/testResponse")
    public List<Object> test();

}
