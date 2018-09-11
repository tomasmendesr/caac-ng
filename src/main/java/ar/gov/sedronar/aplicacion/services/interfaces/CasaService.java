package ar.gov.sedronar.aplicacion.services.interfaces;

import ar.gov.sedronar.aplicacion.dto.CasaDTO;
import ar.gov.sedronar.aplicacion.dto.CasaLightDTO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by TMR on 10/09/2018.
 */
@Path("/casa")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface CasaService {

    @POST
    @Path("/findAllLight")
    List<CasaLightDTO> findAllLight();
}
