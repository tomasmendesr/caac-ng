package ar.gov.sedronar.aplicacion.dao.hibernate;

import ar.gov.sedronar.aplicacion.dao.interfaces.HojaDAO;
import ar.gov.sedronar.aplicacion.definition.TipoHoja;
import ar.gov.sedronar.aplicacion.filters.ConsultaFilter;
import ar.gov.sedronar.aplicacion.model.Hoja;
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
 * Created by TMR on 10/09/2018.
 */
@Stateless
@HibernateDAO
public class HojaDAOImpl extends AbstractDAOImpl<Hoja> implements HojaDAO {

    @Override
    public Integer count(ConsultaFilter filter) {
        Criteria criteria = this.applyFilters(filter,null);
        criteria.setProjection(Projections.rowCount());
        return Math.toIntExact((Long) criteria.uniqueResult());
    }

    @Override
    public List<Hoja> findAll(Integer start, Integer length, Map<String, Boolean> sortOrder, ConsultaFilter filter) {
        Map<String,String> aliases = new HashMap<>();
        Criteria criteria = applyFilters(filter, aliases);
        if(sortOrder == null || sortOrder.isEmpty()) criteria.addOrder(Order.desc("id"));
        return super.executeCriteria(criteria, start, length, sortOrder, aliases);
    }

    public Criteria applyFilters(ConsultaFilter filter, Map<String,String> aliases){
        Criteria criteria = entityManager.unwrap(Session.class).createCriteria(Hoja.class);

        if(filter.getNombreCasa() != null && StringUtils.isNotBlank(filter.getNombreCasa())){
            criteria.createAlias("casa", "casaAlias");
            if(aliases != null) aliases.put("casa","casaAlias");
            criteria.add(Restrictions.eq("casaAlias.nomcaac", filter.getNombreCasa()));
        }
        if(filter.getAnioInicio() != null) criteria.add(Restrictions.ge("anio", filter.getAnioInicio()));
        if(filter.getMesInicioId() != null) criteria.add(Restrictions.ge("mes.id", filter.getMesInicioId()));
        if(filter.getAnioFin() != null) criteria.add(Restrictions.le("anio", filter.getAnioFin()));
        if(filter.getMesFinId() != null) criteria.add(Restrictions.le("mes.id", filter.getMesFinId()));
        if(filter.getTipoInformacionEstructural() != null && filter.getTipoInformacionMensual() != null){
            if(filter.getTipoInformacionMensual() && !filter.getTipoInformacionEstructural()){
                criteria.add(Restrictions.eq("tipoHoja", TipoHoja.MENSUAL.getValue()));
            }
            else if(filter.getTipoInformacionEstructural() && !filter.getTipoInformacionMensual()){
                criteria.add(Restrictions.eq("tipoHoja", TipoHoja.ESTRUCTURAL.getValue()));
            }
        } else if(filter.getTipoInformacionMensual() != null && filter.getTipoInformacionMensual()){
            criteria.add(Restrictions.eq("tipoHoja", TipoHoja.MENSUAL.getValue()));
        } else if(filter.getTipoInformacionEstructural() != null && filter.getTipoInformacionEstructural()){
            criteria.add(Restrictions.eq("tipoHoja", TipoHoja.ESTRUCTURAL.getValue()));
        }

        return criteria;
    }
}
