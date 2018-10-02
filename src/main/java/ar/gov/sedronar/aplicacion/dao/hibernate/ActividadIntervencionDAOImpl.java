package ar.gov.sedronar.aplicacion.dao.hibernate;

import ar.gov.sedronar.aplicacion.dao.interfaces.ActividadIntervencionDAO;
import ar.gov.sedronar.aplicacion.model.ActividadIntervencion;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;

import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by TMR on 02/10/2018.
 */
@Stateless
@HibernateDAO
public class ActividadIntervencionDAOImpl extends AbstractDAOImpl<ActividadIntervencion> implements ActividadIntervencionDAO {
    @Override
    public List<ActividadIntervencion> findByTipo(String tipo) {
        Criteria criteria = entityManager.unwrap(Session.class).createCriteria(ActividadIntervencion.class);
        criteria.add(Restrictions.eq("tipoActividad", tipo));
        criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        return criteria.list();
    }
}
