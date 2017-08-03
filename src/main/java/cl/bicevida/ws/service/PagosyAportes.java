package cl.bicevida.ws.service;

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
 * This class was generated by Apache CXF 3.1.12
 * 2017-07-25T08:48:06.925-04:00
 * Generated source version: 3.1.12
 * 
 */
@WebService(targetNamespace = "http://service.ws.bicevida.cl/", name = "PagosyAportes")
@XmlSeeAlso({ObjectFactory.class})
public interface PagosyAportes {

    @WebMethod
    @Action(input = "http://service.ws.bicevida.cl/PagosyAportes/getPagosYAportesRequest", output = "http://service.ws.bicevida.cl/PagosyAportes/getPagosYAportesResponse", fault = {@FaultAction(className = PagosYAportesSoapException.class, value = "http://service.ws.bicevida.cl/PagosyAportes/getPagosYAportes/Fault/PagosYAportesSoapException")})
    @RequestWrapper(localName = "getPagosYAportes", targetNamespace = "http://service.ws.bicevida.cl/", className = "cl.bicevida.ws.service.GetPagosYAportes")
    @ResponseWrapper(localName = "getPagosYAportesResponse", targetNamespace = "http://service.ws.bicevida.cl/", className = "cl.bicevida.ws.service.GetPagosYAportesResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cl.bicevida.ws.service.ResponseServiceTO getPagosYAportes(
        @WebParam(name = "rutDv", targetNamespace = "")
        java.lang.String rutDv,
        @WebParam(name = "poliza", targetNamespace = "")
        java.lang.String poliza,
        @WebParam(name = "fechaDesde", targetNamespace = "")
        java.lang.String fechaDesde,
        @WebParam(name = "fechaHasta", targetNamespace = "")
        java.lang.String fechaHasta
    ) throws PagosYAportesSoapException;
}