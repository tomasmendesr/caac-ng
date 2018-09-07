package ar.gov.sedronar.aplicacion.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

/**
 * Created by TMR on 05/09/2018.
 */
@Embeddable
public class HojaRegistrosInstitucionalesId implements Serializable {
    private BigInteger idHoja;
    private Integer idClasificacionRegistro;

    public HojaRegistrosInstitucionalesId(){}

    public HojaRegistrosInstitucionalesId(BigInteger idHoja, Integer idClasificacionRegistro){
        this.idClasificacionRegistro = idClasificacionRegistro;
        this.idHoja = idHoja;
    }

    @Column(name = "idhoja")
    public BigInteger getIdHoja() {
        return idHoja;
    }

    public void setIdHoja(BigInteger idHoja) {
        this.idHoja = idHoja;
    }

    @Column(name = "idclasif_registros")
    public Integer getIdClasificacionRegistro() {
        return idClasificacionRegistro;
    }

    public void setIdClasificacionRegistro(Integer idClasificacionRegistro) {
        this.idClasificacionRegistro = idClasificacionRegistro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HojaRegistrosInstitucionalesId)) return false;
        HojaRegistrosInstitucionalesId that = (HojaRegistrosInstitucionalesId) o;
        return Objects.equals(getIdHoja(), that.getIdHoja()) &&
                Objects.equals(getIdClasificacionRegistro(), that.getIdClasificacionRegistro());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdHoja(), getIdClasificacionRegistro());
    }
}
