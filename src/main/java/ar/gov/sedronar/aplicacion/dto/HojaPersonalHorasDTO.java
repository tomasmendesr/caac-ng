package ar.gov.sedronar.aplicacion.dto;

import ar.gov.sedronar.aplicacion.model.Hoja;
import ar.gov.sedronar.modulo.commonsModels.dto.ProfesionDTO;
import ar.gov.sedronar.modulo.commonsModels.modelo.Profesion;

import java.math.BigInteger;
import java.util.Date;

/**
 * Created by TMR on 05/09/2018.
 */
public class HojaPersonalHorasDTO {
    private BigInteger id;
    private HojaDTO hoja;
    private ProfesionDTO profesion;
    private Integer cantidadRentadoHs;
    private Integer cantidadRentadoPers;
    private Integer cantidadNoRentadoHs;
    private Integer cantidadNoRentadoPers;
    private String uum;
    private java.util.Date fum;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public HojaDTO getHoja() {
        return hoja;
    }

    public void setHoja(HojaDTO hoja) {
        this.hoja = hoja;
    }

    public ProfesionDTO getProfesion() {
        return profesion;
    }

    public void setProfesion(ProfesionDTO profesion) {
        this.profesion = profesion;
    }

    public Integer getCantidadRentadoHs() {
        return cantidadRentadoHs;
    }

    public void setCantidadRentadoHs(Integer cantidadRentadoHs) {
        this.cantidadRentadoHs = cantidadRentadoHs;
    }

    public Integer getCantidadRentadoPers() {
        return cantidadRentadoPers;
    }

    public void setCantidadRentadoPers(Integer cantidadRentadoPers) {
        this.cantidadRentadoPers = cantidadRentadoPers;
    }

    public Integer getCantidadNoRentadoHs() {
        return cantidadNoRentadoHs;
    }

    public void setCantidadNoRentadoHs(Integer cantidadNoRentadoHs) {
        this.cantidadNoRentadoHs = cantidadNoRentadoHs;
    }

    public Integer getCantidadNoRentadoPers() {
        return cantidadNoRentadoPers;
    }

    public void setCantidadNoRentadoPers(Integer cantidadNoRentadoPers) {
        this.cantidadNoRentadoPers = cantidadNoRentadoPers;
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
