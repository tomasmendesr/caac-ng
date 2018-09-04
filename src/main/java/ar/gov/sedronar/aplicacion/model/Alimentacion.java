package ar.gov.sedronar.aplicacion.model;

import javax.persistence.*;

/**
 * Created by TMR on 04/09/2018.
 */
@Entity
@Table(name = "ALIMENTACION", schema="caac")
public class Alimentacion {
    private Integer id;
    private String clasificacion;
    private String descripcion;

    public Alimentacion() {}

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "clasificacion", length = 20)
    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    @Column(name = "descripcion", length=100)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
