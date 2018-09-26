package ar.gov.sedronar.aplicacion.dto;

import ar.gov.sedronar.aplicacion.model.Categoria;
import ar.gov.sedronar.modulo.geo.dto.DepartamentoLightDTO;
import ar.gov.sedronar.modulo.geo.dto.LocalidadLightDTO;
import ar.gov.sedronar.modulo.geo.dto.ProvinciaLightDTO;

import java.util.Date;

/**
 * Created by TMR on 11/09/2018.
 */
public class CasaLightDTO {
    private Integer id;
    private String nomcaac, perjuridica, cuit, dir, nomrepre, tel, mail, obser, expsed, req, modal, obseradm;
    private ProvinciaLightDTO provincia;
    private LocalidadLightDTO localidad;
    private DepartamentoLightDTO departamento;
    private Categoria cat, ncat;
    private Date fechaini, fechacon;
    private Boolean activa;

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

    public ProvinciaLightDTO getProvincia() {
        return provincia;
    }

    public void setProvincia(ProvinciaLightDTO provincia) {
        this.provincia = provincia;
    }

    public LocalidadLightDTO getLocalidad() {
        return localidad;
    }

    public void setLocalidad(LocalidadLightDTO localidad) {
        this.localidad = localidad;
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

    public Date getFechacon() {
        return fechacon;
    }

    public void setFechacon(Date fechacon) {
        this.fechacon = fechacon;
    }

    public Date getFechaini() {
        return fechaini;
    }

    public void setFechaini(Date fechaini) {
        this.fechaini = fechaini;
    }

    public DepartamentoLightDTO getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoLightDTO departamento) {
        this.departamento = departamento;
    }

    public Boolean getActiva() {
        return activa;
    }

    public void setActiva(Boolean activa) {
        this.activa = activa;
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

    public String getModal() {
        return modal;
    }

    public void setModal(String modal) {
        this.modal = modal;
    }

    public String getObseradm() {
        return obseradm;
    }

    public void setObseradm(String obseradm) {
        this.obseradm = obseradm;
    }
}
