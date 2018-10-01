package ar.gov.sedronar.aplicacion.dao.interfaces;

import ar.gov.sedronar.aplicacion.model.HojaMensualAlimentacion;

/**
 * Created by TMR on 19/09/2018.
 */
public interface HojaMensualAlimentacionDAO extends AbstractDAO<HojaMensualAlimentacion> {
    HojaMensualAlimentacion findById(Long idHoja, Integer idAlimentacion);
    HojaMensualAlimentacion findByIdAndClasificacion(Long idHoja, Integer idAlimentacion, String clasificacion);
}
