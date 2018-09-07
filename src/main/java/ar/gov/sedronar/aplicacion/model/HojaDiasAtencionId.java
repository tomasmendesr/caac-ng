package ar.gov.sedronar.aplicacion.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by TMR on 05/09/2018.
 */
@Embeddable
public class HojaDiasAtencionId  implements Serializable {
    private Long idHoja;
    private Integer idDia;

    public HojaDiasAtencionId(){}

    public HojaDiasAtencionId(Long idHoja, Integer idDia){
        this.idHoja = idHoja;
        this.idDia = idDia;
    }

    @Column(name = "idhoja")
    public Long getIdHoja() {
        return idHoja;
    }

    public void setIdHoja(Long idHoja) {
        this.idHoja = idHoja;
    }

    @Column(name = "id")
    public Integer getIdDia() {
        return idDia;
    }

    public void setIdDia(Integer idDia) {
        this.idDia = idDia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HojaDiasAtencionId)) return false;
        HojaDiasAtencionId that = (HojaDiasAtencionId) o;
        return Objects.equals(getIdHoja(), that.getIdHoja()) &&
                Objects.equals(getIdDia(), that.getIdDia());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdHoja(), getIdDia());
    }
}
