package ar.gov.sedronar.aplicacion.services.interfaces;

import ar.gov.sedronar.aplicacion.dto.HojaMensualAlimentacionDTO;
import ar.gov.sedronar.aplicacion.model.HojaMensualAlimentacion;
import ar.gov.sedronar.util.app.AppResponse;

import java.util.List;

/**
 * Created by TMR on 18/09/2018.
 */
public interface HojaMensualAlimentacionService {
    AppResponse validateInputsEnSede(List<HojaMensualAlimentacionDTO> hojaMensualAlimentacionList);

    AppResponse validateInputsFueraDeSede(List<HojaMensualAlimentacionDTO> hojaMensualAlimentacionList);

    void saveOrUpdate(HojaMensualAlimentacionDTO h) throws Exception;
}
