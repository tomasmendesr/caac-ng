package ar.gov.sedronar.aplicacion.dao.interfaces;

import ar.gov.sedronar.aplicacion.dto.HeaderSigeseForms;
import ar.gov.sedronar.aplicacion.filters.AbstractFilter;
import ar.gov.sedronar.aplicacion.filters.ConsultaFilter;
import ar.gov.sedronar.aplicacion.model.Hoja;
import ar.gov.sedronar.aplicacion.model.HojaMensualPersonal;

import java.util.List;
import java.util.Map;

/**
 * Created by TMR on 02/10/2018.
 */
public interface HojaMensualPersonalDAO extends AbstractDAO<HojaMensualPersonal> {
    Integer count(AbstractFilter filter);
    List<HojaMensualPersonal> findAll(Integer start, Integer length, Map<String, Boolean> sortOrder, AbstractFilter filter);
    HojaMensualPersonal findById(Long idHoja, Integer idPersonal);
}
