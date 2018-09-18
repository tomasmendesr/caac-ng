package ar.gov.sedronar.aplicacion.services.implementation;

import ar.gov.sedronar.aplicacion.dao.hibernate.HibernateDAO;
import ar.gov.sedronar.aplicacion.dao.interfaces.HojaMensualAsistidosDAO;
import ar.gov.sedronar.aplicacion.dto.HojaMensualAsistidosDTO;
import ar.gov.sedronar.aplicacion.model.HojaDatosIniciales;
import ar.gov.sedronar.aplicacion.model.HojaMensualAsistidos;
import ar.gov.sedronar.aplicacion.services.interfaces.HojaMensualAsistidosService;
import ar.gov.sedronar.aplicacion.services.interfaces.UsuarioService;
import ar.gov.sedronar.util.app.AppResponse;
import ar.gov.sedronar.util.dozer.DozerHelper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by TMR on 17/09/2018.
 */
@Stateless
@Transactional
@DefaultServiceImpl
public class HojaMensualAsistidosServiceImpl implements HojaMensualAsistidosService {

    @Inject
    @HibernateDAO
    private HojaMensualAsistidosDAO hojaMensualAsistidosDAO;

    @Inject @UserServiceProvider
    private UsuarioService usuarioService;

    @Override
    public AppResponse saveOrUpdate(HojaMensualAsistidosDTO hojaMensualAsistidosDTO) throws Exception {
        if(hojaMensualAsistidosDTO.getHoja() == null || hojaMensualAsistidosDTO.getHoja().getId() == null) return new AppResponse(AppResponse.ERROR, Arrays.asList("Debe seleccionar una hoja"));
        hojaMensualAsistidosDTO.setId(hojaMensualAsistidosDTO.getHoja().getId());
        AppResponse appResponseValidation = validateInputs(hojaMensualAsistidosDTO);
        if(appResponseValidation.getCode() == AppResponse.ERROR) return appResponseValidation;

        if (hojaMensualAsistidosDTO == null) throw new Exception("Error creando la consulta");
        HojaMensualAsistidos hojaMensualAsistidos;
        if(hojaMensualAsistidosDTO.getId() != null) hojaMensualAsistidos = hojaMensualAsistidosDAO.findById(HojaMensualAsistidos.class, hojaMensualAsistidosDTO.getId());
        hojaMensualAsistidosDTO.setFum(new Date());
        hojaMensualAsistidosDTO.setUum(usuarioService.getCurrentUsername());
        hojaMensualAsistidos = DozerHelper.map(hojaMensualAsistidosDTO, HojaMensualAsistidos.class);
        hojaMensualAsistidos = hojaMensualAsistidosDAO.merge(hojaMensualAsistidos);
        return new AppResponse(hojaMensualAsistidos.getId());
    }

    @Override
    public HojaMensualAsistidosDTO findById(Long id) {
        HojaMensualAsistidos hoja = hojaMensualAsistidosDAO.findById(HojaMensualAsistidos.class, id);
        return hoja != null ? DozerHelper.map(hoja, HojaMensualAsistidosDTO.class) : null;
    }

    private AppResponse validateInputs(HojaMensualAsistidosDTO hojaMensualAsistidosDTO){
        List<String> messages = new ArrayList<>();
        boolean hayNumeroNegativo = false;
        if(hojaMensualAsistidosDTO.getAsistidosMujeres() == null) messages.add("Debe ingresar la cantidad de asistidas mujeres");
        else if(hojaMensualAsistidosDTO.getAsistidosMujeres() < 0 && !hayNumeroNegativo){
            hayNumeroNegativo = true;
            messages.add("Debe ingresar un número mayor o igual a 0");
        }

        if(hojaMensualAsistidosDTO.getAsistidosVarones() == null) messages.add("Debe ingresar la cantidad de asistidos varones");
        else if(hojaMensualAsistidosDTO.getAsistidosMujeres() < 0 && !hayNumeroNegativo){
            messages.add("Debe ingresar un número mayor o igual a 0");
            hayNumeroNegativo = true;
        }

        if(hojaMensualAsistidosDTO.getAsistidosOtroGenero() == null) messages.add("Debe ingresar la cantidad de asistidos de otro género");
        else if(hojaMensualAsistidosDTO.getAsistidosMujeres() < 0 && !hayNumeroNegativo){
            messages.add("Debe ingresar un número mayor o igual a 0");
            hayNumeroNegativo = true;
        }

        if(hojaMensualAsistidosDTO.getAsistidosCantidad() == null) messages.add("Debe ingresar la cantidad de atendidos");
        else if(hojaMensualAsistidosDTO.getAsistidosMujeres() < 0 && !hayNumeroNegativo) {
            messages.add("Debe ingresar un número mayor o igual a 0");
        }
        return messages.isEmpty() ? new AppResponse() : new AppResponse(AppResponse.ERROR, messages);
    }
}
