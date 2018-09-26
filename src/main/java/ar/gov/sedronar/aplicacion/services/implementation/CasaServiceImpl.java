package ar.gov.sedronar.aplicacion.services.implementation;

import ar.gov.sedronar.aplicacion.dao.hibernate.HibernateDAO;
import ar.gov.sedronar.aplicacion.dao.interfaces.CasaDAO;
import ar.gov.sedronar.aplicacion.dao.interfaces.CategoriaDAO;
import ar.gov.sedronar.aplicacion.dto.CasaDTO;
import ar.gov.sedronar.aplicacion.dto.CasaLightDTO;
import ar.gov.sedronar.aplicacion.dto.CategoriaDTO;
import ar.gov.sedronar.aplicacion.filters.AdministrativoTableFilter;
import ar.gov.sedronar.aplicacion.filters.GeneralTableFilter;
import ar.gov.sedronar.aplicacion.model.Casa;
import ar.gov.sedronar.aplicacion.model.Categoria;
import ar.gov.sedronar.aplicacion.services.interfaces.CasaService;
import ar.gov.sedronar.aplicacion.services.interfaces.CategoriaService;
import ar.gov.sedronar.aplicacion.util.DefaultValues;
import ar.gov.sedronar.aplicacion.util.QueryUtil;
import ar.gov.sedronar.util.dataTable.DataTableObjectResponse;
import ar.gov.sedronar.util.dozer.DozerHelper;
import jdk.internal.instrumentation.InstrumentationMethod;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Date;
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

    @Inject
    @HibernateDAO
    private CategoriaDAO categoriaDAO;

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
    public Boolean saveOrUpdate(CasaDTO casaDTO) throws Exception {
        if (casaDTO == null) throw new Exception("Error creando la consulta");
        Casa casa = DozerHelper.map(casaDTO, Casa.class);
        casaDAO.merge(casa);

        return true;
    }

    public Boolean saveGeneral(CasaDTO casaDTO) throws Exception {
        if(casaDTO.getId() == null) { //robado del viejo y querido caac
            casaDTO.setCat(DozerHelper.map(categoriaDAO.findById(1), CategoriaDTO.class)); //no se porque es categoria 1 pero en el viejo caac estaba asi
            casaDTO.setNcat(DozerHelper.map(categoriaDAO.findById(2), CategoriaDTO.class)); //idem
            casaDTO.setExpsed("");
            casaDTO.setFechacon((Date)DefaultValues.FechaEmpty.getValue());
            casaDTO.setFechaini((Date)DefaultValues.FechaEmpty.getValue());
            casaDTO.setModal("");
            casaDTO.setReq("");
            casaDTO.setObseradm("");
        }

        validarCasa(casaDTO);

        return saveOrUpdate(casaDTO);
    }

    private void validarCasa(CasaDTO casaDTO) {
        //todo implementar validacion
    }

    @Override
    public DataTableObjectResponse findAllForAdministrativo(AdministrativoTableFilter administrativoTableFilter) {
        Collection<CasaLightDTO> items = DozerHelper.mapList(
                casaDAO.findAllForAdministrativo(
                        administrativoTableFilter.getStart(),
                        administrativoTableFilter.getLength(),
                        QueryUtil.getColumnOrders(administrativoTableFilter),
                        administrativoTableFilter.getFilter()
                ),
                CasaLightDTO.class
        );
        Integer count = casaDAO.count(administrativoTableFilter.getFilter());
        return new DataTableObjectResponse(items, administrativoTableFilter.getDraw(), count , count);
    }
}
