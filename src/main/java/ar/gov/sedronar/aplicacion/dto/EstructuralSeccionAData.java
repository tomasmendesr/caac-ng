package ar.gov.sedronar.aplicacion.dto;


import java.util.List;

/**
 * Created by TMR on 04/10/2018.
 */
public class EstructuralSeccionAData {
    private List<HojaAlternativasAsistencialesDTO> hojaAlternativasAsistencialesList;
    private HojaDatosInicialesDTO hojaDatosIniciales;
    private HojaDTO hoja;

    public List<HojaAlternativasAsistencialesDTO> getHojaAlternativasAsistencialesList() {
        return hojaAlternativasAsistencialesList;
    }

    public void setHojaAlternativasAsistencialesList(List<HojaAlternativasAsistencialesDTO> hojaAlternativasAsistencialesList) {
        this.hojaAlternativasAsistencialesList = hojaAlternativasAsistencialesList;
    }

    public HojaDatosInicialesDTO getHojaDatosIniciales() {
        return hojaDatosIniciales;
    }

    public void setHojaDatosIniciales(HojaDatosInicialesDTO hojaDatosIniciales) {
        this.hojaDatosIniciales = hojaDatosIniciales;
    }

    public HojaDTO getHoja() {
        return hoja;
    }

    public void setHoja(HojaDTO hoja) {
        this.hoja = hoja;
    }
}
