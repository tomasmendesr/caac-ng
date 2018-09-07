package ar.gov.sedronar.aplicacion.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

/**
 * Created by TMR on 05/09/2018.
 */
@Embeddable
public class HojaMensualActividadesId implements Serializable {
    private BigInteger idHoja;
    private Integer idActividad;

    public HojaMensualActividadesId(){}

    public HojaMensualActividadesId(BigInteger idHoja, Integer idActividad){
        this.idHoja = idHoja;
        this.idActividad = idActividad;
    }

    @Column(name = "idhoja")
    public BigInteger getIdHoja() {
        return idHoja;
    }

    public void setIdHoja(BigInteger idHoja) {
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
        if (!(o instanceof HojaMensualActividadesId)) return false;
        HojaMensualActividadesId that = (HojaMensualActividadesId) o;
        return Objects.equals(getIdHoja(), that.getIdHoja()) &&
                Objects.equals(getIdActividad(), that.getIdActividad());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdHoja(), getIdActividad());
    }
}
