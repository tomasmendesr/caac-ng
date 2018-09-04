package ar.gov.sedronar.dao.hibernate;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import ar.gov.sedronar.dao.hibernate.AbstractDAOImpl;
import ar.gov.sedronar.dao.hibernate.HibernateDAO;
import ar.gov.sedronar.dao.interfaces.VencimientoDAO;
import ar.gov.sedronar.models.Vencimiento;

@Stateless
@HibernateDAO
public class VencimientoDAOImpl extends AbstractDAOImpl<Vencimiento> implements VencimientoDAO {

	public Vencimiento findByCasaId(Integer id) {
		Criteria c = entityManager.unwrap(Session.class).createCriteria(Vencimiento.class);
		c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		c.add(Restrictions.eq("casa.id", id.intValue()));
		return (Vencimiento) c.uniqueResult();
	}

	@Override
	public List<Vencimiento> findAll(int offset, int limit, Map<String, Boolean> sortOrders,Class<Vencimiento> typeParameterClass) {
		Criteria criteria = entityManager.unwrap(Session.class).createCriteria(typeParameterClass);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.setFirstResult(offset);
		criteria.setMaxResults(limit);
		sortOrders.entrySet().stream().forEach(order -> {
			if(order.getKey().compareTo("casa")==0)
				if (order.getValue()) {
					criteria.createCriteria("casa").addOrder(Order.asc("nomcaac"));
				} else {
					criteria.createCriteria("casa").addOrder(Order.desc("nomcaac"));
				}
			else
				if (order.getValue()) {
					criteria.addOrder(Order.asc(order.getKey()));
				} else {
					criteria.addOrder(Order.desc(order.getKey()));
				}
		});
		return criteria.list();
	}
}