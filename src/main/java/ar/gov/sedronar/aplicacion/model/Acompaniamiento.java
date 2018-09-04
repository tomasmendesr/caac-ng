package ar.gov.sedronar.aplicacion.model;

import javax.persistence.*;

/**
 * Created by TMR on 04/09/2018.
 */
@Entity
@Table(name = "ACOMPANIAMIENTO", schema = "caac")
public class Acompaniamiento {
    private Integer id;
    private String tipo;
    private String establecimiento;
    private String detalle;

    public Acompaniamiento(){}

    @Id
    @Column(name="idacompaniamiento")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "acomp_tipo")
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Column(name = "acomp_establecimiento")
    public String getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(String establecimiento) {
        this.establecimiento = establecimiento;
    }

    @Column(name = "acomp_detalle")
    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}
