package ar.gov.sedronar.aplicacion.dao.interfaces;

import ar.gov.sedronar.aplicacion.dto.HeaderSigeseForms;
import ar.gov.sedronar.aplicacion.filters.ConsultaFilter;
import ar.gov.sedronar.aplicacion.model.Hoja;

import java.util.List;
import java.util.Map;

/**
 * Created by TMR on 10/09/2018.
 */
public interface HojaDAO extends AbstractDAO<Hoja> {
    Integer count(ConsultaFilter filter);
    List<Hoja> findAll(Integer start, Integer length, Map<String, Boolean> sortOrder, ConsultaFilter filter);

    Hoja findByPeriodoAndCasa(HeaderSigeseForms headerSigeseForms);
}
