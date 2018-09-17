package ar.gov.sedronar.aplicacion.services.implementation;

import ar.gov.sedronar.aplicacion.dao.hibernate.HibernateDAO;
import ar.gov.sedronar.aplicacion.dao.interfaces.HojaDatosInicialesDAO;
import ar.gov.sedronar.aplicacion.dto.CasaDTO;
import ar.gov.sedronar.aplicacion.dto.HojaDTO;
import ar.gov.sedronar.aplicacion.dto.HojaDatosInicialesDTO;
import ar.gov.sedronar.aplicacion.dto.MensualSeccionARequestDTO;
import ar.gov.sedronar.aplicacion.model.HojaDatosIniciales;
import ar.gov.sedronar.aplicacion.services.interfaces.*;
import ar.gov.sedronar.util.app.AppRequest;
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
 * Created by TMR on 13/09/2018.
 */
@Stateless
@Transactional
@DefaultServiceImpl
public class HojaDatosInicialesServiceImpl implements HojaDatosInicialesService {

    @Inject @HibernateDAO
    private HojaDatosInicialesDAO hojaDatosInicialesDAO;

    @Inject @DefaultServiceImpl
    private HojaService hojaService;

    @Inject @UserServiceProvider
    private UsuarioService usuarioService;

    @Inject @DefaultServiceImpl
    private CasaService casaService;

    @Override
    public AppResponse saveOrUpdateMensual(MensualSeccionARequestDTO mensualSeccionARequestDTO) throws Exception {
        HojaDTO hojaDTO = mensualSeccionARequestDTO.getHojaDTO();
        hojaDTO.setTipoHoja("M");
        HojaDatosInicialesDTO hojaDatosInicialesDTO = mensualSeccionARequestDTO.getHojaDatosInicialesDTO();
        if(hojaDTO.getId() != null) hojaDatosInicialesDTO.setId(hojaDTO.getId());

        AppResponse validateHoja = hojaService.validateInputsDatosInicialesMensual(hojaDTO);
        if(validateHoja.getCode() == AppResponse.ERROR) return validateHoja; // si falla retorno los errores

        AppResponse validateHojaDatosIniciales = validateInputsMensual(hojaDatosInicialesDTO);
        if(validateHojaDatosIniciales.getCode() == AppResponse.ERROR) return validateHoja; // si falla retorno los errores

        CasaDTO casaDTO = hojaDTO.getCasa();
        if((hojaDatosInicialesDTO.getProvinciaLight().getId() != casaDTO.getProvincia().getId()) || !hojaDatosInicialesDTO.getNombreCaac().equals(casaDTO.getNomcaac())){
            casaDTO.setProvincia(hojaDatosInicialesDTO.getProvinciaLight());
            casaDTO.setNomcaac(hojaDatosInicialesDTO.getNombreCaac());
            casaService.saveOrUpdate(casaDTO);
        }

        Long idHoja = hojaService.saveOrUpdate(hojaDTO); // guardo la hoja y la vinculo a hojaDatosIniciales
        hojaDatosInicialesDTO.setHoja(hojaService.findById(idHoja));
        hojaDatosInicialesDTO.setId(saveOrUpdate(hojaDatosInicialesDTO));
        return new AppResponse(hojaDatosInicialesDTO); // retorno el objeto para guardar referencia en el front
    }

    private Long saveOrUpdate(HojaDatosInicialesDTO hojaDatosInicialesDTO) throws Exception {
        if (hojaDatosInicialesDTO == null) throw new Exception("Error creando la consulta");
        HojaDatosIniciales hoja;
        if(hojaDatosInicialesDTO.getId() != null) hoja = hojaDatosInicialesDAO.findById(HojaDatosIniciales.class, hojaDatosInicialesDTO.getId());
        hojaDatosInicialesDTO.setFum(new Date());
        hojaDatosInicialesDTO.setUum(usuarioService.getCurrentUsername());
        hoja = DozerHelper.map(hojaDatosInicialesDTO, HojaDatosIniciales.class);
        hoja = hojaDatosInicialesDAO.merge(hoja);
        return hoja.getId();
    }

    @Override
    public AppResponse validateInputsMensual(HojaDatosInicialesDTO hojaDatosInicialesDTO) {
        List<String> messages = new ArrayList();
        if(hojaDatosInicialesDTO.getNombreCaac() == null || StringUtils.isBlank(hojaDatosInicialesDTO.getNombreCaac()))
            messages.add("Debe ingresar el nombre de la CAAC");
        if(hojaDatosInicialesDTO.getProvinciaLight() == null)
            messages.add("Debe seleccionar una provincia");
        return messages.isEmpty() ? new AppResponse() : new AppResponse(AppResponse.ERROR, messages);
    }
}
