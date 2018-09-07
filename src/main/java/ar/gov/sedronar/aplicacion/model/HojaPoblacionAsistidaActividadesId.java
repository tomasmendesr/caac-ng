package ar.gov.sedronar.aplicacion.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by TMR on 05/09/2018.
 */
@Embeddable
public class HojaPoblacionAsistidaActividadesId implements Serializable {
    private Long idHoja;
    private Integer idPoblacion;

    public HojaPoblacionAsistidaActividadesId(){}

    public HojaPoblacionAsistidaActividadesId(Long idHoja, Integer idPoblacion){
        this.idHoja = idHoja;
        this.idPoblacion = idPoblacion;
    }

    @Column(name = "idhoja")
    public Long getIdHoja() {
        return idHoja;
    }

    public void setIdHoja(Long idHoja) {
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
        if (!(o instanceof HojaPoblacionAsistidaActividadesId)) return false;
        HojaPoblacionAsistidaActividadesId that = (HojaPoblacionAsistidaActividadesId) o;
        return Objects.equals(getIdHoja(), that.getIdHoja()) &&
                Objects.equals(getIdPoblacion(), that.getIdPoblacion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdHoja(), getIdPoblacion());
    }
}
