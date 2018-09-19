package ar.gov.sedronar.aplicacion.services.interfaces;

import ar.gov.sedronar.aplicacion.dto.HojaMensualObservacionesDTO;

/**
 * Created by TMR on 18/09/2018.
 */
public interface HojaMensualObservacionesService {
    void saveOrUpdate(HojaMensualObservacionesDTO hojaMensualObservaciones) throws Exception;

    HojaMensualObservacionesDTO findByHojaId(Long idHoja);
}
