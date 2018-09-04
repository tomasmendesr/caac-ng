package ar.gov.sedronar.dao.hibernate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import ar.gov.sedronar.dao.hibernate.AbstractDAOImpl;
import ar.gov.sedronar.dao.hibernate.HibernateDAO;
import ar.gov.sedronar.dao.interfaces.CasaDAO;
import ar.gov.sedronar.models.Casa;

@Stateless
@HibernateDAO
public class CasaDAOImpl extends AbstractDAOImpl<Casa> implements CasaDAO {
	
	@Override
	public List<Casa> findAll(int offset, int limit, Map<String, Boolean> sortOrders) {
		Criteria criteria = entityManager.unwrap(Session.class).createCriteria(Casa.class);
		criteria.add(Restrictions.eq("activa", true));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.setFirstResult(offset);
		criteria.setMaxResults(limit);
		sortOrders.entrySet().stream().forEach(order -> {
			if (order.getValue()) {
				criteria.addOrder(Order.asc(order.getKey()));
			} else {
				criteria.addOrder(Order.desc(order.getKey()));
			}
		});
		return criteria.list();
	}

	@Override
	public int count() {
		Criteria criteria = entityManager.unwrap(Session.class).createCriteria(Casa.class);
		criteria.add(Restrictions.eq("activa", true));
		return Integer.decode(criteria.setProjection(Projections.rowCount()).uniqueResult().toString());        
	}

}