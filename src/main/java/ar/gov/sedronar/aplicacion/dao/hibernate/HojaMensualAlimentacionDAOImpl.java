package ar.gov.sedronar.aplicacion.dao.hibernate;

import ar.gov.sedronar.aplicacion.dao.interfaces.HojaMensualAlimentacionDAO;
import ar.gov.sedronar.aplicacion.model.HojaMensualAlimentacion;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.ejb.Stateless;

/**
 * Created by TMR on 19/09/2018.
 */
@Stateless
@HibernateDAO
public class HojaMensualAlimentacionDAOImpl extends AbstractDAOImpl<HojaMensualAlimentacion> implements HojaMensualAlimentacionDAO {
    @Override
    public HojaMensualAlimentacion findById(Long idHoja, Integer idAlimentacion) {
        Criteria criteria = entityManager.unwrap(Session.class).createCriteria(HojaMensualAlimentacion.class, "hojaMensualAlimentacion");
        criteria.add(Restrictions.eq("hojaMensualAlimentacion.id.idHoja", idHoja));
        criteria.add(Restrictions.eq("hojaMensualAlimentacion.id.idTipoAlimentacion", idAlimentacion));
        return (HojaMensualAlimentacion) criteria.uniqueResult();
    }
}
