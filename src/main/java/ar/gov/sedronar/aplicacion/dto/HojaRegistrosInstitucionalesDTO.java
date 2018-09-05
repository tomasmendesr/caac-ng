package ar.gov.sedronar.aplicacion.dto;
import java.util.Date;
/**
 * Created by TMR on 05/09/2018.
 */
public class HojaRegistrosInstitucionalesDTO {
    private HojaDTO hoja;
    private ClasificacionRegistroDTO clasificacionRegistro;
    private String siPapel;
    private String siInformatico;
    private String uum;
    private java.util.Date fum;

    public HojaDTO getHoja() {
        return hoja;
    }

    public void setHoja(HojaDTO hoja) {
        this.hoja = hoja;
    }

    public ClasificacionRegistroDTO getClasificacionRegistro() {
        return clasificacionRegistro;
    }

    public void setClasificacionRegistro(ClasificacionRegistroDTO clasificacionRegistro) {
        this.clasificacionRegistro = clasificacionRegistro;
    }

    public String getSiPapel() {
        return siPapel;
    }

    public void setSiPapel(String siPapel) {
        this.siPapel = siPapel;
    }

    public String getSiInformatico() {
        return siInformatico;
    }

    public void setSiInformatico(String siInformatico) {
        this.siInformatico = siInformatico;
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
