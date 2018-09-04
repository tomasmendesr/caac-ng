package ar.gov.sedronar.dao.interfaces;

import ar.gov.sedronar.models.Vencimiento;

public interface VencimientoDAO extends AbstractDAO<Vencimiento>{

	Vencimiento findByCasaId(Integer id);	

}
