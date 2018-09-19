package ar.gov.sedronar.aplicacion.services.interfaces;

import ar.gov.sedronar.aplicacion.dto.HojaMensualTramitesDTO;
import ar.gov.sedronar.aplicacion.model.HojaMensualTramites;
import ar.gov.sedronar.util.app.AppResponse;

import java.util.List;

/**
 * Created by TMR on 18/09/2018.
 */
public interface HojaMensualTramitesService {
    AppResponse validateInputs(List<HojaMensualTramitesDTO> hojaMensualTramitesList);

    void saveOrUpdate(HojaMensualTramitesDTO h) throws Exception;
}
