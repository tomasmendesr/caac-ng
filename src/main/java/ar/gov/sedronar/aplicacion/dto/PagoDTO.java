package ar.gov.sedronar.aplicacion.dto;

import java.util.Date;


public class PagoDTO {

    private Integer id;
    private Integer anio;
    private Integer asistidos;
    private Integer atendidos;
    private Date fechPag;
    private Date fechResep;
    private String mes;
    private Double monto;
    private String numExp;
    private String numFac;
    private String observaciones;
    private CasaDTO casa;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAnio() {
        return this.anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getAsistidos() {
        return this.asistidos;
    }

    public void setAsistidos(Integer asistidos) {
        this.asistidos = asistidos;
    }

    public Integer getAtendidos() {
        return this.atendidos;
    }

    public void setAtendidos(Integer atendidos) {
        this.atendidos = atendidos;
    }

    public Date getFechPag() {
        return this.fechPag;
    }

    public void setFechPag(Date fechPag) {
        this.fechPag = fechPag;
    }

    public Date getFechResep() {
        return this.fechResep;
    }

    public void setFechResep(Date fechResep) {
        this.fechResep = fechResep;
    }

    public String getMes() {
        return this.mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public Double getMonto() {
        return this.monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getNumExp() {
        return this.numExp;
    }

    public void setNumExp(String numExp) {
        this.numExp = numExp;
    }

    public String getNumFac() {
        return this.numFac;
    }

    public void setNumFac(String numFac) {
        this.numFac = numFac;
    }

    public String getObservaciones() {
        return this.observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public CasaDTO getCasa() {
        return this.casa;
    }

    public void setCasa(CasaDTO casa) {
        this.casa = casa;
    }

}