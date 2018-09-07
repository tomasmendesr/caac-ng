package ar.gov.sedronar.aplicacion.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by TMR on 05/09/2018.
 */
@Embeddable
public class HojaAlternativasAsistencialesId implements Serializable {
    private Long idHoja;
    private Integer idAlternativaAsistencial;

    public HojaAlternativasAsistencialesId(){}

    public HojaAlternativasAsistencialesId(Long idhoja, Integer idAlternativaAsistencial){
        this.idHoja = idhoja;
        this.idAlternativaAsistencial = idAlternativaAsistencial;
    }

    @Column(name = "idhoja")
    public Long getIdHoja() {
        return idHoja;
    }

    public void setIdHoja(Long idHoja) {
        this.idHoja = idHoja;
    }

    @Column(name = "idalter_asist")
    public Integer getIdAlternativaAsistencial() {
        return idAlternativaAsistencial;
    }

    public void setIdAlternativaAsistencial(Integer idAlternativaAsistencial) {
        this.idAlternativaAsistencial = idAlternativaAsistencial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HojaAlternativasAsistencialesId)) return false;
        HojaAlternativasAsistencialesId that = (HojaAlternativasAsistencialesId) o;
        return Objects.equals(getIdHoja(), that.getIdHoja()) &&
                Objects.equals(getIdAlternativaAsistencial(), that.getIdAlternativaAsistencial());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdHoja(), getIdAlternativaAsistencial());
    }

}
