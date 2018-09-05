package ar.gov.sedronar.aplicacion.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import java.math.BigInteger;

/**
 * Created by TMR on 05/09/2018.
 */
@Embeddable
public class HojaMensualRecursosId {
    private Integer idRecursos;
    private BigInteger idHoja;

    public HojaMensualRecursosId(Integer idRecursos, BigInteger idhoja){
        this.idRecursos = idRecursos;
        this.idHoja = idhoja;
    }

    @Column(name = "idrecursos")
    public Integer getIdRecursos() {
        return idRecursos;
    }

    public void setIdRecursos(Integer idRecursos) {
        this.idRecursos = idRecursos;
    }

    @Column(name = "idhoja")
    public BigInteger getIdHoja() {
        return idHoja;
    }

    public void setIdHoja(BigInteger idHoja) {
        this.idHoja = idHoja;
    }
}
