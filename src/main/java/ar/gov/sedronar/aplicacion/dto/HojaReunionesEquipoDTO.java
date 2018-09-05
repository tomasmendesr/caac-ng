package ar.gov.sedronar.aplicacion.dto;
import java.math.BigInteger;
import java.util.Date;
/**
 * Created by TMR on 05/09/2018.
 */
public class HojaReunionesEquipoDTO {
    private BigInteger id;
    private HojaDTO hoja;
    private String si;
    private String no;
    private ClasificacionFrecuenciaDTO clasificacionFrecuencia;
    private String uum;
    private java.util.Date fum;


    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public HojaDTO getHoja() {
        return hoja;
    }

    public void setHoja(HojaDTO hoja) {
        this.hoja = hoja;
    }

    public String getSi() {
        return si;
    }

    public void setSi(String si) {
        this.si = si;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public ClasificacionFrecuenciaDTO getClasificacionFrecuencia() {
        return clasificacionFrecuencia;
    }

    public void setClasificacionFrecuencia(ClasificacionFrecuenciaDTO clasificacionFrecuencia) {
        this.clasificacionFrecuencia = clasificacionFrecuencia;
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
