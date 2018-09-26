package ar.gov.sedronar.aplicacion.services.interfaces;

import ar.gov.sedronar.aplicacion.dto.HojaMensualAcompaniamientoDTO;
import ar.gov.sedronar.aplicacion.model.HojaMensualAcompaniamiento;
import ar.gov.sedronar.util.app.AppResponse;

import java.util.List;

/**
 * Created by TMR on 21/09/2018.
 */
public interface HojaMensualAcompaniamientoService {
    AppResponse validateInputs(List<HojaMensualAcompaniamientoDTO> hojaMensualAcompaniamientoDTOList);

    void saveOrUpdate(HojaMensualAcompaniamientoDTO hojaMensualAcompaniamientoDTO) throws Exception;

    List<HojaMensualAcompaniamientoDTO> findListByHojaAndAcompaniamientoId(Long idHoja, List<Integer> idsAcompaniamientos);

    AppResponse validateInputsEnEstablecimiento(List<HojaMensualAcompaniamientoDTO> hojaMensualAcompaniamientoList, String establecimiento, boolean validateGestiones, boolean validatePersonas);

    AppResponse validateInputsByEstablecimientoAndTipo(List<HojaMensualAcompaniamientoDTO> hojaMensualAcompaniamientoList, String establecimiento, String tipo, boolean validateGestiones, boolean validatePersonas);
}
