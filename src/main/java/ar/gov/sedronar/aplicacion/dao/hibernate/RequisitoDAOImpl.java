package ar.gov.sedronar.aplicacion.dao.hibernate;


import javax.ejb.Stateless;

import ar.gov.sedronar.aplicacion.dao.interfaces.RequisitoDAO;
import ar.gov.sedronar.aplicacion.model.Requisito;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


@Stateless
@HibernateDAO
public class RequisitoDAOImpl extends AbstractDAOImpl<Requisito> implements RequisitoDAO {


}