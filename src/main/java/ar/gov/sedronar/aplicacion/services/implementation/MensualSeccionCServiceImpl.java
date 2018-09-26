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

        // TODO - implementar esta validación
        if(StringUtils.isNotBlank(data.getHojaMensualObservaciones().getActividadesFamiliares()) && data.getHojaMensualObservaciones().getActividadesFamiliares().length() > 500) return new AppResponse(AppResponse.ERROR, new AppResponse(SECCION_2_FORMULARIO, Arrays.asList("Las observaciones no pueden tener más de 500 caracteres")));

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
        MensualSeccionC2Data data = new MensualSeccionC2Data();
        data.setHojaMensualObservaciones(hojaMensualObservacionesService.findByHojaId(idHoja));
        data.setHojaMensualActividad(hojaMensualActividadService.findByHojaId(idHoja));
        List<Integer> idsAcompaniamientos = Arrays.asList(AcompaniamientoServiceImpl.ID_EST_SALUD_INTERVENCION, AcompaniamientoServiceImpl.ID_ESTB_SALUD_CONSULTORIOS,AcompaniamientoServiceImpl.ID_ESTB_SALUD_DESINTOXICACION, AcompaniamientoServiceImpl.ID_ESTB_SALUD_EMERGENCIAS);
        data.setHojaMensualAcompaniamientoList(hojaMensualAcompaniamientoService.findListByHojaAndAcompaniamientoId(idHoja,idsAcompaniamientos));
        return data;
    }

    @Override
    public AppResponse saveOrUpdateSeccionC3(MensualSeccionC3Data data) throws Exception {
        AppResponse validateGestionEnEstablecimientoDeSalud = hojaMensualAcompaniamientoService.validateInputsEnEstablecimiento(data.getHojaMensualAcompaniamientoList(), AcompaniamientoServiceImpl.ESTABLECIMIENTO_DE_SALUD, true,true);
        if(validateGestionEnEstablecimientoDeSalud.getCode() == AppResponse.ERROR) return new AppResponse(AppResponse.ERROR, new AppResponse(SECCION_1_FORMULARIO, validateGestionEnEstablecimientoDeSalud.getData()));

        if(StringUtils.isNotBlank(data.getHojaMensualObservaciones().getGestionesEstablecimientoSalud()) && data.getHojaMensualObservaciones().getGestionesEstablecimientoSalud().length() > 500) return new AppResponse(AppResponse.ERROR, new AppResponse(SECCION_2_FORMULARIO, Arrays.asList("Las observaciones no pueden tener más de 500 caracteres")));

        AppResponse validateEstablecimientoComunidadTerapeutica = hojaMensualAcompaniamientoService.validateInputsEnEstablecimiento(data.getHojaMensualAcompaniamientoList(),  AcompaniamientoServiceImpl.COMUNIDAD_TERAPEUTICA,true,true);
        if(validateEstablecimientoComunidadTerapeutica.getCode() == AppResponse.ERROR) return new AppResponse(AppResponse.ERROR, new AppResponse(SECCION_3_FORMULARIO, validateEstablecimientoComunidadTerapeutica.getData()));

        if(StringUtils.isNotBlank(data.getHojaMensualObservaciones().getAcompaniamientoCentroEspecial()) && data.getHojaMensualObservaciones().getAcompaniamientoCentroEspecial().length() > 500) return new AppResponse(AppResponse.ERROR, new AppResponse(SECCION_4_FORMULARIO, Arrays.asList("Las observaciones no pueden tener más de 500 caracteres")));

        AppResponse validateEstablecimientoPatrocinioLegal = hojaMensualAcompaniamientoService.validateInputsEnEstablecimiento(data.getHojaMensualAcompaniamientoList(),  AcompaniamientoServiceImpl.PATROCINIO_LEGAL,true,true);
        if(validateEstablecimientoPatrocinioLegal.getCode() == AppResponse.ERROR) return new AppResponse(AppResponse.ERROR, new AppResponse(SECCION_5_FORMULARIO, validateEstablecimientoPatrocinioLegal.getData()));

        if(StringUtils.isNotBlank(data.getHojaMensualObservaciones().getAsesoramientoLegal()) && data.getHojaMensualObservaciones().getAsesoramientoLegal().length() > 500) return new AppResponse(AppResponse.ERROR, new AppResponse(SECCION_6_FORMULARIO, Arrays.asList("Las observaciones no pueden tener más de 500 caracteres")));

        for (HojaMensualAcompaniamientoDTO hojaMensualAcompaniamientoDTO : data.getHojaMensualAcompaniamientoList()) hojaMensualAcompaniamientoService.saveOrUpdate(hojaMensualAcompaniamientoDTO);
        hojaMensualObservacionesService.saveOrUpdate(data.getHojaMensualObservaciones());
        return new AppResponse();
    }

    @Override
    public MensualSeccionC3Data getDataForSeccionC3ByHojaId(Long idHoja) {
        MensualSeccionC3Data data = new MensualSeccionC3Data();
        data.setHojaMensualObservaciones(hojaMensualObservacionesService.findByHojaId(idHoja));
        List<Integer> idsAcompaniamientos = Arrays.asList(AcompaniamientoServiceImpl.ID_ESTB_SALUD_GESTION_DE_TURNOS, AcompaniamientoServiceImpl.ID_ESTB_SALUD_GESTION_DE_TRAMITES,AcompaniamientoServiceImpl.ID_ESTB_SALUD_GESTION_DE_SERVICIOS,
                AcompaniamientoServiceImpl.ID_ACOMP_CENTRO_ESPECIALIZADO, AcompaniamientoServiceImpl.ID_GESTION_SIN_SUBSIDIO,
                AcompaniamientoServiceImpl.ID_GESTION_CON_SUBSIDIO, AcompaniamientoServiceImpl.ID_GESTION_EN_SEDE,
                AcompaniamientoServiceImpl.ID_GESTION_FUERA_DE_SEDE);
        data.setHojaMensualAcompaniamientoList(hojaMensualAcompaniamientoService.findListByHojaAndAcompaniamientoId(idHoja,idsAcompaniamientos));
        return data;
    }

    @Override
    public AppResponse saveOrUpdateSeccionC4(MensualSeccionC4Data data) throws Exception {
        AppResponse validateAcompaniamientosEnComisariasYPenales = hojaMensualAcompaniamientoService.validateInputsByEstablecimientoAndTipo(data.getHojaMensualAcompaniamientoList(), AcompaniamientoServiceImpl.ESTABLECIMIENTO_PENALES_COMISARIAS, AcompaniamientoServiceImpl.TIPO_ACOMPANIAMIENTO, true, true);
        if(validateAcompaniamientosEnComisariasYPenales.getCode() == AppResponse.ERROR) return new AppResponse(AppResponse.ERROR, new AppResponse(SECCION_1_FORMULARIO, validateAcompaniamientosEnComisariasYPenales.getData()));

        AppResponse validatePersonasActividadPenales = hojaMensualAcompaniamientoService.validateInputsByEstablecimientoAndTipo(data.getHojaMensualAcompaniamientoList(), AcompaniamientoServiceImpl.ESTABLECIMIENTO_PENALES_COMISARIAS, AcompaniamientoServiceImpl.TIPO_ACTIVIDADES, false, true);
        if(validatePersonasActividadPenales.getCode() == AppResponse.ERROR) return new AppResponse(AppResponse.ERROR, new AppResponse(SECCION_2_FORMULARIO, validatePersonasActividadPenales.getData()));

        if(data.getHojaMensualObservaciones().getActividadesTalleresComisaria() != null && StringUtils.isNotBlank(data.getHojaMensualObservaciones().getActividadesTalleresComisaria()) && data.getHojaMensualObservaciones().getActividadesTalleresComisaria().length() > 500) return new AppResponse(AppResponse.ERROR, new AppResponse(SECCION_3_FORMULARIO, Arrays.asList("Las observaciones no pueden tener más de 500 caracteres")));

        if(data.getHojaMensualObservaciones().getActividadesProductivasComisaria() != null && StringUtils.isNotBlank(data.getHojaMensualObservaciones().getActividadesProductivasComisaria()) && data.getHojaMensualObservaciones().getActividadesProductivasComisaria().length() > 500) return new AppResponse(AppResponse.ERROR, new AppResponse(SECCION_4_FORMULARIO, Arrays.asList("Las observaciones no pueden tener más de 500 caracteres")));

        if(data.getHojaMensualObservaciones().getActividadesCapacitacionComisaria() != null && StringUtils.isNotBlank(data.getHojaMensualObservaciones().getActividadesCapacitacionComisaria()) && data.getHojaMensualObservaciones().getActividadesCapacitacionComisaria().length() > 500) return new AppResponse(AppResponse.ERROR, new AppResponse(SECCION_4_FORMULARIO, Arrays.asList("Las observaciones no pueden tener más de 500 caracteres")));

        for (HojaMensualAcompaniamientoDTO hojaMensualAcompaniamientoDTO : data.getHojaMensualAcompaniamientoList()) hojaMensualAcompaniamientoService.saveOrUpdate(hojaMensualAcompaniamientoDTO);
        hojaMensualObservacionesService.saveOrUpdate(data.getHojaMensualObservaciones());
        return new AppResponse();    }

    @Override
    public MensualSeccionC4Data getDataForSeccionC4ByHojaId(Long idHoja) {
        MensualSeccionC4Data data = new MensualSeccionC4Data();
        data.setHojaMensualObservaciones(hojaMensualObservacionesService.findByHojaId(idHoja));
        List<Integer> idsAcompaniamientos = Arrays.asList(AcompaniamientoServiceImpl.ID_ACOMPAÑAMIENTO_COMISARIAS, AcompaniamientoServiceImpl.ID_ACOMPAÑAMIENTO_PENALES,AcompaniamientoServiceImpl.ID_PENALES_COMISARIAS_TALLERES,
                AcompaniamientoServiceImpl.ID_PENALES_COMISARIAS_ACT_PROD, AcompaniamientoServiceImpl.ID_PENALES_COMISARIAS_CAPACITACION);
        data.setHojaMensualAcompaniamientoList(hojaMensualAcompaniamientoService.findListByHojaAndAcompaniamientoId(idHoja,idsAcompaniamientos));
        return data;
    }

    @Override
    public AppResponse saveOrUpdateSeccionC5(MensualSeccionC5Data data) throws Exception {
        AppResponse validateProfesionalDeSalud = hojaMensualAcompaniamientoService.validateInputsEnEstablecimiento(data.getHojaMensualAcompaniamientoList(), AcompaniamientoServiceImpl.ESTABLECIMIENTO_PROFESIONAL_DE_SALUD, true, true);
        if(validateProfesionalDeSalud.getCode() == AppResponse.ERROR) return new AppResponse(AppResponse.ERROR, new AppResponse(SECCION_1_FORMULARIO, validateProfesionalDeSalud.getData()));

        if(data.getHojaMensualObservaciones().getAcompaniamientoProfesionalSalud() != null && StringUtils.isNotBlank(data.getHojaMensualObservaciones().getAcompaniamientoProfesionalSalud()) && data.getHojaMensualObservaciones().getAcompaniamientoProfesionalSalud().length() > 500) return new AppResponse(AppResponse.ERROR, new AppResponse(SECCION_2_FORMULARIO, Arrays.asList("Las observaciones no pueden tener más de 500 caracteres")));

        AppResponse validateRecursos = hojaMensualRecursosService.validateInputs(data.getHojaMensualRecursoList());
        if(validateRecursos.getCode() == AppResponse.ERROR) return new AppResponse(AppResponse.ERROR, new AppResponse(SECCION_3_FORMULARIO, validateRecursos.getData()));

        AppResponse validateTrayectorias = hojaMensualAcompaniamientoService.validateInputsEnEstablecimiento(data.getHojaMensualAcompaniamientoList(), AcompaniamientoServiceImpl.ESTABLECIMIENTO_TRAYECTORIAS_EDUCATIVAS, false, true);
        if(validateTrayectorias.getCode() == AppResponse.ERROR) return new AppResponse(AppResponse.ERROR, new AppResponse(SECCION_4_FORMULARIO, validateTrayectorias.getData()));

        if(data.getHojaMensualObservaciones().getAcompaniamientoTrayectoriaEducativa() != null && StringUtils.isNotBlank(data.getHojaMensualObservaciones().getAcompaniamientoTrayectoriaEducativa()) && data.getHojaMensualObservaciones().getAcompaniamientoTrayectoriaEducativa().length() > 500) return new AppResponse(AppResponse.ERROR, new AppResponse(SECCION_5_FORMULARIO, Arrays.asList("Las observaciones no pueden tener más de 500 caracteres")));

        for (HojaMensualAcompaniamientoDTO hojaMensualAcompaniamientoDTO : data.getHojaMensualAcompaniamientoList()) hojaMensualAcompaniamientoService.saveOrUpdate(hojaMensualAcompaniamientoDTO);
        for (HojaMensualRecursosDTO hojaMensualRecursosDTO : data.getHojaMensualRecursoList()) hojaMensualRecursosService.saveOrUpdate(hojaMensualRecursosDTO);
        hojaMensualObservacionesService.saveOrUpdate(data.getHojaMensualObservaciones());
        return new AppResponse();
    }

    @Override
    public MensualSeccionC5Data getDataForSeccionC5ByHojaId(Long idHoja) {
        MensualSeccionC5Data data = new MensualSeccionC5Data();
        data.setHojaMensualObservaciones(hojaMensualObservacionesService.findByHojaId(idHoja));

        List<Integer> idsAcompaniamientos = new ArrayList<>();
        for(int i = AcompaniamientoServiceImpl.ID_TERAPIA_INDIVIDUAL; i<=AcompaniamientoServiceImpl.ID_ESCUELA_EN_SEDE; i++) idsAcompaniamientos.add(i);
        data.setHojaMensualAcompaniamientoList(hojaMensualAcompaniamientoService.findListByHojaAndAcompaniamientoId(idHoja,idsAcompaniamientos));

        data.setHojaMensualRecursoList(hojaMensualRecursosService.findByHojaId(idHoja));
        return data;
    }
}
