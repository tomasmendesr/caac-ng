package ar.gov.sedronar.aplicacion.dto;

import java.util.List;

/**
 * Created by TMR on 21/09/2018.
 */
public class MensualSeccionC2Data {
    private HojaMensualActividadDTO hojaMensualActividad;
    private List<HojaMensualAcompaniamientoDTO> hojaMensualAcompaniamientoList;
    private HojaMensualObservacionesDTO hojaMensualObservaciones;

    public HojaMensualActividadDTO getHojaMensualActividad() {
        return hojaMensualActividad;
    }

    public void setHojaMensualActividad(HojaMensualActividadDTO hojaMensualActividad) {
        this.hojaMensualActividad = hojaMensualActividad;
    }

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
