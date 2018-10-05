package ar.gov.sedronar.aplicacion.dto;
import java.util.Date;
/**
 * Created by TMR on 05/09/2018.
 */
public class HojaAlternativasAsistencialesDTO {
    private HojaDTO hoja;
    private AlternativaAsistencialDTO alternativaAsistencial;
    private String descripcion;
    private String uum;
    private java.util.Date fum;
    private Boolean isChecked;

    public HojaDTO getHoja() {
        return hoja;
    }

    public void setHoja(HojaDTO hoja) {
        this.hoja = hoja;
    }

    public AlternativaAsistencialDTO getAlternativaAsistencial() {
        return alternativaAsistencial;
    }

    public void setAlternativaAsistencial(AlternativaAsistencialDTO alternativaAsistencial) {
        this.alternativaAsistencial = alternativaAsistencial;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUum() {
        return uum;
    }

    public void setUum(String uum) {
        this.uum = uum;
    }

    public Date getFum() {
        return fum;
    }

    public void setFum(Date fum) {
        this.fum = fum;
    }

    public Boolean getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(Boolean checked) {
        isChecked = checked;
    }
}
