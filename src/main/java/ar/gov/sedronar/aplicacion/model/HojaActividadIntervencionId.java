package ar.gov.sedronar.aplicacion.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.math.BigInteger;

/**
 * Created by TMR on 05/09/2018.
 */
@Embeddable
public class HojaActividadIntervencionId implements Serializable {
    private BigInteger idhoja;
    private Integer idActividad;

    public HojaActividadIntervencionId(BigInteger idhoja, Integer idActividad){
        this.idhoja = idhoja;
        this.idActividad = idActividad;
    }

    @Column(name = "idhoja")
    public BigInteger getIdhoja() {
        return idhoja;
    }

    public void setIdhoja(BigInteger idhoja) {
        this.idhoja = idhoja;
    }

    @Column(name = "idactividad")
    public Integer getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Integer idActividad) {
        this.idActividad = idActividad;
    }
}
