package ar.gov.sedronar.aplicacion.dto;

/**
 * Created by TMR on 04/09/2018.
 */
public class ActividadIntervencionDTO {
    private Integer id;
    private String tipoActividad;
    private String descripcionActividad;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public String getDescripcionActividad() {
        return descripcionActividad;
    }

    public void setDescripcionActividad(String descripcionActividad) {
        this.descripcionActividad = descripcionActividad;
    }
}
