package ar.gov.sedronar.aplicacion.dto;

import ar.gov.sedronar.aplicacion.model.Gestion;
import ar.gov.sedronar.aplicacion.model.Hoja;

import java.util.Date;

/**
 * Created by TMR on 05/09/2018.
 */
public class HojaSaludDTO {
    private HojaDTO hoja;
    private GestionDTO gestion;
    private String descripcion;
    private String uum;
    private java.util.Date fum;

    public HojaDTO getHoja() {
        return hoja;
    }

    public void setHoja(HojaDTO hoja) {
        this.hoja = hoja;
    }

    public GestionDTO getGestion() {
        return gestion;
    }

    public void setGestion(GestionDTO gestion) {
        this.gestion = gestion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
