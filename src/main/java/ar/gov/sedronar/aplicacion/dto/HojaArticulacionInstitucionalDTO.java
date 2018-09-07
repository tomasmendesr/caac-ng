package ar.gov.sedronar.aplicacion.dto;

import java.util.Date;

/**
 * Created by TMR on 05/09/2018.
 */
public class HojaArticulacionInstitucionalDTO {
    private HojaDTO hoja;
    private TipoInstitucionDTO tipoInstitucion;
    private String ningunVinculo;
    private String intercambioInfo;
    private String derivacionRecepcionDePersonas;
    private String accionesConjuntas;
    private String proyectosConjuntos;
    private String nombreInstitucion;
    private String uum;
    private java.util.Date fum;

    public HojaDTO getHoja() {
        return hoja;
    }

    public void setHoja(HojaDTO hoja) {
        this.hoja = hoja;
    }

    public TipoInstitucionDTO getTipoInstitucion() {
        return tipoInstitucion;
    }

    public void setTipoInstitucion(TipoInstitucionDTO tipoInstitucion) {
        this.tipoInstitucion = tipoInstitucion;
    }

    public String getNingunVinculo() {
        return ningunVinculo;
    }

    public void setNingunVinculo(String ningunVinculo) {
        this.ningunVinculo = ningunVinculo;
    }

    public String getIntercambioInfo() {
        return intercambioInfo;
    }

    public void setIntercambioInfo(String intercambioInfo) {
        this.intercambioInfo = intercambioInfo;
    }

    public String getDerivacionRecepcionDePersonas() {
        return derivacionRecepcionDePersonas;
    }

    public void setDerivacionRecepcionDePersonas(String derivacionRecepcionDePersonas) {
        this.derivacionRecepcionDePersonas = derivacionRecepcionDePersonas;
    }

    public String getAccionesConjuntas() {
        return accionesConjuntas;
    }

    public void setAccionesConjuntas(String accionesConjuntas) {
        this.accionesConjuntas = accionesConjuntas;
    }

    public String getNombreInstitucion() {
        return nombreInstitucion;
    }

    public void setNombreInstitucion(String nombreInstitucion) {
        this.nombreInstitucion = nombreInstitucion;
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

    public String getProyectosConjuntos() {
        return proyectosConjuntos;
    }

    public void setProyectosConjuntos(String proyectosConjuntos) {
        this.proyectosConjuntos = proyectosConjuntos;
    }
}
