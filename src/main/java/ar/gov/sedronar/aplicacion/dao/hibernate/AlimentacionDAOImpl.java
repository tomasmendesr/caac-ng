package ar.gov.sedronar.aplicacion.dao.hibernate;

import ar.gov.sedronar.aplicacion.dao.interfaces.AlimentacionDAO;
import ar.gov.sedronar.aplicacion.model.Alimentacion;

import javax.ejb.Stateless;

/**
 * Created by TMR on 18/09/2018.
 */
@HibernateDAO
@Stateless
public class AlimentacionDAOImpl extends AbstractDAOImpl<Alimentacion> implements AlimentacionDAO {
}
