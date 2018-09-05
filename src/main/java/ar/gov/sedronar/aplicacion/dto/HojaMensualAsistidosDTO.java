package ar.gov.sedronar.aplicacion.dto;

import ar.gov.sedronar.aplicacion.model.Hoja;

import java.math.BigInteger;
import java.util.Date;

/**
 * Created by TMR on 05/09/2018.
 */
public class HojaMensualAsistidosDTO {
    private BigInteger id;
    private HojaDTO hoja;
    private Integer asistidosVarones;
    private Integer asistidosMujeres;
    private Integer asistidosOtroGenero;
    private Integer asistidosCantidad;
    private String uum;
    private Date fum;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public HojaDTO getHoja() {
        return hoja;
    }

    public void setHoja(HojaDTO hoja) {
        this.hoja = hoja;
    }

    public Integer getAsistidosVarones() {
        return asistidosVarones;
    }

    public void setAsistidosVarones(Integer asistidosVarones) {
        this.asistidosVarones = asistidosVarones;
    }

    public Integer getAsistidosMujeres() {
        return asistidosMujeres;
    }

    public void setAsistidosMujeres(Integer asistidosMujeres) {
        this.asistidosMujeres = asistidosMujeres;
    }

    public Integer getAsistidosOtroGenero() {
        return asistidosOtroGenero;
    }

    public void setAsistidosOtroGenero(Integer asistidosOtroGenero) {
        this.asistidosOtroGenero = asistidosOtroGenero;
    }

    public Integer getAsistidosCantidad() {
        return asistidosCantidad;
    }

    public void setAsistidosCantidad(Integer asistidosCantidad) {
        this.asistidosCantidad = asistidosCantidad;
    }

    public String getUum() {
        return uum;
    }

    public void setUum(String uum) {
        this.uum = uum;
    }

    public Date getFum() {
        return fum;
    }

    public void setFum(Date fum) {
        this.fum = fum;
    }
}
