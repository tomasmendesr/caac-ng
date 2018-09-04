package ar.gov.sedronar.dao.interfaces;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import ar.gov.sedronar.models.Casa;

public interface CasaDAO extends AbstractDAO<Casa>{	
	public List<Casa> findAll(int offset, int limit, Map<String, Boolean> sortOrders) ;


	public int count();


}
