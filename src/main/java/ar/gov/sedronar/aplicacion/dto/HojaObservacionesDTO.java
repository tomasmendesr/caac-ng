package ar.gov.sedronar.aplicacion.dto;

import ar.gov.sedronar.aplicacion.model.Hoja;

import java.math.BigInteger;
import java.util.Date;

/**
 * Created by TMR on 05/09/2018.
 */
public class HojaObservacionesDTO {
    private BigInteger id;
    private HojaDTO hoja;
    private String alimentacionEnSede;
    private String alimentacionFueraDeSede;
    private String actividadesFamiliares;
    private String intervencionCalle;
    private String acompaniamientoVisitas;
    private String asesoramientoLegal;
    private String orientacionSalud;
    private String trayectoriasEducativas;
    private String dificultadesObstaculos;
    private String observacionPersonal;
    private String espacioProduccionAnimalVegetal;
    private String maquinariaTrabajo;
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

    public String getAlimentacionEnSede() {
        return alimentacionEnSede;
    }

    public void setAlimentacionEnSede(String alimentacionEnSede) {
        this.alimentacionEnSede = alimentacionEnSede;
    }

    public String getAlimentacionFueraDeSede() {
        return alimentacionFueraDeSede;
    }

    public void setAlimentacionFueraDeSede(String alimentacionFueraDeSede) {
        this.alimentacionFueraDeSede = alimentacionFueraDeSede;
    }

    public String getActividadesFamiliares() {
        return actividadesFamiliares;
    }

    public void setActividadesFamiliares(String actividadesFamiliares) {
        this.actividadesFamiliares = actividadesFamiliares;
    }

    public String getIntervencionCalle() {
        return intervencionCalle;
    }

    public void setIntervencionCalle(String intervencionCalle) {
        this.intervencionCalle = intervencionCalle;
    }

    public String getAcompaniamientoVisitas() {
        return acompaniamientoVisitas;
    }

    public void setAcompaniamientoVisitas(String acompaniamientoVisitas) {
        this.acompaniamientoVisitas = acompaniamientoVisitas;
    }

    public String getAsesoramientoLegal() {
        return asesoramientoLegal;
    }

    public void setAsesoramientoLegal(String asesoramientoLegal) {
        this.asesoramientoLegal = asesoramientoLegal;
    }

    public String getOrientacionSalud() {
        return orientacionSalud;
    }

    public void setOrientacionSalud(String orientacionSalud) {
        this.orientacionSalud = orientacionSalud;
    }

    public String getTrayectoriasEducativas() {
        return trayectoriasEducativas;
    }

    public void setTrayectoriasEducativas(String trayectoriasEducativas) {
        this.trayectoriasEducativas = trayectoriasEducativas;
    }

    public String getDificultadesObstaculos() {
        return dificultadesObstaculos;
    }

    public void setDificultadesObstaculos(String dificultadesObstaculos) {
        this.dificultadesObstaculos = dificultadesObstaculos;
    }

    public String getObservacionPersonal() {
        return observacionPersonal;
    }

    public void setObservacionPersonal(String observacionPersonal) {
        this.observacionPersonal = observacionPersonal;
    }

    public String getEspacioProduccionAnimalVegetal() {
        return espacioProduccionAnimalVegetal;
    }

    public void setEspacioProduccionAnimalVegetal(String espacioProduccionAnimalVegetal) {
        this.espacioProduccionAnimalVegetal = espacioProduccionAnimalVegetal;
    }

    public String getMaquinariaTrabajo() {
        return maquinariaTrabajo;
    }

    public void setMaquinariaTrabajo(String maquinariaTrabajo) {
        this.maquinariaTrabajo = maquinariaTrabajo;
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
