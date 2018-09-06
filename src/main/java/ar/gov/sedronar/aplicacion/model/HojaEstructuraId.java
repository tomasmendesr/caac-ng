package ar.gov.sedronar.aplicacion.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.math.BigInteger;

/**
 * Created by TMR on 05/09/2018.
 */
@Embeddable
public class HojaEstructuraId implements Serializable {
    private BigInteger idhoja;
    private Integer idEspacio;

    public HojaEstructuraId(BigInteger idhoja, Integer idEspacio){
        this.idEspacio = idEspacio;
        this.idhoja = idhoja;
    }

    @Column(name = "idhoja")
    public BigInteger getIdhoja() {
        return idhoja;
    }

    public void setIdhoja(BigInteger idhoja) {
        this.idhoja = idhoja;
    }

    @Column(name = "idespacio")
    public Integer getIdEspacio() {
        return idEspacio;
    }

    public void setIdEspacio(Integer idEspacio) {
        this.idEspacio = idEspacio;
    }
}
