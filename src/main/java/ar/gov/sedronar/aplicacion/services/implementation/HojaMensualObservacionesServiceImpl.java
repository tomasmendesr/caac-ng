package ar.gov.sedronar.aplicacion.services.implementation;

import ar.gov.sedronar.aplicacion.dao.hibernate.HibernateDAO;
import ar.gov.sedronar.aplicacion.dao.interfaces.HojaMensualObservacionesDAO;
import ar.gov.sedronar.aplicacion.dto.HojaMensualObservacionesDTO;
import ar.gov.sedronar.aplicacion.model.HojaMensualAlimentacion;
import ar.gov.sedronar.aplicacion.model.HojaMensualObservaciones;
import ar.gov.sedronar.aplicacion.services.interfaces.HojaMensualObservacionesService;
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
@Transactional
@DefaultServiceImpl
@Stateless
public class HojaMensualObservacionesServiceImpl implements HojaMensualObservacionesService {

    @Inject
    @HibernateDAO
    private HojaMensualObservacionesDAO hojaMensualObservacionesDAO;

    @Inject
    @UserServiceProvider
    private UsuarioService usuarioService;

    @Override
    public void saveOrUpdate(HojaMensualObservacionesDTO dto) throws Exception {
        if (dto == null) throw new Exception("Error creando la consulta");
        HojaMensualObservaciones model;
        if(dto.getId() != null) model = hojaMensualObservacionesDAO.findById(HojaMensualObservaciones.class, dto.getId());
        dto.setFum(new Date());
        dto.setUum(usuarioService.getCurrentUsername());
        model = DozerHelper.map(dto, HojaMensualObservaciones.class);
        hojaMensualObservacionesDAO.merge(model);
    }

    @Override
    public AppResponse saveOrUpdateSeccionD(HojaMensualObservacionesDTO hojaMensualObservaciones) throws Exception {
        AppResponse validation = validateInputsSeccionD(hojaMensualObservaciones);
        if(validation.getCode() == AppResponse.ERROR) return validation;

        saveOrUpdate(hojaMensualObservaciones);
        return new AppResponse();
    }

    private AppResponse validateInputsSeccionD(HojaMensualObservacionesDTO hojaMensualObservaciones){
        List<String> messages = new ArrayList<>();
        if(hojaMensualObservaciones.getMejorasInfraestructura().length() > 2000){
            messages.add("El texto para las mejoras de infraestructura no puede tener más de 2000 caracteres");
        }
        if(hojaMensualObservaciones.getRequerimientosFormacion().length() > 4000){
            messages.add("El texto para los requerimientos no puede tener más de 4000 caracteres");
        }
        return messages.isEmpty() ? new AppResponse() : new AppResponse(AppResponse.ERROR, messages);
    }

    @Override
    public HojaMensualObservacionesDTO findByHojaId(Long idHoja) {
        if(idHoja == null) return null;
        HojaMensualObservaciones hojaMensualObservaciones = hojaMensualObservacionesDAO.findById(HojaMensualObservaciones.class, idHoja);
        return hojaMensualObservaciones != null ? DozerHelper.map(hojaMensualObservaciones, HojaMensualObservacionesDTO.class) : null;
    }
}
