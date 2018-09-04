package ar.gov.sedronar.dao.hibernate;

import javax.ejb.Stateless;
import ar.gov.sedronar.dao.hibernate.AbstractDAOImpl;
import ar.gov.sedronar.dao.hibernate.HibernateDAO;
import ar.gov.sedronar.dao.interfaces.MesDAO;
import ar.gov.sedronar.models.Mes;

@Stateless
@HibernateDAO
public class MesDAOImpl extends AbstractDAOImpl<Mes> implements MesDAO {

}