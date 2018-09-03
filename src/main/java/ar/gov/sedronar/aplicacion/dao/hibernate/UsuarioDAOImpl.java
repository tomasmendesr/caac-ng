package ar.gov.sedronar.aplicacion.dao.hibernate;



import ar.gov.sedronar.aplicacion.dao.interfaces.UsuarioDAO;
import ar.gov.sedronar.aplicacion.filters.AbstractFilter;
import ar.gov.sedronar.aplicacion.model.Usuario;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.*;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Stateless
@HibernateDAO
public class UsuarioDAOImpl extends AbstractDAOImpl<Usuario> implements UsuarioDAO {

	@Override
	public Integer count(AbstractFilter filter) {
		Criteria criteria = this.applyFilters(filter,null);
		criteria.setProjection(Projections.rowCount());
		return Math.toIntExact((Long) criteria.uniqueResult());
	}

	@Override
	public List<Usuario> findAll(Integer start, Integer length, Map<String, Boolean> sortOrder, AbstractFilter filter) {
		Map<String,String> aliases = new HashMap<>();
		Criteria criteria = applyFilters(filter, aliases);
		if(sortOrder == null || sortOrder.isEmpty()) criteria.addOrder(Order.desc("id"));
		return super.executeCriteria(criteria, start, length, sortOrder, aliases);
	}

	public Criteria applyFilters(AbstractFilter filter, Map<String,String> aliases){
		Criteria criteria = entityManager.unwrap(Session.class).createCriteria(Usuario.class);

		if(filter.getValue() != null){
			List<Criterion> criterions = new ArrayList<>();
			String value = filter.getValue();

			criterions.add(Restrictions.like("nombre",value, MatchMode.ANYWHERE));
			criterions.add(Restrictions.like("apellido",value, MatchMode.ANYWHERE));
			criterions.add(Restrictions.like("email",value, MatchMode.ANYWHERE));
			criterions.add(Restrictions.like("username",value, MatchMode.ANYWHERE));

			Criterion[] critArray = new Criterion[criterions.size()];
			critArray = criterions.toArray(critArray);
			criteria.add(Restrictions.or(critArray));
		}
		return criteria;
	}


}
