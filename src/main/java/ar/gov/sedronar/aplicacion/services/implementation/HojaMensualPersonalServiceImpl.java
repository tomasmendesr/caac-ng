package ar.gov.sedronar.aplicacion.services.implementation;

import ar.gov.sedronar.aplicacion.dao.hibernate.HibernateDAO;
import ar.gov.sedronar.aplicacion.dao.interfaces.HojaMensualPersonalDAO;
import ar.gov.sedronar.aplicacion.dto.HojaDTO;
import ar.gov.sedronar.aplicacion.dto.HojaMensualPersonalDTO;
import ar.gov.sedronar.aplicacion.filters.AbstractTableFilter;
import ar.gov.sedronar.aplicacion.services.interfaces.HojaMensualPersonalService;
import ar.gov.sedronar.util.dataTable.Column;
import ar.gov.sedronar.util.dataTable.ColumnOrder;
import ar.gov.sedronar.util.dataTable.DataTableObjectResponse;
import ar.gov.sedronar.util.dozer.DozerHelper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by TMR on 02/10/2018.
 */
@Stateless
@DefaultServiceImpl
@Transactional
public class HojaMensualPersonalServiceImpl implements HojaMensualPersonalService{
    @Inject
    @HibernateDAO
    private HojaMensualPersonalDAO hojaMensualPersonalDAO;

    @Override
    public DataTableObjectResponse getDataForTable(AbstractTableFilter filtro) {
        if(filtro.getFilter().getValue() == null) return new DataTableObjectResponse(new ArrayList<>(),filtro.getDraw(),0, 0);

        Map<String, Boolean> sortOrder = new HashMap<>();
        for (ColumnOrder order : filtro.getOrder()) {
            Column column = filtro.getColumns().get(order.getColumn());
            sortOrder.put(column.getData(), order.getDir().equals("asc"));
        }
        Collection<HojaMensualPersonalDTO> items = DozerHelper.mapList(hojaMensualPersonalDAO.findAll(filtro.getStart(), filtro.getLength(), sortOrder,filtro.getFilter()), HojaMensualPersonalDTO.class);
        Integer count = hojaMensualPersonalDAO.count( filtro.getFilter());
        return new DataTableObjectResponse(items,filtro.getDraw(),count, count);
    }
}
