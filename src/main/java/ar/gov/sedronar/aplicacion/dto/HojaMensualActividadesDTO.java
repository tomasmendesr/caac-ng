package ar.gov.sedronar.aplicacion.dto;

import ar.gov.sedronar.aplicacion.model.ActividadIntervencion;
import ar.gov.sedronar.aplicacion.model.Hoja;
import ar.gov.sedronar.aplicacion.model.HojaMensualActividadesId;

import java.util.Date;

/**
 * Created by TMR on 05/09/2018.
 */
public class HojaMensualActividadesDTO {
    private HojaDTO hoja;
    private ActividadIntervencionDTO actividadIntervencion;
    private String descripcionActividad;
    private String uum;
    private java.util.Date fum;

    public HojaDTO getHoja() {
        return hoja;
    }

    public void setHoja(HojaDTO hoja) {
        this.hoja = hoja;
    }

    public ActividadIntervencionDTO getActividadIntervencion() {
        return actividadIntervencion;
    }

    public void setActividadIntervencion(ActividadIntervencionDTO actividadIntervencion) {
        this.actividadIntervencion = actividadIntervencion;
    }

    public String getDescripcionActividad() {
        return descripcionActividad;
    }

    public void setDescripcionActividad(String descripcionActividad) {
        this.descripcionActividad = descripcionActividad;
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
