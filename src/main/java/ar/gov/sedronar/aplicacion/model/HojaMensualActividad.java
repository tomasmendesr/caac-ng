package ar.gov.sedronar.aplicacion.model;

import javax.persistence.*;
import java.util.Date;
/**
 * Created by TMR on 04/09/2018.
 */
@Entity
@Table(name = "H_MENSUAL_ACTIVIDAD", schema = "caac")
public class HojaMensualActividad {

    private Long id;
    private Hoja hoja;
    private Integer cantidadVisitasDomiciliarias;
    private Integer cantidadOrientaciones;
    private Integer cantidadGrupos;
    private Integer cantidadEntrevistas;
    private Integer personasVisitasDomiciliarias;
    private Integer personasOrientaciones;
    private Integer personasGrupos;
    private Integer personasEntrevistas;
    private Integer cantidadOrientacionesCalle;
    private Integer cantidadAcompaniamientoCalle;
    private String uum;
    private Date fum;

    public HojaMensualActividad(){}

    @Id
    @Column(name = "idhoja")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Column(name = "cant_visitas_dom")
    public Integer getCantidadVisitasDomiciliarias() {
        return cantidadVisitasDomiciliarias;
    }

    public void setCantidadVisitasDomiciliarias(Integer cantidadVisitasDomiciliarias) {
        this.cantidadVisitasDomiciliarias = cantidadVisitasDomiciliarias;
    }

    @Column(name = "cant_orientaciones")
    public Integer getCantidadOrientaciones() {
        return cantidadOrientaciones;
    }

    public void setCantidadOrientaciones(Integer cantidadOrientaciones) {
        this.cantidadOrientaciones = cantidadOrientaciones;
    }

    @Column(name = "cant_grupos")
    public Integer getCantidadGrupos() {
        return cantidadGrupos;
    }

    public void setCantidadGrupos(Integer cantidadGrupos) {
        this.cantidadGrupos = cantidadGrupos;
    }

    @Column(name = "cant_entrevistas")
    public Integer getCantidadEntrevistas() {
        return cantidadEntrevistas;
    }

    public void setCantidadEntrevistas(Integer cantidadEntrevistas) {
        this.cantidadEntrevistas = cantidadEntrevistas;
    }

    @Column(name = "pers_visitas_dom")
    public Integer getPersonasVisitasDomiciliarias() {
        return personasVisitasDomiciliarias;
    }

    public void setPersonasVisitasDomiciliarias(Integer personasVisitasDomiciliarias) {
        this.personasVisitasDomiciliarias = personasVisitasDomiciliarias;
    }

    @Column(name = "pers_orientaciones")
    public Integer getPersonasOrientaciones() {
        return personasOrientaciones;
    }

    public void setPersonasOrientaciones(Integer personasOrientaciones) {
        this.personasOrientaciones = personasOrientaciones;
    }

    @Column(name = "pers_grupos")
    public Integer getPersonasGrupos() {
        return personasGrupos;
    }

    public void setPersonasGrupos(Integer personasGrupos) {
        this.personasGrupos = personasGrupos;
    }

    @Column(name = "pers_entrevistas")
    public Integer getPersonasEntrevistas() {
        return personasEntrevistas;
    }

    public void setPersonasEntrevistas(Integer value) {
        this.personasEntrevistas = value;
    }

    @Column(name = "cant_orient_calle")
    public Integer getCantidadOrientacionesCalle() {
        return cantidadOrientacionesCalle;
    }

    public void setCantidadOrientacionesCalle(Integer cantidadOrientacionesCalle) {
        this.cantidadOrientacionesCalle = cantidadOrientacionesCalle;
    }

    @Column(name = "cant_acomp_calle")
    public Integer getCantidadAcompaniamientoCalle() {
        return cantidadAcompaniamientoCalle;
    }

    public void setCantidadAcompaniamientoCalle(Integer cantidadAcompaniamientoCalle) {
        this.cantidadAcompaniamientoCalle = cantidadAcompaniamientoCalle;
    }

    @Column(name = "h_mens_act_uum", length = 50)
    public String getUum() {
        return uum;
    }

    public void setUum(String uum) {
        this.uum = uum;
    }

    @Column(name = "h_mens_act_fum")
    public Date getFum() {
        return fum;
    }

    public void setFum(Date fum) {
        this.fum = fum;
    }
}
