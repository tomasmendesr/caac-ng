package ar.gov.sedronar.aplicacion.model;

import ar.gov.sedronar.modulo.commonsModels.modelo.Mes;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by TMR on 04/09/2018.
 */
@Entity
@Table(name = "HOJA_CAAC", schema = "caac")
public class Hoja {
    private Long id;
    private Integer anio;
    private Mes mes;
    private Casa casa;
    private String tipoHoja;
    private Date fechaCierre;
    private String uum;
    private Date fum;

    public Hoja(){}

    @Id
    @Column(name="idhoja")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="anio")
    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idmes")
    public Mes getMes() {
        return mes;
    }

    public void setMes(Mes mes) {
        this.mes = mes;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcaac")
    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    @Column(name = "tipo_hoja", length=1, columnDefinition = "char(1)")
    public String getTipoHoja() {
        return tipoHoja;
    }

    public void setTipoHoja(String tipoHoja) {
        this.tipoHoja = tipoHoja;
    }

    @Column(name = "hoja_fecha_cierre")
    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    @Column(name = "hoja_uum", length = 50)
    public String getUum() {
        return uum;
    }

    public void setUum(String uum) {
        this.uum = uum;
    }

    @Column(name = "hoja_fum")
    public Date getFum() {
        return fum;
    }

    public void setFum(Date fum) {
        this.fum = fum;
    }
}
