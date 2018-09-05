package ar.gov.sedronar.aplicacion.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

/**
 * Created by TMR on 05/09/2018.
 */
@Entity
@Table(name = "HOJA_REUNIONES_EQUIPO", schema = "caac")
public class HojaReunionesEquipo {
    private BigInteger id;
    private Hoja hoja;
    private String si;
    private String no;
    private ClasificacionFrecuencia clasificacionFrecuencia;
    private String uum;
    private java.util.Date fum;

    public HojaReunionesEquipo() {
    }

    @Id
    @Column(name = "idhoja")
    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
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

    @Column(name = "si", length = 1, columnDefinition = "char(1)")
    public String getSi() {
        return si;
    }

    public void setSi(String si) {
        this.si = si;
    }

    @Column(name = "no", length = 1, columnDefinition = "char(1)")
    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idfrecuencia")
    public ClasificacionFrecuencia getClasificacionFrecuencia() {
        return clasificacionFrecuencia;
    }

    public void setClasificacionFrecuencia(ClasificacionFrecuencia clasificacionFrecuencia) {
        this.clasificacionFrecuencia = clasificacionFrecuencia;
    }

    @Column(name = "reuniones_uum", length = 50)
    public String getUum() {
        return uum;
    }

    public void setUum(String uum) {
        this.uum = uum;
    }

    @Column(name = "reuniones_fum")
    public Date getFum() {
        return fum;
    }

    public void setFum(Date fum) {
        this.fum = fum;
    }
}
