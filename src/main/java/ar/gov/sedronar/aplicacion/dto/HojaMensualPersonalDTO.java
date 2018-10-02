package ar.gov.sedronar.aplicacion.dto;
import java.util.Date;
/**
 * Created by TMR on 05/09/2018.
 */
public class HojaMensualPersonalDTO {
    private HojaDTO hoja;
    private PersonalDTO personal;
    private String altaBaja;
    private String uum;
    private java.util.Date fum;
    private String nombre;
    private Integer horasSemanales;
    private String apellido;
    private String rol;
    private String titulo;
    private String esRentado;

    public HojaDTO getHoja() {
        return hoja;
    }

    public void setHoja(HojaDTO hoja) {
        this.hoja = hoja;
    }

    public PersonalDTO getPersonal() {
        return personal;
    }

    public void setPersonal(PersonalDTO personal) {
        this.personal = personal;
    }

    public String getAltaBaja() {
        return altaBaja;
    }

    public void setAltaBaja(String altaBaja) {
        this.altaBaja = altaBaja;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getHorasSemanales() {
        return horasSemanales;
    }

    public void setHorasSemanales(Integer horasSemanales) {
        this.horasSemanales = horasSemanales;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEsRentado() {
        return esRentado;
    }

    public void setEsRentado(String esRentado) {
        this.esRentado = esRentado;
    }
}
