package ar.gov.sedronar.aplicacion.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

/**
 * Created by TMR on 05/09/2018.
 */
@Entity
@Table(name = "HOJA_LEGALES", schema = "caac")
public class HojasLegales {
    private BigInteger id;
    private Hoja hoja;
    private String acompComisarias;
    private String acompPenales;
    private String acompOtro;
    private String acompOtroDescripcion;
    private String actividadesTalleres;
    private String actividadesProductivas;
    private String actividadesCapacitacion;
    private String actividadesOtro;
    private String actividadesOtroDescripcion;
    private String uum;
    private java.util.Date fum;

    public HojasLegales(){}

    @Id
    @Column(name = "idhoja")
    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idhoja", insertable = false, updatable = false)
    public Hoja getHoja() {
        return hoja;
    }

    public void setHoja(Hoja hoja) {
        this.hoja = hoja;
    }

    @Column(name = "acomp_comisarias", length = 1, columnDefinition = "char(1)")
    public String getAcompComisarias() {
        return acompComisarias;
    }

    public void setAcompComisarias(String acompComisarias) {
        this.acompComisarias = acompComisarias;
    }

    @Column(name = "acomp_penales", length = 1, columnDefinition = "char(1)")
    public String getAcompPenales() {
        return acompPenales;
    }

    public void setAcompPenales(String acompPenales) {
        this.acompPenales = acompPenales;
    }

    @Column(name = "acomp_otro", length = 1, columnDefinition = "char(1)")
    public String getAcompOtro() {
        return acompOtro;
    }

    public void setAcompOtro(String acompOtro) {
        this.acompOtro = acompOtro;
    }

    @Column(name = "acomp_otro_descripcion", length = 100)
    public String getAcompOtroDescripcion() {
        return acompOtroDescripcion;
    }

    public void setAcompOtroDescripcion(String acompOtroDescripcion) {
        this.acompOtroDescripcion = acompOtroDescripcion;
    }

    @Column(name = "activ_talleres", length = 1, columnDefinition = "char(1)")
    public String getActividadesTalleres() {
        return actividadesTalleres;
    }

    public void setActividadesTalleres(String actividadesTalleres) {
        this.actividadesTalleres = actividadesTalleres;
    }

    @Column(name = "activ_productivas", length = 1, columnDefinition = "char(1)")
    public String getActividadesProductivas() {
        return actividadesProductivas;
    }

    public void setActividadesProductivas(String actividadesProductivas) {
        this.actividadesProductivas = actividadesProductivas;
    }

    @Column(name = "activ_capacitacion", length = 1, columnDefinition = "char(1)")
    public String getActividadesCapacitacion() {
        return actividadesCapacitacion;
    }

    public void setActividadesCapacitacion(String actividadesCapacitacion) {
        this.actividadesCapacitacion = actividadesCapacitacion;
    }

    @Column(name = "activ_otro", length = 1, columnDefinition = "char(1)")
    public String getActividadesOtro() {
        return actividadesOtro;
    }

    public void setActividadesOtro(String actividadesOtro) {
        this.actividadesOtro = actividadesOtro;
    }

    @Column(name = "activ_otro_descripcion", length = 100)
    public String getActividadesOtroDescripcion() {
        return actividadesOtroDescripcion;
    }

    public void setActividadesOtroDescripcion(String actividadesOtroDescripcion) {
        this.actividadesOtroDescripcion = actividadesOtroDescripcion;
    }

    @Column(name = "legales_uum", length = 50)
    public String getUum() {
        return uum;
    }

    public void setUum(String uum) {
        this.uum = uum;
    }

    @Column(name = "legales_fum")
    public Date getFum() {
        return fum;
    }

    public void setFum(Date fum) {
        this.fum = fum;
    }
}
