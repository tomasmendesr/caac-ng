package ar.gov.sedronar.aplicacion.dao.hibernate;

import ar.gov.sedronar.aplicacion.dao.interfaces.HojaMensualAcompaniamientoDAO;
import ar.gov.sedronar.aplicacion.model.HojaMensualAcompaniamiento;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.ejb.Stateless;

/**
 * Created by TMR on 21/09/2018.
 */
@Stateless
@HibernateDAO
public class HojaMensualAcompaniamientoDAOImpl extends AbstractDAOImpl<HojaMensualAcompaniamiento> implements HojaMensualAcompaniamientoDAO {
    @Override
    public HojaMensualAcompaniamiento findById(Long idHoja, Integer idAcompaniamiento) {
        Criteria criteria = entityManager.unwrap(Session.class).createCriteria(HojaMensualAcompaniamiento.class, "hojaMensualAcompaniamiento");
        criteria.add(Restrictions.eq("hojaMensualAcompaniamiento.id.idHoja", idHoja));
        criteria.add(Restrictions.eq("hojaMensualAcompaniamiento.id.idAcompaniamiento", idAcompaniamiento));
        return (HojaMensualAcompaniamiento) criteria.uniqueResult();
    }
}
