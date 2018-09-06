package ar.gov.sedronar.aplicacion.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by TMR on 05/09/2018.
 */
@Entity
@Table(name = "HOJA_POBL_ASISTIDA_ACTIV", schema = "caac")
public class HojaPoblacionAsistidaActividades {
    private HojaPoblacionAsistidaActividadesId id;
    private Hoja hoja;
    private Poblacion poblacion;
    private String descripcion;
    private String uum;
    private java.util.Date fum;

    public HojaPoblacionAsistidaActividades(){}

    @EmbeddedId
    public HojaPoblacionAsistidaActividadesId getId() {
        return id;
    }

    public void setId(HojaPoblacionAsistidaActividadesId id) {
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
    @JoinColumn(name = "idpoblacion", insertable = false, updatable = false)
    public Poblacion getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(Poblacion poblacion) {
        this.poblacion = poblacion;
    }

    @Column(name = "descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name = "pob_asistida_activ_uum", length = 50)
    public String getUum() {
        return uum;
    }

    public void setUum(String uum) {
        this.uum = uum;
    }

    @Column(name = "pob_asistida_activ_fum")
    public Date getFum() {
        return fum;
    }

    public void setFum(Date fum) {
        this.fum = fum;
    }
}
