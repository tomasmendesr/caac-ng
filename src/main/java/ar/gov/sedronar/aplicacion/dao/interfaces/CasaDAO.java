package ar.gov.sedronar.aplicacion.dao.interfaces;

import ar.gov.sedronar.aplicacion.filters.ConsultaFilter;
import ar.gov.sedronar.aplicacion.filters.GeneralFilter;
import ar.gov.sedronar.aplicacion.model.Casa;
import ar.gov.sedronar.aplicacion.model.Hoja;

import java.util.List;
import java.util.Map;

public interface CasaDAO extends AbstractDAO<Casa>{

    List<Casa> findAllForGeneral(Integer start, Integer length, Map<String, Boolean> sortOrder, GeneralFilter filter);
    Integer count(GeneralFilter filter);
    List<Casa> findAllForAdministrativo(Integer start, Integer length, Map<String, Boolean> columnOrders, GeneralFilter filter);
}
