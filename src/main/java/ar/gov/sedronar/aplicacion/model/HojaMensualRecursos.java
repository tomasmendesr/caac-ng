package ar.gov.sedronar.aplicacion.model;

import javax.persistence.*;
import java.util.Date;
/**
 * Created by TMR on 05/09/2018.
 */
@Entity
@Table(name = "H_MENSUAL_RECURSOS", schema ="caac")
public class HojaMensualRecursos {
    private HojaMensualRecursosId id;
    private Recurso recurso;
    private Hoja hoja;
    private Integer cantidadPersonas;
    private String uum;
    private Date fum;

    public HojaMensualRecursos(){}


    @EmbeddedId
    public HojaMensualRecursosId getId() {
        return id;
    }

    public void setId(HojaMensualRecursosId id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idrecursos")
    public Recurso getRecurso() {
        return recurso;
    }

    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idhoja")
    public Hoja getHoja() {
        return hoja;
    }

    public void setHoja(Hoja hoja) {
        this.hoja = hoja;
    }

    @Column(name = "cant_personas")
    public Integer getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(Integer cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    @Column(name = "h_mens_recurso_uum", length =50)
    public String getUum() {
        return uum;
    }

    public void setUum(String uum) {
        this.uum = uum;
    }

    @Column(name = "h_mens_recurso_fum")
    public Date getFum() {
        return fum;
    }

    public void setFum(Date fum) {
        this.fum = fum;
    }
}
