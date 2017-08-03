package cl.bicevida.service.rest.exception;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.common.logging.LogUtils;
import org.apache.cxf.jaxrs.impl.WebApplicationExceptionMapper;
import org.apache.cxf.jaxrs.utils.ExceptionUtils;
import org.apache.cxf.jaxrs.utils.JAXRSUtils;
import org.apache.cxf.logging.FaultListener;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.PhaseInterceptorChain;

import cl.bicevida.service.rest.exception.out.OutException;


public class WebApplicationJsonError extends WebApplicationExceptionMapper {
	
	 private static final Logger LOG = LogUtils.getL7dLogger(WebApplicationJsonError.class);	
	 private boolean addMessageToResponse;
	 private boolean printStackTrace = true;
	 
	 @Override
	 public Response toResponse(WebApplicationException ex) {
	        
	        Response r = ex.getResponse();
	        if (r == null) {
	            r = Response.serverError().build();
	        }
	        boolean doAddMessage = r.getEntity() != null ? false : addMessageToResponse;
	        
	        
	        Message msg = PhaseInterceptorChain.getCurrentMessage();
	        FaultListener flogger = null;
	        if (msg != null) {
	            flogger = (FaultListener)PhaseInterceptorChain.getCurrentMessage()
	                .getContextualProperty(FaultListener.class.getName());
	        }
	        OutException errorMessage = doAddMessage || flogger != null  ? buildErrorMessageOut(r, ex) : null; 
	        if (flogger == null
	            || !flogger.faultOccurred(ex, errorMessage.toString(), msg)) {
	            Level level = printStackTrace ? Level.WARNING : Level.FINE;
	            LOG.log(level, ExceptionUtils.getStackTrace(ex));
	            
	        }
	        
	        if (doAddMessage) {
	            r = JAXRSUtils.copyResponseIfNeeded(r);
	            r = JAXRSUtils.fromResponse(r).entity(errorMessage).type(MediaType.APPLICATION_JSON).build();
	        }
	        return r;
	    }
	
	/**
	 * Crea la respuesta en caso de que la URLS GET, sean mal ingresada.
	 * 
	 * @param r
	 * @param ex
	 * @return
	 */
	protected OutException buildErrorMessageOut(Response r, WebApplicationException ex) {
		OutException out = new OutException();
        out.setStatusCode(r.getStatus());
        
        Throwable cause = ex.getCause();
        String message = cause == null ? ex.getMessage() : cause.getMessage();
        if (message == null && cause != null) {
        	message = "exception cause class: " + cause.getClass().getName();
        }
        if (message != null) {
            out.setMensaje(message);
        }
        return out;
    }
	
	
	public void setAddMessageToResponse(boolean addMessageToResponse) {
        this.addMessageToResponse = addMessageToResponse;
    }

	
}
