package ar.gov.sedronar.aplicacion.services.interfaces;

import ar.gov.sedronar.aplicacion.dto.RequisitoDTO;
import ar.gov.sedronar.aplicacion.filters.AdministrativoTableFilter;
import ar.gov.sedronar.util.app.AppResponse;
import ar.gov.sedronar.util.dataTable.DataTableObjectResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/requisito")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface RequisitoService {

    @POST
    @Path("/saveOrUpdate")
    AppResponse saveOrUpdate(RequisitoDTO requisitoDTO) throws Exception;

    @POST
    @Path("/findAllRequisitos")
    List<RequisitoDTO> findAll()throws Exception;

    @POST
    @Path("/findAllRequisitosForAdministrativo")
    DataTableObjectResponse findAllDataTable(AdministrativoTableFilter administrativoFilter) throws Exception;

}
