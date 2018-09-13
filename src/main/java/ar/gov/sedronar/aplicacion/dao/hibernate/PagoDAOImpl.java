package ar.gov.sedronar.aplicacion.dao.hibernate;


import ar.gov.sedronar.aplicacion.dao.interfaces.PagoDAO;
import ar.gov.sedronar.aplicacion.model.Pago;

import javax.ejb.Stateless;

@Stateless
@HibernateDAO
public class PagoDAOImpl extends AbstractDAOImpl<Pago> implements PagoDAO {
/*
	public Pago findByCasaId(Integer id) {
		Criteria c = entityManager.unwrap(Session.class).createCriteria(Pago.class);
		c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		c.add(Restrictions.eq("casa.id", id));
		return (Pago) c.uniqueResult();
	}

	public List<Pago> findAllUnique(int offset, int limit, Map<String, Boolean> sortOrders) {
		return entityManager.unwrap(Session.class).createSQLQuery("SELECT * FROM CAAC.pagos A WHERE A.id IN (select TOP 1 p.id from"
				+ " caac.pagos p WHERE p.caac=A.caac GROUP BY p.id, p.caac ORDER BY MAX(p.fech_resep) DESC)").addEntity(Pago.class).list();
	}

	@Override
	public List<Pago> findAllByCasaId(Integer id) {
		Criteria c = entityManager.unwrap(Session.class).createCriteria(Pago.class);
		c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		c.add(Restrictions.eq("casa.id", id));
		c.addOrder(Order.desc("fechaudi"));
		return c.list();
	}

	@Override
	public List<Pago> findAllForGeneral(int offset, int limit, Map<String, Boolean> sortOrders, Integer id) {
		Criteria criteria = entityManager.unwrap(Session.class).createCriteria(Pago.class);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.add(Restrictions.eq("casa.id", id));
		criteria.setFirstResult(offset);
		criteria.createCriteria("casa").addOrder(Order.asc("nomcaac"));
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
	public Integer count(Integer id) {
		Criteria criteria = getEntityManager().unwrap(Session.class).createCriteria(Pago.class);
		criteria.add(Restrictions.eq("casa.id", id));
		return Math.toIntExact((long) criteria.setProjection(Projections.rowCount()).uniqueResult());
	}

	@Override
	public Integer countCantAsistidos(Integer id) {
		System.out.println(id);
		Criteria criteria = entityManager.unwrap(Session.class).createCriteria(Pago.class);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.createCriteria("casa").add(Restrictions.eq("id", id));
		criteria.addOrder(Order.desc("fechResep"));
		criteria.setMaxResults(1);
		Pago result=(Pago)criteria.uniqueResult();
		if(result==null)
			return 0;
		return result.getAsistidos()!=null?result.getAsistidos():0;
	}

	@Override
	public Double countMontoAPagar(Integer id) {
		Criteria criteria = entityManager.unwrap(Session.class).createCriteria(Pago.class);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.createCriteria("casa").add(Restrictions.eq("id", id));
		criteria.addOrder(Order.desc("fechResep"));
		criteria.setMaxResults(1);
		Pago result=(Pago)criteria.uniqueResult();
		if(result==null)
			return 0D;
		return result.getMonto()!=null?result.getMonto():0;
	}
*/

}