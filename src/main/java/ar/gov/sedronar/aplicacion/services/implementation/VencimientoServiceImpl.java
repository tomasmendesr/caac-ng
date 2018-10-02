package ar.gov.sedronar.aplicacion.services.implementation;

import ar.gov.sedronar.aplicacion.dao.hibernate.HibernateDAO;
import ar.gov.sedronar.aplicacion.dao.interfaces.VencimientoDAO;
import ar.gov.sedronar.aplicacion.dto.RequisitoDTO;
import ar.gov.sedronar.aplicacion.filters.VencimientoTableFilter;
import ar.gov.sedronar.aplicacion.services.interfaces.VencimientoService;
import ar.gov.sedronar.aplicacion.util.QueryUtil;
import ar.gov.sedronar.aplicacion.util.RequisitoToFrontentUtil;
import ar.gov.sedronar.util.dataTable.DataTableObjectResponse;
import ar.gov.sedronar.util.dozer.DozerHelper;

import javax.inject.Inject;

public class VencimientoServiceImpl implements VencimientoService {

    @HibernateDAO @Inject
    private VencimientoDAO vencimientoDAO;

    @Override
    public DataTableObjectResponse findAllForVencimientos(VencimientoTableFilter vencimientoTableFilter) throws Exception {
        Integer count = vencimientoDAO.count(vencimientoTableFilter.getFilter());

        return new DataTableObjectResponse(
                new RequisitoToFrontentUtil().mapToFrontentd(DozerHelper.mapList(vencimientoDAO.findAllForTable(
                        vencimientoTableFilter.getStart(),
                        vencimientoTableFilter.getLength(),
                        QueryUtil.getColumnOrders(vencimientoTableFilter),
                        vencimientoTableFilter.getFilter()), RequisitoDTO.class)),
                vencimientoTableFilter.getDraw(),
                count,
                count
        );
    }

}
