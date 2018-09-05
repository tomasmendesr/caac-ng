package ar.gov.sedronar.aplicacion.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by TMR on 05/09/2018.
 */
@Entity
@Table(name = "HOJA_POBL_ASISTIDA_CONSUMO", schema = "caac")
public class HojaPoblacionAsistidaConsumo {
    private HojaPoblacionAsistidaConsumoId id;
    private Hoja hoja;
    private Poblacion poblacion;
    private String descripcion;
    private String uum;
    private java.util.Date fum;

    public HojaPoblacionAsistidaConsumo(){}

    @EmbeddedId
    public HojaPoblacionAsistidaConsumoId getId() {
        return id;
    }

    public void setId(HojaPoblacionAsistidaConsumoId id) {
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
    @JoinColumn(name = "idpoblacion")
    public Poblacion getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(Poblacion poblacion) {
        this.poblacion = poblacion;
    }

    @Column(name = "descripcion", length = 300)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name = "pob_asistida_consumo_uum", length = 50)
    public String getUum() {
        return uum;
    }

    public void setUum(String uum) {
        this.uum = uum;
    }

    @Column(name = "pob_asistida_consumo_fum")
    public Date getFum() {
        return fum;
    }

    public void setFum(Date fum) {
        this.fum = fum;
    }
}
