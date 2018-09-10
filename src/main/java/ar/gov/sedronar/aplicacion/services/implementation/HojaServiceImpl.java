package ar.gov.sedronar.aplicacion.services.implementation;

import ar.gov.sedronar.aplicacion.dao.hibernate.HibernateDAO;
import ar.gov.sedronar.aplicacion.dao.interfaces.HojaDAO;
import ar.gov.sedronar.aplicacion.dto.HojaDTO;
import ar.gov.sedronar.aplicacion.dto.UsuarioDTO;
import ar.gov.sedronar.aplicacion.filters.AbstractTableFilter;
import ar.gov.sedronar.aplicacion.filters.ConsultaFilter;
import ar.gov.sedronar.aplicacion.filters.ConsultaTableFilter;
import ar.gov.sedronar.aplicacion.services.interfaces.HojaService;
import ar.gov.sedronar.util.dataTable.Column;
import ar.gov.sedronar.util.dataTable.ColumnOrder;
import ar.gov.sedronar.util.dataTable.DataTableObjectResponse;
import ar.gov.sedronar.util.dozer.DozerHelper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by TMR on 10/09/2018.
 */
@Transactional
@Stateless
@DefaultServiceImpl
public class HojaServiceImpl implements HojaService {

    @Inject @HibernateDAO
    private HojaDAO hojaDAO;

    @Override
    public DataTableObjectResponse getHojasForTable(ConsultaTableFilter filtro) {
        Map<String, Boolean> sortOrder = new HashMap<>();
        for (ColumnOrder order : filtro.getOrder()) {
            Column column = filtro.getColumns().get(order.getColumn());
            sortOrder.put(column.getData(), order.getDir().equals("asc"));
        }
        Collection<HojaDTO> items = DozerHelper.mapList(hojaDAO.findAll(filtro.getStart(), filtro.getLength(), sortOrder,filtro.getFilter()), HojaDTO.class);
        Integer count = hojaDAO.count( filtro.getFilter());
        return new DataTableObjectResponse(items,filtro.getDraw(),count, count);
    }
}
