package ar.gov.sedronar.aplicacion.filters;

/**
 * Created by TMR on 10/09/2018.
 */
public class ConsultaFilter  {
    private Integer casaId;
    private Integer anioInicio;
    private Integer anioFin;
    private Integer mesInicioId;
    private Integer mesFinId;
    private Boolean tipoInformacionEstructural;
    private Boolean tipoInformacionMensual;

    public Integer getCasaId() {
        return casaId;
    }

    public void setCasaId(Integer casaId) {
        this.casaId = casaId;
    }

    public Integer getAnioInicio() {
        return anioInicio;
    }

    public void setAnioInicio(Integer anioInicio) {
        this.anioInicio = anioInicio;
    }

    public Integer getAnioFin() {
        return anioFin;
    }

    public void setAnioFin(Integer anioFin) {
        this.anioFin = anioFin;
    }

    public Integer getMesInicioId() {
        return mesInicioId;
    }

    public void setMesInicioId(Integer mesInicioId) {
        this.mesInicioId = mesInicioId;
    }

    public Integer getMesFinId() {
        return mesFinId;
    }

    public void setMesFinId(Integer mesFinId) {
        this.mesFinId = mesFinId;
    }

    public Boolean getTipoInformacionEstructural() {
        return tipoInformacionEstructural;
    }

    public void setTipoInformacionEstructural(Boolean tipoInformacionEstructural) {
        this.tipoInformacionEstructural = tipoInformacionEstructural;
    }

    public Boolean getTipoInformacionMensual() {
        return tipoInformacionMensual;
    }

    public void setTipoInformacionMensual(Boolean tipoInformacionMensual) {
        this.tipoInformacionMensual = tipoInformacionMensual;
    }
}
