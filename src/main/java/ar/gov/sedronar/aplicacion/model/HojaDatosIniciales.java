package ar.gov.sedronar.aplicacion.model;

import ar.gov.sedronar.modulo.geo.modelo.DepartamentoLight;
import ar.gov.sedronar.modulo.geo.modelo.LocalidadLight;
import ar.gov.sedronar.modulo.geo.modelo.Municipio;
import ar.gov.sedronar.modulo.geo.modelo.ProvinciaLight;
import java.util.Date;

import javax.persistence.*;

/**
 * Created by TMR on 04/09/2018.
 */
@Entity
@Table(name = "HOJA_DATOS_INICIALES", schema ="caac")
public class HojaDatosIniciales {
    private Integer id;
    private Hoja hoja;
    private String nombreCaac;
    private String organismoResponsable;
    private String personaResponsable;
    private String telefonoResponsable;
    private String mailResponsable;
    private String otrosReferentes;
    private String direccion;
    private String interseccion1;
    private String interseccion2;
    private String barrio;
    private LocalidadLight localidadLight;
    private Municipio municipio;
    private DepartamentoLight departamentoLight;
    private ProvinciaLight provinciaLight;
    private String anexo;
    private String direccionHorarioAnexos;
    private String caracteristicasGenerales;
    private String telefonoCaac;
    private String mailCaac;
    private String uum;
    private Date fum;

    public HojaDatosIniciales(){}

    @Id
    @Column(name = "idhoja")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    @Column(name = "nombre_caac", length=300)
    public String getNombreCaac() {
        return nombreCaac;
    }

    public void setNombreCaac(String nombreCaac) {
        this.nombreCaac = nombreCaac;
    }

    @Column(name = "org_responsable", length= 300)
    public String getOrganismoResponsable() {
        return organismoResponsable;
    }

    public void setOrganismoResponsable(String organismoResponsable) {
        this.organismoResponsable = organismoResponsable;
    }

    @Column(name = "pers_responsable", length = 300)
    public String getPersonaResponsable() {
        return personaResponsable;
    }

    public void setPersonaResponsable(String personaResponsable) {
        this.personaResponsable = personaResponsable;
    }

    @Column(name = "tel_responsable", length = 100)
    public String getTelefonoResponsable() {
        return telefonoResponsable;
    }

    public void setTelefonoResponsable(String telefonoResponsable) {
        this.telefonoResponsable = telefonoResponsable;
    }

    @Column(name = "mail_responsable", length = 300)
    public String getMailResponsable() {
        return mailResponsable;
    }

    public void setMailResponsable(String mailResponsable) {
        this.mailResponsable = mailResponsable;
    }

    @Column(name = "otros_referentes", length = 4000)
    public String getOtrosReferentes() {
        return otrosReferentes;
    }

    public void setOtrosReferentes(String otrosReferentes) {
        this.otrosReferentes = otrosReferentes;
    }

    @Column(name = "direccion", length = 300)
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Column(name = "interseccion_1", length = 300)
    public String getInterseccion1() {
        return interseccion1;
    }

    public void setInterseccion1(String interseccion1) {
        this.interseccion1 = interseccion1;
    }

    @Column(name = "interseccion_2", length = 300)
    public String getInterseccion2() {
        return interseccion2;
    }

    public void setInterseccion2(String interseccion2) {
        this.interseccion2 = interseccion2;
    }

    @Column(name = "barrio", length = 300)
    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idlocalidad")
    public LocalidadLight getLocalidadLight() {
        return localidadLight;
    }

    public void setLocalidadLight(LocalidadLight localidadLight) {
        this.localidadLight = localidadLight;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idmunicipio")
    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iddepto")
    public DepartamentoLight getDepartamentoLight() {
        return departamentoLight;
    }

    public void setDepartamentoLight(DepartamentoLight departamentoLight) {
        this.departamentoLight = departamentoLight;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idprovincia")
    public ProvinciaLight getProvinciaLight() {
        return provinciaLight;
    }

    public void setProvinciaLight(ProvinciaLight provinciaLight) {
        this.provinciaLight = provinciaLight;
    }

    @Column(name = "anexos", length = 1, columnDefinition = "char(1)")
    public String getAnexo() {
        return anexo;
    }

    public void setAnexo(String anexo) {
        this.anexo = anexo;
    }

    @Column(name = "dir_horario_anexos", length = 4000)
    public String getDireccionHorarioAnexos() {
        return direccionHorarioAnexos;
    }

    public void setDireccionHorarioAnexos(String direccionHorarioAnexos) {
        this.direccionHorarioAnexos = direccionHorarioAnexos;
    }

    @Column(name = "caracteristicas_grales", length = 4000)
    public String getCaracteristicasGenerales() {
        return caracteristicasGenerales;
    }

    public void setCaracteristicasGenerales(String caracteristicasGenerales) {
        this.caracteristicasGenerales = caracteristicasGenerales;
    }

    @Column(name = "tel_caac", length = 100)
    public String getTelefonoCaac() {
        return telefonoCaac;
    }

    public void setTelefonoCaac(String telefonoCaac) {
        this.telefonoCaac = telefonoCaac;
    }

    @Column(name = "mail_caac", length = 100)
    public String getMailCaac() {
        return mailCaac;
    }

    public void setMailCaac(String mailCaac) {
        this.mailCaac = mailCaac;
    }

    @Column(name = "datos_iniciales_uum", length = 50)
    public String getUum() {
        return uum;
    }

    public void setUum(String uum) {
        this.uum = uum;
    }

    @Column(name = "datos_iniciales_fum")
    public Date getFum() {
        return fum;
    }

    public void setFum(Date fum) {
        this.fum = fum;
    }
}
