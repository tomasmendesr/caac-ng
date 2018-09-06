package ar.gov.sedronar.aplicacion.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
/**
 * Created by TMR on 05/09/2018.
 */
@Entity
@Table(name = "H_MENSUAL_ASISTIDOS", schema = "caac")
public class HojaMensualAsistidos {

    private BigInteger id;
    private Hoja hoja;
    private Integer asistidosVarones;
    private Integer asistidosMujeres;
    private Integer asistidosOtroGenero;
    private Integer asistidosCantidad;
    private String uum;
    private Date fum;

    public HojaMensualAsistidos(){}

    @Id
    @Column(name = "idhoja")
    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
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

    @Column(name = "asist_varones")
    public Integer getAsistidosVarones() {
        return asistidosVarones;
    }

    public void setAsistidosVarones(Integer asistidosVarones) {
        this.asistidosVarones = asistidosVarones;
    }

    @Column(name = "asist_mujeres")
    public Integer getAsistidosMujeres() {
        return asistidosMujeres;
    }

    public void setAsistidosMujeres(Integer asistidosMujeres) {
        this.asistidosMujeres = asistidosMujeres;
    }

    @Column(name = "asist_otro_genero")
    public Integer getAsistidosOtroGenero() {
        return asistidosOtroGenero;
    }

    public void setAsistidosOtroGenero(Integer asistidosOtroGenero) {
        this.asistidosOtroGenero = asistidosOtroGenero;
    }

    @Column(name = "asist_cantidad")
    public Integer getAsistidosCantidad() {
        return asistidosCantidad;
    }

    public void setAsistidosCantidad(Integer asistidosCantidad) {
        this.asistidosCantidad = asistidosCantidad;
    }

    @Column(name = "asist_uum", length = 50)
    public String getUum() {
        return uum;
    }

    public void setUum(String uum) {
        this.uum = uum;
    }

    @Column(name = "asist_fum")
    public Date getFum() {
        return fum;
    }

    public void setFum(Date fum) {
        this.fum = fum;
    }
}
