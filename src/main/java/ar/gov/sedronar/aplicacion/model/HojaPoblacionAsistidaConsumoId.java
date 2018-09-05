package ar.gov.sedronar.aplicacion.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import java.math.BigInteger;

/**
 * Created by TMR on 05/09/2018.
 */
@Embeddable
public class HojaPoblacionAsistidaConsumoId {

    private BigInteger idHoja;
    private Integer idPoblacion;

    public HojaPoblacionAsistidaConsumoId(BigInteger idHoja, Integer idPoblacion){
        this.idHoja = idHoja;
        this.idPoblacion = idPoblacion;
    }

    @Column(name = "idhoja")
    public BigInteger getIdHoja() {
        return idHoja;
    }

    public void setIdHoja(BigInteger idHoja) {
        this.idHoja = idHoja;
    }

    @Column(name = "idpoblacion")
    public Integer getIdPoblacion() {
        return idPoblacion;
    }

    public void setIdPoblacion(Integer idPoblacion) {
        this.idPoblacion = idPoblacion;
    }
}
