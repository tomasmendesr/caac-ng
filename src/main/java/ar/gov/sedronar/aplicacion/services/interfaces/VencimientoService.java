package ar.gov.sedronar.aplicacion.services.interfaces;

import ar.gov.sedronar.aplicacion.filters.VencimientoTableFilter;
import ar.gov.sedronar.util.dataTable.DataTableObjectResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/vencimiento")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface VencimientoService {


    @POST
    @Path("/findAllForVencimientos")
    DataTableObjectResponse findAllForVencimientos(VencimientoTableFilter vencimientoTableFilter) throws Exception;

}
