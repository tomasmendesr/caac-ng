package ar.gov.sedronar.aplicacion.dto;

import java.util.List;

/**
 * Created by TMR on 21/09/2018.
 */
public class MensualSeccionC3Data {
    private List<HojaMensualAcompaniamientoDTO> hojaMensualAcompaniamientoEstablComuTerapeuticaList;
    private List<HojaMensualAcompaniamientoDTO> hojaMensualAcompaniamientoTipoGestionList;
    private List<HojaMensualAcompaniamientoDTO> hojaMensualAcompaniamientoEstablPatrocinioLegalList;
    private HojaMensualObservacionesDTO hojaMensualObservaciones;

    public HojaMensualObservacionesDTO getHojaMensualObservaciones() {
        return hojaMensualObservaciones;
    }

    public void setHojaMensualObservaciones(HojaMensualObservacionesDTO hojaMensualObservaciones) {
        this.hojaMensualObservaciones = hojaMensualObservaciones;
    }

    public List<HojaMensualAcompaniamientoDTO> getHojaMensualAcompaniamientoTipoGestionList() {
        return hojaMensualAcompaniamientoTipoGestionList;
    }

    public void setHojaMensualAcompaniamientoTipoGestionList(List<HojaMensualAcompaniamientoDTO> hojaMensualAcompaniamientoTipoGestionList) {
        this.hojaMensualAcompaniamientoTipoGestionList = hojaMensualAcompaniamientoTipoGestionList;
    }

    public List<HojaMensualAcompaniamientoDTO> getHojaMensualAcompaniamientoEstablComuTerapeuticaList() {
        return hojaMensualAcompaniamientoEstablComuTerapeuticaList;
    }

    public void setHojaMensualAcompaniamientoEstablComuTerapeuticaList(List<HojaMensualAcompaniamientoDTO> hojaMensualAcompaniamientoEstablComuTerapeuticaList) {
        this.hojaMensualAcompaniamientoEstablComuTerapeuticaList = hojaMensualAcompaniamientoEstablComuTerapeuticaList;
    }

    public List<HojaMensualAcompaniamientoDTO> getHojaMensualAcompaniamientoEstablPatrocinioLegalList() {
        return hojaMensualAcompaniamientoEstablPatrocinioLegalList;
    }

    public void setHojaMensualAcompaniamientoEstablPatrocinioLegalList(List<HojaMensualAcompaniamientoDTO> hojaMensualAcompaniamientoEstablPatrocinioLegalList) {
        this.hojaMensualAcompaniamientoEstablPatrocinioLegalList = hojaMensualAcompaniamientoEstablPatrocinioLegalList;
    }
}
