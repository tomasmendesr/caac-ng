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
public class HojaMensualTramitesId implements Serializable {
    private BigInteger idHoja;
    private Integer idTramite;

    public HojaMensualTramitesId(){}

    public HojaMensualTramitesId(BigInteger idHoja, Integer idTramite){
        this.idHoja = idHoja;
        this.idTramite = idTramite;
    }

    @Column(name = "idhoja")
    public BigInteger getIdHoja() {
        return idHoja;
    }

    public void setIdHoja(BigInteger idHoja) {
        this.idHoja = idHoja;
    }

    @Column(name = "idtramite")
    public Integer getIdTramite() {
        return idTramite;
    }

    public void setIdTramite(Integer idTramite) {
        this.idTramite = idTramite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HojaMensualTramitesId)) return false;
        HojaMensualTramitesId that = (HojaMensualTramitesId) o;
        return Objects.equals(getIdHoja(), that.getIdHoja()) &&
                Objects.equals(getIdTramite(), that.getIdTramite());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdHoja(), getIdTramite());
    }
}
