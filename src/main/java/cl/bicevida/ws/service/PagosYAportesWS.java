package cl.bicevida.ws.service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.1.12
 * 2017-08-08T09:53:10.396-04:00
 * Generated source version: 3.1.12
 * 
 */
@WebServiceClient(name = "PagosYAportesWS", 
                  wsdlLocation = "file:/C:/workspaceFuse/bv-historial-pagos-y-aportes/src/main/resources/wsdl/PagosYAportesPort.wsdl",
                  targetNamespace = "http://service.ws.bicevida.cl/") 
public class PagosYAportesWS extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://service.ws.bicevida.cl/", "PagosYAportesWS");
    public final static QName PagosyAportesPort = new QName("http://service.ws.bicevida.cl/", "PagosyAportesPort");
    static {
        URL url = null;
        try {
            url = new URL("file:/C:/workspaceFuse/bv-historial-pagos-y-aportes/src/main/resources/wsdl/PagosYAportesPort.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(PagosYAportesWS.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/C:/workspaceFuse/bv-historial-pagos-y-aportes/src/main/resources/wsdl/PagosYAportesPort.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public PagosYAportesWS(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public PagosYAportesWS(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public PagosYAportesWS() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public PagosYAportesWS(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public PagosYAportesWS(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public PagosYAportesWS(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns PagosyAportes
     */
    @WebEndpoint(name = "PagosyAportesPort")
    public PagosyAportes getPagosyAportesPort() {
        return super.getPort(PagosyAportesPort, PagosyAportes.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns PagosyAportes
     */
    @WebEndpoint(name = "PagosyAportesPort")
    public PagosyAportes getPagosyAportesPort(WebServiceFeature... features) {
        return super.getPort(PagosyAportesPort, PagosyAportes.class, features);
    }

}
