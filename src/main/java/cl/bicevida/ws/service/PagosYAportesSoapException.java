
package cl.bicevida.ws.service;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.1.12
 * 2017-08-10T17:52:50.155-04:00
 * Generated source version: 3.1.12
 */

@WebFault(name = "PagosYAportesSoapException", targetNamespace = "http://service.ws.bicevida.cl/")
public class PagosYAportesSoapException extends Exception {
    
    private cl.bicevida.ws.service.SoapFaultMessage pagosYAportesSoapException;

    public PagosYAportesSoapException() {
        super();
    }
    
    public PagosYAportesSoapException(String message) {
        super(message);
    }
    
    public PagosYAportesSoapException(String message, Throwable cause) {
        super(message, cause);
    }

    public PagosYAportesSoapException(String message, cl.bicevida.ws.service.SoapFaultMessage pagosYAportesSoapException) {
        super(message);
        this.pagosYAportesSoapException = pagosYAportesSoapException;
    }

    public PagosYAportesSoapException(String message, cl.bicevida.ws.service.SoapFaultMessage pagosYAportesSoapException, Throwable cause) {
        super(message, cause);
        this.pagosYAportesSoapException = pagosYAportesSoapException;
    }

    public cl.bicevida.ws.service.SoapFaultMessage getFaultInfo() {
        return this.pagosYAportesSoapException;
    }
}
