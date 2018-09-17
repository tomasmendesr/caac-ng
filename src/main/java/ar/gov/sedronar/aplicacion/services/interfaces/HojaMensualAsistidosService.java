package ar.gov.sedronar.aplicacion.services.interfaces;

import ar.gov.sedronar.aplicacion.dto.HojaDTO;
import ar.gov.sedronar.aplicacion.dto.HojaMensualAsistidosDTO;
import ar.gov.sedronar.aplicacion.model.HojaMensualAsistidos;
import ar.gov.sedronar.util.app.AppResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by TMR on 17/09/2018.
 */
@Path("/hojaMensualAsistidos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface HojaMensualAsistidosService {

    @POST
    @Path("/saveOrUpdate")
    AppResponse saveOrUpdate(HojaMensualAsistidosDTO hojaMensualAsistidosDTO) throws Exception;

    @POST
    @Path("/findById")
    HojaMensualAsistidosDTO findById(Long id);

}
