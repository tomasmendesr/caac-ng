package ar.gov.sedronar.aplicacion.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by TMR on 05/09/2018.
 */
@Embeddable
public class HojaMensualAlimentacionId implements Serializable {

    private Long idHoja;
    private Integer idTipoAlimentacion;

    public HojaMensualAlimentacionId(){}

    public HojaMensualAlimentacionId(Long idHoja, Integer idTipoAlimentacion){
        this.idHoja = idHoja;
        this.idTipoAlimentacion = idTipoAlimentacion;
    }

    @Column(name = "idhoja")
    public Long getIdHoja() {
        return idHoja;
    }

    public void setIdHoja(Long idHoja) {
        this.idHoja = idHoja;
    }

    @Column(name = "id_tipo_alimentacion")
    public Integer getIdTipoAlimentacion() {
        return idTipoAlimentacion;
    }

    public void setIdTipoAlimentacion(Integer idTipoAlimentacion) {
        this.idTipoAlimentacion = idTipoAlimentacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HojaMensualAlimentacionId)) return false;
        HojaMensualAlimentacionId that = (HojaMensualAlimentacionId) o;
        return Objects.equals(getIdHoja(), that.getIdHoja()) &&
                Objects.equals(getIdTipoAlimentacion(), that.getIdTipoAlimentacion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdHoja(), getIdTipoAlimentacion());
    }
}
