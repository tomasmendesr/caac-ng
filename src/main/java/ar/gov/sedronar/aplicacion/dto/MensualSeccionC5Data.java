package ar.gov.sedronar.aplicacion.dto;


import java.util.List;

/**
 * Created by TMR on 26/09/2018.
 */
public class MensualSeccionC5Data {
    private HojaMensualObservacionesDTO hojaMensualObservaciones;
    private List<HojaMensualAcompaniamientoDTO> hojaMensualAcompaniamientoList;
    private List<HojaMensualRecursosDTO> hojaMensualRecursoList;

    public HojaMensualObservacionesDTO getHojaMensualObservaciones() {
        return hojaMensualObservaciones;
    }

    public void setHojaMensualObservaciones(HojaMensualObservacionesDTO hojaMensualObservaciones) {
        this.hojaMensualObservaciones = hojaMensualObservaciones;
    }


    public List<HojaMensualAcompaniamientoDTO> getHojaMensualAcompaniamientoList() {
        return hojaMensualAcompaniamientoList;
    }

    public void setHojaMensualAcompaniamientoList(List<HojaMensualAcompaniamientoDTO> hojaMensualAcompaniamientoList) {
        this.hojaMensualAcompaniamientoList = hojaMensualAcompaniamientoList;
    }

    public List<HojaMensualRecursosDTO> getHojaMensualRecursoList() {
        return hojaMensualRecursoList;
    }

    public void setHojaMensualRecursoList(List<HojaMensualRecursosDTO> hojaMensualRecursoList) {
        this.hojaMensualRecursoList = hojaMensualRecursoList;
    }
}
