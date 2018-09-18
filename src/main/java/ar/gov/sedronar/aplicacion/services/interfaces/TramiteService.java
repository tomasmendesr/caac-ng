package ar.gov.sedronar.aplicacion.services.interfaces;

import ar.gov.sedronar.aplicacion.dto.TramiteDTO;
import ar.gov.sedronar.modulo.commonsModels.dto.MesDTO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by TMR on 18/09/2018.
 */
@Path("/tramite")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface TramiteService {

    @POST
    @Path("/findAll")
    List<TramiteDTO> findAll();
}
