package ar.gov.sedronar.aplicacion.dao.hibernate;

import ar.gov.sedronar.aplicacion.dao.interfaces.AlimentacionDAO;
import ar.gov.sedronar.aplicacion.model.Alimentacion;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by TMR on 18/09/2018.
 */
@HibernateDAO
@Stateless
public class AlimentacionDAOImpl extends AbstractDAOImpl<Alimentacion> implements AlimentacionDAO {
    @Override
    public List<Alimentacion> findByClasificacion(String clasificacion) {
        Criteria criteria = entityManager.unwrap(Session.class).createCriteria(Alimentacion.class);
        criteria.add(Restrictions.eq("clasificacion", clasificacion));
        return criteria.list();
    }
}
