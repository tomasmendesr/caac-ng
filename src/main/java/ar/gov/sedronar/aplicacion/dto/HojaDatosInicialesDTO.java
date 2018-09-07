package ar.gov.sedronar.aplicacion.dto;


import ar.gov.sedronar.modulo.geo.dto.DepartamentoLightDTO;
import ar.gov.sedronar.modulo.geo.dto.LocalidadLightDTO;
import ar.gov.sedronar.modulo.geo.dto.MunicipioDTO;
import ar.gov.sedronar.modulo.geo.dto.ProvinciaLightDTO;

import java.util.Date;

/**
 * Created by TMR on 04/09/2018.
 */
public class HojaDatosInicialesDTO {
    private Long id;
    private HojaDTO hoja;
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
    private LocalidadLightDTO localidadLight;
    private MunicipioDTO municipio;
    private DepartamentoLightDTO departamentoLight;
    private ProvinciaLightDTO provinciaLight;
    private String anexo;
    private String direccionHorarioAnexos;
    private String caracteristicasGenerales;
    private String telefonoCaac;
    private String mailCaac;
    private String uum;
    private Date fum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HojaDTO getHoja() {
        return hoja;
    }

    public void setHoja(HojaDTO hoja) {
        this.hoja = hoja;
    }

    public String getNombreCaac() {
        return nombreCaac;
    }

    public void setNombreCaac(String nombreCaac) {
        this.nombreCaac = nombreCaac;
    }

    public String getOrganismoResponsable() {
        return organismoResponsable;
    }

    public void setOrganismoResponsable(String organismoResponsable) {
        this.organismoResponsable = organismoResponsable;
    }

    public String getPersonaResponsable() {
        return personaResponsable;
    }

    public void setPersonaResponsable(String personaResponsable) {
        this.personaResponsable = personaResponsable;
    }

    public String getTelefonoResponsable() {
        return telefonoResponsable;
    }

    public void setTelefonoResponsable(String telefonoResponsable) {
        this.telefonoResponsable = telefonoResponsable;
    }

    public String getMailResponsable() {
        return mailResponsable;
    }

    public void setMailResponsable(String mailResponsable) {
        this.mailResponsable = mailResponsable;
    }

    public String getOtrosReferentes() {
        return otrosReferentes;
    }

    public void setOtrosReferentes(String otrosReferentes) {
        this.otrosReferentes = otrosReferentes;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getInterseccion1() {
        return interseccion1;
    }

    public void setInterseccion1(String interseccion1) {
        this.interseccion1 = interseccion1;
    }

    public String getInterseccion2() {
        return interseccion2;
    }

    public void setInterseccion2(String interseccion2) {
        this.interseccion2 = interseccion2;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public LocalidadLightDTO getLocalidadLight() {
        return localidadLight;
    }

    public void setLocalidadLight(LocalidadLightDTO localidadLight) {
        this.localidadLight = localidadLight;
    }

    public MunicipioDTO getMunicipio() {
        return municipio;
    }

    public void setMunicipio(MunicipioDTO municipio) {
        this.municipio = municipio;
    }

    public DepartamentoLightDTO getDepartamentoLight() {
        return departamentoLight;
    }

    public void setDepartamentoLight(DepartamentoLightDTO departamentoLight) {
        this.departamentoLight = departamentoLight;
    }

    public ProvinciaLightDTO getProvinciaLight() {
        return provinciaLight;
    }

    public void setProvinciaLight(ProvinciaLightDTO provinciaLight) {
        this.provinciaLight = provinciaLight;
    }

    public String getAnexo() {
        return anexo;
    }

    public void setAnexo(String anexo) {
        this.anexo = anexo;
    }

    public String getDireccionHorarioAnexos() {
        return direccionHorarioAnexos;
    }

    public void setDireccionHorarioAnexos(String direccionHorarioAnexos) {
        this.direccionHorarioAnexos = direccionHorarioAnexos;
    }

    public String getCaracteristicasGenerales() {
        return caracteristicasGenerales;
    }

    public void setCaracteristicasGenerales(String caracteristicasGenerales) {
        this.caracteristicasGenerales = caracteristicasGenerales;
    }

    public String getTelefonoCaac() {
        return telefonoCaac;
    }

    public void setTelefonoCaac(String telefonoCaac) {
        this.telefonoCaac = telefonoCaac;
    }

    public String getMailCaac() {
        return mailCaac;
    }

    public void setMailCaac(String mailCaac) {
        this.mailCaac = mailCaac;
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
