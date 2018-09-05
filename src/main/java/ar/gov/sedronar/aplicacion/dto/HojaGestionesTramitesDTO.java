package ar.gov.sedronar.aplicacion.dto;

import java.util.Date;

/**
 * Created by TMR on 05/09/2018.
 */
public class HojaGestionesTramitesDTO {
    private HojaDTO hoja;
    private TramiteDTO tramite;
    private String descripcionOtro;
    private String uum;
    private java.util.Date fum;

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

    public String getDescripcionOtro() {
        return descripcionOtro;
    }

    public void setDescripcionOtro(String descripcionOtro) {
        this.descripcionOtro = descripcionOtro;
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
