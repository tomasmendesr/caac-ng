package ar.gov.sedronar.aplicacion.dto;

import ar.gov.sedronar.aplicacion.model.HojaMensualAlimentacion;
import ar.gov.sedronar.aplicacion.model.HojaMensualTramites;

import java.util.List;

/**
 * Created by TMR on 18/09/2018.
 */
public class MensualSeccionC1Data {
    private List<HojaMensualTramitesDTO> hojaMensualTramitesList;
    private List<HojaMensualAlimentacionDTO> hojaMensualAlimentacionEnSedeList;
    private List<HojaMensualAlimentacionDTO> hojaMensualAlimentacionFueraDeSedeList;
    private HojaMensualObservacionesDTO hojaMensualObservaciones;

    public List<HojaMensualTramitesDTO> getHojaMensualTramitesList() {
        return hojaMensualTramitesList;
    }

    public void setHojaMensualTramitesList(List<HojaMensualTramitesDTO> hojaMensualTramitesList) {
        this.hojaMensualTramitesList = hojaMensualTramitesList;
    }

    public HojaMensualObservacionesDTO getHojaMensualObservaciones() {
        return hojaMensualObservaciones;
    }

    public void setHojaMensualObservaciones(HojaMensualObservacionesDTO hojaMensualObservaciones) {
        this.hojaMensualObservaciones = hojaMensualObservaciones;
    }

    public List<HojaMensualAlimentacionDTO> getHojaMensualAlimentacionEnSedeList() {
        return hojaMensualAlimentacionEnSedeList;
    }

    public void setHojaMensualAlimentacionEnSedeList(List<HojaMensualAlimentacionDTO> hojaMensualAlimentacionEnSedeList) {
        this.hojaMensualAlimentacionEnSedeList = hojaMensualAlimentacionEnSedeList;
    }

    public List<HojaMensualAlimentacionDTO> getHojaMensualAlimentacionFueraDeSedeList() {
        return hojaMensualAlimentacionFueraDeSedeList;
    }

    public void setHojaMensualAlimentacionFueraDeSedeList(List<HojaMensualAlimentacionDTO> hojaMensualAlimentacionFueraDeSedeList) {
        this.hojaMensualAlimentacionFueraDeSedeList = hojaMensualAlimentacionFueraDeSedeList;
    }
}
