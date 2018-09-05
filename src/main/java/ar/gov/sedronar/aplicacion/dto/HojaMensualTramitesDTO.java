package ar.gov.sedronar.aplicacion.dto;

import ar.gov.sedronar.aplicacion.model.Hoja;
import ar.gov.sedronar.aplicacion.model.HojaMensualTramitesId;
import ar.gov.sedronar.aplicacion.model.Tramite;

import java.util.Date;

/**
 * Created by TMR on 05/09/2018.
 */
public class HojaMensualTramitesDTO {
    private HojaDTO hoja;
    private TramiteDTO tramite;
    private Integer cantidad;
    private String uum;
    private Date fum;

    public HojaDTO getHoja() {
        return hoja;
    }

    public void setHoja(HojaDTO hoja) {
        this.hoja = hoja;
    }

    public TramiteDTO getTramite() {
        return tramite;
    }

    public void setTramite(TramiteDTO tramite) {
        this.tramite = tramite;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getUum() {
        return uum;
    }

    public void setUum(String uum) {
        this.uum = uum;
    }

    public Date getFum() {
        return fum;
    }

    public void setFum(Date fum) {
        this.fum = fum;
    }
}
