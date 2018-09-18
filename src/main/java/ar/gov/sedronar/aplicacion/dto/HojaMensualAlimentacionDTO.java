package ar.gov.sedronar.aplicacion.dto;
import java.util.Date;

/**
 * Created by TMR on 05/09/2018.
 */
public class HojaMensualAlimentacionDTO {
    private HojaDTO hoja;
    private AlimentacionDTO tipoAlimentacion;
    private Integer cantidadPersonas;
    private Integer cantidadPrestaciones;
    private String uum;
    private Date fum;

    public HojaDTO getHoja() {
        return hoja;
    }

    public void setHoja(HojaDTO hoja) {
        this.hoja = hoja;
    }

    public AlimentacionDTO getTipoAlimentacion() {
        return tipoAlimentacion;
    }

    public void setTipoAlimentacion(AlimentacionDTO tipoAlimentacion) {
        this.tipoAlimentacion = tipoAlimentacion;
    }

    public Integer getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(Integer cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public Integer getCantidadPrestaciones() {
        return cantidadPrestaciones;
    }

    public void setCantidadPrestaciones(Integer cantidadPrestaciones) {
        this.cantidadPrestaciones = cantidadPrestaciones;
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
