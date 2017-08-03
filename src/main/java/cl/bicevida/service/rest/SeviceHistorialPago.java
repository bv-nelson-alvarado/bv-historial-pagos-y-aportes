package cl.bicevida.service.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import cl.bicevida.ws.service.GetPagosYAportesResponse;

@Path("/historialPago")
public class SeviceHistorialPago {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/obtenerpagosyaportes/{rutdv}/{poliza}/{fechaDesde}/{fechaHasta}")
	public GetPagosYAportesResponse obtenerpagosyaportes( @PathParam("rutdv") String rutdv,
			@PathParam("poliza") String poliza,
			@PathParam("fechaDesde") String fechaDesde,
			@PathParam("fechaHasta") String fechaHasta) {
		return null;
	}
	
}
