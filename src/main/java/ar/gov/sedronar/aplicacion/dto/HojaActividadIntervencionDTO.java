package ar.gov.sedronar.aplicacion.dto;
import java.util.Date;
/**
 * Created by TMR on 05/09/2018.
 */
public class HojaActividadIntervencionDTO {
    private HojaDTO hoja;
    private ActividadIntervencionDTO actividadIntervencion;
    private String descripcion;
    private String uum;
    private java.util.Date fum;

    public HojaDTO getHoja() {
        return hoja;
    }

    public void setHoja(HojaDTO hoja) {
        this.hoja = hoja;
    }

    public ActividadIntervencionDTO getActividadIntervencion() {
        return actividadIntervencion;
    }

    public void setActividadIntervencion(ActividadIntervencionDTO actividadIntervencion) {
        this.actividadIntervencion = actividadIntervencion;
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
}
