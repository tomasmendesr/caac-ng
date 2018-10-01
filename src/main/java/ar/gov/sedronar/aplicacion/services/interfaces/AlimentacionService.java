package ar.gov.sedronar.aplicacion.services.interfaces;

import ar.gov.sedronar.aplicacion.dto.AlimentacionDTO;
import ar.gov.sedronar.aplicacion.dto.TramiteDTO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by TMR on 18/09/2018.
 */
@Path("/alimentacion")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface AlimentacionService {

    @POST
    @Path("/findAll")
    List<AlimentacionDTO> findAll();

    @POST
    @Path("/findAllEnSede")
    List<AlimentacionDTO> findAllEnSede();

    @POST
    @Path("/findAllFueraDeSede")
    List<AlimentacionDTO> findAllFueraDeSede();
}
