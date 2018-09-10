package ar.gov.sedronar.aplicacion.definition;

/**
 * Created by TMR on 10/09/2018.
 */
public enum TipoHoja {
    MENSUAL("M"),
    ESTRUCTURAL("E");

    private String value;

    private TipoHoja(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

}
