package ar.gov.sedronar.aplicacion.util;

import java.util.Date;

public enum DefaultValues {
    Categoria("A"),
    FechaEmpty(new Date("01/01/1900"));

    Object value;

    private DefaultValues(Object value) {
        this.value=value;
    }

    public Object getValue(){
        return value;
    }
}

