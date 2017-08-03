package cl.bicevida.beans.processors;

import java.io.IOException;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.camel.Exchange;
import org.apache.camel.http.common.HttpOperationFailedException;
import org.apache.cxf.jaxrs.utils.JAXRSUtils;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.message.MessageContentsList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.bicevida.service.rest.exception.WebApplicationJsonError;
import cl.bicevida.service.rest.exception.out.OutException;
import cl.bicevida.ws.service.GetPagosYAportesResponse;
import cl.bicevida.ws.service.PagosYAportesSoapException;
import cl.bicevida.ws.service.PagosyAportes;
import cl.bicevida.ws.service.ResponseServiceTO;

public class HistorialProcess extends WebApplicationJsonError {
	Logger logger = LoggerFactory.getLogger(HistorialProcess.class);

	
	/**
	 * Metodo que se utiliza para consultar los datos de historial de pagos y aportes
	 * 
	 * @param exchange process de camel
	 * @return
	 * @throws Exception Excepcion.
	 */
	public GetPagosYAportesResponse obtenerpagosyaportes(Exchange exchange) throws Exception {
		logger.info("[obtenerpagosyaportes]Inicio...");
		
		MessageContentsList cxfMessage = exchange.getIn().getBody(MessageContentsList.class);
		GetPagosYAportesResponse response = new GetPagosYAportesResponse();
		
		String url = exchange.getContext().resolvePropertyPlaceholders("{{servicio.pagosyaportes}}");
		
		try {
			String rutdv = cxfMessage.get(0).toString();
			String poliza = cxfMessage.get(1).toString();
			String fechaDesde = cxfMessage.get(2).toString();
			String fechaHasta = cxfMessage.get(3).toString();

			PagosyAportes client = createCXFClient(url);

			ResponseServiceTO out = client.getPagosYAportes(rutdv, poliza, fechaDesde, fechaHasta);
			response.setReturn(out);
			logger.info("[obtenerpagosyaportes][" + response.toString() + "]");
		} catch (PagosYAportesSoapException e) {
			logger.error("[obtenerpagosyaportes][SoapFaultException][" + e.getMessage() + "]", e);
			exchange.getOut().getExchange().setException(e);
			throw new WebApplicationException(e);
		} catch (Exception e) {
			logger.error("[obtenerpagosyaportes][Exception][" + e.getMessage() + "]", e);
			exchange.getOut().getExchange().setException(e);
			throw new WebApplicationException(e);
		}
		exchange.getOut().setBody(response);
		logger.info("[obtenerpagosyaportes]Fin...");
		return response;
	}

	/**
	 * Metodo que conecta con nuestro cliente del servicioWEB
	 * 
	 * @return Objeto de pagos y aportes
	 */
	protected static PagosyAportes createCXFClient(String url) {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(PagosyAportes.class);
		factory.setAddress(url);
		return (PagosyAportes) factory.create();
	}

	public Response exceptionProcess(Exchange ex) throws IOException{
		   logger.info("[HistorialProcess][exceptionProcess]...");
		   Response response = null;
		   
		   Exception causa = ex.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);
	       OutException out = new OutException();
	       if(causa instanceof HttpOperationFailedException){
	              HttpOperationFailedException c= (HttpOperationFailedException) causa;
	              out.setMensaje(c.getMessage());
	              out.setStatusCode(c.getStatusCode());
	              out.setStatusText(c.getStatusText());
	              ex.getOut().setBody(out);
	       }
	       else if(causa instanceof WebApplicationException){
	              WebApplicationException c= (WebApplicationException) causa;
	              out.setMensaje(c.getMessage());
	              out.setStatusCode(c.getResponse().getStatus());
	              out.setStatusText(c.getResponse().getStatusInfo().toString());
	              ex.getOut().setBody(out);
	              
	              response = c.getResponse();
	            //  response= Response.status(Response.Status.ACCEPTED).entity(out).build();
	       }else{
	              out.setMensaje(causa.getMessage());
	              out.setStatusCode(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
	              out.setStatusText(Response.Status.INTERNAL_SERVER_ERROR.toString());
	              ex.getOut().setBody(out);  
	       }
	       
	       
	       response = JAXRSUtils.copyResponseIfNeeded(response);
	       response = JAXRSUtils.fromResponse(response).type(MediaType.APPLICATION_JSON).build();
	       return response;

		}

}
