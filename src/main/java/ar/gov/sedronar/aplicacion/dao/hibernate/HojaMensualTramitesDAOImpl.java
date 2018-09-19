package ar.gov.sedronar.aplicacion.dao.hibernate;

import ar.gov.sedronar.aplicacion.dao.interfaces.HojaMensualTramitesDAO;
import ar.gov.sedronar.aplicacion.model.HojaMensualTramites;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.ejb.Stateless;

/**
 * Created by TMR on 19/09/2018.
 */
@Stateless
@HibernateDAO
public class HojaMensualTramitesDAOImpl extends AbstractDAOImpl<HojaMensualTramites>  implements HojaMensualTramitesDAO {

    @Override
    public HojaMensualTramites findById(Long idHoja, Integer idTramite) {
        Criteria criteria = entityManager.unwrap(Session.class).createCriteria(HojaMensualTramites.class, "hojaMensualTramite");
        criteria.add(Restrictions.eq("hojaMensualTramite.id.idHoja", idHoja));
        criteria.add(Restrictions.eq("hojaMensualTramite.id.idTramite", idTramite));
        return (HojaMensualTramites) criteria.uniqueResult();
    }
}
