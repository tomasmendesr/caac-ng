package ar.gov.sedronar.aplicacion.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by TMR on 05/09/2018.
 */
@Embeddable
public class HojaActividadIntervencionId implements Serializable {
    private Long idHoja;
    private Integer idActividad;

    public HojaActividadIntervencionId(){}

    public HojaActividadIntervencionId(Long idHoja, Integer idActividad){
        this.idHoja = idHoja;
        this.idActividad = idActividad;
    }

    @Column(name = "idHoja")
    public Long getIdHoja() {
        return idHoja;
    }

    public void setIdHoja(Long idHoja) {
        this.idHoja = idHoja;
    }

    @Column(name = "idactividad")
    public Integer getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Integer idActividad) {
        this.idActividad = idActividad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HojaActividadIntervencionId)) return false;
        HojaActividadIntervencionId that = (HojaActividadIntervencionId) o;
        return Objects.equals(getIdHoja(), that.getIdHoja()) &&
                Objects.equals(getIdActividad(), that.getIdActividad());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdHoja(), getIdActividad());
    }
}
