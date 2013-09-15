
package async.wsdl_hello_lit.server;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Holder;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.12-09/15/2013 04:03 PM(snajper)-
 * Generated source version: 2.1
 * 
 */
@WebService(name = "Hello", targetNamespace = "urn:test")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Hello {


    /**
     * 
     * @param parameters
     * @return
     *     returns async.wsdl_hello_lit.server.HelloOutput
     */
    @WebMethod(action = "urn:test:hello")
    @WebResult(name = "HelloOutput", targetNamespace = "urn:test:types", partName = "parameters")
    public HelloOutput hello(
        @WebParam(name = "Hello", targetNamespace = "urn:test:types", partName = "parameters")
        Hello_Type parameters);

    /**
     * 
     * @param res
     * @param req
     * @param inHeader
     * @param outHeader
     */
    @WebMethod(action = "urn:test:hello")
    public void hello1(
        @WebParam(name = "Hello1", targetNamespace = "urn:test:types", partName = "req")
        HelloType req,
        @WebParam(name = "Header", targetNamespace = "urn:test:types", header = true, partName = "inHeader")
        HelloType inHeader,
        @WebParam(name = "HelloOutput", targetNamespace = "urn:test:types", mode = WebParam.Mode.OUT, partName = "res")
        Holder<HelloOutput> res,
        @WebParam(name = "Header", targetNamespace = "urn:test:types", header = true, mode = WebParam.Mode.OUT, partName = "outHeader")
        Holder<HelloType> outHeader);

    /**
     * 
     * @param paramIn
     * @return
     *     returns int
     */
    @WebMethod(action = "urn:test:hello0")
    @WebResult(name = "Hello_out0", targetNamespace = "urn:test:types", partName = "param_out")
    public int hello0(
        @WebParam(name = "Hello_in0", targetNamespace = "urn:test:types", partName = "param_in")
        int paramIn);

}