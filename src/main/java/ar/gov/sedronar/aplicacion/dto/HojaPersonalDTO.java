package ar.gov.sedronar.aplicacion.dto;

import java.util.Date;

/**
 * Created by TMR on 05/09/2018.
 */
public class HojaPersonalDTO {
    private HojaDTO hoja;
    private PersonalDTO empleado;
    private String uum;
    private java.util.Date fum;

    public HojaDTO getHoja() {
        return hoja;
    }

    public void setHoja(HojaDTO hoja) {
        this.hoja = hoja;
    }

    public PersonalDTO getEmpleado() {
        return empleado;
    }

    public void setEmpleado(PersonalDTO empleado) {
        this.empleado = empleado;
    }

    public String getUum() {
        return uum;
    }

    public void setUum(String uum) {
        this.uum = uum;
    }

    public Date getFum() {
        return fum;
    }

    public void setFum(Date fum) {
        this.fum = fum;
    }
}
