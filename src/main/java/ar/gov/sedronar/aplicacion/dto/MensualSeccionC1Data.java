package ar.gov.sedronar.aplicacion.dto;

import ar.gov.sedronar.aplicacion.model.HojaMensualAlimentacion;
import ar.gov.sedronar.aplicacion.model.HojaMensualTramites;

import java.util.List;

/**
 * Created by TMR on 18/09/2018.
 */
public class MensualSeccionC1Data {
    private List<HojaMensualTramites> hojaMensualTramitesList;
    private List<HojaMensualAlimentacion> hojaMensualAlimentacionList;
    private HojaMensualObservacionesDTO hojaMensualObservaciones;

    public List<HojaMensualTramites> getHojaMensualTramitesList() {
        return hojaMensualTramitesList;
    }

    public void setHojaMensualTramitesList(List<HojaMensualTramites> hojaMensualTramitesList) {
        this.hojaMensualTramitesList = hojaMensualTramitesList;
    }

    public List<HojaMensualAlimentacion> getHojaMensualAlimentacionList() {
        return hojaMensualAlimentacionList;
    }

    public void setHojaMensualAlimentacionList(List<HojaMensualAlimentacion> hojaMensualAlimentacionList) {
        this.hojaMensualAlimentacionList = hojaMensualAlimentacionList;
    }

    public HojaMensualObservacionesDTO getHojaMensualObservaciones() {
        return hojaMensualObservaciones;
    }

    public void setHojaMensualObservaciones(HojaMensualObservacionesDTO hojaMensualObservaciones) {
        this.hojaMensualObservaciones = hojaMensualObservaciones;
    }
}
