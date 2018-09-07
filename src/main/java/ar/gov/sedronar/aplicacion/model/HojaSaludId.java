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
public class HojaSaludId implements Serializable {
    private BigInteger idHoja;
    private Integer idGestion;

    public HojaSaludId(){}

    public HojaSaludId(BigInteger idHoja, Integer idGestion){
        this.idHoja = idHoja;
        this.idGestion = idGestion;
    }

    @Column(name = "idhoja")
    public BigInteger getIdHoja() {
        return idHoja;
    }

    public void setIdHoja(BigInteger idHoja) {
        this.idHoja = idHoja;
    }

    @Column(name = "idgestion")
    public Integer getIdGestion() {
        return idGestion;
    }

    public void setIdGestion(Integer idGestion) {
        this.idGestion = idGestion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HojaSaludId)) return false;
        HojaSaludId that = (HojaSaludId) o;
        return Objects.equals(getIdHoja(), that.getIdHoja()) &&
                Objects.equals(getIdGestion(), that.getIdGestion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdHoja(), getIdGestion());
    }
}
