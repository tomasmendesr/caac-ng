package ar.gov.sedronar.dao.hibernate;

import javax.ejb.Stateless;
import ar.gov.sedronar.dao.hibernate.AbstractDAOImpl;
import ar.gov.sedronar.dao.hibernate.HibernateDAO;
import ar.gov.sedronar.dao.interfaces.LogDAO;
import ar.gov.sedronar.models.Log;

@Stateless
@HibernateDAO
public class LogDAOImpl extends AbstractDAOImpl<Log> implements LogDAO {

}