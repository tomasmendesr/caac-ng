package ar.gov.sedronar.aplicacion.services.interfaces;

import ar.gov.sedronar.aplicacion.dto.ConfiguracionDTO;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by TMR on 12/07/2018.
 */
@Path("/configuracion")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface ConfiguracionService {
    @GET
    @Path("/getParametrosIniciales")
    ConfiguracionDTO getParametrosIniciales();
}
