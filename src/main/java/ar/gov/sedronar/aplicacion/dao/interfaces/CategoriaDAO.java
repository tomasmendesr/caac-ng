package ar.gov.sedronar.dao.interfaces;

import ar.gov.sedronar.models.Categoria;

public interface CategoriaDAO extends AbstractDAO<Categoria>{

	Object findById(String id);	

}
