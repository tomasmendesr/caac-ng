package ar.gov.sedronar.aplicacion.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by TMR on 05/09/2018.
 */
@Entity
@Table(name = "HOJA_ACOMPANIAMIENTO", schema = "caac")
public class HojaAcompaniamiento {
    private HojaAcompaniamientoId id;
    private Hoja hoja;
    private Acompaniamiento acompaniamiento;
    private String descripcion;
    private String interno;
    private String externo;
    private String uum;
    private java.util.Date fum;

    public HojaAcompaniamiento(){}

    @EmbeddedId
    public HojaAcompaniamientoId getId() {
        return id;
    }

    public void setId(HojaAcompaniamientoId id) {
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
    @JoinColumn(name = "idacompaniamiento", insertable = false, updatable = false)
    public Acompaniamiento getAcompaniamiento() {
        return acompaniamiento;
    }

    public void setAcompaniamiento(Acompaniamiento acompaniamiento) {
        this.acompaniamiento = acompaniamiento;
    }

    @Column(name = "descripcion", length = 300)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name = "interno", length = 1, columnDefinition = "char(1)")
    public String getInterno() {
        return interno;
    }

    public void setInterno(String interno) {
        this.interno = interno;
    }

    @Column(name = "externo", length = 1, columnDefinition = "char(1)")
    public String getExterno() {
        return externo;
    }

    public void setExterno(String externo) {
        this.externo = externo;
    }

    @Column(name = "hoja_acom_uum", length = 50)
    public String getUum() {
        return uum;
    }

    public void setUum(String uum) {
        this.uum = uum;
    }

    @Column(name = "hoja_acom_fum")
    public Date getFum() {
        return fum;
    }

    public void setFum(Date fum) {
        this.fum = fum;
    }
}
