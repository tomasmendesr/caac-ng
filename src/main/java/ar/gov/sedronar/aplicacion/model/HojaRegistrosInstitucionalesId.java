package ar.gov.sedronar.aplicacion.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigInteger;

/**
 * Created by TMR on 05/09/2018.
 */
@Embeddable
public class HojaRegistrosInstitucionalesId {
    private BigInteger idHoja;
    private Integer idClasificacionRegistro;

    public HojaRegistrosInstitucionalesId(BigInteger idHoja, Integer idClasificacionRegistro){
        this.idClasificacionRegistro = idClasificacionRegistro;
        this.idHoja = idHoja;
    }

    @Column(name = "idhoja")
    public BigInteger getIdHoja() {
        return idHoja;
    }

    public void setIdHoja(BigInteger idHoja) {
        this.idHoja = idHoja;
    }

    @Column(name = "idclasif_registros")
    public Integer getIdClasificacionRegistro() {
        return idClasificacionRegistro;
    }

    public void setIdClasificacionRegistro(Integer idClasificacionRegistro) {
        this.idClasificacionRegistro = idClasificacionRegistro;
    }
}
