package ar.gov.sedronar.aplicacion.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by TMR on 05/09/2018.
 */
@Embeddable
public class HojaEstructuraId implements Serializable {
    private Long idhoja;
    private Integer idEspacio;

    public HojaEstructuraId(){}

    public HojaEstructuraId(Long idhoja, Integer idEspacio){
        this.idEspacio = idEspacio;
        this.idhoja = idhoja;
    }

    @Column(name = "idhoja")
    public Long getIdhoja() {
        return idhoja;
    }

    public void setIdhoja(Long idhoja) {
        this.idhoja = idhoja;
    }

    @Column(name = "idespacio")
    public Integer getIdEspacio() {
        return idEspacio;
    }

    public void setIdEspacio(Integer idEspacio) {
        this.idEspacio = idEspacio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HojaEstructuraId)) return false;
        HojaEstructuraId that = (HojaEstructuraId) o;
        return Objects.equals(getIdhoja(), that.getIdhoja()) &&
                Objects.equals(getIdEspacio(), that.getIdEspacio());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdhoja(), getIdEspacio());
    }
}
