package ar.gov.sedronar.aplicacion.model;
import java.util.Date;
import javax.persistence.*;

/**
 * Created by TMR on 05/09/2018.
 */
@Entity
@Table(name = "H_MENSUAL_ALIMENTACION", schema = "caac")
public class HojaMensualAlimentacion {

    private HojaMensualAlimentacionId id;
    private Hoja hoja;
    private Alimentacion tipoAlimentacion;
    private Integer cantidadPersonas;
    private Integer cantidadPrestanciones;
    private String uum;
    private Date fum;

    public HojaMensualAlimentacion(){}

    @EmbeddedId
    public HojaMensualAlimentacionId getId() {
        return id;
    }

    public void setId(HojaMensualAlimentacionId id) {
        this.id = id;
    }

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "idhoja")
    public Hoja getHoja() {
        return hoja;
    }

    public void setHoja(Hoja hoja) {
        this.hoja = hoja;
    }

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "id_tipo_alimentacion")
    public Alimentacion getTipoAlimentacion() {
        return tipoAlimentacion;
    }

    public void setTipoAlimentacion(Alimentacion tipoAlimentacion) {
        this.tipoAlimentacion = tipoAlimentacion;
    }

    @Column(name = "cantidad_personas")
    public Integer getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(Integer cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    @Column(name = "cantidad_prestaciones")
    public Integer getCantidadPrestanciones() {
        return cantidadPrestanciones;
    }

    public void setCantidadPrestanciones(Integer cantidadPrestanciones) {
        this.cantidadPrestanciones = cantidadPrestanciones;
    }

    @Column(name = "h_mensual_alim_uum", length = 50)
    public String getUum() {
        return uum;
    }

    public void setUum(String uum) {
        this.uum = uum;
    }

    @Column(name = "h_mensual_alim_fum")
    public Date getFum() {
        return fum;
    }

    public void setFum(Date fum) {
        this.fum = fum;
    }
}
