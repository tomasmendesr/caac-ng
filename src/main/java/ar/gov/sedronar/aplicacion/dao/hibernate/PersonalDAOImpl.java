package ar.gov.sedronar.aplicacion.dao.hibernate;

import ar.gov.sedronar.aplicacion.dao.interfaces.PersonalDAO;
import ar.gov.sedronar.aplicacion.model.Personal;
import ar.gov.sedronar.modulo.commonsModels.dto.TipoDocumentoDTO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.ejb.Stateless;

/**
 * Created by TMR on 03/10/2018.
 */
@Stateless
@HibernateDAO
public class PersonalDAOImpl extends AbstractDAOImpl<Personal> implements PersonalDAO {


    @Override
    public Personal findByDocumento(Short idtipoDoc, Integer nroDocumento) {
        Criteria criteria = entityManager.unwrap(Session.class).createCriteria(Personal.class);
        criteria.add(Restrictions.eq("tipoDocumento.id",idtipoDoc));
        criteria.add(Restrictions.eq("numeroDocumento",nroDocumento));
        return (Personal) criteria.uniqueResult();
    }
}
