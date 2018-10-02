package ar.gov.sedronar.aplicacion.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by TMR on 05/09/2018.
 */
@Entity
@Table(name = "HOJA_PERSONAL", schema ="caac")
public class HojaPersonal {
    private HojaPersonalId id;
    private Hoja hoja;
    private Personal empleado;
    private String uum;
    private java.util.Date fum;
    private String nombre;
    private Integer horasSemanales;
    private String apellido;
    private String rol;
    private String titulo;
    private String esRentado;

    public HojaPersonal(){}

    @EmbeddedId
    public HojaPersonalId getId() {
        return id;
    }

    public void setId(HojaPersonalId id) {
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
    @JoinColumn(name = "idempleado", insertable = false, updatable = false)
    public Personal getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Personal empleado) {
        this.empleado = empleado;
    }

    @Column(name = "hpersonal_uum", length = 50)
    public String getUum() {
        return uum;
    }

    public void setUum(String uum) {
        this.uum = uum;
    }

    @Column(name = "hpersonal_fum")
    public Date getFum() {
        return fum;
    }

    public void setFum(Date fum) {
        this.fum = fum;
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

    @Column(name = "es_rentado", columnDefinition = "char(1)", length = 1)
    public String getEsRentado() {
        return esRentado;
    }

    public void setEsRentado(String esRentado) {
        this.esRentado = esRentado;
    }

    @Column(name = "hs_semanales")
    public Integer getHorasSemanales() {
        return horasSemanales;
    }

    public void setHorasSemanales(Integer horasSemanales) {
        this.horasSemanales = horasSemanales;
    }
}
