package ar.gov.sedronar.aplicacion.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by TMR on 05/09/2018.
 */
@Entity
@Table(name = "HOJA_REGISTROS_INSTITUCIONALES", schema = "caac")
public class HojaRegistrosInstitucionales {
    private HojaRegistrosInstitucionalesId id;
    private Hoja hoja;
    private ClasificacionRegistro clasificacionRegistro;
    private String siPapel;
    private String siInformatico;
    private String uum;
    private java.util.Date fum;

    public HojaRegistrosInstitucionales(){}

    @EmbeddedId
    public HojaRegistrosInstitucionalesId getId() {
        return id;
    }

    public void setId(HojaRegistrosInstitucionalesId id) {
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
    @JoinColumn(name = "idclasif_registros")
    public ClasificacionRegistro getClasificacionRegistro() {
        return clasificacionRegistro;
    }

    public void setClasificacionRegistro(ClasificacionRegistro clasificacionRegistro) {
        this.clasificacionRegistro = clasificacionRegistro;
    }

    @Column(name = "si_papel", length = 1, columnDefinition = "char(1)")
    public String getSiPapel() {
        return siPapel;
    }

    public void setSiPapel(String siPapel) {
        this.siPapel = siPapel;
    }

    @Column(name = "si_informatico", length = 10, columnDefinition = "char(10)")
    public String getSiInformatico() {
        return siInformatico;
    }

    public void setSiInformatico(String siInformatico) {
        this.siInformatico = siInformatico;
    }

    @Column(name = "reg_uum", length = 50)
    public String getUum() {
        return uum;
    }

    public void setUum(String uum) {
        this.uum = uum;
    }

    @Column(name = "reg_fum")
    public Date getFum() {
        return fum;
    }

    public void setFum(Date fum) {
        this.fum = fum;
    }
}
