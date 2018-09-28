package ar.gov.sedronar.aplicacion.dao.hibernate;


import ar.gov.sedronar.aplicacion.dao.interfaces.RequisitoDAO;
import ar.gov.sedronar.aplicacion.filters.AdministrativoFilter;
import ar.gov.sedronar.aplicacion.filters.GeneralFilter;
import ar.gov.sedronar.aplicacion.model.Casa;
import ar.gov.sedronar.aplicacion.model.Requisito;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

import javax.ejb.Stateless;
import java.util.List;
import java.util.Map;


@Stateless
@HibernateDAO
public class RequisitoDAOImpl extends AbstractDAOImpl<Requisito> implements RequisitoDAO {


    @Override
    public void saveOrUpdate(Requisito requisito) {
        merge(requisito);
    }

    @Override
    public List<Requisito> findAllForTable(Integer start, Integer length, Map<String, Boolean> sortOrder, Object filter) {
        Criteria criteria = entityManager.unwrap(Session.class).createCriteria(Requisito.class);

        return super.executeCriteria(criteria, start, length, sortOrder, null);
    }

    @Override
    public Integer count(AdministrativoFilter filter) {
        Criteria criteria = entityManager.unwrap(Session.class).createCriteria(Requisito.class);
        criteria.setProjection(Projections.rowCount());
        return Math.toIntExact((Long) criteria.uniqueResult());
    }

}