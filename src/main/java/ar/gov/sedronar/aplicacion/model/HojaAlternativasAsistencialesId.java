package ar.gov.sedronar.aplicacion.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.math.BigInteger;

/**
 * Created by TMR on 05/09/2018.
 */
@Embeddable
public class HojaAlternativasAsistencialesId implements Serializable {
    private BigInteger idHoja;
    private Integer idAlternativaAsistencial;

    public HojaAlternativasAsistencialesId(BigInteger idhoja, Integer idAlternativaAsistencial){
        this.idHoja = idhoja;
        this.idAlternativaAsistencial = idAlternativaAsistencial;
    }

    @Column(name = "idhoja")
    public BigInteger getIdHoja() {
        return idHoja;
    }

    public void setIdHoja(BigInteger idHoja) {
        this.idHoja = idHoja;
    }

    @Column(name = "idalter_asist")
    public Integer getIdAlternativaAsistencial() {
        return idAlternativaAsistencial;
    }

    public void setIdAlternativaAsistencial(Integer idAlternativaAsistencial) {
        this.idAlternativaAsistencial = idAlternativaAsistencial;
    }

}
