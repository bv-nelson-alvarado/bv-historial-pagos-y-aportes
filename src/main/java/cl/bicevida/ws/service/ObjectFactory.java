
package cl.bicevida.ws.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cl.bicevida.ws.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetGlosaResponse_QNAME = new QName("http://service.ws.bicevida.cl/", "getGlosaResponse");
    private final static QName _Exception_QNAME = new QName("http://service.ws.bicevida.cl/", "Exception");
    private final static QName _GetGlosa_QNAME = new QName("http://service.ws.bicevida.cl/", "getGlosa");
    private final static QName _GetPagosYAportes_QNAME = new QName("http://service.ws.bicevida.cl/", "getPagosYAportes");
    private final static QName _GetPagosYAportesResponse_QNAME = new QName("http://service.ws.bicevida.cl/", "getPagosYAportesResponse");
    private final static QName _PagosYAportesSoapException_QNAME = new QName("http://service.ws.bicevida.cl/", "PagosYAportesSoapException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cl.bicevida.ws.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetGlosaResponse }
     * 
     */
    public GetGlosaResponse createGetGlosaResponse() {
        return new GetGlosaResponse();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link GetGlosa }
     * 
     */
    public GetGlosa createGetGlosa() {
        return new GetGlosa();
    }

    /**
     * Create an instance of {@link GetPagosYAportes }
     * 
     */
    public GetPagosYAportes createGetPagosYAportes() {
        return new GetPagosYAportes();
    }

    /**
     * Create an instance of {@link GetPagosYAportesResponse }
     * 
     */
    public GetPagosYAportesResponse createGetPagosYAportesResponse() {
        return new GetPagosYAportesResponse();
    }

    /**
     * Create an instance of {@link SoapFaultMessage }
     * 
     */
    public SoapFaultMessage createSoapFaultMessage() {
        return new SoapFaultMessage();
    }

    /**
     * Create an instance of {@link ResponseGlosa }
     * 
     */
    public ResponseGlosa createResponseGlosa() {
        return new ResponseGlosa();
    }

    /**
     * Create an instance of {@link ResponseServiceTO }
     * 
     */
    public ResponseServiceTO createResponseServiceTO() {
        return new ResponseServiceTO();
    }

    /**
     * Create an instance of {@link PagosYAportesWsVO }
     * 
     */
    public PagosYAportesWsVO createPagosYAportesWsVO() {
        return new PagosYAportesWsVO();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGlosaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.bicevida.cl/", name = "getGlosaResponse")
    public JAXBElement<GetGlosaResponse> createGetGlosaResponse(GetGlosaResponse value) {
        return new JAXBElement<GetGlosaResponse>(_GetGlosaResponse_QNAME, GetGlosaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.bicevida.cl/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGlosa }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.bicevida.cl/", name = "getGlosa")
    public JAXBElement<GetGlosa> createGetGlosa(GetGlosa value) {
        return new JAXBElement<GetGlosa>(_GetGlosa_QNAME, GetGlosa.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPagosYAportes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.bicevida.cl/", name = "getPagosYAportes")
    public JAXBElement<GetPagosYAportes> createGetPagosYAportes(GetPagosYAportes value) {
        return new JAXBElement<GetPagosYAportes>(_GetPagosYAportes_QNAME, GetPagosYAportes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPagosYAportesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.bicevida.cl/", name = "getPagosYAportesResponse")
    public JAXBElement<GetPagosYAportesResponse> createGetPagosYAportesResponse(GetPagosYAportesResponse value) {
        return new JAXBElement<GetPagosYAportesResponse>(_GetPagosYAportesResponse_QNAME, GetPagosYAportesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapFaultMessage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.bicevida.cl/", name = "PagosYAportesSoapException")
    public JAXBElement<SoapFaultMessage> createPagosYAportesSoapException(SoapFaultMessage value) {
        return new JAXBElement<SoapFaultMessage>(_PagosYAportesSoapException_QNAME, SoapFaultMessage.class, null, value);
    }

}
