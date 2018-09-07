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
public class HojaPersonalId implements Serializable {
    private BigInteger idhoja;
    private Integer idEmpleado;

    public HojaPersonalId(){}

    public HojaPersonalId(BigInteger idhoja, Integer idEmpleado){
        this.idhoja = idhoja;
        this.idEmpleado = idEmpleado;
    }

    @Column(name = "idhoja")
    public BigInteger getIdhoja() {
        return idhoja;
    }

    public void setIdhoja(BigInteger idhoja) {
        this.idhoja = idhoja;
    }

    @Column(name = "idempleado")
    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HojaPersonalId)) return false;
        HojaPersonalId that = (HojaPersonalId) o;
        return Objects.equals(getIdhoja(), that.getIdhoja()) &&
                Objects.equals(getIdEmpleado(), that.getIdEmpleado());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdhoja(), getIdEmpleado());
    }
}
