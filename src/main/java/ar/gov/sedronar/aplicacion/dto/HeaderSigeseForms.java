package ar.gov.sedronar.aplicacion.dto;

import ar.gov.sedronar.modulo.commonsModels.dto.MesDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by TMR on 17/09/2018.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class HeaderSigeseForms {
    private CasaDTO casa;
    private Integer anioCarga;
    private MesDTO mesCarga;
    private Integer anioRecuperacionDatos;
    private MesDTO mesRecuperacionDatos;

    public CasaDTO getCasa() {
        return casa;
    }

    public void setCasa(CasaDTO casa) {
        this.casa = casa;
    }

    public Integer getAnioCarga() {
        return anioCarga;
    }

    public void setAnioCarga(Integer anioCarga) {
        this.anioCarga = anioCarga;
    }

    public MesDTO getMesCarga() {
        return mesCarga;
    }

    public void setMesCarga(MesDTO mesCarga) {
        this.mesCarga = mesCarga;
    }

    public Integer getAnioRecuperacionDatos() {
        return anioRecuperacionDatos;
    }

    public void setAnioRecuperacionDatos(Integer anioRecuperacionDatos) {
        this.anioRecuperacionDatos = anioRecuperacionDatos;
    }

    public MesDTO getMesRecuperacionDatos() {
        return mesRecuperacionDatos;
    }

    public void setMesRecuperacionDatos(MesDTO mesRecuperacionDatos) {
        this.mesRecuperacionDatos = mesRecuperacionDatos;
    }

}
