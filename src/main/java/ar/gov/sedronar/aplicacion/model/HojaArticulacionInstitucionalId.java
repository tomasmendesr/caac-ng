package ar.gov.sedronar.aplicacion.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigInteger;

/**
 * Created by TMR on 05/09/2018.
 */
@Embeddable
public class HojaArticulacionInstitucionalId {
    private BigInteger idHoja;
    private Integer idTipoInstitucion;

    public HojaArticulacionInstitucionalId(BigInteger idHoja, Integer idTipoInstitucion){
        this.idHoja = idHoja;
        this.idTipoInstitucion = idTipoInstitucion;
    }

    @Column(name = "idhoja")
    public BigInteger getIdHoja() {
        return idHoja;
    }

    public void setIdHoja(BigInteger idHoja) {
        this.idHoja = idHoja;
    }

    @Column(name = "id_tipo_inst")
    public Integer getIdTipoInstitucion() {
        return idTipoInstitucion;
    }

    public void setIdTipoInstitucion(Integer idTipoInstitucion) {
        this.idTipoInstitucion = idTipoInstitucion;
    }
}
