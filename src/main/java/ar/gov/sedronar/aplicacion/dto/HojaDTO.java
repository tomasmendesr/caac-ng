package ar.gov.sedronar.aplicacion.dto;

import ar.gov.sedronar.modulo.commonsModels.dto.MesDTO;

import java.math.BigInteger;
import java.util.Date;

/**
 * Created by TMR on 04/09/2018.
 */
public class HojaDTO {
    private BigInteger id;
    private Integer anio;
    private MesDTO mes;
    private CasaDTO casa;
    private String tipoHoja;
    private Date fechaCierre;
    private String uum;
    private Date fum;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public MesDTO getMes() {
        return mes;
    }

    public void setMes(MesDTO mes) {
        this.mes = mes;
    }

    public CasaDTO getCasa() {
        return casa;
    }

    public void setCasa(CasaDTO casa) {
        this.casa = casa;
    }

    public String getTipoHoja() {
        return tipoHoja;
    }

    public void setTipoHoja(String tipoHoja) {
        this.tipoHoja = tipoHoja;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
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
}
