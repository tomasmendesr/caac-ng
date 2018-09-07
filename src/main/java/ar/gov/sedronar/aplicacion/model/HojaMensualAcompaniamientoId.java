package ar.gov.sedronar.aplicacion.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by TMR on 04/09/2018.
 */
@Embeddable
public class HojaMensualAcompaniamientoId implements Serializable {

    private Long idHoja;
    private Integer idAcompaniamiento;

    public HojaMensualAcompaniamientoId(){}

    public HojaMensualAcompaniamientoId(Long idHoja, Integer idAcompaniamiento){
        this.idHoja = idHoja;
        this.idAcompaniamiento = idAcompaniamiento;
    }

    @Column(name = "idhoja")
    public Long getIdHoja() {
        return idHoja;
    }

    public void setIdHoja(Long idHoja) {
        this.idHoja = idHoja;
    }

    @Column(name = "idacompaniamiento")
    public Integer getIdAcompaniamiento() {
        return idAcompaniamiento;
    }

    public void setIdAcompaniamiento(Integer idAcompaniamiento) {
        this.idAcompaniamiento = idAcompaniamiento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HojaMensualAcompaniamientoId)) return false;
        HojaMensualAcompaniamientoId that = (HojaMensualAcompaniamientoId) o;
        return Objects.equals(getIdHoja(), that.getIdHoja()) &&
                Objects.equals(getIdAcompaniamiento(), that.getIdAcompaniamiento());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdHoja(), getIdAcompaniamiento());
    }

}
