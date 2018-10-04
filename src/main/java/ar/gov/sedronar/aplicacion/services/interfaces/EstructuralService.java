package ar.gov.sedronar.aplicacion.services.interfaces;

import ar.gov.sedronar.aplicacion.dto.EstructuralSeccionAData;
import ar.gov.sedronar.util.app.AppResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by TMR on 04/10/2018.
 */
@Path("/estructural")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface EstructuralService {
    @Path("/saveOrUpdateSeccionA")
    @POST
    AppResponse saveOrUpdateSeccionA(EstructuralSeccionAData data) throws Exception;

    @Path("/findDataSeccionAByHojaId")
    @POST
    EstructuralSeccionAData findDataSeccionAByHojaId(Long idhoja);

}
