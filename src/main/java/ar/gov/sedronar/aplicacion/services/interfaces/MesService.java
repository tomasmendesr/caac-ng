package ar.gov.sedronar.aplicacion.services.interfaces;

import ar.gov.sedronar.modulo.commonsModels.dto.MesDTO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by TMR on 10/09/2018.
 */
@Path("/mes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface MesService {

    @POST
    @Path("/findAll")
    List<MesDTO> findAll();
}
