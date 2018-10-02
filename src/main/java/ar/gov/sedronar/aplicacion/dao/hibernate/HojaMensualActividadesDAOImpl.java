package ar.gov.sedronar.aplicacion.dao.hibernate;

import ar.gov.sedronar.aplicacion.dao.interfaces.HojaMensualActividadesDAO;
import ar.gov.sedronar.aplicacion.model.HojaMensualActividades;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.ejb.Stateless;

/**
 * Created by TMR on 02/10/2018.
 */
@Stateless
@HibernateDAO
public class HojaMensualActividadesDAOImpl extends AbstractDAOImpl<HojaMensualActividades> implements HojaMensualActividadesDAO{
    @Override
    public HojaMensualActividades findById(Long idHoja, Integer idActividadIntervencion) {
        Criteria criteria = entityManager.unwrap(Session.class).createCriteria(HojaMensualActividades.class, "hojaMensualActividades");
        criteria.add(Restrictions.eq("hojaMensualActividades.id.idHoja", idHoja));
        criteria.add(Restrictions.eq("hojaMensualActividades.id.idActividad", idActividadIntervencion));
        return (HojaMensualActividades) criteria.uniqueResult();
    }
}
