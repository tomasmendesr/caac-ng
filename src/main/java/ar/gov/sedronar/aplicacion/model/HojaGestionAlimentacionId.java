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
public class HojaGestionAlimentacionId implements Serializable {
    private BigInteger idHoja;
    private Integer idAlimentacion;

    public HojaGestionAlimentacionId(){}

    public HojaGestionAlimentacionId(BigInteger idhoja, Integer idAlimentacion){
        this.idAlimentacion = idAlimentacion;
        this.idHoja = idhoja;
    }

    @Column(name = "idhoja")
    public BigInteger getIdHoja() {
        return idHoja;
    }

    public void setIdHoja(BigInteger idHoja) {
        this.idHoja = idHoja;
    }

    @Column(name = "idalimentacion")
    public Integer getIdAlimentacion() {
        return idAlimentacion;
    }

    public void setIdAlimentacion(Integer idAlimentacion) {
        this.idAlimentacion = idAlimentacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HojaGestionAlimentacionId)) return false;
        HojaGestionAlimentacionId that = (HojaGestionAlimentacionId) o;
        return Objects.equals(getIdHoja(), that.getIdHoja()) &&
                Objects.equals(getIdAlimentacion(), that.getIdAlimentacion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdHoja(), getIdAlimentacion());
    }
}
