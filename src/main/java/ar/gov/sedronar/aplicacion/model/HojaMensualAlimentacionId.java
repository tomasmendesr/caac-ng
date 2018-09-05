package ar.gov.sedronar.aplicacion.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigInteger;

/**
 * Created by TMR on 05/09/2018.
 */
@Embeddable
public class HojaMensualAlimentacionId {

    private BigInteger idHoja;
    private Integer idTipoAlimetacion;

    public HojaMensualAlimentacionId(BigInteger idHoja, Integer idTipoAlimetacion){
        this.idHoja = idHoja;
        this.idTipoAlimetacion = idTipoAlimetacion;
    }

    @Column(name = "idhoja")
    public BigInteger getIdHoja() {
        return idHoja;
    }

    @Column(name = "id_tipo_alimentacion")
    public void setIdHoja(BigInteger idHoja) {
        this.idHoja = idHoja;
    }

    public Integer getIdTipoAlimetacion() {
        return idTipoAlimetacion;
    }

    public void setIdTipoAlimetacion(Integer idTipoAlimetacion) {
        this.idTipoAlimetacion = idTipoAlimetacion;
    }
}
