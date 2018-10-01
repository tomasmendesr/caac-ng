package ar.gov.sedronar.aplicacion.dto;

import java.util.List;

/**
 * Created by TMR on 24/09/2018.
 */
public class MensualSeccionC4Data {
    private List<HojaMensualAcompaniamientoDTO> hojaMensualAcompEstPenalesTipoAcompList;
    private List<HojaMensualAcompaniamientoDTO> hojaMensualAcompEstPenalesTipoActividadesList;
    private HojaMensualObservacionesDTO hojaMensualObservaciones;

    public HojaMensualObservacionesDTO getHojaMensualObservaciones() {
        return hojaMensualObservaciones;
    }

    public void setHojaMensualObservaciones(HojaMensualObservacionesDTO hojaMensualObservaciones) {
        this.hojaMensualObservaciones = hojaMensualObservaciones;
    }

    public List<HojaMensualAcompaniamientoDTO> getHojaMensualAcompEstPenalesTipoAcompList() {
        return hojaMensualAcompEstPenalesTipoAcompList;
    }

    public void setHojaMensualAcompEstPenalesTipoAcompList(List<HojaMensualAcompaniamientoDTO> hojaMensualAcompEstPenalesTipoAcompList) {
        this.hojaMensualAcompEstPenalesTipoAcompList = hojaMensualAcompEstPenalesTipoAcompList;
    }

    public List<HojaMensualAcompaniamientoDTO> getHojaMensualAcompEstPenalesTipoActividadesList() {
        return hojaMensualAcompEstPenalesTipoActividadesList;
    }

    public void setHojaMensualAcompEstPenalesTipoActividadesList(List<HojaMensualAcompaniamientoDTO> hojaMensualAcompEstPenalesTipoActividadesList) {
        this.hojaMensualAcompEstPenalesTipoActividadesList = hojaMensualAcompEstPenalesTipoActividadesList;
    }
}
