package ar.gov.sedronar.aplicacion.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by TMR on 05/09/2018.
 */
@Entity
@Table(name = "H_MENSUAL_ACTIVIDADES", schema = "caac")
public class HojaMensualActividades {
    private HojaMensualActividadesId id;
    private Hoja hoja;
    private ActividadIntervencion actividadIntervencion;
    private String descripcionActividad;
    private String uum;
    private java.util.Date fum;

    public HojaMensualActividades(){}

    @EmbeddedId
    public HojaMensualActividadesId getId() {
        return id;
    }

    public void setId(HojaMensualActividadesId id) {
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
    @JoinColumn(name = "idactividad", insertable = false, updatable = false)
    public ActividadIntervencion getActividadIntervencion() {
        return actividadIntervencion;
    }

    public void setActividadIntervencion(ActividadIntervencion actividadIntervencion) {
        this.actividadIntervencion = actividadIntervencion;
    }

    @Column(name = "descripcion_actividad", length = 4000)
    public String getDescripcionActividad() {
        return descripcionActividad;
    }

    public void setDescripcionActividad(String descripcionActividad) {
        this.descripcionActividad = descripcionActividad;
    }

    @Column(name = "h_mens_act_uum", length = 4000)
    public String getUum() {
        return uum;
    }

    public void setUum(String uum) {
        this.uum = uum;
    }

    @Column(name = "h_mens_act_fum")
    public Date getFum() {
        return fum;
    }

    public void setFum(Date fum) {
        this.fum = fum;
    }
}
