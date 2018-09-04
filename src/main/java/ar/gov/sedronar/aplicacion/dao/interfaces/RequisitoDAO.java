package ar.gov.sedronar.dao.interfaces;

import java.util.List;

import ar.gov.sedronar.models.Requisito;

public interface RequisitoDAO extends AbstractDAO<Requisito>{

	Requisito findByCasaId(Integer id);	

}
