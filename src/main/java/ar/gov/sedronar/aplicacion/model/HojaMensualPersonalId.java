package ar.gov.sedronar.aplicacion.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigInteger;

/**
 * Created by TMR on 05/09/2018.
 */
@Embeddable
public class HojaMensualPersonalId {
    private BigInteger idHoja;
    private Integer idEmpleado;
    public HojaMensualPersonalId(BigInteger idhoja, Integer idEmpleado){
        this.idHoja = idhoja;
        this.idEmpleado = idEmpleado;
    }

    @Column(name = "idhoja")
    public BigInteger getIdHoja() {
        return idHoja;
    }

    public void setIdHoja(BigInteger idHoja) {
        this.idHoja = idHoja;
    }

    @Column(name = "idempleado")
    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
}
