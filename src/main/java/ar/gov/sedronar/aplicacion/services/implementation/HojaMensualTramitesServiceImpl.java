package ar.gov.sedronar.aplicacion.services.implementation;

import ar.gov.sedronar.aplicacion.dao.hibernate.HibernateDAO;
import ar.gov.sedronar.aplicacion.dao.interfaces.HojaMensualTramitesDAO;
import ar.gov.sedronar.aplicacion.dto.HojaMensualAlimentacionDTO;
import ar.gov.sedronar.aplicacion.dto.HojaMensualTramitesDTO;
import ar.gov.sedronar.aplicacion.model.HojaDatosIniciales;
import ar.gov.sedronar.aplicacion.model.HojaMensualAlimentacion;
import ar.gov.sedronar.aplicacion.model.HojaMensualTramites;
import ar.gov.sedronar.aplicacion.model.HojaMensualTramitesId;
import ar.gov.sedronar.aplicacion.services.interfaces.HojaMensualTramitesService;
import ar.gov.sedronar.aplicacion.services.interfaces.UsuarioService;
import ar.gov.sedronar.util.app.AppResponse;
import ar.gov.sedronar.util.dozer.DozerHelper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by TMR on 18/09/2018.
 */
@Stateless
@Transactional
@DefaultServiceImpl
public class HojaMensualTramitesServiceImpl implements HojaMensualTramitesService {
    public static final Integer ID_DNI = 1;
    public static final Integer ID_SUBSIDIOS = 2;
    public static final Integer ID_BECAS = 3;
    public static final Integer ID_CERTIFICADO_DISCAPACIDAD = 4;
    public static final Integer ID_INSERCION_LABORAL = 5;
    public static final Integer ID_SERVICIOS_PREVISIONALES = 6;
    public static final Integer ID_GESTIONES = 7;
    public static final Integer ID_OTROS = 8;

    @Inject
    @UserServiceProvider
    private UsuarioService usuarioService;

    @Inject
    @HibernateDAO
    private HojaMensualTramitesDAO hojaMensualTramitesDAO;

    @Override
    public AppResponse validateInputs(List<HojaMensualTramitesDTO> hojaMensualTramitesList) {
        List<String> messages = new ArrayList<>();
        hojaMensualTramitesList.forEach(hojaMensualTramite -> {
            if(hojaMensualTramite.getCantidad() == null) messages.add("Debe ingresar la cantidad para el trámite: " + hojaMensualTramite.getTramite().getDescripcion());
            else if(hojaMensualTramite.getCantidad() < 0) messages.add("El valor ingresado para el trámite " + hojaMensualTramite.getTramite().getDescripcion() + " debe ser mayor o igual a 0");
        });

        return messages.isEmpty() ? new AppResponse() : new AppResponse(AppResponse.ERROR, messages);
    }

    @Override
    public void saveOrUpdate(HojaMensualTramitesDTO dto) throws Exception {
        if (dto == null) throw new Exception("Error creando la consulta");
        HojaMensualTramites model;
        if(dto.getHoja() != null && dto.getTramite() != null) model = hojaMensualTramitesDAO.findById(dto.getHoja().getId(), dto.getTramite().getId());
        dto.setFum(new Date());
        dto.setUum(usuarioService.getCurrentUsername());
        model = DozerHelper.map(dto, HojaMensualTramites.class);
        model.setId(new HojaMensualTramitesId(dto.getHoja().getId(), dto.getTramite().getId()));
        hojaMensualTramitesDAO.merge(model);
    }

    @Override
    public List<HojaMensualTramitesDTO> findListByHojaId(Long idHoja) {
        List<HojaMensualTramitesDTO> list = new ArrayList<>();
        findAndAddIfExists(idHoja, list, ID_DNI);
        findAndAddIfExists(idHoja, list, ID_SERVICIOS_PREVISIONALES);
        findAndAddIfExists(idHoja, list, ID_SUBSIDIOS);
        findAndAddIfExists(idHoja, list, ID_CERTIFICADO_DISCAPACIDAD);
        findAndAddIfExists(idHoja, list, ID_BECAS);
        findAndAddIfExists(idHoja, list, ID_INSERCION_LABORAL);
        findAndAddIfExists(idHoja, list, ID_GESTIONES);
        findAndAddIfExists(idHoja, list, ID_OTROS);
        return list;
    }

    private void findAndAddIfExists(Long idHoja, List<HojaMensualTramitesDTO> list, Integer idTramite) {
        HojaMensualTramites hojaMensualTramites = hojaMensualTramitesDAO.findById(idHoja, idTramite);
        if(hojaMensualTramites != null) list.add(DozerHelper.map(hojaMensualTramites, HojaMensualTramitesDTO.class));
    }
}
