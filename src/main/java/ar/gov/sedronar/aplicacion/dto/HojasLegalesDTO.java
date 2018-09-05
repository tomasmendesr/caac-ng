package ar.gov.sedronar.aplicacion.dto;

import ar.gov.sedronar.aplicacion.model.Hoja;

import java.math.BigInteger;
import java.util.Date;

/**
 * Created by TMR on 05/09/2018.
 */
public class HojasLegalesDTO {
    private BigInteger id;
    private HojaDTO hoja;
    private String acompComisarias;
    private String acompPenales;
    private String acompOtro;
    private String acompOtroDescripcion;
    private String actividadesTalleres;
    private String actividadesProductivas;
    private String actividadesCapacitacion;
    private String actividadesOtro;
    private String actividadesOtroDescripcion;
    private String uum;
    private java.util.Date fum;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public HojaDTO getHoja() {
        return hoja;
    }

    public void setHoja(HojaDTO hoja) {
        this.hoja = hoja;
    }

    public String getAcompComisarias() {
        return acompComisarias;
    }

    public void setAcompComisarias(String acompComisarias) {
        this.acompComisarias = acompComisarias;
    }

    public String getAcompPenales() {
        return acompPenales;
    }

    public void setAcompPenales(String acompPenales) {
        this.acompPenales = acompPenales;
    }

    public String getAcompOtro() {
        return acompOtro;
    }

    public void setAcompOtro(String acompOtro) {
        this.acompOtro = acompOtro;
    }

    public String getAcompOtroDescripcion() {
        return acompOtroDescripcion;
    }

    public void setAcompOtroDescripcion(String acompOtroDescripcion) {
        this.acompOtroDescripcion = acompOtroDescripcion;
    }

    public String getActividadesTalleres() {
        return actividadesTalleres;
    }

    public void setActividadesTalleres(String actividadesTalleres) {
        this.actividadesTalleres = actividadesTalleres;
    }

    public String getActividadesProductivas() {
        return actividadesProductivas;
    }

    public void setActividadesProductivas(String actividadesProductivas) {
        this.actividadesProductivas = actividadesProductivas;
    }

    public String getActividadesCapacitacion() {
        return actividadesCapacitacion;
    }

    public void setActividadesCapacitacion(String actividadesCapacitacion) {
        this.actividadesCapacitacion = actividadesCapacitacion;
    }

    public String getActividadesOtro() {
        return actividadesOtro;
    }

    public void setActividadesOtro(String actividadesOtro) {
        this.actividadesOtro = actividadesOtro;
    }

    public String getActividadesOtroDescripcion() {
        return actividadesOtroDescripcion;
    }

    public void setActividadesOtroDescripcion(String actividadesOtroDescripcion) {
        this.actividadesOtroDescripcion = actividadesOtroDescripcion;
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
