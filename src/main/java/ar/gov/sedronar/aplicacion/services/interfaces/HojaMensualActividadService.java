package ar.gov.sedronar.aplicacion.services.interfaces;

import ar.gov.sedronar.aplicacion.dto.HojaMensualActividadDTO;
import ar.gov.sedronar.util.app.AppResponse;

/**
 * Created by TMR on 21/09/2018.
 */
public interface HojaMensualActividadService {
    AppResponse validateInputs(HojaMensualActividadDTO hojaMensualActividadDTO);
}
