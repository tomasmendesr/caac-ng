package ar.gov.sedronar.aplicacion.dto;


import java.util.Date;

/**
 * Created by TMR on 04/09/2018.
 */
public class HojaMensualActividadDTO {
    private Integer id;
    private HojaDTO hoja;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public HojaDTO getHoja() {
        return hoja;
    }

    public void setHoja(HojaDTO hoja) {
        this.hoja = hoja;
    }

    public Integer getCantidadVisitasDomiciliarias() {
        return cantidadVisitasDomiciliarias;
    }

    public void setCantidadVisitasDomiciliarias(Integer cantidadVisitasDomiciliarias) {
        this.cantidadVisitasDomiciliarias = cantidadVisitasDomiciliarias;
    }

    public Integer getCantidadOrientaciones() {
        return cantidadOrientaciones;
    }

    public void setCantidadOrientaciones(Integer cantidadOrientaciones) {
        this.cantidadOrientaciones = cantidadOrientaciones;
    }

    public Integer getCantidadGrupos() {
        return cantidadGrupos;
    }

    public void setCantidadGrupos(Integer cantidadGrupos) {
        this.cantidadGrupos = cantidadGrupos;
    }

    public Integer getCantidadEntrevistas() {
        return cantidadEntrevistas;
    }

    public void setCantidadEntrevistas(Integer cantidadEntrevistas) {
        this.cantidadEntrevistas = cantidadEntrevistas;
    }

    public Integer getPersonasVisitasDomiciliarias() {
        return personasVisitasDomiciliarias;
    }

    public void setPersonasVisitasDomiciliarias(Integer personasVisitasDomiciliarias) {
        this.personasVisitasDomiciliarias = personasVisitasDomiciliarias;
    }

    public Integer getPersonasOrientaciones() {
        return personasOrientaciones;
    }

    public void setPersonasOrientaciones(Integer personasOrientaciones) {
        this.personasOrientaciones = personasOrientaciones;
    }

    public Integer getPersonasGrupos() {
        return personasGrupos;
    }

    public void setPersonasGrupos(Integer personasGrupos) {
        this.personasGrupos = personasGrupos;
    }

    public Integer getPersonasEntrevistas() {
        return personasEntrevistas;
    }

    public void setPersonasEntrevistas(Integer value) {
        this.personasEntrevistas = value;
    }

    public Integer getCantidadOrientacionesCalle() {
        return cantidadOrientacionesCalle;
    }

    public void setCantidadOrientacionesCalle(Integer cantidadOrientacionesCalle) {
        this.cantidadOrientacionesCalle = cantidadOrientacionesCalle;
    }

    public Integer getCantidadAcompaniamientoCalle() {
        return cantidadAcompaniamientoCalle;
    }

    public void setCantidadAcompaniamientoCalle(Integer cantidadAcompaniamientoCalle) {
        this.cantidadAcompaniamientoCalle = cantidadAcompaniamientoCalle;
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
