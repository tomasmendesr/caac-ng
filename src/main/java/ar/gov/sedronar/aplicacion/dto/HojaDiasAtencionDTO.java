package ar.gov.sedronar.aplicacion.dto;

import java.util.Date;

/**
 * Created by TMR on 05/09/2018.
 */
public class HojaDiasAtencionDTO {
    private HojaDTO hoja;
    private DiaDTO dia;
    private String horario;
    private String uum;
    private java.util.Date fum;


    public HojaDTO getHoja() {
        return hoja;
    }

    public void setHoja(HojaDTO hoja) {
        this.hoja = hoja;
    }

    public DiaDTO getDia() {
        return dia;
    }

    public void setDia(DiaDTO dia) {
        this.dia = dia;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
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
