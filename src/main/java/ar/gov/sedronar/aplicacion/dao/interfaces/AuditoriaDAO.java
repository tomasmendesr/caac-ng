package ar.gov.sedronar.dao.interfaces;

import java.util.List;
import java.util.Map;

import ar.gov.sedronar.models.Auditoria;

public interface AuditoriaDAO extends AbstractDAO<Auditoria>{

	//Auditoria findByCasaId(Integer id);

	List<Auditoria> findAllUnique(int offset, int limit, Map<String, Boolean> sortOrders, Class<Auditoria> class1);

	List<Auditoria> findAllByCasaId(Integer id, Class<Auditoria> class1);	

}
