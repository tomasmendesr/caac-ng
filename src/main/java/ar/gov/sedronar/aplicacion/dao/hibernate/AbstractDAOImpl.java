package ar.gov.sedronar.aplicacion.dao.hibernate;

import org.hibernate.Criteria;
import org.hibernate.NullPrecedence;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.sql.JoinType;

import ar.gov.sedronar.aplicacion.dao.interfaces.AbstractDAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class AbstractDAOImpl<T> implements AbstractDAO<T>{
	@PersistenceContext(type=PersistenceContextType.TRANSACTION, unitName="pu")
	protected EntityManager entityManager;

	@Override
	public T findById(Class<T> typeParameterClass, Integer id){
		T instance = entityManager.find(typeParameterClass, id);
		return instance;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(Class<T> typeParameterClass){
		Criteria c = entityManager.unwrap(Session.class).createCriteria(typeParameterClass);
		c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return c.list();
	}


	@Override
	public void save(T entity) {
		entityManager.persist(entity);
	}

	public T merge(T entity) {
		return entityManager.merge(entity);
	}

	@Override
	public void delete(T entity) {
		entityManager.remove(entity);
	}


	@Override
	public void deleteAll(Set<T> entities) {
		entities.forEach(entity -> {
			entityManager.remove(entity);
		});
	}

	@Override
    public List<T> executeCriteria(Criteria criteria, Integer offset, Integer limit, Map<String, Boolean> sortOrders, Map<String,String> aliases){
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		if(offset != null && limit != null && offset != -1 && limit != -1) {
			if (criteria.list().size() > limit) {
				criteria.setFirstResult(offset);
			}
			criteria.setMaxResults(limit);
		}
		if(sortOrders != null && !sortOrders.isEmpty()) {
			sortOrders.entrySet().stream().forEach((order) -> {
				String property = order.getKey();
				if(property.contains(".")){
					String beforePoint = property.substring(0,property.indexOf("."));
					String afterPoint = property.substring(property.indexOf("."));
					if(aliases != null && !aliases.isEmpty() && aliases.get(beforePoint) != null){
						property = aliases.get(beforePoint) + afterPoint; // el get me devuelve el alias ya existente
					}else{
						String alias = beforePoint + "Alias";
						criteria.createAlias(beforePoint, alias, JoinType.LEFT_OUTER_JOIN);
						property = alias + afterPoint;
					}
				}
				if((order.getValue()).booleanValue()) {
					criteria.addOrder(Order.asc(property).nulls(NullPrecedence.FIRST));
				} else {
					criteria.addOrder(Order.desc(property).nulls(NullPrecedence.LAST));
				}
			});
		}
		return criteria.list();
	}
}
