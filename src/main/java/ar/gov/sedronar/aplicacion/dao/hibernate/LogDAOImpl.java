package ar.gov.sedronar.aplicacion.dao.hibernate;


import ar.gov.sedronar.aplicacion.dao.interfaces.LogDAO;
import ar.gov.sedronar.aplicacion.model.Log;

import javax.ejb.Stateless;

@Stateless
@HibernateDAO
public class LogDAOImpl extends AbstractDAOImpl<Log> implements LogDAO {

}