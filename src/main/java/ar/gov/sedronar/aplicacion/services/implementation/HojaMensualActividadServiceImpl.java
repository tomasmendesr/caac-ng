package ar.gov.sedronar.aplicacion.services.implementation;

import ar.gov.sedronar.aplicacion.dto.HojaMensualActividadDTO;
import ar.gov.sedronar.aplicacion.services.interfaces.HojaMensualActividadService;
import ar.gov.sedronar.util.app.AppResponse;

import javax.ejb.Stateless;
import javax.transaction.Transactional;

/**
 * Created by TMR on 21/09/2018.
 */
@Stateless
@Transactional
@DefaultServiceImpl
public class HojaMensualActividadServiceImpl implements HojaMensualActividadService {
    @Override
    public AppResponse validateInputs(HojaMensualActividadDTO hojaMensualActividadDTO) {
        return null;
    }
}
