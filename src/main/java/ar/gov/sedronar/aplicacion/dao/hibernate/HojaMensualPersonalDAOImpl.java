package ar.gov.sedronar.aplicacion.dao.hibernate;

import ar.gov.sedronar.aplicacion.dao.interfaces.HojaMensualPersonalDAO;
import ar.gov.sedronar.aplicacion.definition.TipoHoja;
import ar.gov.sedronar.aplicacion.filters.AbstractFilter;
import ar.gov.sedronar.aplicacion.filters.ConsultaFilter;
import ar.gov.sedronar.aplicacion.model.Hoja;
import ar.gov.sedronar.aplicacion.model.HojaMensualPersonal;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import javax.ejb.Stateless;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by TMR on 02/10/2018.
 */
@Stateless
@HibernateDAO
public class HojaMensualPersonalDAOImpl extends AbstractDAOImpl<HojaMensualPersonal> implements HojaMensualPersonalDAO {

    private Criteria getCriteria(){
        return entityManager.unwrap(Session.class).createCriteria(HojaMensualPersonal.class, "hojaMensual");
    }

    @Override
    public Integer count(AbstractFilter filter) {
        Criteria criteria = this.applyFilters(filter,null);
        criteria.setProjection(Projections.rowCount());
        return Math.toIntExact((Long) criteria.uniqueResult());
    }

    @Override
    public List<HojaMensualPersonal> findAll(Integer start, Integer length, Map<String, Boolean> sortOrder, AbstractFilter filter) {
        Map<String,String> aliases = new HashMap<>();
        Criteria criteria = applyFilters(filter, aliases);
        return super.executeCriteria(criteria, start, length, sortOrder, aliases);
    }

    @Override
    public HojaMensualPersonal findById(Long idHoja, Integer idPersonal) {
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.eq("hojaMensual.id.idHoja", idHoja));
        criteria.add(Restrictions.eq("hojaMensual.id.idEmpleado", idPersonal));
        return (HojaMensualPersonal) criteria.uniqueResult();
    }

    private Criteria applyFilters(AbstractFilter filter, Map<String,String> aliases){
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.eq("hojaMensual.id.idHoja", Long.parseLong(filter.getValue())));
        return criteria;
    }
}
