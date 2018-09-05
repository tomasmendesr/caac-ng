package ar.gov.sedronar.aplicacion.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigInteger;

/**
 * Created by TMR on 05/09/2018.
 */
@Embeddable
public class HojaRecursosId {
    private BigInteger idHoja;
    private Integer idRecurso;

    public HojaRecursosId(BigInteger idHoja, Integer idRecurso){
        this.idHoja = idHoja;
        this.idRecurso = idRecurso;
    }

    @Column(name = "idhoja")
    public BigInteger getIdHoja() {
        return idHoja;
    }

    public void setIdHoja(BigInteger idHoja) {
        this.idHoja = idHoja;
    }

    @Column(name = "idrecurso")
    public Integer getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(Integer idRecurso) {
        this.idRecurso = idRecurso;
    }
}
