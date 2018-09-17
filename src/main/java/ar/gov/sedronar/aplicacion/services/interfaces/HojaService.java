package ar.gov.sedronar.aplicacion.services.interfaces;

import ar.gov.sedronar.aplicacion.dto.HeaderSigeseForms;
import ar.gov.sedronar.aplicacion.dto.HojaDTO;
import ar.gov.sedronar.aplicacion.filters.ConsultaTableFilter;
import ar.gov.sedronar.util.app.AppResponse;
import ar.gov.sedronar.util.dataTable.DataTableObjectResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by TMR on 10/09/2018.
 */
@Path("/hoja")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface HojaService {

    @POST
    @Path("/getHojasForTable")
    DataTableObjectResponse getHojasForTable(ConsultaTableFilter filter);

    @POST
    @Path("/saveOrUpdate")
    Long saveOrUpdate(HojaDTO hojaDTO) throws Exception;

    AppResponse validateInputsDatosInicialesMensual(HojaDTO hojaDTO);

    HojaDTO findById(Long idHoja);

    @POST
    @Path("/findByPeriodoAndCasa")
    Long findByPeriodoAndCasa(HeaderSigeseForms headerSigeseForms);
}
