package ar.gov.sedronar.aplicacion.model;
import java.util.Date;

import javax.persistence.*;
/**
 * Created by TMR on 04/09/2018.
 */
@Entity
@Table(name="pagos", schema="caac")
public class Pago {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="anio")
    private Integer anio;

    @Column(name="asistidos")
    private Integer asistidos;

    @Column(name="atendidos")
    private Integer atendidos;

    @Column(name="fech_pag")
    private Date fechPag;

    @Column(name="fech_resep")
    private Date fechResep;

    @Column(name="mes")
    private String mes;

    @Column(name="monto")
    private Double monto;

    @Column(name="num_exp")
    private String numExp;

    @Column(name="num_fac")
    private String numFac;

    @Column(name="observaciones")
    private String observaciones;

    //uni-directional many-to-one association to Casa
    @ManyToOne
    @JoinColumn(name="caac")
    private Casa casa;

    public Pago() {
    }

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

    public Casa getCasa() {
        return this.casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }
}
