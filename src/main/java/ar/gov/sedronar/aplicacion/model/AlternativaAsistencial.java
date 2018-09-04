package ar.gov.sedronar.aplicacion.model;

import javax.persistence.*;

/**
 * Created by TMR on 04/09/2018.
 */
@Entity
@Table(name = "ALTERNATIVAS_ASISTENCIALES", schema="caac")
public class AlternativaAsistencial {
    private Integer id;
    private String nombre;
    private String descripcion;

    public AlternativaAsistencial(){}

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "nombre", length=100)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "descripcion", length = 300)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
