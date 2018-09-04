package ar.gov.sedronar.dao.interfaces;

import java.util.List;
import java.util.Map;

import ar.gov.sedronar.models.Pago;

public interface PagoDAO extends AbstractDAO<Pago>{

	Pago findByCasaId(Integer id);

	List<Pago> findAllUnique(int offset, int limit, Map<String, Boolean> sortOrders);

	List<Pago> findAllByCasaId(Integer id);

	List<Pago> findAll(int offset, int limit, Map<String, Boolean> sortOrders, Integer id);

	Integer count(Integer id);

	Integer countCantAsistidos(Integer id);

	Double countMontoAPagar(Integer id);	

}
