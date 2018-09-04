package ar.gov.sedronar.aplicacion.dto;

/**
 * Created by TMR on 04/09/2018.
 */
public class CategoriaDTO {

    private String cat;
    private Integer valor;

    public CategoriaDTO() {
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