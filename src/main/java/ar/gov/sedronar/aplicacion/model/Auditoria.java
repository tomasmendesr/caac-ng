package ar.gov.sedronar.aplicacion.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by TMR on 04/09/2018.
 */
@Entity
@Table(name="auditorias", schema="caac")
public class Auditoria {


    private Integer id;
    private Casa casa;

    private Integer anio;

    private Integer naudi;

    private String tipoaud;

    private Date fechaudi;

    private String prof;

    private Date fechven;

    private Integer canaten;

    private Integer canasis;

    private String obsaudi;

    @Id
    @Column(name="id_audi")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id_audi) {
        this.id = id_audi;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id")
    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa id) {
        this.casa = id;
    }

    @Column(name="anio")
    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    @Column(name="naudi")
    public Integer getNaudi() {
        return naudi;
    }

    public void setNaudi(Integer naudi) {
        this.naudi = naudi;
    }

    @Column(name="tipoaud")
    public String getTipoaud() {
        return tipoaud;
    }

    public void setTipoaud(String tipoaud) {
        this.tipoaud = tipoaud;
    }

    @Column(name="fechaudi")
    public Date getFechaudi() {
        return fechaudi;
    }

    public void setFechaudi(Date fechaudi) {
        this.fechaudi = fechaudi;
    }

    @Column(name="prof")
    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

    @Column(name="fechven")
    public Date getFechven() {
        return fechven;
    }

    public void setFechven(Date fechven) {
        this.fechven = fechven;
    }

    @Column(name="canaten")
    public Integer getCanaten() {
        return canaten;
    }

    public void setCanaten(Integer canaten) {
        this.canaten = canaten;
    }

    @Column(name="canasis")
    public Integer getCanasis() {
        return canasis;
    }

    public void setCanasis(Integer canasis) {
        this.canasis = canasis;
    }

    @Column(name="obsaudi")
    public String getObsaudi() {
        return obsaudi;
    }

    public void setObsaudi(String obsaudi) {
        this.obsaudi = obsaudi;
    }

}
