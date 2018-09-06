package ar.gov.sedronar.aplicacion.model;

import ar.gov.sedronar.modulo.commonsModels.modelo.Profesion;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

/**
 * Created by TMR on 05/09/2018.
 */
@Entity
@Table(name = "HOJA_PERSONAL_HORAS", schema ="caac")
public class HojaPersonalHoras {
    private BigInteger id;
    private Hoja hoja;
    private Profesion profesion;
    private Integer cantidadRentadoHs;
    private Integer cantidadRentadoPers;
    private Integer cantidadNoRentadoHs;
    private Integer cantidadNoRentadoPers;
    private String uum;
    private java.util.Date fum;

    public HojaPersonalHoras(){}

    @Id
    @Column(name = "idhoja")
    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idhoja", insertable = false, updatable = false)
    public Hoja getHoja() {
        return hoja;
    }

    public void setHoja(Hoja hoja) {
        this.hoja = hoja;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idprofesion")
    public Profesion getProfesion() {
        return profesion;
    }

    public void setProfesion(Profesion profesion) {
        this.profesion = profesion;
    }

    @Column(name = "cant_rentado_hs")
    public Integer getCantidadRentadoHs() {
        return cantidadRentadoHs;
    }

    public void setCantidadRentadoHs(Integer cantidadRentadoHs) {
        this.cantidadRentadoHs = cantidadRentadoHs;
    }

    @Column(name = "cant_rentado_pers")
    public Integer getCantidadRentadoPers() {
        return cantidadRentadoPers;
    }

    public void setCantidadRentadoPers(Integer cantidadRentadoPers) {
        this.cantidadRentadoPers = cantidadRentadoPers;
    }

    @Column(name = "cant_norentado_hs")
    public Integer getCantidadNoRentadoHs() {
        return cantidadNoRentadoHs;
    }

    public void setCantidadNoRentadoHs(Integer cantidadNoRentadoHs) {
        this.cantidadNoRentadoHs = cantidadNoRentadoHs;
    }

    @Column(name = "cant_norentado_pers")
    public Integer getCantidadNoRentadoPers() {
        return cantidadNoRentadoPers;
    }

    public void setCantidadNoRentadoPers(Integer cantidadNoRentadoPers) {
        this.cantidadNoRentadoPers = cantidadNoRentadoPers;
    }

    @Column(name = "personal_hs_uum", length = 50)
    public String getUum() {
        return uum;
    }

    public void setUum(String uum) {
        this.uum = uum;
    }

    @Column(name = "personal_hs_fum")
    public Date getFum() {
        return fum;
    }

    public void setFum(Date fum) {
        this.fum = fum;
    }
}
