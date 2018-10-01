package ar.gov.sedronar.aplicacion.dao.interfaces;

import ar.gov.sedronar.aplicacion.model.Alimentacion;

import java.util.List;

/**
 * Created by TMR on 18/09/2018.
 */
public interface AlimentacionDAO extends AbstractDAO<Alimentacion> {
    List<Alimentacion> findByClasificacion(String clasificacion);
}
