package ar.gov.sedronar.aplicacion.model;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
/**
 * Created by TMR on 05/09/2018.
 */
@Entity
@Table(name = "H_MENSUAL_OBSERVACIONES", schema="caac")
public class HojaMensualObservaciones {
    private BigInteger id;
    private Hoja hoja;
    private String otrosTramites;
    private String alimentacionEnSede;
    private String alimentacionFueraDeSede;
    private String actividadesFamiliares;
    private String intervencionCalleObservacion;
    private String acompaniamientoVisitasEstablecimientoSalud;
    private String gestionesEstablecimientoSalud;
    private String acompaniamientoCentroEspecial;
    private String asesoramientoLegal;
    private String actividadesTalleresComisaria;
    private String actividadesProductivasComisaria;
    private String actividadesCapacitacionComisaria;
    private String acompaniamientoProfesionalSalud;
    private String acompaniamientoTrayectoriaSalud;
    private String mejorasInfraestructura;
    private String requerimientosFormacion;
    private String uum;
    private Date fum;

    public HojaMensualObservaciones(){}

    @Id
    @Column(name = "idhoja")
    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idhoja")
    public Hoja getHoja() {
        return hoja;
    }

    public void setHoja(Hoja hoja) {
        this.hoja = hoja;
    }

    @Column(name = "otros_tramites", length = 500)
    public String getOtrosTramites() {
        return otrosTramites;
    }

    public void setOtrosTramites(String otrosTramites) {
        this.otrosTramites = otrosTramites;
    }

    @Column(name = "alimentacion_en_sede", length = 500)
    public String getAlimentacionEnSede() {
        return alimentacionEnSede;
    }

    public void setAlimentacionEnSede(String alimentacionEnSede) {
        this.alimentacionEnSede = alimentacionEnSede;
    }

    @Column(name = "alimentacion_fuera_sede", length = 500)
    public String getAlimentacionFueraDeSede() {
        return alimentacionFueraDeSede;
    }

    public void setAlimentacionFueraDeSede(String alimentacionFueraDeSede) {
        this.alimentacionFueraDeSede = alimentacionFueraDeSede;
    }

    @Column(name = "actividades_familiares", length = 500)
    public String getActividadesFamiliares() {
        return actividadesFamiliares;
    }

    public void setActividadesFamiliares(String actividadesFamiliares) {
        this.actividadesFamiliares = actividadesFamiliares;
    }

    @Column(name = "interv_calle_observ", length = 500)
    public String getIntervencionCalleObservacion() {
        return intervencionCalleObservacion;
    }

    public void setIntervencionCalleObservacion(String intervencionCalleObservacion) {
        this.intervencionCalleObservacion = intervencionCalleObservacion;
    }

    @Column(name = "acomp_visitas_estab_salud", length = 500)
    public String getAcompaniamientoVisitasEstablecimientoSalud() {
        return acompaniamientoVisitasEstablecimientoSalud;
    }

    public void setAcompaniamientoVisitasEstablecimientoSalud(String acompaniamientoVisitasEstablecimientoSalud) {
        this.acompaniamientoVisitasEstablecimientoSalud = acompaniamientoVisitasEstablecimientoSalud;
    }

    @Column(name = "gestiones_estab_salud", length = 500)
    public String getGestionesEstablecimientoSalud() {
        return gestionesEstablecimientoSalud;
    }

    public void setGestionesEstablecimientoSalud(String gestionesEstablecimientoSalud) {
        this.gestionesEstablecimientoSalud = gestionesEstablecimientoSalud;
    }

    @Column(name = "acomp_centro_especial", length = 500)
    public String getAcompaniamientoCentroEspecial() {
        return acompaniamientoCentroEspecial;
    }

    public void setAcompaniamientoCentroEspecial(String acompaniamientoCentroEspecial) {
        this.acompaniamientoCentroEspecial = acompaniamientoCentroEspecial;
    }

    @Column(name = "asesoramiento_legal", length = 500)
    public String getAsesoramientoLegal() {
        return asesoramientoLegal;
    }

    public void setAsesoramientoLegal(String asesoramientoLegal) {
        this.asesoramientoLegal = asesoramientoLegal;
    }

    @Column(name = "act_talleres_comisaria", length = 500)
    public String getActividadesTalleresComisaria() {
        return actividadesTalleresComisaria;
    }

    public void setActividadesTalleresComisaria(String actividadesTalleresComisaria) {
        this.actividadesTalleresComisaria = actividadesTalleresComisaria;
    }

    @Column(name = "act_productivas_comisaria", length = 500)
    public String getActividadesProductivasComisaria() {
        return actividadesProductivasComisaria;
    }

    public void setActividadesProductivasComisaria(String actividadesProductivasComisaria) {
        this.actividadesProductivasComisaria = actividadesProductivasComisaria;
    }

    @Column(name = "act_capacitacion_comisaria", length = 500)
    public String getActividadesCapacitacionComisaria() {
        return actividadesCapacitacionComisaria;
    }

    public void setActividadesCapacitacionComisaria(String actividadesCapacitacionComisaria) {
        this.actividadesCapacitacionComisaria = actividadesCapacitacionComisaria;
    }

    @Column(name = "acomp_profesional_salud", length = 500)
    public String getAcompaniamientoProfesionalSalud() {
        return acompaniamientoProfesionalSalud;
    }

    public void setAcompaniamientoProfesionalSalud(String acompaniamientoProfesionalSalud) {
        this.acompaniamientoProfesionalSalud = acompaniamientoProfesionalSalud;
    }

    @Column(name = "acomp_trayectoria_educ", length = 500)
    public String getAcompaniamientoTrayectoriaSalud() {
        return acompaniamientoTrayectoriaSalud;
    }

    public void setAcompaniamientoTrayectoriaSalud(String acompaniamientoTrayectoriaSalud) {
        this.acompaniamientoTrayectoriaSalud = acompaniamientoTrayectoriaSalud;
    }

    @Column(name = "mejoras_infraestructura", length = 2000)
    public String getMejorasInfraestructura() {
        return mejorasInfraestructura;
    }

    public void setMejorasInfraestructura(String mejorasInfraestructura) {
        this.mejorasInfraestructura = mejorasInfraestructura;
    }

    @Column(name = "requerimientos_formacion", length = 4000)
    public String getRequerimientosFormacion() {
        return requerimientosFormacion;
    }

    public void setRequerimientosFormacion(String requerimientosFormacion) {
        this.requerimientosFormacion = requerimientosFormacion;
    }

    @Column(name = "h_mens_obs_uum", length = 50)
    public String getUum() {
        return uum;
    }

    public void setUum(String uum) {
        this.uum = uum;
    }

    @Column(name = "h_mens_obs_fum")
    public Date getFum() {
        return fum;
    }

    public void setFum(Date fum) {
        this.fum = fum;
    }
}
