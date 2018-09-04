package ar.gov.sedronar.aplicacion.dto;
import java.util.Date;
/**
 * Created by TMR on 04/09/2018.
 */
public class AuditoriaDTO {

    private Integer id;
    private CasaDTO casa;
    private Integer anio;
    private Integer naudi;
    private String tipoaud;
    private Date fechaudi;
    private String prof;
    private Date fechven;
    private Integer canaten;
    private Integer canasis;
    private String obsaudi;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CasaDTO getCasa() {
        return casa;
    }

    public void setCasa(CasaDTO casa) {
        this.casa = casa;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getNaudi() {
        return naudi;
    }

    public void setNaudi(Integer naudi) {
        this.naudi = naudi;
    }

    public String getTipoaud() {
        return tipoaud;
    }

    public void setTipoaud(String tipoaud) {
        this.tipoaud = tipoaud;
    }

    public Date getFechaudi() {
        return fechaudi;
    }

    public void setFechaudi(Date fechaudi) {
        this.fechaudi = fechaudi;
    }

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

    public Date getFechven() {
        return fechven;
    }

    public void setFechven(Date fechven) {
        this.fechven = fechven;
    }

    public Integer getCanaten() {
        return canaten;
    }

    public void setCanaten(Integer canaten) {
        this.canaten = canaten;
    }

    public Integer getCanasis() {
        return canasis;
    }

    public void setCanasis(Integer canasis) {
        this.canasis = canasis;
    }

    public String getObsaudi() {
        return obsaudi;
    }

    public void setObsaudi(String obsaudi) {
        this.obsaudi = obsaudi;
    }

}

