package ar.gov.sedronar.aplicacion.services.implementation;

import ar.gov.sedronar.aplicacion.dao.hibernate.HibernateDAO;
import ar.gov.sedronar.aplicacion.dao.interfaces.RequisitoDAO;
import ar.gov.sedronar.aplicacion.dto.RequisitoDTO;
import ar.gov.sedronar.aplicacion.filters.AdministrativoFilter;
import ar.gov.sedronar.aplicacion.filters.AdministrativoTableFilter;
import ar.gov.sedronar.aplicacion.model.Requisito;
import ar.gov.sedronar.aplicacion.services.interfaces.RequisitoService;
import ar.gov.sedronar.aplicacion.util.QueryUtil;
import ar.gov.sedronar.aplicacion.util.RequisitoToFrontentUtil;
import ar.gov.sedronar.util.app.AppResponse;
import ar.gov.sedronar.util.dataTable.DataTableObjectResponse;
import ar.gov.sedronar.util.dozer.DozerHelper;
import org.bouncycastle.cert.ocsp.Req;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
@Transactional
@DefaultServiceImpl
public class RequisitoServiceImpl implements RequisitoService {

    @Inject @HibernateDAO
    private RequisitoDAO requisitoDAO;


    @Override
    public AppResponse saveOrUpdate(RequisitoDTO requisitoDTO) throws Exception {
        requisitoDAO.saveOrUpdate(DozerHelper.map(requisitoDTO, Requisito.class));

        return new AppResponse();
    }

    @Override
    public List<RequisitoDTO> findAll() throws Exception {
        return DozerHelper.mapList(requisitoDAO.findAll(Requisito.class), RequisitoDTO.class);
    }

    @Override
    public DataTableObjectResponse findAllDataTable(AdministrativoTableFilter administrativoFilter) throws Exception {
        Integer count = requisitoDAO.count(administrativoFilter.getFilter());

        return new DataTableObjectResponse(
                new RequisitoToFrontentUtil().mapToFrontentd(DozerHelper.mapList(requisitoDAO.findAllForTable(
                            administrativoFilter.getStart(),
                            administrativoFilter.getLength(),
                            QueryUtil.getColumnOrders(administrativoFilter),
                            administrativoFilter.getFilter()), RequisitoDTO.class)),
                            administrativoFilter.getDraw(),
                        count,
                        count
        );
    }
}
