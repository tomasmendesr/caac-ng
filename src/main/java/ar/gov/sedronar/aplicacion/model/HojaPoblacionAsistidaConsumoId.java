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
public class HojaPoblacionAsistidaConsumoId implements Serializable {

    private BigInteger idHoja;
    private Integer idPoblacion;

    public HojaPoblacionAsistidaConsumoId(){}

    public HojaPoblacionAsistidaConsumoId(BigInteger idHoja, Integer idPoblacion){
        this.idHoja = idHoja;
        this.idPoblacion = idPoblacion;
    }

    @Column(name = "idhoja")
    public BigInteger getIdHoja() {
        return idHoja;
    }

    public void setIdHoja(BigInteger idHoja) {
        this.idHoja = idHoja;
    }

    @Column(name = "idpoblacion")
    public Integer getIdPoblacion() {
        return idPoblacion;
    }

    public void setIdPoblacion(Integer idPoblacion) {
        this.idPoblacion = idPoblacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HojaPoblacionAsistidaConsumoId)) return false;
        HojaPoblacionAsistidaConsumoId that = (HojaPoblacionAsistidaConsumoId) o;
        return Objects.equals(getIdHoja(), that.getIdHoja()) &&
                Objects.equals(getIdPoblacion(), that.getIdPoblacion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdHoja(), getIdPoblacion());
    }
}
