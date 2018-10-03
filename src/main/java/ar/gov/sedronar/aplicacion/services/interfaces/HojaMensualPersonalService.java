package ar.gov.sedronar.aplicacion.services.interfaces;

import ar.gov.sedronar.aplicacion.filters.AbstractTableFilter;
import ar.gov.sedronar.aplicacion.filters.ConsultaTableFilter;
import ar.gov.sedronar.util.dataTable.DataTableObjectResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by TMR on 02/10/2018.
 */
@Path("/hojaMensualPersonal")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface HojaMensualPersonalService {

    /********
     * El filtro contiene el id de la hoja
     * @param filter
     * @return
     */
    @POST
    @Path("/getDataForTable")
    DataTableObjectResponse getDataForTable(AbstractTableFilter filter);
}
