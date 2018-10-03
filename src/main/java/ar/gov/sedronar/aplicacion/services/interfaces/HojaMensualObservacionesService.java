package ar.gov.sedronar.aplicacion.services.interfaces;

import ar.gov.sedronar.aplicacion.dto.HojaMensualObservacionesDTO;
import ar.gov.sedronar.util.app.AppResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by TMR on 18/09/2018.
 */
@Path("/hojaMensualObservaciones")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface HojaMensualObservacionesService {
    void saveOrUpdate(HojaMensualObservacionesDTO hojaMensualObservaciones) throws Exception;

    @POST
    @Path("/saveOrUpdateSeccionD")
    AppResponse saveOrUpdateSeccionD(HojaMensualObservacionesDTO hojaMensualObservaciones) throws Exception;

    @POST
    @Path("/findByHojaId")
    HojaMensualObservacionesDTO findByHojaId(Long idHoja);
}
