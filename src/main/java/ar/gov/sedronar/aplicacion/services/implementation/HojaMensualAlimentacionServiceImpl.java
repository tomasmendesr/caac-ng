package ar.gov.sedronar.aplicacion.services.implementation;

import ar.gov.sedronar.aplicacion.dao.hibernate.HibernateDAO;
import ar.gov.sedronar.aplicacion.dao.interfaces.HojaMensualAlimentacionDAO;
import ar.gov.sedronar.aplicacion.dto.HojaMensualAlimentacionDTO;
import ar.gov.sedronar.aplicacion.model.HojaMensualAlimentacion;
import ar.gov.sedronar.aplicacion.model.HojaMensualTramites;
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
    private static final String FUERA_DE_SEDE = "Fera de Sede";

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
        hojaMensualAlimentacionDAO.merge(model);
    }

    private List<HojaMensualAlimentacionDTO> filterListByClasificacion(List<HojaMensualAlimentacionDTO> hojaMensualAlimentacionList, String enSedeOFueraDeSede) {
        return hojaMensualAlimentacionList.stream().filter(h -> h.getTipoAlimentacion().getClasificacion().equals(enSedeOFueraDeSede)).collect(Collectors.toList());

    }
}
