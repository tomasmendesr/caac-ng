package ar.gov.sedronar.aplicacion.dto;

import java.util.List;

/**
 * Created by TMR on 21/09/2018.
 */
public class MensualSeccionC3Data {
    private List<HojaMensualAcompaniamientoDTO> hojaMensualAcompaniamientoList;
    private HojaMensualObservacionesDTO hojaMensualObservaciones;

    public List<HojaMensualAcompaniamientoDTO> getHojaMensualAcompaniamientoList() {
        return hojaMensualAcompaniamientoList;
    }

    public void setHojaMensualAcompaniamientoList(List<HojaMensualAcompaniamientoDTO> hojaMensualAcompaniamientoList) {
        this.hojaMensualAcompaniamientoList = hojaMensualAcompaniamientoList;
    }

    public HojaMensualObservacionesDTO getHojaMensualObservaciones() {
        return hojaMensualObservaciones;
    }

    public void setHojaMensualObservaciones(HojaMensualObservacionesDTO hojaMensualObservaciones) {
        this.hojaMensualObservaciones = hojaMensualObservaciones;
    }
}
