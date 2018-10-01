package ar.gov.sedronar.aplicacion.services.implementation;

import ar.gov.sedronar.aplicacion.dto.*;
import ar.gov.sedronar.aplicacion.services.interfaces.*;
import ar.gov.sedronar.util.app.AppResponse;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    @Inject
    @DefaultServiceImpl
    private HojaMensualRecursosService hojaMensualRecursosService;

    @Inject
    @DefaultServiceImpl
    private AcompaniamientoService acompaniamientoService;

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

        if(data.getHojaMensualObservaciones().getActividadesFamiliares() != null && StringUtils.isNotBlank(data.getHojaMensualObservaciones().getActividadesFamiliares()) && data.getHojaMensualObservaciones().getActividadesFamiliares().length() > 500) return new AppResponse(AppResponse.ERROR, new AppResponse(SECCION_2_FORMULARIO, Arrays.asList("Las observaciones no pueden tener más de 500 caracteres")));

        AppResponse validationAlimentacionEnSede = hojaMensualAlimentacionService.validateInputsEnSede(data.getHojaMensualAlimentacionEnSedeList());
        if(validationAlimentacionEnSede.getCode() == AppResponse.ERROR) return new AppResponse(AppResponse.ERROR, new AppResponse(SECCION_3_FORMULARIO, validationAlimentacionEnSede.getData()));

        if(data.getHojaMensualObservaciones().getAlimentacionEnSede() != null && StringUtils.isNotBlank(data.getHojaMensualObservaciones().getAlimentacionEnSede()) && data.getHojaMensualObservaciones().getAlimentacionEnSede().length() > 500) return new AppResponse(AppResponse.ERROR, new AppResponse(SECCION_4_FORMULARIO, Arrays.asList("Las observaciones no pueden tener más de 500 caracteres")));

        AppResponse validationAlimentacioFueraDeSede = hojaMensualAlimentacionService.validateInputsFueraDeSede(data.getHojaMensualAlimentacionFueraDeSedeList());
        if(validationAlimentacioFueraDeSede.getCode() == AppResponse.ERROR) return new AppResponse(AppResponse.ERROR, new AppResponse(SECCION_5_FORMULARIO, validationAlimentacioFueraDeSede.getData()));

        if(data.getHojaMensualObservaciones().getAlimentacionFueraDeSede() != null && StringUtils.isNotBlank(data.getHojaMensualObservaciones().getAlimentacionFueraDeSede()) && data.getHojaMensualObservaciones().getAlimentacionFueraDeSede().length() > 500) return new AppResponse(AppResponse.ERROR, new AppResponse(SECCION_6_FORMULARIO, Arrays.asList("Las observaciones no pueden tener más de 500 caracteres")));

        for (HojaMensualTramitesDTO hojaMensualTramitesDTO : data.getHojaMensualTramitesList()) hojaMensualTramitesService.saveOrUpdate(hojaMensualTramitesDTO);
        for (HojaMensualAlimentacionDTO hojaMensualAlimentacionDTO : data.getHojaMensualAlimentacionEnSedeList()) hojaMensualAlimentacionService.saveOrUpdate(hojaMensualAlimentacionDTO);
        for (HojaMensualAlimentacionDTO hojaMensualAlimentacionDTO : data.getHojaMensualAlimentacionFueraDeSedeList()) hojaMensualAlimentacionService.saveOrUpdate(hojaMensualAlimentacionDTO);
        hojaMensualObservacionesService.saveOrUpdate(data.getHojaMensualObservaciones());
        return new AppResponse();
    }

    @Override
    public MensualSeccionC1Data getDataForSeccionC1ByHojaId(Long idHoja) {
        MensualSeccionC1Data data = new MensualSeccionC1Data();
        data.setHojaMensualObservaciones(hojaMensualObservacionesService.findByHojaId(idHoja));
        data.setHojaMensualAlimentacionEnSedeList(hojaMensualAlimentacionService.findListByHojaIdAndClasificacion(idHoja, AlimentacionServiceImpl.EN_SEDE));
        data.setHojaMensualAlimentacionFueraDeSedeList(hojaMensualAlimentacionService.findListByHojaIdAndClasificacion(idHoja, AlimentacionServiceImpl.FUERA_DE_SEDE));
        data.setHojaMensualTramitesList(hojaMensualTramitesService.findListByHojaId(idHoja));
        return data;
    }

    @Override
    public AppResponse saveOrUpdateSeccionC2(MensualSeccionC2Data data) throws Exception {
        AppResponse validationActividadesFamiliares = hojaMensualActividadService.validateInputsActividadesFamiliares(data.getHojaMensualActividad());
        if(validationActividadesFamiliares.getCode() == AppResponse.ERROR) return new AppResponse(AppResponse.ERROR, new AppResponse(SECCION_1_FORMULARIO, validationActividadesFamiliares.getData()));

        AppResponse validationIntervencionEnCalle = hojaMensualActividadService.validateInputsIntervencionEnCalle(data.getHojaMensualActividad());
        if(validationIntervencionEnCalle.getCode() == AppResponse.ERROR) return new AppResponse(AppResponse.ERROR, new AppResponse(SECCION_3_FORMULARIO, validationIntervencionEnCalle.getData()));

        AppResponse validationAcompaniamiento = hojaMensualAcompaniamientoService.validateInputs(data.getHojaMensualAcompaniamientoList(),true,true);
        if(validationAcompaniamiento.getCode() == AppResponse.ERROR) return new AppResponse(AppResponse.ERROR, new AppResponse(SECCION_5_FORMULARIO, validationAcompaniamiento.getData()));

        for (HojaMensualAcompaniamientoDTO hojaMensualAcompaniamientoDTO : data.getHojaMensualAcompaniamientoList()) hojaMensualAcompaniamientoService.saveOrUpdate(hojaMensualAcompaniamientoDTO);
        hojaMensualObservacionesService.saveOrUpdate(data.getHojaMensualObservaciones());
        hojaMensualActividadService.saveOrUpdate(data.getHojaMensualActividad());
        return new AppResponse();
    }

    @Override
    public MensualSeccionC2Data getDataForSeccionC2ByHojaId(Long idHoja) {
        MensualSeccionC2Data data = new MensualSeccionC2Data();
        data.setHojaMensualObservaciones(hojaMensualObservacionesService.findByHojaId(idHoja));
        data.setHojaMensualActividad(hojaMensualActividadService.findByHojaId(idHoja));
        List<Integer> idsAcompaniamientos = acompaniamientoService.findAllEstablecimientosDeSaludAndTipoAcompaniamiento().stream().map(a -> a.getId()).collect(Collectors.toList());
        data.setHojaMensualAcompaniamientoList(hojaMensualAcompaniamientoService.findListByHojaAndAcompaniamientoId(idHoja,idsAcompaniamientos));
        return data;
    }

    @Override
    public AppResponse saveOrUpdateSeccionC3(MensualSeccionC3Data data) throws Exception {
        AppResponse validateGestion = hojaMensualAcompaniamientoService.validateInputs(data.getHojaMensualAcompaniamientoTipoGestionList(),true,true);
        if(validateGestion.getCode() == AppResponse.ERROR) return new AppResponse(AppResponse.ERROR, new AppResponse(SECCION_1_FORMULARIO, validateGestion.getData()));

        if(StringUtils.isNotBlank(data.getHojaMensualObservaciones().getGestionesEstablecimientoSalud()) && data.getHojaMensualObservaciones().getGestionesEstablecimientoSalud().length() > 500) return new AppResponse(AppResponse.ERROR, new AppResponse(SECCION_2_FORMULARIO, Arrays.asList("Las observaciones no pueden tener más de 500 caracteres")));

        AppResponse validateEstablecimientoComunidadTerapeutica = hojaMensualAcompaniamientoService.validateInputs(data.getHojaMensualAcompaniamientoEstablComuTerapeuticaList(),true,true);
        if(validateEstablecimientoComunidadTerapeutica.getCode() == AppResponse.ERROR) return new AppResponse(AppResponse.ERROR, new AppResponse(SECCION_3_FORMULARIO, validateEstablecimientoComunidadTerapeutica.getData()));

        if(StringUtils.isNotBlank(data.getHojaMensualObservaciones().getAcompaniamientoCentroEspecial()) && data.getHojaMensualObservaciones().getAcompaniamientoCentroEspecial().length() > 500) return new AppResponse(AppResponse.ERROR, new AppResponse(SECCION_4_FORMULARIO, Arrays.asList("Las observaciones no pueden tener más de 500 caracteres")));

        AppResponse validateEstablecimientoPatrocinioLegal = hojaMensualAcompaniamientoService.validateInputs(data.getHojaMensualAcompaniamientoEstablPatrocinioLegalList(), true,true);
        if(validateEstablecimientoPatrocinioLegal.getCode() == AppResponse.ERROR) return new AppResponse(AppResponse.ERROR, new AppResponse(SECCION_5_FORMULARIO, validateEstablecimientoPatrocinioLegal.getData()));

        if(StringUtils.isNotBlank(data.getHojaMensualObservaciones().getAsesoramientoLegal()) && data.getHojaMensualObservaciones().getAsesoramientoLegal().length() > 500) return new AppResponse(AppResponse.ERROR, new AppResponse(SECCION_6_FORMULARIO, Arrays.asList("Las observaciones no pueden tener más de 500 caracteres")));

        for (HojaMensualAcompaniamientoDTO hojaMensualAcompaniamientoDTO : data.getHojaMensualAcompaniamientoTipoGestionList()) hojaMensualAcompaniamientoService.saveOrUpdate(hojaMensualAcompaniamientoDTO);
        for (HojaMensualAcompaniamientoDTO hojaMensualAcompaniamientoDTO : data.getHojaMensualAcompaniamientoEstablComuTerapeuticaList()) hojaMensualAcompaniamientoService.saveOrUpdate(hojaMensualAcompaniamientoDTO);
        for (HojaMensualAcompaniamientoDTO hojaMensualAcompaniamientoDTO : data.getHojaMensualAcompaniamientoEstablPatrocinioLegalList()) hojaMensualAcompaniamientoService.saveOrUpdate(hojaMensualAcompaniamientoDTO);
        hojaMensualObservacionesService.saveOrUpdate(data.getHojaMensualObservaciones());
        return new AppResponse();
    }

    @Override
    public MensualSeccionC3Data getDataForSeccionC3ByHojaId(Long idHoja) {
        MensualSeccionC3Data data = new MensualSeccionC3Data();

        data.setHojaMensualObservaciones(hojaMensualObservacionesService.findByHojaId(idHoja));

        List<Integer> idsAcompTipoGestion = acompaniamientoService.findAllEstablecimientosDeSaludAndTipoGestion().stream().map(a -> a.getId()).collect(Collectors.toList());
        data.setHojaMensualAcompaniamientoTipoGestionList(hojaMensualAcompaniamientoService.findListByHojaAndAcompaniamientoId(idHoja, idsAcompTipoGestion));

        List<Integer> idsAcompEstComuTerapeutica = acompaniamientoService.findAllEstablecimientosComunuidadTerapeutica().stream().map(a -> a.getId()).collect(Collectors.toList());
        data.setHojaMensualAcompaniamientoEstablComuTerapeuticaList(hojaMensualAcompaniamientoService.findListByHojaAndAcompaniamientoId(idHoja, idsAcompEstComuTerapeutica));

        List<Integer> idsAcompEstPatrocinioLegal = acompaniamientoService.findAllEstablecimientosPatrocinioLegal().stream().map(a -> a.getId()).collect(Collectors.toList());
        data.setHojaMensualAcompaniamientoEstablPatrocinioLegalList(hojaMensualAcompaniamientoService.findListByHojaAndAcompaniamientoId(idHoja, idsAcompEstPatrocinioLegal));

        return data;
    }

    @Override
    public AppResponse saveOrUpdateSeccionC4(MensualSeccionC4Data data) throws Exception {
        AppResponse validateAcompaniamientosEnComisariasYPenales = hojaMensualAcompaniamientoService.validateInputs(data.getHojaMensualAcompEstPenalesTipoAcompList(), true, true);
        if(validateAcompaniamientosEnComisariasYPenales.getCode() == AppResponse.ERROR) return new AppResponse(AppResponse.ERROR, new AppResponse(SECCION_1_FORMULARIO, validateAcompaniamientosEnComisariasYPenales.getData()));

        AppResponse validatePersonasActividadPenales = hojaMensualAcompaniamientoService.validateInputs(data.getHojaMensualAcompEstPenalesTipoActividadesList(), false, true);
        if(validatePersonasActividadPenales.getCode() == AppResponse.ERROR) return new AppResponse(AppResponse.ERROR, new AppResponse(SECCION_2_FORMULARIO, validatePersonasActividadPenales.getData()));

        if(data.getHojaMensualObservaciones().getActividadesTalleresComisaria() != null && StringUtils.isNotBlank(data.getHojaMensualObservaciones().getActividadesTalleresComisaria()) && data.getHojaMensualObservaciones().getActividadesTalleresComisaria().length() > 500) return new AppResponse(AppResponse.ERROR, new AppResponse(SECCION_3_FORMULARIO, Arrays.asList("Las observaciones no pueden tener más de 500 caracteres")));

        if(data.getHojaMensualObservaciones().getActividadesProductivasComisaria() != null && StringUtils.isNotBlank(data.getHojaMensualObservaciones().getActividadesProductivasComisaria()) && data.getHojaMensualObservaciones().getActividadesProductivasComisaria().length() > 500) return new AppResponse(AppResponse.ERROR, new AppResponse(SECCION_4_FORMULARIO, Arrays.asList("Las observaciones no pueden tener más de 500 caracteres")));

        if(data.getHojaMensualObservaciones().getActividadesCapacitacionComisaria() != null && StringUtils.isNotBlank(data.getHojaMensualObservaciones().getActividadesCapacitacionComisaria()) && data.getHojaMensualObservaciones().getActividadesCapacitacionComisaria().length() > 500) return new AppResponse(AppResponse.ERROR, new AppResponse(SECCION_4_FORMULARIO, Arrays.asList("Las observaciones no pueden tener más de 500 caracteres")));

        for (HojaMensualAcompaniamientoDTO hojaMensualAcompaniamientoDTO : data.getHojaMensualAcompEstPenalesTipoAcompList()) hojaMensualAcompaniamientoService.saveOrUpdate(hojaMensualAcompaniamientoDTO);
        for (HojaMensualAcompaniamientoDTO hojaMensualAcompaniamientoDTO : data.getHojaMensualAcompEstPenalesTipoActividadesList()) hojaMensualAcompaniamientoService.saveOrUpdate(hojaMensualAcompaniamientoDTO);
        hojaMensualObservacionesService.saveOrUpdate(data.getHojaMensualObservaciones());
        return new AppResponse();    }

    @Override
    public MensualSeccionC4Data getDataForSeccionC4ByHojaId(Long idHoja) {
        MensualSeccionC4Data data = new MensualSeccionC4Data();
        data.setHojaMensualObservaciones(hojaMensualObservacionesService.findByHojaId(idHoja));
        List<Integer> idsAcompEstPenalesTipoAcomp = acompaniamientoService.findAllEstablecimientosPenalesAndTipoAcompaniamiento().stream().map(a -> a.getId()).collect(Collectors.toList());
        data.setHojaMensualAcompEstPenalesTipoAcompList(hojaMensualAcompaniamientoService.findListByHojaAndAcompaniamientoId(idHoja,idsAcompEstPenalesTipoAcomp));

        List<Integer> idsAcompEstPenalesTipoAct = acompaniamientoService.findAllEstablecimientosPenalesAndTipoActividades().stream().map(a -> a.getId()).collect(Collectors.toList());
        data.setHojaMensualAcompEstPenalesTipoActividadesList(hojaMensualAcompaniamientoService.findListByHojaAndAcompaniamientoId(idHoja,idsAcompEstPenalesTipoAct));

        return data;
    }

    @Override
    public AppResponse saveOrUpdateSeccionC5(MensualSeccionC5Data data) throws Exception {
        AppResponse validateProfesionalDeSalud = hojaMensualAcompaniamientoService.validateInputs(data.getHojaMensualAcompaniamientoEstabProfSaludList(),  true, true);
        if(validateProfesionalDeSalud.getCode() == AppResponse.ERROR) return new AppResponse(AppResponse.ERROR, new AppResponse(SECCION_1_FORMULARIO, validateProfesionalDeSalud.getData()));

        if(data.getHojaMensualObservaciones().getAcompaniamientoProfesionalSalud() != null && StringUtils.isNotBlank(data.getHojaMensualObservaciones().getAcompaniamientoProfesionalSalud()) && data.getHojaMensualObservaciones().getAcompaniamientoProfesionalSalud().length() > 500) return new AppResponse(AppResponse.ERROR, new AppResponse(SECCION_2_FORMULARIO, Arrays.asList("Las observaciones no pueden tener más de 500 caracteres")));

        AppResponse validateRecursos = hojaMensualRecursosService.validateInputs(data.getHojaMensualRecursoList());
        if(validateRecursos.getCode() == AppResponse.ERROR) return new AppResponse(AppResponse.ERROR, new AppResponse(SECCION_3_FORMULARIO, validateRecursos.getData()));

        AppResponse validateTrayectorias = hojaMensualAcompaniamientoService.validateInputs(data.getHojaMensualAcompaniamientoEstabTrayEducativaList(), false, true);
        if(validateTrayectorias.getCode() == AppResponse.ERROR) return new AppResponse(AppResponse.ERROR, new AppResponse(SECCION_4_FORMULARIO, validateTrayectorias.getData()));

        if(data.getHojaMensualObservaciones().getAcompaniamientoTrayectoriaEducativa() != null && StringUtils.isNotBlank(data.getHojaMensualObservaciones().getAcompaniamientoTrayectoriaEducativa()) && data.getHojaMensualObservaciones().getAcompaniamientoTrayectoriaEducativa().length() > 500) return new AppResponse(AppResponse.ERROR, new AppResponse(SECCION_5_FORMULARIO, Arrays.asList("Las observaciones no pueden tener más de 500 caracteres")));

        for (HojaMensualAcompaniamientoDTO hojaMensualAcompaniamientoDTO : data.getHojaMensualAcompaniamientoEstabProfSaludList()) hojaMensualAcompaniamientoService.saveOrUpdate(hojaMensualAcompaniamientoDTO);
        for (HojaMensualAcompaniamientoDTO hojaMensualAcompaniamientoDTO : data.getHojaMensualAcompaniamientoEstabTrayEducativaList()) hojaMensualAcompaniamientoService.saveOrUpdate(hojaMensualAcompaniamientoDTO);
        for (HojaMensualRecursosDTO hojaMensualRecursosDTO : data.getHojaMensualRecursoList()) hojaMensualRecursosService.saveOrUpdate(hojaMensualRecursosDTO);
        hojaMensualObservacionesService.saveOrUpdate(data.getHojaMensualObservaciones());
        return new AppResponse();
    }

    @Override
    public MensualSeccionC5Data getDataForSeccionC5ByHojaId(Long idHoja) {
        MensualSeccionC5Data data = new MensualSeccionC5Data();
        data.setHojaMensualObservaciones(hojaMensualObservacionesService.findByHojaId(idHoja));

        List<Integer> idsAcompEstProfSalud = acompaniamientoService.findAllEstablecimientoProfesionalDeSalud().stream().map(a -> a.getId()).collect(Collectors.toList());
        data.setHojaMensualAcompaniamientoEstabProfSaludList(hojaMensualAcompaniamientoService.findListByHojaAndAcompaniamientoId(idHoja,idsAcompEstProfSalud));

        List<Integer> idsAcompEstTrayEduc = acompaniamientoService.findAllEstablecimientoTrayectoriasEducativas().stream().map(a -> a.getId()).collect(Collectors.toList());
        data.setHojaMensualAcompaniamientoEstabTrayEducativaList(hojaMensualAcompaniamientoService.findListByHojaAndAcompaniamientoId(idHoja,idsAcompEstTrayEduc));

        data.setHojaMensualRecursoList(hojaMensualRecursosService.findByHojaId(idHoja));
        return data;
    }
}
