package ar.gov.sedronar.aplicacion.dao.interfaces;

import ar.gov.sedronar.aplicacion.model.HojaMensualAcompaniamiento;

/**
 * Created by TMR on 21/09/2018.
 */
public interface HojaMensualAcompaniamientoDAO extends AbstractDAO<HojaMensualAcompaniamiento> {
    HojaMensualAcompaniamiento findById(Long idHoja, Integer idAcompaniamiento);
}
