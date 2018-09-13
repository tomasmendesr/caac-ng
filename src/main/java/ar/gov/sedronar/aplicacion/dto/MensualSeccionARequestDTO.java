package ar.gov.sedronar.aplicacion.dto;

/**
 * Created by TMR on 13/09/2018.
 */
public class MensualSeccionARequestDTO {
    private HojaDTO hojaDTO;
    private HojaDatosInicialesDTO hojaDatosInicialesDTO;

    public HojaDTO getHojaDTO() {
        return hojaDTO;
    }

    public void setHojaDTO(HojaDTO hojaDTO) {
        this.hojaDTO = hojaDTO;
    }

    public HojaDatosInicialesDTO getHojaDatosInicialesDTO() {
        return hojaDatosInicialesDTO;
    }

    public void setHojaDatosInicialesDTO(HojaDatosInicialesDTO hojaDatosInicialesDTO) {
        this.hojaDatosInicialesDTO = hojaDatosInicialesDTO;
    }
}
