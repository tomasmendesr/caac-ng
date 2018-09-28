package ar.gov.sedronar.aplicacion.util;

import ar.gov.sedronar.aplicacion.dto.CasaDTO;
import ar.gov.sedronar.aplicacion.dto.RequisitoDTO;
import ar.gov.sedronar.aplicacion.model.Requisito;

import java.util.List;
import java.util.stream.Collectors;

public class RequisitoToFrontentUtil {

    public class RequisitoFrontend {

        private Integer id;
        private Boolean actaasa;
        private Boolean altbanca;
        private Boolean cronalimen;
        private Boolean crondiayh;
        private Boolean cronmerc;
        private Boolean cronparad;
        private Boolean cvsliscom;
        private Boolean desaut;
        private Boolean forafip;
        private Boolean fotodni;
        private Boolean lisrrhh;
        private Boolean organi;
        private Boolean perjur;
        private Boolean prodesex;
        private Boolean segmalpra;
        private Boolean segrescivil;
        private Boolean soliform;
        private Boolean statuto;
        private CasaDTO casa;

        public RequisitoFrontend(RequisitoDTO requisitoBack) {
            this.id = requisitoBack.getId();
            this.actaasa = this.stringToBoolean(requisitoBack.getActaasa());
            this.altbanca = this.stringToBoolean(requisitoBack.getAltbanca());
            this.cronalimen = this.stringToBoolean(requisitoBack.getCronalimen());
            this.crondiayh = this.stringToBoolean(requisitoBack.getCrondiayh());
            this.cronmerc = this.stringToBoolean(requisitoBack.getCronmerc());
            this.cronparad = this.stringToBoolean(requisitoBack.getCronparad());
            this.cvsliscom = this.stringToBoolean(requisitoBack.getCvsliscom());
            this.desaut = this.stringToBoolean(requisitoBack.getDesaut());
            this.forafip = this.stringToBoolean(requisitoBack.getForafip());
            this.fotodni = this.stringToBoolean(requisitoBack.getFotodni());
            this.lisrrhh = this.stringToBoolean(requisitoBack.getLisrrhh());
            this.organi = this.stringToBoolean(requisitoBack.getOrgani());
            this.perjur = this.stringToBoolean(requisitoBack.getPerjur());
            this.prodesex = this.stringToBoolean(requisitoBack.getProdesex());
            this.segmalpra = this.stringToBoolean(requisitoBack.getSegmalpra());
            this.segrescivil = this.stringToBoolean(requisitoBack.getSegrescivil());
            this.soliform = this.stringToBoolean(requisitoBack.getSoliform());
            this.statuto = this.stringToBoolean(requisitoBack.getStatuto());
            this.casa = requisitoBack.getCasa();
        }

        private Boolean stringToBoolean(String string) {
            return string.equals("checked") ? true : false;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Boolean getActaasa() {
            return actaasa;
        }

        public void setActaasa(Boolean actaasa) {
            this.actaasa = actaasa;
        }

        public Boolean getAltbanca() {
            return altbanca;
        }

        public void setAltbanca(Boolean altbanca) {
            this.altbanca = altbanca;
        }

        public Boolean getCronalimen() {
            return cronalimen;
        }

        public void setCronalimen(Boolean cronalimen) {
            this.cronalimen = cronalimen;
        }

        public Boolean getCrondiayh() {
            return crondiayh;
        }

        public void setCrondiayh(Boolean crondiayh) {
            this.crondiayh = crondiayh;
        }

        public Boolean getCronmerc() {
            return cronmerc;
        }

        public void setCronmerc(Boolean cronmerc) {
            this.cronmerc = cronmerc;
        }

        public Boolean getCronparad() {
            return cronparad;
        }

        public void setCronparad(Boolean cronparad) {
            this.cronparad = cronparad;
        }

        public Boolean getCvsliscom() {
            return cvsliscom;
        }

        public void setCvsliscom(Boolean cvsliscom) {
            this.cvsliscom = cvsliscom;
        }

        public Boolean getDesaut() {
            return desaut;
        }

        public void setDesaut(Boolean desaut) {
            this.desaut = desaut;
        }

        public Boolean getForafip() {
            return forafip;
        }

        public void setForafip(Boolean forafip) {
            this.forafip = forafip;
        }

        public Boolean getFotodni() {
            return fotodni;
        }

        public void setFotodni(Boolean fotodni) {
            this.fotodni = fotodni;
        }

        public Boolean getLisrrhh() {
            return lisrrhh;
        }

        public void setLisrrhh(Boolean lisrrhh) {
            this.lisrrhh = lisrrhh;
        }

        public Boolean getOrgani() {
            return organi;
        }

        public void setOrgani(Boolean organi) {
            this.organi = organi;
        }

        public Boolean getPerjur() {
            return perjur;
        }

        public void setPerjur(Boolean perjur) {
            this.perjur = perjur;
        }

        public Boolean getProdesex() {
            return prodesex;
        }

        public void setProdesex(Boolean prodesex) {
            this.prodesex = prodesex;
        }

        public Boolean getSegmalpra() {
            return segmalpra;
        }

        public void setSegmalpra(Boolean segmalpra) {
            this.segmalpra = segmalpra;
        }

        public Boolean getSegrescivil() {
            return segrescivil;
        }

        public void setSegrescivil(Boolean segrescivil) {
            this.segrescivil = segrescivil;
        }

        public Boolean getSoliform() {
            return soliform;
        }

        public void setSoliform(Boolean soliform) {
            this.soliform = soliform;
        }

        public Boolean getStatuto() {
            return statuto;
        }

        public void setStatuto(Boolean statuto) {
            this.statuto = statuto;
        }

        public CasaDTO getCasa() {
            return casa;
        }

        public void setCasa(CasaDTO casa) {
            this.casa = casa;
        }

    }

    public List<RequisitoFrontend> mapToFrontentd(List<RequisitoDTO> requisitoDTOList) {
        return requisitoDTOList.stream().map(elem -> new RequisitoFrontend(elem)).collect(Collectors.toList());
    }

}


