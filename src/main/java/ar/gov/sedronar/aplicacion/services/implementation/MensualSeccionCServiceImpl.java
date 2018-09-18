package ar.gov.sedronar.aplicacion.services.implementation;

import ar.gov.sedronar.aplicacion.dto.MensualSeccionC1Data;
import ar.gov.sedronar.aplicacion.model.HojaMensualObservaciones;
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

    @Inject
    @DefaultServiceImpl
    private HojaMensualObservacionesService observacionesService;

    @Inject
    @DefaultServiceImpl
    private HojaMensualAlimentacionService hojaMensualAlimentacionService;

    @Inject
    @DefaultServiceImpl
    private HojaMensualTramitesService hojaMensualTramitesService;

    @Override
    public AppResponse saveOrUpdateSeccionC1(MensualSeccionC1Data data) {
        return new AppResponse();
    }

    @Override
    public MensualSeccionC1Data getDataForSeccionC1ByHojaId(Long idHoja) {
        MensualSeccionC1Data data = new MensualSeccionC1Data();

        return data;
    }
}
