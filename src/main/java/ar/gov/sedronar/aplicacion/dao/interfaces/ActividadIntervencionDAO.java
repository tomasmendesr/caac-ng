package ar.gov.sedronar.aplicacion.dao.interfaces;

import ar.gov.sedronar.aplicacion.model.ActividadIntervencion;

import java.util.List;

/**
 * Created by TMR on 02/10/2018.
 */
public interface ActividadIntervencionDAO extends AbstractDAO<ActividadIntervencion> {
    List<ActividadIntervencion> findByTipo(String tipo);
}
