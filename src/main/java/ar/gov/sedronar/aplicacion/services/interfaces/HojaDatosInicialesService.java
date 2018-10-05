package ar.gov.sedronar.aplicacion.services.interfaces;

import ar.gov.sedronar.aplicacion.dto.HojaDatosInicialesDTO;
import ar.gov.sedronar.aplicacion.dto.MensualSeccionARequestDTO;
import ar.gov.sedronar.util.app.AppRequest;
import ar.gov.sedronar.util.app.AppResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by TMR on 13/09/2018.
 */
@Path("/hojaDatosIniciales")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface HojaDatosInicialesService {

    @POST
    @Path("/saveOrUpdateMensual")
    AppResponse saveOrUpdateMensual(MensualSeccionARequestDTO mensualSeccionARequestDTO) throws Exception;

    @POST
    @Path("/validateInputsMensual")
    AppResponse validateInputsMensual(HojaDatosInicialesDTO hojaDatosInicialesDTO);

    HojaDatosInicialesDTO findByHojaId(Long idhoja);

    Long saveOrUpdate(HojaDatosInicialesDTO hojaDatosInicialesDTO) throws Exception;
}
