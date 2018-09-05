package ar.gov.sedronar.aplicacion.model;

import javax.persistence.*;

/**
 * Created by TMR on 05/09/2018.
 */
@Entity
@Table(name = "DIA", schema = "caac")
public class Dia {
    private Integer id;
    private String descripcion;

    public Dia(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "descripcion", length = 10)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
