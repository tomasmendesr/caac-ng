package ar.gov.sedronar.aplicacion.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by TMR on 05/09/2018.
 */
@Entity
@Table(name = "HOJA_ACT_INTERVENCION", schema = "caac")
public class HojaActividadIntervencion {
    private HojaActividadIntervencionId id;
    private Hoja hoja;
    private ActividadIntervencion actividadIntervencion;
    private String descripcion;
    private String uum;
    private java.util.Date fum;

    public HojaActividadIntervencion(){}

    @EmbeddedId
    public HojaActividadIntervencionId getId() {
        return id;
    }

    public void setId(HojaActividadIntervencionId id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idhoja")
    public Hoja getHoja() {
        return hoja;
    }

    public void setHoja(Hoja hoja) {
        this.hoja = hoja;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idactividad")
    public ActividadIntervencion getActividadIntervencion() {
        return actividadIntervencion;
    }

    public void setActividadIntervencion(ActividadIntervencion actividadIntervencion) {
        this.actividadIntervencion = actividadIntervencion;
    }

    @Column(name = "descripcion", length = 300)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name = "act_interv_uum", length = 300)
    public String getUum() {
        return uum;
    }

    public void setUum(String uum) {
        this.uum = uum;
    }

    @Column(name = "act_interv_fum")
    public Date getFum() {
        return fum;
    }

    public void setFum(Date fum) {
        this.fum = fum;
    }
}
