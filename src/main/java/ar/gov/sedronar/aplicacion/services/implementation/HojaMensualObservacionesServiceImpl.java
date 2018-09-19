package ar.gov.sedronar.aplicacion.services.implementation;

import ar.gov.sedronar.aplicacion.dao.hibernate.HibernateDAO;
import ar.gov.sedronar.aplicacion.dao.interfaces.HojaMensualObservacionesDAO;
import ar.gov.sedronar.aplicacion.dto.HojaMensualObservacionesDTO;
import ar.gov.sedronar.aplicacion.model.HojaMensualAlimentacion;
import ar.gov.sedronar.aplicacion.model.HojaMensualObservaciones;
import ar.gov.sedronar.aplicacion.services.interfaces.HojaMensualObservacionesService;
import ar.gov.sedronar.aplicacion.services.interfaces.UsuarioService;
import ar.gov.sedronar.util.dozer.DozerHelper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Date;

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
    public HojaMensualObservacionesDTO findByHojaId(Long idHoja) {
        HojaMensualObservaciones hojaMensualObservaciones = hojaMensualObservacionesDAO.findById(HojaMensualObservaciones.class, idHoja);
        return hojaMensualObservaciones != null ? DozerHelper.map(hojaMensualObservaciones, HojaMensualObservacionesDTO.class) : null;
    }
}
