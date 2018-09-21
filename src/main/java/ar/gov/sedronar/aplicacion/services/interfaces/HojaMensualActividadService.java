package ar.gov.sedronar.aplicacion.services.interfaces;

import ar.gov.sedronar.aplicacion.dto.HojaMensualActividadDTO;
import ar.gov.sedronar.util.app.AppResponse;

/**
 * Created by TMR on 21/09/2018.
 */
public interface HojaMensualActividadService {
    AppResponse validateInputsActividadesFamiliares(HojaMensualActividadDTO hojaMensualActividadDTO);
    AppResponse validateInputsIntervencionEnCalle(HojaMensualActividadDTO hojaMensualActividadDTO);

    void saveOrUpdate(HojaMensualActividadDTO hojaMensualActividad) throws Exception;
}
