package ar.gov.sedronar.aplicacion.dao.interfaces;

import ar.gov.sedronar.aplicacion.model.HojaMensualActividades;

/**
 * Created by TMR on 02/10/2018.
 */
public interface HojaMensualActividadesDAO extends AbstractDAO<HojaMensualActividades> {

    HojaMensualActividades findById(Long idHoja, Integer idActividadIntervencion);
}
