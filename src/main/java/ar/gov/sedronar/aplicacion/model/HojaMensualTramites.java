package ar.gov.sedronar.aplicacion.model;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.Date;
/**
 * Created by TMR on 05/09/2018.
 */
@Entity
@Table(name = "H_MENSUAL_TRAMITES", schema = "caac")
public class HojaMensualTramites {
    private HojaMensualTramitesId id;
    private Hoja hoja;
    private Tramite tramite;
    private Integer cantidad;
    private String uum;
    private Date fum;

    public HojaMensualTramites(){}

    @EmbeddedId
    public HojaMensualTramitesId getId() {
        return id;
    }

    public void setId(HojaMensualTramitesId id) {
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
    @JoinColumn(name = "idtramite")
    public Tramite getTramite() {
        return tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

    @Column(name = "cantidad")
    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Column(name = "h_mens_tramite_uum", length = 50)
    public String getUum() {
        return uum;
    }

    public void setUum(String uum) {
        this.uum = uum;
    }

    @Column(name = "h_mens_tramite_fum")
    public Date getFum() {
        return fum;
    }

    public void setFum(Date fum) {
        this.fum = fum;
    }
}
