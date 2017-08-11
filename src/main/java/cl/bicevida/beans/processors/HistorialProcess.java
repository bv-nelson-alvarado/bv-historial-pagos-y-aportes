package cl.bicevida.beans.processors;

import java.io.IOException;
import java.io.Serializable;

import javax.ws.rs.WebApplicationException;

import org.apache.camel.Exchange;
import org.apache.camel.http.common.HttpOperationFailedException;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.bicevida.service.rest.exception.out.OutException;
import cl.bicevida.ws.service.GetPagosYAportesResponse;
import cl.bicevida.ws.service.PagosYAportesSoapException;
import cl.bicevida.ws.service.PagosyAportes;
import cl.bicevida.ws.service.ResponseServiceTO;

public class HistorialProcess implements Serializable  {
	/**
	 * serial id
	 */
	private static final long serialVersionUID = 1L;
	
	Logger logger = LoggerFactory.getLogger(HistorialProcess.class);

	/**
	 * Metodo que se utiliza para consultar los datos de historial de pagos y
	 * aportes
	 * 
	 * @param exchange
	 *            process de camel
	 * @return
	 * @throws Exception
	 *             Excepcion.
	 */
	public GetPagosYAportesResponse obtenerpagosyaportes(Exchange exchange) throws Exception {
		logger.info("[obtenerpagosyaportes]Inicio...");
		

		GetPagosYAportesResponse response = new GetPagosYAportesResponse();

		String url = exchange.getContext().resolvePropertyPlaceholders("{{servicio.pagosyaportes}}");

		try {
			String rutdv = exchange.getIn().getHeader("rut").toString();
			String poliza = exchange.getIn().getHeader("poliza").toString();
			String fechaDesde = exchange.getIn().getHeader("fechadesde").toString();
			String fechaHasta = exchange.getIn().getHeader("fechahasta").toString();
			
			logger.info("[obtenerpagosyaportes][Llamada al servicio]"
						+ "[rut=" + rutdv +" ] "
						+ "[poliza=" + poliza +" ] "
						+ "[fechaDesde=" + fechaDesde +" ] "
						+ "[fechaHasta=" + fechaHasta +" ] ");

			PagosyAportes client = createCXFClient(url);
			
					
			
			ResponseServiceTO out = client.getPagosYAportes(rutdv, poliza, fechaDesde, fechaHasta);
			response.setReturn(out);
			logger.info("[obtenerpagosyaportes][" + response.toString() + "]");
			exchange.getOut().setBody(response);

		} catch (PagosYAportesSoapException e) {
			logger.error("[obtenerpagosyaportes][SoapFaultException][" + e.getMessage() + "]", e);
			exchange.getOut().getExchange().setException(e);
			throw new WebApplicationException(e);
		} catch (Exception e) {

		    logger.error("[obtenerpagosyaportes][Exception][" + e.getMessage() + "]", e);
			exchange.getOut().getExchange().setException(e);
			throw new WebApplicationException(e);
		}

		logger.info("[obtenerpagosyaportes]Fin...");
		return response;
	}


	/**
	 * Metodo que conecta con nuestro cliente del servicioWEB
	 * 
	 * @return Objeto de pagos y aportes
	 */
	protected static PagosyAportes createCXFClient(String url) {
		long timeout = 300000L; // 300segundos
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(PagosyAportes.class);
		factory.setAddress(url);
		
		
		PagosyAportes runtimeService = (PagosyAportes) factory.create();
		 
        Client client = ClientProxy.getClient(runtimeService);
        if (client != null) {
            HTTPConduit conduit = (HTTPConduit) client.getConduit();
            HTTPClientPolicy policy = new HTTPClientPolicy();
            policy.setConnectionTimeout(timeout);
            policy.setReceiveTimeout(timeout);
            conduit.setClient(policy);
        }
        return runtimeService;
	}

	/**
	 * Maneja la excepciones del servicio, para un retorno de error en la cabecera
	 * 
	 * @param ex
	 * @return
	 * @throws IOException
	 */
	public OutException exceptionProcess(Exchange ex) throws IOException {
		logger.info("[HistorialProcess][exceptionProcess]Inicio...");

		Exception causa = ex.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);
		OutException out = new OutException();
		if (causa instanceof HttpOperationFailedException) {
			HttpOperationFailedException c = (HttpOperationFailedException) causa;
			out.setMensaje(c.getMessage());
			out.setStatusCode(c.getStatusCode());
			out.setStatusText(c.getStatusText());
			
		} else if (causa instanceof WebApplicationException) {
			WebApplicationException c = (WebApplicationException) causa;
			out.setMensaje(c.getCause().getMessage());
			out.setStatusCode(c.getResponse().getStatus());
			out.setStatusText(c.getMessage());
		
		} else {
			out.setMensaje(causa.getMessage());
			out.setStatusCode(500);
			out.setStatusText("Internal Server Error");
		}

		ex.getOut().setBody(out);
		ex.getIn().setHeader(Exchange.CONTENT_TYPE, "application/json");
		ex.getIn().setHeader(Exchange.HTTP_RESPONSE_CODE, out.getStatusCode());
		
		logger.info("[HistorialProcess][exceptionProcess]Fin...");
		return out;
	}

}
