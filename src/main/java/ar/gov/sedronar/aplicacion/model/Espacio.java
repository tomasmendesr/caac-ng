package ar.gov.sedronar.aplicacion.model;

import javax.persistence.*;

/**
 * Created by TMR on 05/09/2018.
 */
@Entity
@Table(name = "ESPACIOS", schema = "caac")
public class Espacio {
    private Integer id;
    private String descripcion;

    public Espacio(){}

    @Id
    @Column(name = "idespacio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "descripcion", length = 100)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
