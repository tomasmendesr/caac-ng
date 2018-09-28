package ar.gov.sedronar.aplicacion.dao.interfaces;


import ar.gov.sedronar.aplicacion.filters.AdministrativoFilter;
import ar.gov.sedronar.aplicacion.filters.GeneralFilter;
import ar.gov.sedronar.aplicacion.model.Requisito;

import java.util.List;
import java.util.Map;

public interface RequisitoDAO extends AbstractDAO<Requisito>{

    void saveOrUpdate(Requisito requisito);

    List<Requisito> findAllForTable(Integer start, Integer length, Map<String, Boolean> sortOrder, Object filter);

    Integer count(AdministrativoFilter filter);
}
