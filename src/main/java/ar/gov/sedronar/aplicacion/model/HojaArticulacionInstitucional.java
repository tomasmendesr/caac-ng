package ar.gov.sedronar.aplicacion.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by TMR on 05/09/2018.
 */
@Entity
@Table(name = "HOJA_ARTICULACION_INST", schema = "caac")
public class HojaArticulacionInstitucional {
    private HojaArticulacionInstitucionalId id;
    private Hoja hoja;
    private TipoInstitucion tipoInstitucion;
    private String ningunVinculo;
    private String intercambioInfo;
    private String derivacionRecepcionDePersonas;
    private String accionesConjuntas;
    private String proyectos_conjuntos;
    private String nombreInstitucion;
    private String uum;
    private java.util.Date fum;

    public HojaArticulacionInstitucional(){}

    @EmbeddedId
    public HojaArticulacionInstitucionalId getId() {
        return id;
    }

    public void setId(HojaArticulacionInstitucionalId id) {
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_inst", insertable = false, updatable = false)
    public TipoInstitucion getTipoInstitucion() {
        return tipoInstitucion;
    }

    public void setTipoInstitucion(TipoInstitucion tipoInstitucion) {
        this.tipoInstitucion = tipoInstitucion;
    }

    @Column(name = "ningun_vinculo", length =1, columnDefinition = "char(1)")
    public String getNingunVinculo() {
        return ningunVinculo;
    }

    public void setNingunVinculo(String ningunVinculo) {
        this.ningunVinculo = ningunVinculo;
    }

    @Column(name = "intercambio_info", length =1, columnDefinition = "char(1)")
    public String getIntercambioInfo() {
        return intercambioInfo;
    }

    public void setIntercambioInfo(String intercambioInfo) {
        this.intercambioInfo = intercambioInfo;
    }

    @Column(name = "deriv_recep_personal", length =1, columnDefinition = "char(1)")
    public String getDerivacionRecepcionDePersonas() {
        return derivacionRecepcionDePersonas;
    }

    public void setDerivacionRecepcionDePersonas(String derivacionRecepcionDePersonas) {
        this.derivacionRecepcionDePersonas = derivacionRecepcionDePersonas;
    }

    @Column(name = "acciones_conjuntas", length =1, columnDefinition = "char(1)")
    public String getAccionesConjuntas() {
        return accionesConjuntas;
    }

    public void setAccionesConjuntas(String accionesConjuntas) {
        this.accionesConjuntas = accionesConjuntas;
    }

    @Column(name = "nombre_institucion", length = 300)
    public String getNombreInstitucion() {
        return nombreInstitucion;
    }

    public void setNombreInstitucion(String nombreInstitucion) {
        this.nombreInstitucion = nombreInstitucion;
    }

    @Column(name = "artic_inst_uum", length = 300)
    public String getUum() {
        return uum;
    }

    public void setUum(String uum) {
        this.uum = uum;
    }

    @Column(name = "artic_inst_fum")
    public Date getFum() {
        return fum;
    }

    public void setFum(Date fum) {
        this.fum = fum;
    }

    @Column(name = "proyectos_conjuntos", length =1, columnDefinition = "char(1)")
    public String getProyectos_conjuntos() {
        return proyectos_conjuntos;
    }

    public void setProyectos_conjuntos(String proyectos_conjuntos) {
        this.proyectos_conjuntos = proyectos_conjuntos;
    }
}
