package ar.gov.sedronar.aplicacion.dao.hibernate;

import ar.gov.sedronar.aplicacion.dao.interfaces.VencimientoDAO;
import ar.gov.sedronar.aplicacion.filters.VencimientoFilter;
import ar.gov.sedronar.aplicacion.model.Requisito;
import ar.gov.sedronar.aplicacion.model.Vencimiento;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

import javax.ejb.Stateless;
import java.util.List;
import java.util.Map;

@Stateless
@HibernateDAO
public class VencimientoDAOImpl extends AbstractDAOImpl<Vencimiento> implements VencimientoDAO {

    @Override
    public Integer count(VencimientoFilter filter) {
        Criteria criteria = entityManager.unwrap(Session.class).createCriteria(Requisito.class);
        criteria.setProjection(Projections.rowCount());
        return Math.toIntExact((Long) criteria.uniqueResult());
    }

    @Override
    public List<Vencimiento> findAllForTable(Integer start, Integer length, Map<String, Boolean> columnOrders, VencimientoFilter filter) {
        Criteria criteria = entityManager.unwrap(Session.class).createCriteria(Vencimiento.class);

        return super.executeCriteria(criteria, start, length, columnOrders, null);
    }
}

