package ar.gov.sedronar.aplicacion.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

/**
 * Created by TMR on 05/09/2018.
 */
@Embeddable
public class HojaMensualRecursosId implements Serializable {
    private Integer idRecursos;
    private BigInteger idHoja;

    public HojaMensualRecursosId(){}

    public HojaMensualRecursosId(Integer idRecursos, BigInteger idhoja){
        this.idRecursos = idRecursos;
        this.idHoja = idhoja;
    }

    @Column(name = "idrecursos")
    public Integer getIdRecursos() {
        return idRecursos;
    }

    public void setIdRecursos(Integer idRecursos) {
        this.idRecursos = idRecursos;
    }

    @Column(name = "idhoja")
    public BigInteger getIdHoja() {
        return idHoja;
    }

    public void setIdHoja(BigInteger idHoja) {
        this.idHoja = idHoja;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HojaMensualRecursosId)) return false;
        HojaMensualRecursosId that = (HojaMensualRecursosId) o;
        return Objects.equals(getIdHoja(), that.getIdHoja()) &&
                Objects.equals(getIdRecursos(), that.getIdRecursos());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdHoja(), getIdRecursos());
    }
}
