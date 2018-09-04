package ar.gov.sedronar.aplicacion.model;
import javax.persistence.*;

/**
 * Created by TMR on 04/09/2018.
 */
@Entity
@Table(name="requisitos", schema="caac")
public class Requisito {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="actaasa")
    private String actaasa;

    @Column( name="altbanca")
    private String altbanca;

    @Column(name="cronalimen")
    private String cronalimen;

    @Column(name="crondiayh")
    private String crondiayh;

    @Column(name="cronmerc")
    private String cronmerc;

    @Column(name="cronparad")
    private String cronparad;

    @Column(name="cvsliscom")
    private String cvsliscom;

    @Column(name="desaut")
    private String desaut;

    @Column(name="forafip")
    private String forafip;

    @Column(name="fotodni")
    private String fotodni;

    @Column(name="lisrrhh")
    private String lisrrhh;

    @Column(name="organi")
    private String organi;

    @Column(name="perjur")
    private String perjur;

    @Column(name="prodesex")
    private String prodesex;

    @Column(name="segmalpra")
    private String segmalpra;

    @Column(name="segrescivil")
    private String segrescivil;

    @Column(name="soliform")
    private String soliform;

    @Column(name="statuto")
    private String statuto;

    //uni-directional many-to-one association to Casa
    @ManyToOne
    @JoinColumn(name="idcaac")
    private Casa casa;

    public Requisito() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActaasa() {
        return this.actaasa;
    }

    public void setActaasa(String actaasa) {
        this.actaasa = actaasa;
    }

    public String getAltbanca() {
        return this.altbanca;
    }

    public void setAltbanca(String altbanca) {
        this.altbanca = altbanca;
    }

    public String getCronalimen() {
        return this.cronalimen;
    }

    public void setCronalimen(String cronalimen) {
        this.cronalimen = cronalimen;
    }

    public String getCrondiayh() {
        return this.crondiayh;
    }

    public void setCrondiayh(String crondiayh) {
        this.crondiayh = crondiayh;
    }

    public String getCronmerc() {
        return this.cronmerc;
    }

    public void setCronmerc(String cronmerc) {
        this.cronmerc = cronmerc;
    }

    public String getCronparad() {
        return this.cronparad;
    }

    public void setCronparad(String cronparad) {
        this.cronparad = cronparad;
    }

    public String getCvsliscom() {
        return this.cvsliscom;
    }

    public void setCvsliscom(String cvsliscom) {
        this.cvsliscom = cvsliscom;
    }

    public String getDesaut() {
        return this.desaut;
    }

    public void setDesaut(String desaut) {
        this.desaut = desaut;
    }

    public String getForafip() {
        return this.forafip;
    }

    public void setForafip(String forafip) {
        this.forafip = forafip;
    }

    public String getFotodni() {
        return this.fotodni;
    }

    public void setFotodni(String fotodni) {
        this.fotodni = fotodni;
    }

    public String getLisrrhh() {
        return this.lisrrhh;
    }

    public void setLisrrhh(String lisrrhh) {
        this.lisrrhh = lisrrhh;
    }

    public String getOrgani() {
        return this.organi;
    }

    public void setOrgani(String organi) {
        this.organi = organi;
    }

    public String getPerjur() {
        return this.perjur;
    }

    public void setPerjur(String perjur) {
        this.perjur = perjur;
    }

    public String getProdesex() {
        return this.prodesex;
    }

    public void setProdesex(String prodesex) {
        this.prodesex = prodesex;
    }

    public String getSegmalpra() {
        return this.segmalpra;
    }

    public void setSegmalpra(String segmalpra) {
        this.segmalpra = segmalpra;
    }

    public String getSegrescivil() {
        return this.segrescivil;
    }

    public void setSegrescivil(String segrescivil) {
        this.segrescivil = segrescivil;
    }

    public String getSoliform() {
        return this.soliform;
    }

    public void setSoliform(String soliform) {
        this.soliform = soliform;
    }

    public String getStatuto() {
        return this.statuto;
    }

    public void setStatuto(String statuto) {
        this.statuto = statuto;
    }

    public Casa getCasa() {
        return this.casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

}
