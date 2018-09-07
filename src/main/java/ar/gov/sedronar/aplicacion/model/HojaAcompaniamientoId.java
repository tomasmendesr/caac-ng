package ar.gov.sedronar.aplicacion.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by TMR on 05/09/2018.
 */
@Embeddable
public class HojaAcompaniamientoId implements Serializable {
    private Long idHoja;
    private Integer idAcompaniamiento;

    public HojaAcompaniamientoId(){}

    public HojaAcompaniamientoId(Long idhoja, Integer idAcompaniamiento){
        this.idHoja = idhoja;
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
        if (!(o instanceof HojaAcompaniamientoId)) return false;
        HojaAcompaniamientoId that = (HojaAcompaniamientoId) o;
        return Objects.equals(getIdHoja(), that.getIdHoja()) &&
                Objects.equals(getIdAcompaniamiento(), that.getIdAcompaniamiento());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdHoja(), getIdHoja());
    }
}
