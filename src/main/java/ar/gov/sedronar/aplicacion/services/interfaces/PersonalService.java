package ar.gov.sedronar.aplicacion.services.interfaces;

import ar.gov.sedronar.aplicacion.dto.PersonalDTO;
import ar.gov.sedronar.aplicacion.filters.DocumentFilter;
import ar.gov.sedronar.modulo.commonsModels.dto.TipoDocumentoDTO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by TMR on 03/10/2018.
 */
@Path("/personal")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface PersonalService {

    Integer saveOrUpdate(PersonalDTO personalDTO) throws Exception;

    PersonalDTO findByDocumento(TipoDocumentoDTO tipoDocumento, Integer numeroDocumento);

    PersonalDTO findById(Integer idPersonal);

    @Path("/findByDocumento")
    @POST
    PersonalDTO findByDocumento(DocumentFilter documentFilter);
}
