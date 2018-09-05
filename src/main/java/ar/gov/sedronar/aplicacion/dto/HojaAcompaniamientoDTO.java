package ar.gov.sedronar.aplicacion.dto;
import java.util.Date;
/**
 * Created by TMR on 05/09/2018.
 */
public class HojaAcompaniamientoDTO {
    private HojaDTO hoja;
    private AcompaniamientoDTO acompaniamiento;
    private String descripcion;
    private String interno;
    private String externo;
    private String uum;
    private java.util.Date fum;

    public HojaDTO getHoja() {
        return hoja;
    }

    public void setHoja(HojaDTO hoja) {
        this.hoja = hoja;
    }

    public AcompaniamientoDTO getAcompaniamiento() {
        return acompaniamiento;
    }

    public void setAcompaniamiento(AcompaniamientoDTO acompaniamiento) {
        this.acompaniamiento = acompaniamiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getInterno() {
        return interno;
    }

    public void setInterno(String interno) {
        this.interno = interno;
    }

    public String getExterno() {
        return externo;
    }

    public void setExterno(String externo) {
        this.externo = externo;
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
