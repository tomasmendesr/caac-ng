package ar.gov.sedronar.aplicacion.dao.hibernate;

import ar.gov.sedronar.aplicacion.dao.interfaces.RecursoDAO;
import ar.gov.sedronar.aplicacion.model.Recurso;

import javax.ejb.Stateless;

/**
 * Created by TMR on 26/09/2018.
 */
@Stateless
@HibernateDAO
public class RecursoDAOImpl extends AbstractDAOImpl<Recurso> implements RecursoDAO {
}
