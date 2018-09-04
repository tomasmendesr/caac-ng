package ar.gov.sedronar.dao.hibernate;

import java.util.List;

import javax.ejb.Stateless;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import ar.gov.sedronar.dao.hibernate.AbstractDAOImpl;
import ar.gov.sedronar.dao.hibernate.HibernateDAO;
import ar.gov.sedronar.dao.interfaces.RequisitoDAO;
import ar.gov.sedronar.models.Requisito;

@Stateless
@HibernateDAO
public class RequisitoDAOImpl extends AbstractDAOImpl<Requisito> implements RequisitoDAO {

	public Requisito findByCasaId(Integer id) {
		Criteria c = entityManager.unwrap(Session.class).createCriteria(Requisito.class);
		c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		c.add(Restrictions.eq("casa.id", id));
		return (Requisito) c.uniqueResult();
	}

}