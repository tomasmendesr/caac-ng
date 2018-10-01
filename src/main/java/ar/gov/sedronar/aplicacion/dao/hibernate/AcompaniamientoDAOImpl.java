package ar.gov.sedronar.aplicacion.dao.hibernate;

import ar.gov.sedronar.aplicacion.dao.interfaces.AcompaniamientoDAO;
import ar.gov.sedronar.aplicacion.model.Acompaniamiento;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;

import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by TMR on 21/09/2018.
 */
@Stateless
@HibernateDAO
public class AcompaniamientoDAOImpl extends AbstractDAOImpl<Acompaniamiento> implements AcompaniamientoDAO {

    public List<Acompaniamiento> findByEstablecimiento(String establecimiento){
        Criteria criteria = entityManager.unwrap(Session.class).createCriteria(Acompaniamiento.class);
        criteria.add(Restrictions.eq("establecimiento", establecimiento));
        criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        return criteria.list();
    }

    @Override
    public List<Acompaniamiento> findByEstablecimientoAndTipo(String establecimiento, String tipo) {
        Criteria criteria = entityManager.unwrap(Session.class).createCriteria(Acompaniamiento.class);
        criteria.add(Restrictions.eq("establecimiento", establecimiento));
        criteria.add(Restrictions.eq("tipo", tipo));
        criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        return criteria.list();    }
}
