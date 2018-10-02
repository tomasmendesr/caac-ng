package ar.gov.sedronar.aplicacion.services.interfaces;

import ar.gov.sedronar.aplicacion.dto.*;
import ar.gov.sedronar.util.app.AppResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by TMR on 18/09/2018.
 */
@Path("/mensualSeccionC")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface MensualSeccionCService {

    @POST
    @Path("/saveOrUpdateSeccionC1")
    AppResponse saveOrUpdateSeccionC1(MensualSeccionC1Data data) throws Exception;

    @POST
    @Path("/getDataForSeccionC1ByHojaId")
    MensualSeccionC1Data getDataForSeccionC1ByHojaId(Long idHoja);

    @POST
    @Path("/saveOrUpdateSeccionC2")
    AppResponse saveOrUpdateSeccionC2(MensualSeccionC2Data data) throws Exception;

    @POST
    @Path("/getDataForSeccionC2ByHojaId")
    MensualSeccionC2Data getDataForSeccionC2ByHojaId(Long idHoja);

    @POST
    @Path("/saveOrUpdateSeccionC3")
    AppResponse saveOrUpdateSeccionC3(MensualSeccionC3Data data) throws Exception;

    @POST
    @Path("/getDataForSeccionC3ByHojaId")
    MensualSeccionC3Data getDataForSeccionC3ByHojaId(Long idHoja);

    @POST
    @Path("/saveOrUpdateSeccionC4")
    AppResponse saveOrUpdateSeccionC4(MensualSeccionC4Data data) throws Exception;

    @POST
    @Path("/getDataForSeccionC4ByHojaId")
    MensualSeccionC4Data getDataForSeccionC4ByHojaId(Long idHoja);

    @POST
    @Path("/saveOrUpdateSeccionC5")
    AppResponse saveOrUpdateSeccionC5(MensualSeccionC5Data data) throws Exception;

    @POST
    @Path("/getDataForSeccionC5ByHojaId")
    MensualSeccionC5Data getDataForSeccionC5ByHojaId(Long idHoja);

    @POST
    @Path("/saveOrUpdateSeccionC6")
    AppResponse saveOrUpdateSeccionC6(List<HojaMensualActividadesDTO> data) throws Exception;

    @POST
    @Path("/getDataForSeccionC6ByHojaId")
    List<HojaMensualActividadesDTO> getDataForSeccionC6ByHojaId(Long idHoja);
}
