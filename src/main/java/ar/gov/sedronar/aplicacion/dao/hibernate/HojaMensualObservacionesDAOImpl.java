package ar.gov.sedronar.aplicacion.dao.hibernate;

import ar.gov.sedronar.aplicacion.dao.interfaces.HojaMensualObservacionesDAO;
import ar.gov.sedronar.aplicacion.model.HojaMensualObservaciones;

import javax.ejb.Stateless;

/**
 * Created by TMR on 19/09/2018.
 */
@Stateless
@HibernateDAO
public class HojaMensualObservacionesDAOImpl extends AbstractDAOImpl<HojaMensualObservaciones> implements HojaMensualObservacionesDAO {
}
