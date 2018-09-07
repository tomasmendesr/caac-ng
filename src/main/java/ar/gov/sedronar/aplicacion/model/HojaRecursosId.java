package ar.gov.sedronar.aplicacion.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by TMR on 05/09/2018.
 */
@Embeddable
public class HojaRecursosId implements Serializable {
    private Long idHoja;
    private Integer idRecurso;

    public HojaRecursosId(){}

    public HojaRecursosId(Long idHoja, Integer idRecurso){
        this.idHoja = idHoja;
        this.idRecurso = idRecurso;
    }

    @Column(name = "idhoja")
    public Long getIdHoja() {
        return idHoja;
    }

    public void setIdHoja(Long idHoja) {
        this.idHoja = idHoja;
    }

    @Column(name = "id")
    public Integer getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(Integer idRecurso) {
        this.idRecurso = idRecurso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HojaRecursosId)) return false;
        HojaRecursosId that = (HojaRecursosId) o;
        return Objects.equals(getIdHoja(), that.getIdHoja()) &&
                Objects.equals(getIdRecurso(), that.getIdRecurso());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdHoja(), getIdRecurso());
    }
}
