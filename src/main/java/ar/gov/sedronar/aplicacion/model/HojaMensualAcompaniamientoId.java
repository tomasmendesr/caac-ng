package ar.gov.sedronar.aplicacion.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by TMR on 04/09/2018.
 */
@Embeddable
public class HojaMensualAcompaniamientoId implements Serializable {

    private Integer idHoja;
    private Integer idAcompaniamiento;

    public HojaMensualAcompaniamientoId(Integer idHoja, Integer idAcompaniamiento){
        this.idHoja = idHoja;
        this.idAcompaniamiento = idAcompaniamiento;
    }

    @Column(name = "idhoja")
    public Integer getIdHoja() {
        return idHoja;
    }

    public void setIdHoja(Integer idHoja) {
        this.idHoja = idHoja;
    }

    @Column(name = "idacompaniamiento")
    public Integer getIdAcompaniamiento() {
        return idAcompaniamiento;
    }

    public void setIdAcompaniamiento(Integer idAcompaniamiento) {
        this.idAcompaniamiento = idAcompaniamiento;
    }


}
