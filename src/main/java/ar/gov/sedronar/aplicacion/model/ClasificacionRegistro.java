package ar.gov.sedronar.aplicacion.model;

import javax.persistence.*;

/**
 * Created by TMR on 04/09/2018.
 */
@Entity
@Table(name = "CLASIFICACION_REGISTROS", schema = "caac")
public class ClasificacionRegistro {
    private Integer id;
    private String descripcion;
    public ClasificacionRegistro(){}

    @Id
    @Column(name="idclasif_registros")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "descripcion", length = 200)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
