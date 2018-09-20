package ar.gov.sedronar.aplicacion.dao.hibernate;


import ar.gov.sedronar.aplicacion.dao.interfaces.CasaDAO;
import ar.gov.sedronar.aplicacion.filters.GeneralFilter;
import ar.gov.sedronar.aplicacion.model.Casa;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;

import javax.ejb.Stateless;
import java.util.List;
import java.util.Map;

@Stateless
@HibernateDAO
public class CasaDAOImpl extends AbstractDAOImpl<Casa> implements CasaDAO {


    @Override
    public Integer count(GeneralFilter filter) {
        Criteria criteria = entityManager.unwrap(Session.class).createCriteria(Casa.class);
        criteria.setProjection(Projections.rowCount());
        return Math.toIntExact((Long) criteria.uniqueResult());
    }

    @Override
    public List<Casa> findAllForAdministrativo(Integer start, Integer length, Map<String, Boolean> columnOrders, GeneralFilter filter) {
        Criteria criteria = entityManager.unwrap(Session.class).createCriteria(Casa.class);

        return super.executeCriteria(criteria, start, length, columnOrders, null);
    }

    @Override
    public List<Casa> findAllForGeneral(Integer start, Integer length, Map<String, Boolean> sortOrder, GeneralFilter filter) {
        Criteria criteria = entityManager.unwrap(Session.class).createCriteria(Casa.class);

        return super.executeCriteria(criteria, start, length, sortOrder, null);
    }
}