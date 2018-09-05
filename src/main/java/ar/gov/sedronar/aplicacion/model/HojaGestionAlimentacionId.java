package ar.gov.sedronar.aplicacion.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigInteger;

/**
 * Created by TMR on 05/09/2018.
 */
@Embeddable
public class HojaGestionAlimentacionId {
    private BigInteger idHoja;
    private Integer idAlimentacion;

    public HojaGestionAlimentacionId(BigInteger idhoja, Integer idAlimentacion){
        this.idAlimentacion = idAlimentacion;
        this.idHoja = idhoja;
    }

    @Column(name = "idhoja")
    public BigInteger getIdHoja() {
        return idHoja;
    }

    public void setIdHoja(BigInteger idHoja) {
        this.idHoja = idHoja;
    }

    @Column(name = "idalimentacion")
    public Integer getIdAlimentacion() {
        return idAlimentacion;
    }

    public void setIdAlimentacion(Integer idAlimentacion) {
        this.idAlimentacion = idAlimentacion;
    }
}
