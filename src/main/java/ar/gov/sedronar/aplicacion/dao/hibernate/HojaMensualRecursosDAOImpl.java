package ar.gov.sedronar.aplicacion.dao.hibernate;

import ar.gov.sedronar.aplicacion.dao.interfaces.HojaMensualRecursosDAO;
import ar.gov.sedronar.aplicacion.model.HojaMensualRecursos;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.ejb.Stateless;

/**
 * Created by TMR on 26/09/2018.
 */
@Stateless
@HibernateDAO
public class HojaMensualRecursosDAOImpl extends AbstractDAOImpl<HojaMensualRecursos> implements HojaMensualRecursosDAO {
    @Override
    public HojaMensualRecursos findById(Long idHoja, Integer idRecurso) {
        Criteria criteria = entityManager.unwrap(Session.class).createCriteria(HojaMensualRecursos.class,"hojaMensualRecursos");
        criteria.add(Restrictions.eq("hojaMensualRecursos.id.idHoja", idHoja));
        criteria.add(Restrictions.eq("hojaMensualRecursos.id.idRecursos", idRecurso));
        return (HojaMensualRecursos) criteria.uniqueResult();
    }
}
