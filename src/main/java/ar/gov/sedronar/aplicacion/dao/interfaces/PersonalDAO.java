package ar.gov.sedronar.aplicacion.dao.interfaces;

import ar.gov.sedronar.aplicacion.model.Personal;

/**
 * Created by TMR on 03/10/2018.
 */
public interface PersonalDAO extends AbstractDAO<Personal> {

    Personal findByDocumento(Short idTipoDoc, Integer nroDocumento);
}
