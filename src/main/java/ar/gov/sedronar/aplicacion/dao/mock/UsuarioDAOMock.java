package ar.gov.sedronar.aplicacion.dao.mock;

import java.util.*;
import java.util.stream.Collectors;

import javax.ejb.Stateless;

import ar.gov.sedronar.aplicacion.dao.hibernate.AbstractDAOImpl;
import ar.gov.sedronar.aplicacion.dao.interfaces.UsuarioDAO;
import ar.gov.sedronar.aplicacion.filters.AbstractFilter;
import ar.gov.sedronar.aplicacion.model.Usuario;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.StringUtil;


@Stateless
@MockDAO
public class UsuarioDAOMock extends AbstractDAOImpl<Usuario> implements UsuarioDAO {

	@Override
	public Integer count(AbstractFilter filter) {
		return this.findAll(filter).size();
	}

	@Override
	public List<Usuario> findAll(Integer start, Integer length, Map<String, Boolean> sortOrder, AbstractFilter filter) {
		return findAll(filter);
	}

	public List<Usuario> findAll(AbstractFilter filter){

		Usuario user1 = new Usuario();
		user1.setNombre("Susana");
		user1.setApellido("Gimenez");
		user1.setEmail("su@telefe.com.ar");
		user1.setFechaDeNacimiento(new Date());
		user1.setUsername("username");

		Usuario user2 = new Usuario();
		user2.setNombre("Susana");
		user2.setApellido("Gimenez");
		user2.setEmail("su@telefe.com.ar");
		user2.setFechaDeNacimiento(new Date());
		user2.setUsername("username");

		Usuario user3 = new Usuario();
		user3.setNombre("Susana");
		user3.setApellido("Gimenez");
		user3.setEmail("su@telefe.com.ar");
		user3.setFechaDeNacimiento(new Date());
		user3.setUsername("username");

		List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

		if(filter != null && filter.getValue() != null && StringUtils.isNotBlank(filter.getValue())){
			String value = filter.getValue();
			return usuarios.stream().filter(user -> user.getApellido().contains(value) || user.getNombre().contains(value)
						|| user.getEmail().contains(value) || user.getUsername().contains(value)
			).collect(Collectors.toList());
		}

		return usuarios;

	}


}
