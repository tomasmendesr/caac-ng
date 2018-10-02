package ar.gov.sedronar.aplicacion.dao.interfaces;


import ar.gov.sedronar.aplicacion.filters.VencimientoFilter;
import ar.gov.sedronar.aplicacion.model.Vencimiento;

import java.util.List;
import java.util.Map;

public interface VencimientoDAO extends AbstractDAO<Vencimiento>{
    Integer count(VencimientoFilter filter);

    List<Vencimiento> findAllForTable(Integer start, Integer length, Map<String, Boolean> columnOrders, VencimientoFilter filter);
}
