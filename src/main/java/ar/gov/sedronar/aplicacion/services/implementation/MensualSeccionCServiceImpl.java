package ar.gov.sedronar.aplicacion.services.implementation;

import ar.gov.sedronar.aplicacion.dto.HojaMensualAlimentacionDTO;
import ar.gov.sedronar.aplicacion.dto.HojaMensualTramitesDTO;
import ar.gov.sedronar.aplicacion.dto.MensualSeccionC1Data;
import ar.gov.sedronar.aplicacion.services.interfaces.HojaMensualAlimentacionService;
import ar.gov.sedronar.aplicacion.services.interfaces.HojaMensualObservacionesService;
import ar.gov.sedronar.aplicacion.services.interfaces.HojaMensualTramitesService;
import ar.gov.sedronar.aplicacion.services.interfaces.MensualSeccionCService;
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
    public static final Integer SECCION_1_C1 = 1;
    public static final Integer SECCION_2_C1 = 2;
    public static final Integer SECCION_3_C1 = 3;
    public static final Integer SECCION_4_C1 = 4;
    public static final Integer SECCION_5_C1 = 5;
    public static final Integer SECCION_6_C1 = 6;

    @Inject
    @DefaultServiceImpl
    private HojaMensualObservacionesService hojaMensualObservacionesService;

    @Inject
    @DefaultServiceImpl
    private HojaMensualAlimentacionService hojaMensualAlimentacionService;

    @Inject
    @DefaultServiceImpl
    private HojaMensualTramitesService hojaMensualTramitesService;

    @Override
    /* Si falló una validación retorna un app response con error code y en el atributo data
    * contiene otro app response con el code que identifica a la sección del formulario que falló y la lista de errores de validación
    *
     */
    public AppResponse saveOrUpdateSeccionC1(MensualSeccionC1Data data) throws Exception {
        AppResponse validationTramites = hojaMensualTramitesService.validateInputs(data.getHojaMensualTramitesList());
        if(validationTramites.getCode() == AppResponse.ERROR) return new AppResponse(AppResponse.ERROR, new AppResponse(SECCION_1_C1, validationTramites.getData()));

        AppResponse validationAlimentacioEnSede = hojaMensualAlimentacionService.validateInputsEnSede(data.getHojaMensualAlimentacionList());
        if(validationAlimentacioEnSede.getCode() == AppResponse.ERROR) return new AppResponse(AppResponse.ERROR, new AppResponse(SECCION_3_C1, validationAlimentacioEnSede.getData()));

        AppResponse validationAlimentacioFueraDeSede = hojaMensualAlimentacionService.validateInputsFueraDeSede(data.getHojaMensualAlimentacionList());
        if(validationAlimentacioFueraDeSede.getCode() == AppResponse.ERROR) return new AppResponse(AppResponse.ERROR, new AppResponse(SECCION_5_C1, validationAlimentacioFueraDeSede.getData()));

        for (HojaMensualTramitesDTO hojaMensualTramitesDTO : data.getHojaMensualTramitesList()) hojaMensualTramitesService.saveOrUpdate(hojaMensualTramitesDTO);
        for (HojaMensualAlimentacionDTO hojaMensualAlimentacionDTO : data.getHojaMensualAlimentacionList()) hojaMensualAlimentacionService.saveOrUpdate(hojaMensualAlimentacionDTO);
        hojaMensualObservacionesService.saveOrUpdate(data.getHojaMensualObservaciones());
        return new AppResponse();
    }

    @Override
    public MensualSeccionC1Data getDataForSeccionC1ByHojaId(Long idHoja) {
        MensualSeccionC1Data data = new MensualSeccionC1Data();

        return data;
    }
}
