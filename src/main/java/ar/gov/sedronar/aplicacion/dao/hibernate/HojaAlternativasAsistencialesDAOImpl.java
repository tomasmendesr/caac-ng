package ar.gov.sedronar.aplicacion.dao.hibernate;

import ar.gov.sedronar.aplicacion.dao.interfaces.HojaAlternativasAsistencialesDAO;
import ar.gov.sedronar.aplicacion.model.HojaAlternativasAsistenciales;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.ejb.Stateless;

/**
 * Created by TMR on 04/10/2018.
 */
@Stateless
@HibernateDAO
public class HojaAlternativasAsistencialesDAOImpl extends AbstractDAOImpl<HojaAlternativasAsistenciales> implements HojaAlternativasAsistencialesDAO {

    private Criteria getCriteria(){
        return entityManager.unwrap(Session.class).createCriteria(HojaAlternativasAsistenciales.class,"hoja");
    }

    @Override
    public HojaAlternativasAsistenciales findByIdHojaAndIdAlternativaAsistencial(Long idHoja, Integer idAlt) {
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.eq("hoja.id.idHoja", idHoja));
        criteria.add(Restrictions.eq("hoja.id.idAlternativaAsistencial", idAlt));
        return (HojaAlternativasAsistenciales) criteria.uniqueResult();
    }
}
