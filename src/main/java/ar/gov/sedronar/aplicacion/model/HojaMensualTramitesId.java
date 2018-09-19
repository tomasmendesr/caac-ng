package ar.gov.sedronar.aplicacion.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by TMR on 05/09/2018.
 */
@Embeddable
public class HojaMensualTramitesId implements Serializable {
    private Long idHoja;
    private Integer idTramite;

    public HojaMensualTramitesId(){}


    public HojaMensualTramitesId(Long idHoja, Integer idTramite){
        this.idHoja = idHoja;
        this.idTramite = idTramite;
    }

    @Column(name = "idhoja")
    public Long getIdHoja() {
        return idHoja;
    }

    public void setIdHoja(Long idHoja) {
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
        return Objects.equals(getIdHoja(), that.getIdTramite()) &&
                Objects.equals(getIdHoja(), that.getIdHoja());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdHoja(), getIdTramite());
    }
}
