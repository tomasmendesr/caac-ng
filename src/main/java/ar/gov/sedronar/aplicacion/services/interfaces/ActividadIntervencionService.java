package ar.gov.sedronar.aplicacion.services.interfaces;

import ar.gov.sedronar.aplicacion.dto.ActividadIntervencionDTO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by TMR on 02/10/2018.
 */
@Path("/actividadIntervencion")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface ActividadIntervencionService {

    @Path("/findAllTipoActividad")
    @POST
    List<ActividadIntervencionDTO> findAllTipoActividad();

    @Path("/findAllTipoFamilia")
    @POST
    List<ActividadIntervencionDTO> findAllTipoFamilia();

    @Path("/findAllTipoIntervencion")
    @POST
    List<ActividadIntervencionDTO> findAllTipoIntervencion();
}
