package ar.gov.sedronar.aplicacion.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

/**
 * Created by TMR on 04/09/2018.
 */
@Entity
@Table(name="casas", schema="caac")
public class Casa {
    public Casa(){
        activa=true;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nomcaac")
    private String nomcaac;

    @Column(name="perjuridica")
    private String perjuridica;

    @Column(name="cuit")
    private String cuit;

    @Column(name="dir")
    private String dir;

    @Column(name="nomrepre")
    private String nomrepre;

    @Column(name="tel", columnDefinition="TEXT")
    private String tel;

    @Column(name="mail")
    private String mail;

    //@Column(name="obser",length=255, columnDefinition="TEXT")
    @Column(name="obser", columnDefinition="TEXT")
    private String obser;

    @Column(name="obseradm", columnDefinition="TEXT")
    private String obseradm;

    @Column(name="modal")
    private String modal;

    @OneToOne
    @JoinColumn(name="cat", referencedColumnName="cat")
    private Categoria cat;

    @OneToOne
    @JoinColumn(name="ncat", referencedColumnName="cat")
    private Categoria ncat;

    @Column(name="fechaini")
    private Date fechaini;

    @Column(name="fechacon")
    private Date fechacon;

    @Column(name="expsed")
    private String expsed;

    @Column(name="req")
    private String req;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idprov")
    private ProvinciaLight provincia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idlocalidad")
    private LocalidadLight localidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iddepto")
    private DepartamentoLight departamento;

    @Column(name="activa",nullable=false)
    @ColumnDefault(value = "1")
    private Boolean activa;

    @PrePersist
    public void prePersist() {
        if(activa == null) //We set default value in case if the value is not set yet.
            activa = true;
    }

    public Boolean getActiva() {
        return activa;
    }

    public void setActiva(Boolean activa) {
        this.activa = activa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomcaac() {
        return nomcaac;
    }

    public void setNomcaac(String nomcaac) {
        this.nomcaac = nomcaac;
    }

    public String getPerjuridica() {
        return perjuridica;
    }

    public void setPerjuridica(String perjuridica) {
        this.perjuridica = perjuridica;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getNomrepre() {
        return nomrepre;
    }

    public void setNomrepre(String nomrepre) {
        this.nomrepre = nomrepre;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getObser() {
        return obser;
    }

    public void setObser(String obser) {
        this.obser = obser;
    }

    public String getObseradm() {
        return obseradm;
    }

    public void setObseradm(String obseradm) {
        this.obseradm = obseradm;
    }

    public String getModal() {
        return modal;
    }

    public void setModal(String modal) {
        this.modal = modal;
    }

    public Categoria getCat() {
        return cat;
    }

    public void setCat(Categoria cat) {
        this.cat = cat;
    }

    public Categoria getNcat() {
        return ncat;
    }

    public void setNcat(Categoria ncat) {
        this.ncat = ncat;
    }

    public Date getFechaini() {
        return fechaini;
    }

    public void setFechaini(Date fechaini) {
        this.fechaini = fechaini;
    }

    public Date getFechacon() {
        return fechacon;
    }

    public void setFechacon(Date fechacon) {
        this.fechacon = fechacon;
    }

    public String getExpsed() {
        return expsed;
    }

    public void setExpsed(String expsed) {
        this.expsed = expsed;
    }

    public String getReq() {
        return req;
    }

    public void setReq(String req) {
        this.req = req;
    }

    public ProvinciaLight getProvincia() {
        return provincia;
    }

    public void setProvincia(ProvinciaLight provincia) {
        this.provincia = provincia;
    }

    public LocalidadLight getLocalidad() {
        return localidad;
    }

    public void setLocalidad(LocalidadLight localidad) {
        this.localidad = localidad;
    }

    public DepartamentoLight getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoLight departamento) {
        this.departamento = departamento;
    }

    private class LocalidadLight {
    }
}
