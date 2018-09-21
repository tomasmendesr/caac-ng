package ar.gov.sedronar.aplicacion.model;

import javax.persistence.*;
import java.util.Date;
/**
 * Created by TMR on 04/09/2018.
 */
@Entity
@Table(name = "H_MENSUAL_ACOMPANIAMIENTO", schema = "caac")
public class HojaMensualAcompaniamiento {
    private HojaMensualAcompaniamientoId id;
    private Hoja hoja;
    private Acompaniamiento acompaniamiento;
    private Integer cantidadGestiones;
    private Integer cantidadPersonas;
    private String uum;
    private Date fum;

    public HojaMensualAcompaniamiento(){}

    @EmbeddedId
    public HojaMensualAcompaniamientoId getId(){
        return id;
    }

    public void setId(HojaMensualAcompaniamientoId id){
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idacompaniamiento", insertable = false, updatable = false)
    public Acompaniamiento getAcompaniamiento() {
        return acompaniamiento;
    }

    public void setAcompaniamiento(Acompaniamiento acompaniamiento) {
        this.acompaniamiento = acompaniamiento;
    }

    @Column(name = "cantidad_gestiones")
    public Integer getCantidadGestiones() {
        return cantidadGestiones;
    }

    public void setCantidadGestiones(Integer cantidadGestiones) {
        this.cantidadGestiones = cantidadGestiones;
    }

    @Column(name = "cantidad_personas")
    public Integer getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(Integer cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    @Column(name = "h_mens_acomp_uum", length = 50)
    public String getUum() {
        return uum;
    }

    public void setUum(String uum) {
        this.uum = uum;
    }

    @Column(name = "h_mens_acomp_fum")
    public Date getFum() {
        return fum;
    }

    public void setFum(Date fum) {
        this.fum = fum;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idhoja", insertable = false, updatable = false)
    public Hoja getHoja() {
        return hoja;
    }

    public void setHoja(Hoja hoja) {
        this.hoja = hoja;
    }
}
