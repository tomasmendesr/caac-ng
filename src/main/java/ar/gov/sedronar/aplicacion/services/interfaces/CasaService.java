package ar.gov.sedronar.aplicacion.services.interfaces;

import ar.gov.sedronar.aplicacion.dto.CasaDTO;
import ar.gov.sedronar.aplicacion.dto.CasaLightDTO;
import ar.gov.sedronar.aplicacion.filters.AdministrativoTableFilter;
import ar.gov.sedronar.aplicacion.filters.GeneralTableFilter;
import ar.gov.sedronar.util.dataTable.DataTableObjectResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by TMR on 10/09/2018.
 */
@Path("/casa")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface CasaService {

    @POST
    @Path("/findAll")
    List<CasaDTO> findAll();

    @POST
    @Path("/findAllLight")
    List<CasaLightDTO> findAllLight();

    @POST
    @Path("/findAllGeneral")
    DataTableObjectResponse findAllForGeneral(GeneralTableFilter generalTableFilter);

    @POST
    @Path("/saveOrUpdateCasa")
    Boolean saveOrUpdate(CasaDTO casaDTO) throws Exception;

    @POST
    @Path("/findAllAdministrativo")
    DataTableObjectResponse findAllForAdministrativo(AdministrativoTableFilter administrativoTableFilter);
}
