package ar.gov.sedronar.aplicacion.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by TMR on 05/09/2018.
 */
@Entity
@Table(name = "H_MENSUAL_PERSONAL", schema = "caac")
public class HojaMensualPersonal {
    private HojaMensualPersonalId id;
    private Hoja hoja;
    private Personal personal;
    private String altaBaja;
    private String uum;
    private java.util.Date fum;

    public HojaMensualPersonal(){}

    @EmbeddedId
    public HojaMensualPersonalId getId() {
        return id;
    }

    public void setId(HojaMensualPersonalId id) {
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
    @JoinColumn(name = "idempleado", insertable = false, updatable = false)
    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    @Column(name = "alta_baja", length = 4, columnDefinition = "char(4)")
    public String getAltaBaja() {
        return altaBaja;
    }

    public void setAltaBaja(String altaBaja) {
        this.altaBaja = altaBaja;
    }

    @Column(name = "h_mens_personal_uum", length = 50)
    public String getUum() {
        return uum;
    }

    public void setUum(String uum) {
        this.uum = uum;
    }

    @Column(name = "h_mens_personal_fum")
    public Date getFum() {
        return fum;
    }

    public void setFum(Date fum) {
        this.fum = fum;
    }
}
