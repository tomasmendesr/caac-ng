package ar.gov.sedronar.aplicacion.dto;


public class LogDTO {

    private Integer id;
    private String cambios;
    private String fechHora;
    private String usuario;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCambios() {
        return this.cambios;
    }

    public void setCambios(String cambios) {
        this.cambios = cambios;
    }

    public String getFechHora() {
        return this.fechHora;
    }

    public void setFechHora(String fechHora) {
        this.fechHora = fechHora;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}