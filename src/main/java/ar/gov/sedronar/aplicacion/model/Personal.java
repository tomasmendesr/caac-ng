package ar.gov.sedronar.aplicacion.model;

import ar.gov.sedronar.modulo.commonsModels.modelo.Profesion;
import ar.gov.sedronar.modulo.commonsModels.modelo.TipoDocumento;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by TMR on 05/09/2018.
 */
@Entity
@Table(name = "PERSONAL", schema = "caac")
public class Personal {
    private Integer id;
    private Profesion profesion;
    private String nombre;
    private String apellido;
    private Integer horasSemanales;
    private String rol;
    private String titulo;
    private String esRentado;
    private String estadoActual;
    private String uum;
    private java.util.Date fum;
    private TipoDocumento tipoDocumento;
    private Integer numeroDocumento;


    public Personal(){}

    @Id
    @Column(name = "idempleado")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idprofesion")
    public Profesion getProfesion() {
        return profesion;
    }

    public void setProfesion(Profesion profesion) {
        this.profesion = profesion;
    }

    @Column(name = "nombre", length = 100)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "apellido", length = 100)
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Column(name = "hs_semanales")
    public Integer getHorasSemanales() {
        return horasSemanales;
    }

    public void setHorasSemanales(Integer horasSemanales) {
        this.horasSemanales = horasSemanales;
    }

    @Column(name = "rol", length = 100)
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Column(name = "titulo", length = 100)
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Column(name = "es_rentado", length = 1, columnDefinition = "char(1")
    public String getEsRentado() {
        return esRentado;
    }

    public void setEsRentado(String esRentado) {
        this.esRentado = esRentado;
    }

    @Column(name = "estado_actual", length = 4, columnDefinition = "char(4")
    public String getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(String estadoActual) {
        this.estadoActual = estadoActual;
    }

    @Column(name = "personal_uum", length = 50)
    public String getUum() {
        return uum;
    }

    public void setUum(String uum) {
        this.uum = uum;
    }

    @Column(name = "personal_fum")
    public Date getFum() {
        return fum;
    }

    public void setFum(Date fum) {
        this.fum = fum;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipodocumento")
    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    @Column(name = "nrodocumento")
    public Integer getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(Integer numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
}
