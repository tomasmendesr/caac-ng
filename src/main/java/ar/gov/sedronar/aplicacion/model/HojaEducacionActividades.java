package ar.gov.sedronar.aplicacion.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by TMR on 05/09/2018.
 */
@Entity
@Table(name = "HOJA_EDUCACION_ACTIVIDADES", schema = "caac")
public class HojaEducacionActividades {
    private Long id;
    private Hoja hoja;
    private String educacionAcompaniamientoEscuela;
    private String educacionPrevencion;
    private String educacionApoyoEscular;
    private String educacionProgramaInclusion;
    private String escuelaEnSede;
    private String educacionOtro;
    private String educacionOtroDescripcion;
    private String actividadesDeportivas;
    private String actividadCapacitacionOficios;
    private String actividadesCulturales;
    private String actividadesRecreativas;
    private String actividadesEventosFestivos;
    private String actividadesReligiosas;
    private String actividadesOtro;
    private String actividadesOtroDescripcion;
    private String uum;
    private java.util.Date fum;

    public HojaEducacionActividades(){}

    @Id
    @Column(name = "idhoja")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "edu_acomp_escuela", length = 1, columnDefinition = "char(1)")
    public String getEducacionAcompaniamientoEscuela() {
        return educacionAcompaniamientoEscuela;
    }

    public void setEducacionAcompaniamientoEscuela(String educacionAcompaniamientoEscuela) {
        this.educacionAcompaniamientoEscuela = educacionAcompaniamientoEscuela;
    }

    @Column(name = "edu_prevencion", length = 1, columnDefinition = "char(1)")
    public String getEducacionPrevencion() {
        return educacionPrevencion;
    }

    public void setEducacionPrevencion(String educacionPrevencion) {
        this.educacionPrevencion = educacionPrevencion;
    }

    @Column(name = "edu_apoyo_escolar", length = 1, columnDefinition = "char(1)")
    public String getEducacionApoyoEscular() {
        return educacionApoyoEscular;
    }

    public void setEducacionApoyoEscular(String educacionApoyoEscular) {
        this.educacionApoyoEscular = educacionApoyoEscular;
    }

    @Column(name = "edu_programa_inclusion", length = 1, columnDefinition = "char(1)")
    public String getEducacionProgramaInclusion() {
        return educacionProgramaInclusion;
    }

    public void setEducacionProgramaInclusion(String educacionProgramaInclusion) {
        this.educacionProgramaInclusion = educacionProgramaInclusion;
    }

    @Column(name = "edu_escuela_en_sede", length = 1, columnDefinition = "char(1)")
    public String getEscuelaEnSede() {
        return escuelaEnSede;
    }

    public void setEscuelaEnSede(String escuelaEnSede) {
        this.escuelaEnSede = escuelaEnSede;
    }

    @Column(name = "edu_otro", length = 1, columnDefinition = "char(1)")
    public String getEducacionOtro() {
        return educacionOtro;
    }

    public void setEducacionOtro(String educacionOtro) {
        this.educacionOtro = educacionOtro;
    }

    @Column(name = "edu_otro_descripcion", length = 100)
    public String getEducacionOtroDescripcion() {
        return educacionOtroDescripcion;
    }

    public void setEducacionOtroDescripcion(String educacionOtroDescripcion) {
        this.educacionOtroDescripcion = educacionOtroDescripcion;
    }

    @Column(name = "act_deportivas", length = 1, columnDefinition = "char(1)")
    public String getActividadesDeportivas() {
        return actividadesDeportivas;
    }

    public void setActividadesDeportivas(String actividadesDeportivas) {
        this.actividadesDeportivas = actividadesDeportivas;
    }

    @Column(name = "act_capacitacion_oficios", length = 1, columnDefinition = "char(1)")
    public String getActividadCapacitacionOficios() {
        return actividadCapacitacionOficios;
    }

    public void setActividadCapacitacionOficios(String actividadCapacitacionOficios) {
        this.actividadCapacitacionOficios = actividadCapacitacionOficios;
    }

    @Column(name = "act_culturales", length = 1, columnDefinition = "char(1)")
    public String getActividadesCulturales() {
        return actividadesCulturales;
    }

    public void setActividadesCulturales(String actividadesCulturales) {
        this.actividadesCulturales = actividadesCulturales;
    }

    @Column(name = "act_recreativas", length = 1, columnDefinition = "char(1)")
    public String getActividadesRecreativas() {
        return actividadesRecreativas;
    }

    public void setActividadesRecreativas(String actividadesRecreativas) {
        this.actividadesRecreativas = actividadesRecreativas;
    }

    @Column(name = "act_eventos_festivos", length = 1, columnDefinition = "char(1)")
    public String getActividadesEventosFestivos() {
        return actividadesEventosFestivos;
    }

    public void setActividadesEventosFestivos(String actividadesEventosFestivos) {
        this.actividadesEventosFestivos = actividadesEventosFestivos;
    }

    @Column(name = "act_religiosas", length = 1, columnDefinition = "char(1)")
    public String getActividadesReligiosas() {
        return actividadesReligiosas;
    }

    public void setActividadesReligiosas(String actividadesReligiosas) {
        this.actividadesReligiosas = actividadesReligiosas;
    }

    @Column(name = "act_otro", length = 1, columnDefinition = "char(1)")
    public String getActividadesOtro() {
        return actividadesOtro;
    }

    public void setActividadesOtro(String actividadesOtro) {
        this.actividadesOtro = actividadesOtro;
    }

    @Column(name = "act_otro_descripcion", length = 100)
    public String getActividadesOtroDescripcion() {
        return actividadesOtroDescripcion;
    }

    public void setActividadesOtroDescripcion(String actividadesOtroDescripcion) {
        this.actividadesOtroDescripcion = actividadesOtroDescripcion;
    }

    @Column(name = "edu_act_uum", length = 50)
    public String getUum() {
        return uum;
    }

    public void setUum(String uum) {
        this.uum = uum;
    }

    @Column(name = "edu_act_fum")
    public Date getFum() {
        return fum;
    }

    public void setFum(Date fum) {
        this.fum = fum;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idhoja", insertable = false, updatable = false)
    @MapsId
    public Hoja getHoja() {
        return hoja;
    }

    public void setHoja(Hoja hoja) {
        this.hoja = hoja;
    }
}
