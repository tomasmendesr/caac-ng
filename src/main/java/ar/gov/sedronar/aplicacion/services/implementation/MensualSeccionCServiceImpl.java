package ar.gov.sedronar.aplicacion.services.implementation;

import ar.gov.sedronar.aplicacion.dto.*;
import ar.gov.sedronar.aplicacion.services.interfaces.*;
import ar.gov.sedronar.util.app.AppResponse;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 * Created by TMR on 18/09/2018.
 */
@Stateless
@Transactional
@DefaultServiceImpl
public class MensualSeccionCServiceImpl implements MensualSeccionCService {
    // la única funcionalidad de estas constantes es la declaratividad para que se entiendan qué son
    public static final Integer SECCION_1_FORMULARIO = 1;
    public static final Integer SECCION_2_FORMULARIO = 2;
    public static final Integer SECCION_3_FORMULARIO = 3;
    public static final Integer SECCION_4_FORMULARIO = 4;
    public static final Integer SECCION_5_FORMULARIO = 5;
    public static final Integer SECCION_6_FORMULARIO = 6;

    @Inject
    @DefaultServiceImpl
    private HojaMensualObservacionesService hojaMensualObservacionesService;

    @Inject
    @DefaultServiceImpl
    private HojaMensualAlimentacionService hojaMensualAlimentacionService;

    @Inject
    @DefaultServiceImpl
    private HojaMensualTramitesService hojaMensualTramitesService;

    @Inject
    @DefaultServiceImpl
    private HojaMensualActividadService hojaMensualActividadService;

    @Inject
    @DefaultServiceImpl
    private HojaMensualAcompaniamientoService hojaMensualAcompaniamientoService;

    /***
     * Si falló una validación retorna un app response con error code y en el atributo data
    * contiene otro app response con el code que identifica a la sección del formulario que falló y la lista de errores de validación
    * Si no hay errores de validación se realiza el update en la base. En caso de que ocurra un error lanza una excepción
     * que es capturada en el front y mostrada en una notificación.
     */
    @Override
    public AppResponse saveOrUpdateSeccionC1(MensualSeccionC1Data data) throws Exception {
        AppResponse validationTramites = hojaMensualTramitesService.validateInputs(data.getHojaMensualTramitesList());
        if(validationTramites.getCode() == AppResponse.ERROR) return new AppResponse(AppResponse.ERROR, new AppResponse(SECCION_1_FORMULARIO, validationTramites.getData()));

        AppResponse validationAlimentacioEnSede = hojaMensualAlimentacionService.validateInputsEnSede(data.getHojaMensualAlimentacionList());
        if(validationAlimentacioEnSede.getCode() == AppResponse.ERROR) return new AppResponse(AppResponse.ERROR, new AppResponse(SECCION_3_FORMULARIO, validationAlimentacioEnSede.getData()));

        AppResponse validationAlimentacioFueraDeSede = hojaMensualAlimentacionService.validateInputsFueraDeSede(data.getHojaMensualAlimentacionList());
        if(validationAlimentacioFueraDeSede.getCode() == AppResponse.ERROR) return new AppResponse(AppResponse.ERROR, new AppResponse(SECCION_5_FORMULARIO, validationAlimentacioFueraDeSede.getData()));

        for (HojaMensualTramitesDTO hojaMensualTramitesDTO : data.getHojaMensualTramitesList()) hojaMensualTramitesService.saveOrUpdate(hojaMensualTramitesDTO);
        for (HojaMensualAlimentacionDTO hojaMensualAlimentacionDTO : data.getHojaMensualAlimentacionList()) hojaMensualAlimentacionService.saveOrUpdate(hojaMensualAlimentacionDTO);
        hojaMensualObservacionesService.saveOrUpdate(data.getHojaMensualObservaciones());
        return new AppResponse();
    }

    @Override
    public MensualSeccionC1Data getDataForSeccionC1ByHojaId(Long idHoja) {
        MensualSeccionC1Data data = new MensualSeccionC1Data();
        data.setHojaMensualObservaciones(hojaMensualObservacionesService.findByHojaId(idHoja));
        data.setHojaMensualAlimentacionList(hojaMensualAlimentacionService.findListByHojaId(idHoja));
        data.setHojaMensualTramitesList(hojaMensualTramitesService.findListByHojaId(idHoja));
        return data;
    }

    @Override
    public AppResponse saveOrUpdateSeccionC2(MensualSeccionC2Data data) throws Exception {
        AppResponse validationActividadesFamiliares = hojaMensualActividadService.validateInputsActividadesFamiliares(data.getHojaMensualActividad());
        if(validationActividadesFamiliares.getCode() == AppResponse.ERROR) return new AppResponse(AppResponse.ERROR, new AppResponse(SECCION_1_FORMULARIO, validationActividadesFamiliares.getData()));

        AppResponse validationIntervencionEnCalle = hojaMensualActividadService.validateInputsIntervencionEnCalle(data.getHojaMensualActividad());
        if(validationIntervencionEnCalle.getCode() == AppResponse.ERROR) return new AppResponse(AppResponse.ERROR, new AppResponse(SECCION_3_FORMULARIO, validationIntervencionEnCalle.getData()));

        AppResponse validationAcompaniamiento = hojaMensualAcompaniamientoService.validateInputs(data.getHojaMensualAcompaniamientoList());
        if(validationAcompaniamiento.getCode() == AppResponse.ERROR) return new AppResponse(AppResponse.ERROR, new AppResponse(SECCION_5_FORMULARIO, validationAcompaniamiento.getData()));

        for (HojaMensualAcompaniamientoDTO hojaMensualAcompaniamientoDTO : data.getHojaMensualAcompaniamientoList()) hojaMensualAcompaniamientoService.saveOrUpdate(hojaMensualAcompaniamientoDTO);
        hojaMensualObservacionesService.saveOrUpdate(data.getHojaMensualObservaciones());
        hojaMensualActividadService.saveOrUpdate(data.getHojaMensualActividad());
        return new AppResponse();
    }

    @Override
    public MensualSeccionC2Data getDataForSeccionC2ByHojaId(Long idHoja) {
        return null;
    }
}
