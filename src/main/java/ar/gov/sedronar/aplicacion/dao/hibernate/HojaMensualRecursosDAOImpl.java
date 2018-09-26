package ar.gov.sedronar.aplicacion.dao.hibernate;

import ar.gov.sedronar.aplicacion.dao.interfaces.HojaMensualRecursosDAO;
import ar.gov.sedronar.aplicacion.model.HojaMensualRecursos;

import javax.ejb.Stateless;

/**
 * Created by TMR on 26/09/2018.
 */
@Stateless
@HibernateDAO
public class HojaMensualRecursosDAOImpl extends AbstractDAOImpl<HojaMensualRecursos> implements HojaMensualRecursosDAO {
}
