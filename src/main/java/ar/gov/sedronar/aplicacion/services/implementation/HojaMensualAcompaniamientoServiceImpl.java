package ar.gov.sedronar.aplicacion.services.implementation;

import ar.gov.sedronar.aplicacion.dao.hibernate.HibernateDAO;
import ar.gov.sedronar.aplicacion.dao.interfaces.HojaMensualAcompaniamientoDAO;
import ar.gov.sedronar.aplicacion.dto.HojaMensualAcompaniamientoDTO;
import ar.gov.sedronar.aplicacion.dto.HojaMensualTramitesDTO;
import ar.gov.sedronar.aplicacion.model.*;
import ar.gov.sedronar.aplicacion.services.interfaces.HojaMensualAcompaniamientoService;
import ar.gov.sedronar.aplicacion.services.interfaces.UsuarioService;
import ar.gov.sedronar.util.app.AppResponse;
import ar.gov.sedronar.util.dozer.DozerHelper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by TMR on 21/09/2018.
 */
@DefaultServiceImpl
@Stateless
@Transactional
public class HojaMensualAcompaniamientoServiceImpl implements HojaMensualAcompaniamientoService {
    @Inject
    @HibernateDAO
    private HojaMensualAcompaniamientoDAO hojaMensualAcompaniamientoDAO;

    @Inject
    @UserServiceProvider
    private UsuarioService usuarioService;

    @Override
    public AppResponse validateInputs(List<HojaMensualAcompaniamientoDTO> hojaMensualAcompaniamientoDTOList) {
        List<String> messages = new ArrayList<>();
        hojaMensualAcompaniamientoDTOList.forEach(hojaMensualAcompaniamientoDTO ->
                this.validateCantidadGestionesAndCantidadPersonas(messages,hojaMensualAcompaniamientoDTO, true,true));

        return messages.isEmpty() ? new AppResponse() : new AppResponse(AppResponse.ERROR, messages);
    }

    @Override
    public void saveOrUpdate(HojaMensualAcompaniamientoDTO dto) throws Exception {
        if (dto == null) throw new Exception("Error creando la consulta");
        HojaMensualAcompaniamiento model;
        if(dto.getHoja() != null && dto.getAcompaniamiento() != null) model = hojaMensualAcompaniamientoDAO.findById(dto.getHoja().getId(), dto.getAcompaniamiento().getId());
        dto.setFum(new Date());
        dto.setUum(usuarioService.getCurrentUsername());
        model = DozerHelper.map(dto, HojaMensualAcompaniamiento.class);
        model.setId(new HojaMensualAcompaniamientoId(dto.getHoja().getId(), dto.getAcompaniamiento().getId()));
        hojaMensualAcompaniamientoDAO.merge(model);
    }

    @Override
    public List<HojaMensualAcompaniamientoDTO> findListByHojaAndAcompaniamientoId(Long idHoja, List<Integer> idsAcompaniamientos) {
        List<HojaMensualAcompaniamientoDTO> list = new ArrayList<>();
        idsAcompaniamientos.forEach(id -> findAndAddIfExists(idHoja, list, id));
        return list;
    }

    private void findAndAddIfExists(Long idHoja, List<HojaMensualAcompaniamientoDTO> list, Integer idAcompaniamiento) {
        HojaMensualAcompaniamiento hojaMensualAcompaniamiento = hojaMensualAcompaniamientoDAO.findById(idHoja, idAcompaniamiento);
        if(hojaMensualAcompaniamiento != null) list.add(DozerHelper.map(hojaMensualAcompaniamiento, HojaMensualAcompaniamientoDTO.class));
    }

    @Override
    public AppResponse validateInputsEnEstablecimiento(List<HojaMensualAcompaniamientoDTO> hojaMensualAcompaniamientoList, String establecimiento, boolean validateGestiones, boolean validatePersonas) {
        List<String> messages = new ArrayList<>();
        hojaMensualAcompaniamientoList.stream().filter(h -> establecimiento.equals(h.getAcompaniamiento().getEstablecimiento())).collect(Collectors.toList())
            .forEach(hojaMensualAcompaniamientoDTO ->
                    this.validateCantidadGestionesAndCantidadPersonas(messages, hojaMensualAcompaniamientoDTO,validateGestiones,validatePersonas));

        return messages.isEmpty() ? new AppResponse() : new AppResponse(AppResponse.ERROR, messages);
    }

    @Override
    public AppResponse validateInputsByEstablecimientoAndTipo(List<HojaMensualAcompaniamientoDTO> hojaMensualAcompaniamientoList, String establecimiento, String tipo, boolean validateGestiones, boolean validatePersonas) {
        List<String> messages = new ArrayList<>();
        hojaMensualAcompaniamientoList.stream().filter(h -> establecimiento.equals(h.getAcompaniamiento().getEstablecimiento()) && tipo.equals(h.getAcompaniamiento().getTipo())).collect(Collectors.toList())
                .forEach(hojaMensualAcompaniamientoDTO ->
                        this.validateCantidadGestionesAndCantidadPersonas(messages, hojaMensualAcompaniamientoDTO, validateGestiones, validatePersonas));
        return messages.isEmpty() ? new AppResponse() : new AppResponse(AppResponse.ERROR, messages);
    }

    private void validateCantidadGestionesAndCantidadPersonas(List<String> validationsMessages, HojaMensualAcompaniamientoDTO hojaMensualAcompaniamientoDTO, boolean validateGestiones, boolean validatePersonas){
        if (validateGestiones) {
            if (hojaMensualAcompaniamientoDTO.getCantidadGestiones() == null)
                validationsMessages.add("Debe ingresar la cantidad de gestiones para el acompañamiento: " + hojaMensualAcompaniamientoDTO.getAcompaniamiento().getDetalle());
            else if (hojaMensualAcompaniamientoDTO.getCantidadGestiones() < 0)
                validationsMessages.add("El valor ingresado para la cantidad de gestiones para el acompañamiento " + hojaMensualAcompaniamientoDTO.getAcompaniamiento().getDetalle() + " debe ser mayor o igual a 0");
        }

        if(validatePersonas) {
            if (hojaMensualAcompaniamientoDTO.getCantidadPersonas() == null)
                validationsMessages.add("Debe ingresar la cantidad de personas que alcanzó el acompañamiento: " + hojaMensualAcompaniamientoDTO.getAcompaniamiento().getDetalle());
            else if (hojaMensualAcompaniamientoDTO.getCantidadPersonas() < 0)
                validationsMessages.add("El valor ingresado para la cantidad de personas en el acompañamiento " + hojaMensualAcompaniamientoDTO.getAcompaniamiento().getDetalle() + " debe ser mayor o igual a 0");
        }
    }
}
