package ar.gov.sedronar.aplicacion.dao.interfaces;

import ar.gov.sedronar.aplicacion.model.HojaMensualTramites;

/**
 * Created by TMR on 19/09/2018.
 */
public interface HojaMensualTramitesDAO extends AbstractDAO<HojaMensualTramites> {
    HojaMensualTramites findById(Long idHoja, Integer idTramite);
}
