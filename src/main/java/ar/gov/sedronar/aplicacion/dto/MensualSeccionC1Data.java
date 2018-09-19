package ar.gov.sedronar.aplicacion.dto;

import ar.gov.sedronar.aplicacion.model.HojaMensualAlimentacion;
import ar.gov.sedronar.aplicacion.model.HojaMensualTramites;

import java.util.List;

/**
 * Created by TMR on 18/09/2018.
 */
public class MensualSeccionC1Data {
    private List<HojaMensualTramitesDTO> hojaMensualTramitesList;
    private List<HojaMensualAlimentacionDTO> hojaMensualAlimentacionList;
    private HojaMensualObservacionesDTO hojaMensualObservaciones;

    public List<HojaMensualTramitesDTO> getHojaMensualTramitesList() {
        return hojaMensualTramitesList;
    }

    public void setHojaMensualTramitesList(List<HojaMensualTramitesDTO> hojaMensualTramitesList) {
        this.hojaMensualTramitesList = hojaMensualTramitesList;
    }

    public List<HojaMensualAlimentacionDTO> getHojaMensualAlimentacionList() {
        return hojaMensualAlimentacionList;
    }

    public void setHojaMensualAlimentacionList(List<HojaMensualAlimentacionDTO> hojaMensualAlimentacionList) {
        this.hojaMensualAlimentacionList = hojaMensualAlimentacionList;
    }

    public HojaMensualObservacionesDTO getHojaMensualObservaciones() {
        return hojaMensualObservaciones;
    }

    public void setHojaMensualObservaciones(HojaMensualObservacionesDTO hojaMensualObservaciones) {
        this.hojaMensualObservaciones = hojaMensualObservaciones;
    }
}
