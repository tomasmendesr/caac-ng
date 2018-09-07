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
public class HojaMensualPersonalId implements Serializable {
    private BigInteger idHoja;
    private Integer idEmpleado;

    public HojaMensualPersonalId(){}

    public HojaMensualPersonalId(BigInteger idhoja, Integer idEmpleado){
        this.idHoja = idhoja;
        this.idEmpleado = idEmpleado;
    }

    @Column(name = "idhoja")
    public BigInteger getIdHoja() {
        return idHoja;
    }

    public void setIdHoja(BigInteger idHoja) {
        this.idHoja = idHoja;
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
        if (!(o instanceof HojaMensualPersonalId)) return false;
        HojaMensualPersonalId that = (HojaMensualPersonalId) o;
        return Objects.equals(getIdHoja(), that.getIdHoja()) &&
                Objects.equals(getIdEmpleado(), that.getIdEmpleado());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdHoja(), getIdEmpleado());
    }
}
