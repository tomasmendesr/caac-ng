package ar.gov.sedronar.aplicacion.model;
import javax.persistence.*;


/**
 * Created by TMR on 04/09/2018.
 */
@Entity
@Table(name="logs", schema="caac")
public class Log {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="cambios")
    private String cambios;

    @Column(name="fech_hora")
    private String fechHora;

    @Column(name="usuario")
    private String usuario;

    public Log() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCambios() {
        return this.cambios;
    }

    public void setCambios(String cambios) {
        this.cambios = cambios;
    }

    public String getFechHora() {
        return this.fechHora;
    }

    public void setFechHora(String fechHora) {
        this.fechHora = fechHora;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}
