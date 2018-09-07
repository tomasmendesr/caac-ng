package ar.gov.sedronar.aplicacion.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * The persistent class for the categorias database table.
 *
 */
@Entity
@Table(name="categorias", schema="caac")
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="cat",columnDefinition="char(2)")
    private String cat;

    @Column(name="valor")
    private Integer valor;

    public Categoria() {
    }

    public String getCat() {
        return this.cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public Integer getValor() {
        return this.valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

}