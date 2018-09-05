package ar.gov.sedronar.aplicacion.dto;

import ar.gov.sedronar.aplicacion.model.Espacio;
import ar.gov.sedronar.aplicacion.model.Hoja;
import ar.gov.sedronar.aplicacion.model.HojaEstructuraId;

import javax.persistence.EmbeddedId;
import java.util.Date;

/**
 * Created by TMR on 05/09/2018.
 */
public class HojaEstructuraDTO {
    private HojaDTO hoja;
    private EspacioDTO espacio;
    private Integer cantidad;
    private String descripcion;
    private String uum;
    private java.util.Date fum;


    public HojaDTO getHoja() {
        return hoja;
    }

    public void setHoja(HojaDTO hoja) {
        this.hoja = hoja;
    }

    public EspacioDTO getEspacio() {
        return espacio;
    }

    public void setEspacio(EspacioDTO espacio) {
        this.espacio = espacio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
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
