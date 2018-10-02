package ar.gov.sedronar.aplicacion.services.implementation;

import ar.gov.sedronar.aplicacion.dao.hibernate.HibernateDAO;
import ar.gov.sedronar.aplicacion.dao.interfaces.VencimientoDAO;
import ar.gov.sedronar.aplicacion.dto.VencimientoDTO;
import ar.gov.sedronar.aplicacion.filters.VencimientoTableFilter;
import ar.gov.sedronar.aplicacion.services.interfaces.VencimientoService;
import ar.gov.sedronar.aplicacion.util.QueryUtil;
import ar.gov.sedronar.util.dataTable.DataTableObjectResponse;
import ar.gov.sedronar.util.dozer.DozerHelper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Stateless
@Transactional
@DefaultServiceImpl
public class VencimientoServiceImpl implements VencimientoService {

    @Inject @HibernateDAO
    private VencimientoDAO vencimientoDAO;

    @Override
    public DataTableObjectResponse findAllForVencimientos(VencimientoTableFilter vencimientoTableFilter) throws Exception {
        Integer count = vencimientoDAO.count(vencimientoTableFilter.getFilter());

        return new DataTableObjectResponse(
                DozerHelper.mapList(vencimientoDAO.findAllForTable(
                        vencimientoTableFilter.getStart(),
                        vencimientoTableFilter.getLength(),
                        QueryUtil.getColumnOrders(vencimientoTableFilter),
                        vencimientoTableFilter.getFilter()), VencimientoDTO.class),
                vencimientoTableFilter.getDraw(),
                count,
                count
        );
    }

}
