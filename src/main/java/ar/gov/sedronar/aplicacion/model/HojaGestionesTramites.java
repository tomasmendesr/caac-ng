package ar.gov.sedronar.aplicacion.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by TMR on 05/09/2018.
 */
@Entity
@Table(name = "HOJA_GESTION_TRAMITES", schema = "caac")
public class HojaGestionesTramites {

    private HojaGestionesTramitesId id;
    private Hoja hoja;
    private Tramite tramite;
    private String descripcionOtro;
    private String uum;
    private java.util.Date fum;

    public HojaGestionesTramites(){}

    @EmbeddedId
    public HojaGestionesTramitesId getId() {
        return id;
    }

    public void setId(HojaGestionesTramitesId id) {
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
    @JoinColumn(name = "idtramite", insertable = false, updatable = false)
    public Tramite getTramite() {
        return tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

    @Column(name = "descripcion_otro", length = 100)
    public String getDescripcionOtro() {
        return descripcionOtro;
    }

    public void setDescripcionOtro(String descripcionOtro) {
        this.descripcionOtro = descripcionOtro;
    }

    @Column(name = "tramite_uum", length = 50)
    public String getUum() {
        return uum;
    }

    public void setUum(String uum) {
        this.uum = uum;
    }

    @Column(name = "tramite_fum")
    public Date getFum() {
        return fum;
    }

    public void setFum(Date fum) {
        this.fum = fum;
    }
}
