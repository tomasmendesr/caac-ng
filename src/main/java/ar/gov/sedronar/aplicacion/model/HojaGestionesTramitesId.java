package ar.gov.sedronar.aplicacion.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by TMR on 05/09/2018.
 */
@Embeddable
public class HojaGestionesTramitesId implements Serializable {

    private Long idHoja;
    private Integer idTramite;

    public HojaGestionesTramitesId(){}

    public HojaGestionesTramitesId(Long idhoja, Integer idTramite){
        this.idHoja = idhoja;
        this.idTramite = idTramite;
    }

    @Column(name = "idhoja")
    public Long getIdHoja() {
        return idHoja;
    }

    public void setIdHoja(Long idHoja) {
        this.idHoja = idHoja;
    }

    @Column(name = "idtramite")
    public Integer getIdTramite() {
        return idTramite;
    }

    public void setIdTramite(Integer idTramite) {
        this.idTramite = idTramite;
    }
}
