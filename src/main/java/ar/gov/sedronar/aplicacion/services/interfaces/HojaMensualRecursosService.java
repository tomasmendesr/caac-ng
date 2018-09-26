package ar.gov.sedronar.aplicacion.services.interfaces;

import ar.gov.sedronar.aplicacion.dto.HojaMensualRecursosDTO;
import ar.gov.sedronar.util.app.AppResponse;

import java.util.List;

/**
 * Created by TMR on 26/09/2018.
 */
public interface HojaMensualRecursosService {
    AppResponse validateInputs(List<HojaMensualRecursosDTO> hojaMensualRecursoList);
}
