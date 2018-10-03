package ar.gov.sedronar.aplicacion.services.interfaces;
import ar.gov.sedronar.modulo.commonsModels.dto.TipoDocumentoDTO;
import ar.gov.sedronar.modulo.geo.dto.DepartamentoDTO;
import ar.gov.sedronar.modulo.geo.dto.DepartamentoLightDTO;
import ar.gov.sedronar.modulo.geo.dto.LocalidadLightDTO;
import ar.gov.sedronar.modulo.geo.dto.ProvinciaLightDTO;
import ar.gov.sedronar.util.app.AppRequest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by TMR on 12/09/2018.
 */
@Path("/pics")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface PicsService {

    @POST
    @Path("/findAllProvinciasCombo")
    List<ProvinciaLightDTO> findAllProvinciasCombo();

    @POST
    @Path("/findAllLocalidades")
    List<LocalidadLightDTO> findAllLocalidades();

    @POST
    @Path("/findAllDepartamentos")
    List<DepartamentoLightDTO> findAllDepartamentos();

    @POST
    @Path("/findAllDepartamentosByProvincia")
    List<DepartamentoLightDTO> findAllDepartamentosByProvincia(ProvinciaLightDTO provinciaLightDTO);

    @POST
    @Path("/findAllLocalidadesByDepartamento")
    List<LocalidadLightDTO> findAllLocalidadesByDepartamento(DepartamentoLightDTO departamentoLightDTO);

    @POST
    @Path("/findAllTiposDocumento")
    List<TipoDocumentoDTO> findAllTiposDocumento();


}
