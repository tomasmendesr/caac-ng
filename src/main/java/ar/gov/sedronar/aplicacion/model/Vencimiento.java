package ar.gov.sedronar.aplicacion.model;

import javax.persistence.*;
import java.util.Date;
/**
 * Created by TMR on 04/09/2018.
 */
@Entity
@Table(name="vencimientos", schema="caac")
public class Vencimiento {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="afipbaja")
    private Date afipbaja;

    @Column(name="afiprecib")
    private Date afiprecib;

    @Column(name="asambaja")
    private Date asambaja;

    @Column(name="asamrecib")
    private Date asamrecib;

    @Column(name="autoribaja")
    private Date autoribaja;

    @Column(name="autorirecib")
    private Date autorirecib;

    @Column(name="fech_rec_mala1")
    private Date fechRecMala1;

    @Column(name="fech_rec_mala10")
    private Date fechRecMala10;

    @Column(name="fech_rec_mala2")
    private Date fechRecMala2;

    @Column(name="fech_rec_mala3")
    private Date fechRecMala3;

    @Column(name="fech_rec_mala4")
    private Date fechRecMala4;

    @Column(name="fech_rec_mala5")
    private Date fechRecMala5;

    @Column(name="fech_rec_mala6")
    private Date fechRecMala6;

    @Column(name="fech_rec_mala7")
    private Date fechRecMala7;

    @Column(name="fech_rec_mala8")
    private Date fechRecMala8;

    @Column(name="fech_rec_mala9")
    private Date fechRecMala9;

    @Column(name="fech_ven_mala1")
    private Date fechVenMala1;

    @Column(name="fech_ven_mala10")
    private Date fechVenMala10;

    @Column(name="fech_ven_mala2")
    private Date fechVenMala2;

    @Column(name="fech_ven_mala3")
    private Date fechVenMala3;

    @Column(name="fech_ven_mala4")
    private Date fechVenMala4;

    @Column(name="fech_ven_mala5")
    private Date fechVenMala5;

    @Column(name="fech_ven_mala6")
    private Date fechVenMala6;

    @Column(name="fech_ven_mala7")
    private Date fechVenMala7;

    @Column(name="fech_ven_mala8")
    private Date fechVenMala8;

    @Column(name="fech_ven_mala9")
    private Date fechVenMala9;

    @Column(name="malapra1")
    private String malapra1;

    @Column(name="malapra10")
    private String malapra10;

    @Column(name="malapra2")
    private String malapra2;

    @Column(name="malapra3")
    private String malapra3;

    @Column(name="malapra4")
    private String malapra4;

    @Column(name="malapra5")
    private String malapra5;

    @Column(name="malapra6")
    private String malapra6;

    @Column(name="malapra7")
    private String malapra7;

    @Column(name="malapra8")
    private String malapra8;

    @Column(name="malapra9")
    private String malapra9;

    @Column(name="responbaja")
    private Date responbaja;

    @Column(name="responrecib")
    private Date responrecib;

    //uni-directional many-to-one association to Casa
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name="idcaac")
    private Casa casa;

    public Vencimiento() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getAfipbaja() {
        return this.afipbaja;
    }

    public void setAfipbaja(Date afipbaja) {
        this.afipbaja = afipbaja;
    }

    public Date getAfiprecib() {
        return this.afiprecib;
    }

    public void setAfiprecib(Date afiprecib) {
        this.afiprecib = afiprecib;
    }

    public Date getAsambaja() {
        return this.asambaja;
    }

    public void setAsambaja(Date asambaja) {
        this.asambaja = asambaja;
    }

    public Date getAsamrecib() {
        return this.asamrecib;
    }

    public void setAsamrecib(Date asamrecib) {
        this.asamrecib = asamrecib;
    }

    public Date getAutoribaja() {
        return this.autoribaja;
    }

    public void setAutoribaja(Date autoribaja) {
        this.autoribaja = autoribaja;
    }

    public Date getAutorirecib() {
        return this.autorirecib;
    }

    public void setAutorirecib(Date autorirecib) {
        this.autorirecib = autorirecib;
    }

    public Date getFechRecMala1() {
        return this.fechRecMala1;
    }

    public void setFechRecMala1(Date fechRecMala1) {
        this.fechRecMala1 = fechRecMala1;
    }

    public Date getFechRecMala10() {
        return this.fechRecMala10;
    }

    public void setFechRecMala10(Date fechRecMala10) {
        this.fechRecMala10 = fechRecMala10;
    }

    public Date getFechRecMala2() {
        return this.fechRecMala2;
    }

    public void setFechRecMala2(Date fechRecMala2) {
        this.fechRecMala2 = fechRecMala2;
    }

    public Date getFechRecMala3() {
        return this.fechRecMala3;
    }

    public void setFechRecMala3(Date fechRecMala3) {
        this.fechRecMala3 = fechRecMala3;
    }

    public Date getFechRecMala4() {
        return this.fechRecMala4;
    }

    public void setFechRecMala4(Date fechRecMala4) {
        this.fechRecMala4 = fechRecMala4;
    }

    public Date getFechRecMala5() {
        return this.fechRecMala5;
    }

    public void setFechRecMala5(Date fechRecMala5) {
        this.fechRecMala5 = fechRecMala5;
    }

    public Date getFechRecMala6() {
        return this.fechRecMala6;
    }

    public void setFechRecMala6(Date fechRecMala6) {
        this.fechRecMala6 = fechRecMala6;
    }

    public Date getFechRecMala7() {
        return this.fechRecMala7;
    }

    public void setFechRecMala7(Date fechRecMala7) {
        this.fechRecMala7 = fechRecMala7;
    }

    public Date getFechRecMala8() {
        return this.fechRecMala8;
    }

    public void setFechRecMala8(Date fechRecMala8) {
        this.fechRecMala8 = fechRecMala8;
    }

    public Date getFechRecMala9() {
        return this.fechRecMala9;
    }

    public void setFechRecMala9(Date fechRecMala9) {
        this.fechRecMala9 = fechRecMala9;
    }

    public Date getFechVenMala1() {
        return this.fechVenMala1;
    }

    public void setFechVenMala1(Date fechVenMala1) {
        this.fechVenMala1 = fechVenMala1;
    }

    public Date getFechVenMala10() {
        return this.fechVenMala10;
    }

    public void setFechVenMala10(Date fechVenMala10) {
        this.fechVenMala10 = fechVenMala10;
    }

    public Date getFechVenMala2() {
        return this.fechVenMala2;
    }

    public void setFechVenMala2(Date fechVenMala2) {
        this.fechVenMala2 = fechVenMala2;
    }

    public Date getFechVenMala3() {
        return this.fechVenMala3;
    }

    public void setFechVenMala3(Date fechVenMala3) {
        this.fechVenMala3 = fechVenMala3;
    }

    public Date getFechVenMala4() {
        return this.fechVenMala4;
    }

    public void setFechVenMala4(Date fechVenMala4) {
        this.fechVenMala4 = fechVenMala4;
    }

    public Date getFechVenMala5() {
        return this.fechVenMala5;
    }

    public void setFechVenMala5(Date fechVenMala5) {
        this.fechVenMala5 = fechVenMala5;
    }

    public Date getFechVenMala6() {
        return this.fechVenMala6;
    }

    public void setFechVenMala6(Date fechVenMala6) {
        this.fechVenMala6 = fechVenMala6;
    }

    public Date getFechVenMala7() {
        return this.fechVenMala7;
    }

    public void setFechVenMala7(Date fechVenMala7) {
        this.fechVenMala7 = fechVenMala7;
    }

    public Date getFechVenMala8() {
        return this.fechVenMala8;
    }

    public void setFechVenMala8(Date fechVenMala8) {
        this.fechVenMala8 = fechVenMala8;
    }

    public Date getFechVenMala9() {
        return this.fechVenMala9;
    }

    public void setFechVenMala9(Date fechVenMala9) {
        this.fechVenMala9 = fechVenMala9;
    }

    public String getMalapra1() {
        return this.malapra1;
    }

    public void setMalapra1(String malapra1) {
        this.malapra1 = malapra1;
    }

    public String getMalapra10() {
        return this.malapra10;
    }

    public void setMalapra10(String malapra10) {
        this.malapra10 = malapra10;
    }

    public String getMalapra2() {
        return this.malapra2;
    }

    public void setMalapra2(String malapra2) {
        this.malapra2 = malapra2;
    }

    public String getMalapra3() {
        return this.malapra3;
    }

    public void setMalapra3(String malapra3) {
        this.malapra3 = malapra3;
    }

    public String getMalapra4() {
        return this.malapra4;
    }

    public void setMalapra4(String malapra4) {
        this.malapra4 = malapra4;
    }

    public String getMalapra5() {
        return this.malapra5;
    }

    public void setMalapra5(String malapra5) {
        this.malapra5 = malapra5;
    }

    public String getMalapra6() {
        return this.malapra6;
    }

    public void setMalapra6(String malapra6) {
        this.malapra6 = malapra6;
    }

    public String getMalapra7() {
        return this.malapra7;
    }

    public void setMalapra7(String malapra7) {
        this.malapra7 = malapra7;
    }

    public String getMalapra8() {
        return this.malapra8;
    }

    public void setMalapra8(String malapra8) {
        this.malapra8 = malapra8;
    }

    public String getMalapra9() {
        return this.malapra9;
    }

    public void setMalapra9(String malapra9) {
        this.malapra9 = malapra9;
    }

    public Date getResponbaja() {
        return this.responbaja;
    }

    public void setResponbaja(Date responbaja) {
        this.responbaja = responbaja;
    }

    public Date getResponrecib() {
        return this.responrecib;
    }

    public void setResponrecib(Date responrecib) {
        this.responrecib = responrecib;
    }

    public Casa getCasa() {
        return this.casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

}
