package ar.gov.sedronar.aplicacion.services.interfaces;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import ar.gov.sedronar.aplicacion.dto.UsuarioDTO;
import ar.gov.sedronar.aplicacion.filters.AbstractTableFilter;
import ar.gov.sedronar.util.app.AppResponse;
import ar.gov.sedronar.util.dataTable.DataTableObjectResponse;

@Path("/usuario")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface UsuarioService {

	@POST
	@Path("/getUsersForTable")
	DataTableObjectResponse getUsersForTable(AbstractTableFilter filter);

	@POST
	@Path("/validateInputs")
	AppResponse validateInputs(UsuarioDTO usuarioDTO);

	@POST
	@Path("/saveOrUpdate")
	void saveOrUpdate(UsuarioDTO usuarioDTO) throws Exception;

	@POST
	@Path("/delete")
	void delete(UsuarioDTO usuarioDTO) throws Exception;

	@POST
	@Path("/isInUse")
	AppResponse isInUse(UsuarioDTO usuarioDTO);


}
