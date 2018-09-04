package ar.gov.sedronar.dao.hibernate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.Query;

import org.apache.commons.collections.map.HashedMap;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.hibernate.engine.spi.TypedValue;

import ar.gov.sedronar.dao.hibernate.AbstractDAOImpl;
import ar.gov.sedronar.dao.hibernate.HibernateDAO;
import ar.gov.sedronar.dao.interfaces.AuditoriaDAO;
import ar.gov.sedronar.models.Auditoria;
import ar.gov.sedronar.models.Casa;
import ar.gov.sedronar.models.Pago;
import ar.gov.sedronar.utils.Limit;

@Stateless
@HibernateDAO
public class AuditoriaDAOImpl extends AbstractDAOImpl<Auditoria> implements AuditoriaDAO {


	public List<Auditoria> findAllUnique(int offset, int limit, Map<String, Boolean> sortOrders,Class<Auditoria> typeParameterClass) {

		//		List<Auditoria> auditorias=new ArrayList<>();
		//		
		//		Criteria criteria= entityManager.unwrap(Session.class).createCriteria(Casa.class);
		//		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		//		
		//		List<Casa> casas = (List<Casa>)criteria.list();
		//		
		//		for(Casa casa : casas){
		//			Criteria criteria2=entityManager.unwrap(Session.class).createCriteria(Auditoria.class);
		//			criteria2.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		//			criteria2.add(Restrictions.eq("casa.id", casa.getId()));
		//			criteria2.addOrder(Order.desc("fechaudi"));
		//			criteria2.setMaxResults(1);
		//			auditorias.add((Auditoria)criteria2.uniqueResult());
		//		}




		/*
		Criteria criteria = entityManager.unwrap(Session.class).createCriteria(typeParameterClass);

		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

		HashMap<Integer,List<Auditoria>> auditorias=new LinkedHashMap<>();

		criteria.list().forEach(a->{
			List<Auditoria> aux=auditorias.get(((Auditoria) a).getCasa().getId());
			if(aux==null)
				aux=new ArrayList<>();
			aux.add((Auditoria)a);
			auditorias.put(((Auditoria) a).getCasa().getId(), aux);
		});
		List<Auditoria> aux=new ArrayList<>();
		for(Integer key:auditorias.keySet()){
			Auditoria max=auditorias.get(key).get(0);
			for(Auditoria auditoria:auditorias.get(key)){				
				if(auditoria.getFechaudi().after(max.getFechaudi()))
					max=auditoria;
			};
			aux.add(max);
		};

		return aux;
		 */
		//return auditorias;

		return entityManager.unwrap(Session.class).createSQLQuery("SELECT * FROM CAAC.auditorias A WHERE A.id_audi IN (select TOP 1 ID_AUDI from caac.auditorias WHERE ID=A.id GROUP BY ID_AUDI, id ORDER BY MAX(FECHAUDI) DESC)").addEntity(Auditoria.class).list();

	}

	@Override
	public List<Auditoria> findAllByCasaId(Integer id, Class<Auditoria> class1) {
		Criteria c = entityManager.unwrap(Session.class).createCriteria(Auditoria.class);
		c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		c.add(Restrictions.eq("casa.id", id));
		//Tarda mucho si esto lo hace la base
		//c.addOrder(Order.desc("fechaudi"));
		return c.list();
	}


}