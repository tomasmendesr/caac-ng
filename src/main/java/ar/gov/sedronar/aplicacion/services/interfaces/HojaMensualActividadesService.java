package ar.gov.sedronar.aplicacion.services.interfaces;

import ar.gov.sedronar.aplicacion.dto.HojaMensualActividadesDTO;
import ar.gov.sedronar.util.app.AppResponse;

import java.util.List;

/**
 * Created by TMR on 02/10/2018.
 */
public interface HojaMensualActividadesService {
    AppResponse validateInputs(List<HojaMensualActividadesDTO> data);

    void saveOrUpdate(HojaMensualActividadesDTO hoja) throws Exception;

    List<HojaMensualActividadesDTO> findListByHojaAndActividadId(Long idHoja, List<Integer> idsActividades);

    void deleteIfExists(HojaMensualActividadesDTO hoja);
}
