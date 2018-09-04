package ar.gov.sedronar.aplicacion.dto;

import java.util.Date;
/**
 * Created by TMR on 04/09/2018.
 */
public class HojaMensualAcompaniamientoDTO {
    private HojaDTO hoja;
    private AcompaniamientoDTO acompaniamiento;
    private Integer cantidadGestiones;
    private Integer cantidadPersonas;
    private String uum;
    private Date fum;

    public AcompaniamientoDTO getAcompaniamiento() {
        return acompaniamiento;
    }

    public void setAcompaniamiento(AcompaniamientoDTO acompaniamiento) {
        this.acompaniamiento = acompaniamiento;
    }

    public Integer getCantidadGestiones() {
        return cantidadGestiones;
    }

    public void setCantidadGestiones(Integer cantidadGestiones) {
        this.cantidadGestiones = cantidadGestiones;
    }

    public Integer getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(Integer cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
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

    public HojaDTO getHoja() {
        return hoja;
    }

    public void setHoja(HojaDTO hoja) {
        this.hoja = hoja;
    }
}
