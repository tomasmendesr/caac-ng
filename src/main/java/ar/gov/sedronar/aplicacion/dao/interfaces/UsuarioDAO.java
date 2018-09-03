package ar.gov.sedronar.aplicacion.dao.interfaces;

import ar.gov.sedronar.aplicacion.filters.AbstractFilter;
import ar.gov.sedronar.aplicacion.model.Usuario;

import java.util.List;
import java.util.Map;

public interface UsuarioDAO extends AbstractDAO<Usuario> {
	Integer count(AbstractFilter filter);
	List<Usuario> findAll(Integer start, Integer length, Map<String, Boolean> sortOrder, AbstractFilter filter);
}
