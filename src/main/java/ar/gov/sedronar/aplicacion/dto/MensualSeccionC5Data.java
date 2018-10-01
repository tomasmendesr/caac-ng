package ar.gov.sedronar.aplicacion.dto;


import java.util.List;

/**
 * Created by TMR on 26/09/2018.
 */
public class MensualSeccionC5Data {
    private HojaMensualObservacionesDTO hojaMensualObservaciones;
    private List<HojaMensualAcompaniamientoDTO> hojaMensualAcompaniamientoEstabTrayEducativaList;
    private List<HojaMensualAcompaniamientoDTO> hojaMensualAcompaniamientoEstabProfSaludList;
    private List<HojaMensualRecursosDTO> hojaMensualRecursoList;

    public HojaMensualObservacionesDTO getHojaMensualObservaciones() {
        return hojaMensualObservaciones;
    }

    public void setHojaMensualObservaciones(HojaMensualObservacionesDTO hojaMensualObservaciones) {
        this.hojaMensualObservaciones = hojaMensualObservaciones;
    }


    public List<HojaMensualRecursosDTO> getHojaMensualRecursoList() {
        return hojaMensualRecursoList;
    }

    public void setHojaMensualRecursoList(List<HojaMensualRecursosDTO> hojaMensualRecursoList) {
        this.hojaMensualRecursoList = hojaMensualRecursoList;
    }

    public List<HojaMensualAcompaniamientoDTO> getHojaMensualAcompaniamientoEstabTrayEducativaList() {
        return hojaMensualAcompaniamientoEstabTrayEducativaList;
    }

    public void setHojaMensualAcompaniamientoEstabTrayEducativaList(List<HojaMensualAcompaniamientoDTO> hojaMensualAcompaniamientoEstabTrayEducativaList) {
        this.hojaMensualAcompaniamientoEstabTrayEducativaList = hojaMensualAcompaniamientoEstabTrayEducativaList;
    }

    public List<HojaMensualAcompaniamientoDTO> getHojaMensualAcompaniamientoEstabProfSaludList() {
        return hojaMensualAcompaniamientoEstabProfSaludList;
    }

    public void setHojaMensualAcompaniamientoEstabProfSaludList(List<HojaMensualAcompaniamientoDTO> hojaMensualAcompaniamientoEstabProfSaludList) {
        this.hojaMensualAcompaniamientoEstabProfSaludList = hojaMensualAcompaniamientoEstabProfSaludList;
    }
}
