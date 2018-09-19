package ar.gov.sedronar.aplicacion.services.implementation;

import ar.gov.sedronar.aplicacion.dao.hibernate.HibernateDAO;
import ar.gov.sedronar.aplicacion.dao.interfaces.HojaMensualAlimentacionDAO;
import ar.gov.sedronar.aplicacion.dto.HojaMensualAlimentacionDTO;
import ar.gov.sedronar.aplicacion.model.*;
import ar.gov.sedronar.aplicacion.services.interfaces.HojaMensualAlimentacionService;
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
 * Created by TMR on 18/09/2018.
 */
@Stateless
@Transactional
@DefaultServiceImpl
public class HojaMensualAlimentacionServiceImpl implements HojaMensualAlimentacionService {
    private static final String EN_SEDE = "En Sede";
    private static final String FUERA_DE_SEDE = "Fuera de Sede";

    private static final Integer ID_DESAYUNO = 1;
    private static final Integer ID_ALMUERZO = 2;
    private static final Integer ID_MERIENDA = 3;
    private static final Integer ID_CENA = 4;
    private static final Integer ID_OTRO_EN_SEDE = 5;
    private static final Integer ID_VIANDAS = 6;
    private static final Integer ID_BOLSONES = 7;
    private static final Integer ID_OTRO_FUERA_DE_SEDE = 8;

    @Inject
    @HibernateDAO
    private HojaMensualAlimentacionDAO hojaMensualAlimentacionDAO;

    @Inject
    @UserServiceProvider
    private UsuarioService usuarioService;

    @Override
    public AppResponse validateInputsEnSede(List<HojaMensualAlimentacionDTO> hojaMensualAlimentacionList) {
        hojaMensualAlimentacionList = filterListByClasificacion(hojaMensualAlimentacionList, EN_SEDE);
        List<String> messages = new ArrayList<>();
        hojaMensualAlimentacionList.forEach(hojaMensualAlimentacion -> {
            if(hojaMensualAlimentacion.getCantidadPrestaciones() == null) messages.add("Debe ingresar la cantidad de prestaciones para la alimentación: " + hojaMensualAlimentacion.getTipoAlimentacion().getDescripcion());
            else if(hojaMensualAlimentacion.getCantidadPrestaciones() < 0) messages.add("El valor ingresado para la cantidad de prestaciones en " + hojaMensualAlimentacion.getTipoAlimentacion().getDescripcion() + " debe ser mayor o igual a 0");

            if(hojaMensualAlimentacion.getCantidadPersonas() == null) messages.add("Debe ingresar la cantidad de personas para la alimentación: " + hojaMensualAlimentacion.getTipoAlimentacion().getDescripcion());
            else if(hojaMensualAlimentacion.getCantidadPersonas() < 0) messages.add("El valor ingresado para la cantidad de personas en " + hojaMensualAlimentacion.getTipoAlimentacion().getDescripcion() + " debe ser mayor o igual a 0");
        });

        return messages.isEmpty() ? new AppResponse() : new AppResponse(AppResponse.ERROR, messages);
    }

    @Override
    public AppResponse validateInputsFueraDeSede(List<HojaMensualAlimentacionDTO> hojaMensualAlimentacionList) {
        hojaMensualAlimentacionList = filterListByClasificacion(hojaMensualAlimentacionList, FUERA_DE_SEDE);
        List<String> messages = new ArrayList<>();
        hojaMensualAlimentacionList.forEach(hojaMensualAlimentacion -> {
            if(hojaMensualAlimentacion.getCantidadPrestaciones() == null) messages.add("Debe ingresar la cantidad de prestaciones para la alimentación: " + hojaMensualAlimentacion.getTipoAlimentacion().getDescripcion());
            else if(hojaMensualAlimentacion.getCantidadPrestaciones() < 0) messages.add("El valor ingresado para la cantidad de prestaciones en " + hojaMensualAlimentacion.getTipoAlimentacion().getDescripcion() + " debe ser mayor o igual a 0");
        });

        return messages.isEmpty() ? new AppResponse() : new AppResponse(AppResponse.ERROR, messages);
    }

    @Override
    public void saveOrUpdate(HojaMensualAlimentacionDTO dto) throws Exception {
        if (dto == null) throw new Exception("Error creando la consulta");
        HojaMensualAlimentacion model;
        if(dto.getHoja() != null && dto.getTipoAlimentacion() != null) model = hojaMensualAlimentacionDAO.findById(dto.getHoja().getId(), dto.getTipoAlimentacion().getId());
        dto.setFum(new Date());
        dto.setUum(usuarioService.getCurrentUsername());
        model = DozerHelper.map(dto, HojaMensualAlimentacion.class);
        model.setId(new HojaMensualAlimentacionId(dto.getHoja().getId(), dto.getTipoAlimentacion().getId()));
        hojaMensualAlimentacionDAO.merge(model);
    }

    @Override
    public List<HojaMensualAlimentacionDTO> findListByHojaId(Long idHoja) {
        List<HojaMensualAlimentacionDTO> list = new ArrayList<>();
        findAndAddIfExists(idHoja, list, ID_ALMUERZO);
        findAndAddIfExists(idHoja, list, ID_CENA);
        findAndAddIfExists(idHoja, list, ID_DESAYUNO);
        findAndAddIfExists(idHoja, list, ID_MERIENDA);
        findAndAddIfExists(idHoja, list, ID_VIANDAS);
        findAndAddIfExists(idHoja, list, ID_BOLSONES);
        return list;
    }

    private void findAndAddIfExists(Long idHoja, List<HojaMensualAlimentacionDTO> list, Integer idAlimentacion) {
        HojaMensualAlimentacion hojaMensualAlimentacion = hojaMensualAlimentacionDAO.findById(idHoja, idAlimentacion);
        if(hojaMensualAlimentacion != null) list.add(DozerHelper.map(hojaMensualAlimentacion, HojaMensualAlimentacionDTO.class));
    }

    private List<HojaMensualAlimentacionDTO> filterListByClasificacion(List<HojaMensualAlimentacionDTO> hojaMensualAlimentacionList, String enSedeOFueraDeSede) {
        return hojaMensualAlimentacionList.stream().filter(h -> enSedeOFueraDeSede.equals(h.getTipoAlimentacion().getClasificacion())).collect(Collectors.toList());
    }
}
