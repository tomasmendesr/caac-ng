package ar.gov.sedronar.aplicacion.services.implementation;

import ar.gov.sedronar.aplicacion.dao.hibernate.HibernateDAO;
import ar.gov.sedronar.aplicacion.dao.interfaces.HojaMensualActividadesDAO;
import ar.gov.sedronar.aplicacion.dto.HojaMensualActividadesDTO;
import ar.gov.sedronar.aplicacion.model.*;
import ar.gov.sedronar.aplicacion.services.interfaces.HojaMensualActividadesService;
import ar.gov.sedronar.aplicacion.services.interfaces.UsuarioService;
import ar.gov.sedronar.util.app.AppResponse;
import ar.gov.sedronar.util.dozer.DozerHelper;
import org.codehaus.plexus.util.StringUtils;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by TMR on 02/10/2018.
 */
@Stateless
@DefaultServiceImpl
@Transactional
public class HojaMensualActividadesServiceImpl implements HojaMensualActividadesService {

    @Inject
    @HibernateDAO
    private HojaMensualActividadesDAO hojaMensualActividadesDAO;

    @Inject
    @UserServiceProvider
    private UsuarioService usuarioService;

    @Override
    public AppResponse validateInputs(List<HojaMensualActividadesDTO> data) {
        List<String> messages = new ArrayList<>();
        for(HojaMensualActividadesDTO hoja : data){
            if(hoja.getDescripcionActividad() == null || StringUtils.isBlank(hoja.getDescripcionActividad())){
                messages.add("Debe especificar información para " + hoja.getActividadIntervencion().getDescripcionActividad());
            } else if(hoja.getDescripcionActividad().length() > 4000){
                messages.add("La descripción de " + hoja.getActividadIntervencion().getDescripcionActividad() + " no puede tener más de 4000 caracteres");
            }
        }
        return messages.isEmpty() ? new AppResponse() : new AppResponse(AppResponse.ERROR, messages);
    }


    @Override
    public void saveOrUpdate(HojaMensualActividadesDTO dto) throws Exception {
        if (dto == null) throw new Exception("Error creando la consulta");
        HojaMensualActividades model;
        if(dto.getHoja() != null && dto.getActividadIntervencion() != null) model = hojaMensualActividadesDAO.findById(dto.getHoja().getId(), dto.getActividadIntervencion().getId());
        dto.setFum(new Date());
        dto.setUum(usuarioService.getCurrentUsername());
        model = DozerHelper.map(dto, HojaMensualActividades.class);
        model.setId(new HojaMensualActividadesId(dto.getHoja().getId(), dto.getActividadIntervencion().getId()));
        hojaMensualActividadesDAO.merge(model);
    }

    @Override
    public List<HojaMensualActividadesDTO> findListByHojaAndActividadId(Long idHoja, List<Integer> idsActividades) {
        List<HojaMensualActividadesDTO> list = new ArrayList<>();
        idsActividades.forEach(idActividad -> findAndAddIfExists(idHoja, idActividad, list));
        return list;
    }

    @Override
    public void deleteIfExists(HojaMensualActividadesDTO dto) {
        HojaMensualActividades hoja = hojaMensualActividadesDAO.findById(dto.getHoja().getId(), dto.getActividadIntervencion().getId());
        if(hoja != null) hojaMensualActividadesDAO.delete(hoja);
    }


    private void findAndAddIfExists(Long idHoja, Integer idActividad, List<HojaMensualActividadesDTO> list) {
        HojaMensualActividades hojaMensual = hojaMensualActividadesDAO.findById(idHoja, idActividad);
        if(hojaMensual != null) list.add(DozerHelper.map(hojaMensual, HojaMensualActividadesDTO.class));
    }
}
