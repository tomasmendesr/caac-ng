package ar.gov.sedronar.aplicacion.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by TMR on 05/09/2018.
 */
@Entity
@Table(name = "HOJA_SALUD", schema = "caac")
public class HojaSalud {
    private HojaSaludId id;
    private Hoja hoja;
    private Gestion gestion;
    private String descripcion;
    private String uum;
    private java.util.Date fum;

    public HojaSalud(){}

    @EmbeddedId
    public HojaSaludId getId() {
        return id;
    }

    public void setId(HojaSaludId id) {
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
    @JoinColumn(name = "idgestion")
    public Gestion getGestion() {
        return gestion;
    }

    public void setGestion(Gestion gestion) {
        this.gestion = gestion;
    }

    @Column(name = "descripcion", length = 300)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name = "hsalud_uum", length = 300)
    public String getUum() {
        return uum;
    }

    public void setUum(String uum) {
        this.uum = uum;
    }

    @Column(name = "hsalud_fum")
    public Date getFum() {
        return fum;
    }

    public void setFum(Date fum) {
        this.fum = fum;
    }
}
