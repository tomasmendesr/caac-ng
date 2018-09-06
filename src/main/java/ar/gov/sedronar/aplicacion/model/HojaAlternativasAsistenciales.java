package ar.gov.sedronar.aplicacion.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by TMR on 05/09/2018.
 */
@Entity
@Table(name = "HOJA_ALT_ASIST", schema = "caac")
public class HojaAlternativasAsistenciales {
    private HojaAlternativasAsistencialesId id;
    private Hoja hoja;
    private AlternativaAsistencial alternativaAsistencial;
    private String descripcion;
    private String uum;
    private java.util.Date fum;

    public HojaAlternativasAsistenciales(){}

    @EmbeddedId
    public HojaAlternativasAsistencialesId getId() {
        return id;
    }

    public void setId(HojaAlternativasAsistencialesId id) {
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
    @JoinColumn(name = "idalter_asist", insertable = false, updatable = false)
    public AlternativaAsistencial getAlternativaAsistencial() {
        return alternativaAsistencial;
    }

    public void setAlternativaAsistencial(AlternativaAsistencial alternativaAsistencial) {
        this.alternativaAsistencial = alternativaAsistencial;
    }

    @Column(name = "descripcion", length = 10, columnDefinition = "char(10)")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name = "alt_asist_uum", length = 50)
    public String getUum() {
        return uum;
    }

    public void setUum(String uum) {
        this.uum = uum;
    }

    @Column(name = "alt_asist_fum")
    public Date getFum() {
        return fum;
    }

    public void setFum(Date fum) {
        this.fum = fum;
    }
}
