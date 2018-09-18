package ar.gov.sedronar.aplicacion.dao.hibernate;

import ar.gov.sedronar.aplicacion.dao.interfaces.TramiteDAO;
import ar.gov.sedronar.aplicacion.model.Tramite;

import javax.ejb.Stateless;

/**
 * Created by TMR on 18/09/2018.
 */
@Stateless
@HibernateDAO
public class TramiteDAOImpl extends AbstractDAOImpl<Tramite> implements TramiteDAO {
}
