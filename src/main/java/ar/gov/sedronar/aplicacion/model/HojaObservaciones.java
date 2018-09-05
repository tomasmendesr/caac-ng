package ar.gov.sedronar.aplicacion.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

/**
 * Created by TMR on 05/09/2018.
 */
@Entity
@Table(name = "HOJA_OBSERVACIONES", schema ="caac")
public class HojaObservaciones {
    private BigInteger id;
    private Hoja hoja;
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

    public HojaObservaciones(){}

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

    @Column(name = "alimentacion_en_sede", length = 4000)
    public String getAlimentacionEnSede() {
        return alimentacionEnSede;
    }

    public void setAlimentacionEnSede(String alimentacionEnSede) {
        this.alimentacionEnSede = alimentacionEnSede;
    }

    @Column(name = "alimentacion_fuera_sede", length = 4000)
    public String getAlimentacionFueraDeSede() {
        return alimentacionFueraDeSede;
    }

    public void setAlimentacionFueraDeSede(String alimentacionFueraDeSede) {
        this.alimentacionFueraDeSede = alimentacionFueraDeSede;
    }

    @Column(name = "actividades_familiares", length = 4000)
    public String getActividadesFamiliares() {
        return actividadesFamiliares;
    }

    public void setActividadesFamiliares(String actividadesFamiliares) {
        this.actividadesFamiliares = actividadesFamiliares;
    }

    @Column(name = "intervencion_calle", length = 4000)
    public String getIntervencionCalle() {
        return intervencionCalle;
    }

    public void setIntervencionCalle(String intervencionCalle) {
        this.intervencionCalle = intervencionCalle;
    }

    @Column(name = "acompaniam_visitas", length = 4000)
    public String getAcompaniamientoVisitas() {
        return acompaniamientoVisitas;
    }

    public void setAcompaniamientoVisitas(String acompaniamientoVisitas) {
        this.acompaniamientoVisitas = acompaniamientoVisitas;
    }

    @Column(name = "asesoram_legal", length = 4000)
    public String getAsesoramientoLegal() {
        return asesoramientoLegal;
    }

    public void setAsesoramientoLegal(String asesoramientoLegal) {
        this.asesoramientoLegal = asesoramientoLegal;
    }

    @Column(name = "orientacion_salud", length = 4000)
    public String getOrientacionSalud() {
        return orientacionSalud;
    }

    public void setOrientacionSalud(String orientacionSalud) {
        this.orientacionSalud = orientacionSalud;
    }

    @Column(name = "trayectorias_educativas", length = 4000)
    public String getTrayectoriasEducativas() {
        return trayectoriasEducativas;
    }

    public void setTrayectoriasEducativas(String trayectoriasEducativas) {
        this.trayectoriasEducativas = trayectoriasEducativas;
    }

    @Column(name = "dificultades_obstaculos", length = 4000)
    public String getDificultadesObstaculos() {
        return dificultadesObstaculos;
    }

    public void setDificultadesObstaculos(String dificultadesObstaculos) {
        this.dificultadesObstaculos = dificultadesObstaculos;
    }

    @Column(name = "observ_personal", length = 4000)
    public String getObservacionPersonal() {
        return observacionPersonal;
    }

    public void setObservacionPersonal(String observacionPersonal) {
        this.observacionPersonal = observacionPersonal;
    }

    @Column(name = "espacio_prod_veg_anim", length = 4000)
    public String getEspacioProduccionAnimalVegetal() {
        return espacioProduccionAnimalVegetal;
    }

    public void setEspacioProduccionAnimalVegetal(String espacioProduccionAnimalVegetal) {
        this.espacioProduccionAnimalVegetal = espacioProduccionAnimalVegetal;
    }

    @Column(name = "maquinaria_trabajo", length = 4000)
    public String getMaquinariaTrabajo() {
        return maquinariaTrabajo;
    }

    public void setMaquinariaTrabajo(String maquinariaTrabajo) {
        this.maquinariaTrabajo = maquinariaTrabajo;
    }

    @Column(name = "observaciones_uum", length = 4000)
    public String getUum() {
        return uum;
    }

    public void setUum(String uum) {
        this.uum = uum;
    }

    @Column(name = "observaciones_fum")
    public Date getFum() {
        return fum;
    }

    public void setFum(Date fum) {
        this.fum = fum;
    }
}
