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
public class HojaMensualAlimentacionId implements Serializable {

    private BigInteger idHoja;
    private Integer idTipoAlimetacion;

    public HojaMensualAlimentacionId(){}

    public HojaMensualAlimentacionId(BigInteger idHoja, Integer idTipoAlimetacion){
        this.idHoja = idHoja;
        this.idTipoAlimetacion = idTipoAlimetacion;
    }

    @Column(name = "idhoja")
    public BigInteger getIdHoja() {
        return idHoja;
    }

    @Column(name = "id_tipo_alimentacion")
    public void setIdHoja(BigInteger idHoja) {
        this.idHoja = idHoja;
    }

    public Integer getIdTipoAlimetacion() {
        return idTipoAlimetacion;
    }

    public void setIdTipoAlimetacion(Integer idTipoAlimetacion) {
        this.idTipoAlimetacion = idTipoAlimetacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HojaMensualAlimentacionId)) return false;
        HojaMensualAlimentacionId that = (HojaMensualAlimentacionId) o;
        return Objects.equals(getIdHoja(), that.getIdHoja()) &&
                Objects.equals(getIdTipoAlimetacion(), that.getIdTipoAlimetacion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdHoja(), getIdTipoAlimetacion());
    }
}
