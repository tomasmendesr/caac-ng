package ar.gov.sedronar.aplicacion.services.implementation;


import ar.gov.sedronar.modulo.commonsModels.dao.TipoDocumentoDAO;
import ar.gov.sedronar.modulo.commonsModels.dao.hibernate.HibernateDAO;
import ar.gov.sedronar.aplicacion.services.interfaces.PicsService;
import ar.gov.sedronar.modulo.commonsModels.dto.TipoDocumentoDTO;
import ar.gov.sedronar.modulo.commonsModels.modelo.TipoDocumento;
import ar.gov.sedronar.modulo.geo.dao.interfaces.ProvinciaLightDAO;
import ar.gov.sedronar.modulo.geo.dto.DepartamentoLightDTO;
import ar.gov.sedronar.modulo.geo.dto.LocalidadLightDTO;
import ar.gov.sedronar.modulo.geo.dto.MunicipioDTO;
import ar.gov.sedronar.modulo.geo.dto.ProvinciaLightDTO;
import ar.gov.sedronar.modulo.geo.modelo.ProvinciaLight;
import ar.gov.sedronar.modulo.geo.servicios.DefaultService;
import ar.gov.sedronar.util.dozer.DozerHelper;
import ar.gov.sedronar.modulo.geo.servicios.IGeoServicio;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TMR on 12/09/2018.
 */
@Stateless
@DefaultServiceImpl
@Transactional
public class PicsServiceImpl implements PicsService {

    @Inject @HibernateDAO
    private ProvinciaLightDAO provinciaLightDao;

    @Inject @DefaultService
    private IGeoServicio geoServicio;

    @Inject
    @HibernateDAO
    private TipoDocumentoDAO tipoDocumentoDAO;

    @Override
    public List<ProvinciaLightDTO> findAllProvinciasCombo() {
        List<ProvinciaLight> provincias = provinciaLightDao.findAll();
        List<ProvinciaLightDTO> provinciasDTO = new ArrayList<>();
        for (ProvinciaLight prov : provincias) {
            ProvinciaLightDTO dto = new ProvinciaLightDTO();
            dto.setId(prov.getId());
            dto.setNombre(prov.getNombre());
            provinciasDTO.add(dto);
        }
        return provinciasDTO;
    }

    @Override
    public List<LocalidadLightDTO> findAllLocalidades() {
        return DozerHelper.mapList(geoServicio.findLocalidadesLight(), LocalidadLightDTO.class);
    }

    @Override
    public List<DepartamentoLightDTO> findAllDepartamentos() {
        return DozerHelper.mapList(geoServicio.findAllDepartamentoLigh(), DepartamentoLightDTO.class);
    }

    @Override
    public List<DepartamentoLightDTO> findAllDepartamentosByProvincia(ProvinciaLightDTO provinciaLight) {
        return DozerHelper.mapList(geoServicio.findDepartamentoLightByProvincia(provinciaLight.getId()), DepartamentoLightDTO.class);
    }

    @Override
    public List<LocalidadLightDTO> findAllLocalidadesByDepartamento(DepartamentoLightDTO departamento) {
        return DozerHelper.mapList(geoServicio.findLocalidadesLightByDepartamento(departamento.getId()), LocalidadLightDTO.class);
    }

    @Override
    public List<TipoDocumentoDTO> findAllTiposDocumento() {
        return DozerHelper.mapList(tipoDocumentoDAO.findAll(TipoDocumento.class), TipoDocumentoDTO.class);
    }

    @Override
    public List<MunicipioDTO> findMunicipiosByDepartamentoId(Integer idDpto) {
        return DozerHelper.mapList(geoServicio.findMunicipiosByDepartamento(idDpto), MunicipioDTO.class);
    }


}
