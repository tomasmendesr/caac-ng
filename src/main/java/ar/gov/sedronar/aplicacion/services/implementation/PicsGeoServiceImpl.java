package ar.gov.sedronar.aplicacion.services.implementation;


import ar.gov.sedronar.modulo.commonsModels.dao.hibernate.HibernateDAO;
import ar.gov.sedronar.aplicacion.services.interfaces.PicsGeoService;
import ar.gov.sedronar.modulo.geo.dao.interfaces.ProvinciaLightDAO;
import ar.gov.sedronar.modulo.geo.dto.DepartamentoLightDTO;
import ar.gov.sedronar.modulo.geo.dto.LocalidadLightDTO;
import ar.gov.sedronar.modulo.geo.dto.ProvinciaLightDTO;
import ar.gov.sedronar.modulo.geo.modelo.ProvinciaLight;
import ar.gov.sedronar.modulo.geo.servicios.DefaultService;
import ar.gov.sedronar.modulo.geo.servicios.GeoServicio;
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
public class PicsGeoServiceImpl  implements PicsGeoService {

    @Inject @HibernateDAO
    private ProvinciaLightDAO provinciaLightDao;

    @Inject @DefaultService
    private IGeoServicio geoServicio;

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


}
