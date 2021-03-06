package ar.gov.sedronar.aplicacion.dto;

import ar.gov.sedronar.modulo.commonsModels.dto.ProfesionDTO;
import ar.gov.sedronar.modulo.commonsModels.modelo.Profesion;

import java.util.Date;

/**
 * Created by TMR on 05/09/2018.
 */
public class PersonalDTO {
    private Integer id;
    private ProfesionDTO profesion;
    private String nombre;
    private String apellido;
    private Integer horasSemanales;
    private String rol;
    private String titulo;
    private String esRentado;
    private String estadoActual;
    private String uum;
    private java.util.Date fum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProfesionDTO getProfesion() {
        return profesion;
    }

    public void setProfesion(ProfesionDTO profesion) {
        this.profesion = profesion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getHorasSemanales() {
        return horasSemanales;
    }

    public void setHorasSemanales(Integer horasSemanales) {
        this.horasSemanales = horasSemanales;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEsRentado() {
        return esRentado;
    }

    public void setEsRentado(String esRentado) {
        this.esRentado = esRentado;
    }

    public String getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(String estadoActual) {
        this.estadoActual = estadoActual;
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
