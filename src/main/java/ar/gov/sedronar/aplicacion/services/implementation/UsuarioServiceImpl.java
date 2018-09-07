package ar.gov.sedronar.aplicacion.services.implementation;

import ar.gov.sedronar.aplicacion.dao.interfaces.UsuarioDAO;
import ar.gov.sedronar.aplicacion.dao.mock.MockDAO;
import ar.gov.sedronar.aplicacion.dto.UsuarioDTO;
import ar.gov.sedronar.aplicacion.filters.AbstractTableFilter;
import ar.gov.sedronar.aplicacion.model.Usuario;
import ar.gov.sedronar.aplicacion.services.interfaces.UsuarioService;
import ar.gov.sedronar.util.app.AppResponse;
import ar.gov.sedronar.util.dataTable.Column;
import ar.gov.sedronar.util.dataTable.ColumnOrder;
import ar.gov.sedronar.util.dataTable.DataTableObjectResponse;
import ar.gov.sedronar.util.dozer.DozerHelper;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.*;


@Transactional
@Stateless
@DefaultServiceImpl
//@RolesAllowed({"ROL_NAME"})
public class UsuarioServiceImpl implements UsuarioService {

	@Inject
	@MockDAO
	private UsuarioDAO usuarioDAO;

	@Override
	public DataTableObjectResponse getUsersForTable(AbstractTableFilter filtro) {
		Map<String, Boolean> sortOrder = new HashMap<>();
		for (ColumnOrder order : filtro.getOrder()) {
			Column column = filtro.getColumns().get(order.getColumn());
			sortOrder.put(column.getData(), order.getDir().equals("asc"));
		}
		Collection<UsuarioDTO> items = DozerHelper.mapList(usuarioDAO.findAll(filtro.getStart(), filtro.getLength(), sortOrder, filtro.getFilter()), UsuarioDTO.class);
		Integer count = usuarioDAO.count(filtro.getFilter());
		return new DataTableObjectResponse(items,filtro.getDraw(),count, count);
	}

	@Override
	public AppResponse validateInputs(UsuarioDTO dto) {
		List<String> messages = new ArrayList<>();

		if(dto.getNombre() == null || StringUtils.isBlank(dto.getNombre()))
			messages.add("El nombre no puede estar vacío");
		if(dto.getApellido() == null || StringUtils.isBlank(dto.getApellido()))
			messages.add("El apellido no puede estar vacío");

		if(dto.getEmail() == null || StringUtils.isBlank(dto.getEmail()))
			messages.add("El email no puede estar vacío");

		if(dto.getUsername() == null || StringUtils.isBlank(dto.getUsername()))
			messages.add("El username no puede estar vacío");

		return messages.isEmpty() ? new AppResponse() : new AppResponse(AppResponse.ERROR, messages);
	}

	@Override
	public void saveOrUpdate(UsuarioDTO dto) throws Exception {
		if (dto == null) throw new Exception("Error creando la consulta");
		Usuario usuario;

		if (dto.getId() == null) {
			usuario = new Usuario();
//			dto.setCreatedAt(new Date());
		}else{
			usuario = usuarioDAO.findById(Usuario.class, dto.getId());
			if (usuario == null) throw new Exception("Consulta inexistente");
		}
		usuario = DozerHelper.map(dto, Usuario.class);
		usuarioDAO.merge(usuario);
	}

	@Override
	public void delete(UsuarioDTO usuarioDTO) throws Exception {
		usuarioDAO.delete(usuarioDAO.findById(Usuario.class, usuarioDTO.getId()));
	}

	@Override
	public AppResponse isInUse(UsuarioDTO usuarioDTO) {
		return new AppResponse(false);
	}
}

