package ar.gov.sedronar.aplicacion.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by TMR on 05/09/2018.
 */
@Entity
@Table(name = "HOJA_DIAS_ATENCION", schema = "caac")
public class HojaDiasAtencion {
    private HojaDiasAtencionId id;
    private Hoja hoja;
    private Dia dia;
    private String horario;
    private String uum;
    private java.util.Date fum;

    public HojaDiasAtencion(){}

    @EmbeddedId
    public HojaDiasAtencionId getId() {
        return id;
    }

    public void setId(HojaDiasAtencionId id) {
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }

    @Column(name = "horario", length = 50)
    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Column(name = "dia_atencion_uum", length = 50)
    public String getUum() {
        return uum;
    }

    public void setUum(String uum) {
        this.uum = uum;
    }

    @Column(name = "dia_atencion_fum")
    public Date getFum() {
        return fum;
    }

    public void setFum(Date fum) {
        this.fum = fum;
    }
}
