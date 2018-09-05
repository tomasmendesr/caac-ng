package ar.gov.sedronar.aplicacion.dto;

import ar.gov.sedronar.aplicacion.model.Hoja;
import ar.gov.sedronar.aplicacion.model.HojaRecursosId;
import ar.gov.sedronar.aplicacion.model.Recurso;

import java.util.Date;

/**
 * Created by TMR on 05/09/2018.
 */
public class HojaRecursosDTO {
    private HojaDTO hoja;
    private RecursoDTO recurso;
    private String descripcion;
    private String uum;
    private java.util.Date fum;


    public HojaDTO getHoja() {
        return hoja;
    }

    public void setHoja(HojaDTO hoja) {
        this.hoja = hoja;
    }

    public RecursoDTO getRecurso() {
        return recurso;
    }

    public void setRecurso(RecursoDTO recurso) {
        this.recurso = recurso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
