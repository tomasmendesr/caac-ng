package ar.gov.sedronar.aplicacion.services.interfaces;

import ar.gov.sedronar.aplicacion.dto.AcompaniamientoDTO;
import ar.gov.sedronar.aplicacion.model.Acompaniamiento;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by TMR on 21/09/2018.
 */
@Path("/acompaniamiento")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface AcompaniamientoService {

    @Path("findAllEstablecimientosDeSalud")
    @POST
    List<AcompaniamientoDTO> findAllEstablecimientosDeSalud();

    @Path("findAllEstablecimientosPatrocinioLegal")
    @POST
    List<AcompaniamientoDTO> findAllEstablecimientosPatrocinioLegal();

    @Path("findAllEstablecimientosComunuidadTerapeutica")
    @POST
    List<AcompaniamientoDTO> findAllEstablecimientosComunuidadTerapeutica();

    @Path("findAllEstablecimientoPenalesComisarias")
    @POST
    List<AcompaniamientoDTO> findAllEstablecimientoPenalesComisarias();

    @Path("findAll")
    @POST
    List<AcompaniamientoDTO> findAll();

    @Path("findAllEstablecimientosDeSaludAndTipoAcompaniamiento")
    @POST
    List<AcompaniamientoDTO> findAllEstablecimientosDeSaludAndTipoAcompaniamiento();

    @Path("findAllEstablecimientosPenalesAndTipoAcompaniamiento")
    @POST
    List<AcompaniamientoDTO> findAllEstablecimientosPenalesAndTipoAcompaniamiento();

    @Path("findAllEstablecimientosPenalesAndTipoActividades")
    @POST
    List<AcompaniamientoDTO> findAllEstablecimientosPenalesAndTipoActividades();

    @Path("findAllEstablecimientosDeSaludAndTipoGestion")
    @POST
    List<AcompaniamientoDTO> findAllEstablecimientosDeSaludAndTipoGestion();

    @Path("findAllEstablecimientoProfesionalDeSalud")
    @POST
    List<AcompaniamientoDTO> findAllEstablecimientoProfesionalDeSalud();

    @Path("findAllEstablecimientoTrayectoriasEducativas")
    @POST
    List<AcompaniamientoDTO> findAllEstablecimientoTrayectoriasEducativas();

}
