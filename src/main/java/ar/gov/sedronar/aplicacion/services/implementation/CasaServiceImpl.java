package ar.gov.sedronar.aplicacion.services.implementation;

import ar.gov.sedronar.aplicacion.dao.hibernate.HibernateDAO;
import ar.gov.sedronar.aplicacion.dao.interfaces.CasaDAO;
import ar.gov.sedronar.aplicacion.dto.CasaDTO;
import ar.gov.sedronar.aplicacion.dto.CasaLightDTO;
import ar.gov.sedronar.aplicacion.filters.GeneralTableFilter;
import ar.gov.sedronar.aplicacion.model.Casa;
import ar.gov.sedronar.aplicacion.services.interfaces.CasaService;
import ar.gov.sedronar.aplicacion.util.QueryUtil;
import ar.gov.sedronar.util.dataTable.DataTableObjectResponse;
import ar.gov.sedronar.util.dozer.DozerHelper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

/**
 * Created by TMR on 10/09/2018.
 */
@Transactional
@Stateless
@DefaultServiceImpl
public class CasaServiceImpl implements CasaService {

    @Inject
    @HibernateDAO
    private CasaDAO casaDAO;

    @Override
    public List<CasaDTO> findAll() {
        return DozerHelper.mapList(casaDAO.findAll(Casa.class), CasaDTO.class);
    }

    @Override
    public List<CasaLightDTO> findAllLight() {
        return DozerHelper.mapList(casaDAO.findAll(Casa.class), CasaLightDTO.class);
    }

    @Override
    public DataTableObjectResponse findAllForGeneral(GeneralTableFilter generalTableFilter) {
        Collection<CasaLightDTO> items = DozerHelper.mapList(
                casaDAO.findAllForGeneral(
                    generalTableFilter.getStart(),
                    generalTableFilter.getLength(),
                    QueryUtil.getColumnOrders(generalTableFilter),
                    generalTableFilter.getFilter()
                ),
                CasaLightDTO.class
        );
        Integer count = casaDAO.count(generalTableFilter.getFilter());
        return new DataTableObjectResponse(items, generalTableFilter.getDraw(), count , count);
    }

    @Override
    public void saveOrUpdate(CasaDTO casaDTO) throws Exception {
        if (casaDTO == null) throw new Exception("Error creando la consulta");
        Casa casa = DozerHelper.map(casaDTO, Casa.class);
        casaDAO.merge(casa);
    }
}
