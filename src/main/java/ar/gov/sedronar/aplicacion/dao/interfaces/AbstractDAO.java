package ar.gov.sedronar.aplicacion.dao.interfaces;

import org.hibernate.Criteria;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface AbstractDAO<T> {
	T findById(Class<T> typeParameterClass, Number id);
	
	List<T> findAll(Class<T> typeParameterClass);
	
	void save(T entity);
	
	T merge(T entity);
	
	void delete(T entity);
	
	void deleteAll(Set<T> entities);

	List<T> executeCriteria(Criteria criteria, Integer offset, Integer limit, Map<String, Boolean> sortOrders, Map<String,String> aliases);

}
