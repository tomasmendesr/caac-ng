package ar.gov.sedronar.aplicacion.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by TMR on 05/09/2018.
 */
@Embeddable
public class HojaArticulacionInstitucionalId implements Serializable {
    private Long idHoja;
    private Integer idTipoInstitucion;

    public HojaArticulacionInstitucionalId(){}

    public HojaArticulacionInstitucionalId(Long idHoja, Integer idTipoInstitucion){
        this.idHoja = idHoja;
        this.idTipoInstitucion = idTipoInstitucion;
    }

    @Column(name = "idhoja")
    public Long getIdHoja() {
        return idHoja;
    }

    public void setIdHoja(Long idHoja) {
        this.idHoja = idHoja;
    }

    @Column(name = "id_tipo_inst")
    public Integer getIdTipoInstitucion() {
        return idTipoInstitucion;
    }

    public void setIdTipoInstitucion(Integer idTipoInstitucion) {
        this.idTipoInstitucion = idTipoInstitucion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HojaArticulacionInstitucionalId)) return false;
        HojaArticulacionInstitucionalId that = (HojaArticulacionInstitucionalId) o;
        return Objects.equals(getIdHoja(), that.getIdHoja()) &&
                Objects.equals(getIdTipoInstitucion(), that.getIdTipoInstitucion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdHoja(), getIdTipoInstitucion());
    }
}
