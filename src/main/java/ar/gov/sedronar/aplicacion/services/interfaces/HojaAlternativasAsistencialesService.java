package ar.gov.sedronar.aplicacion.services.interfaces;

import ar.gov.sedronar.aplicacion.dto.HojaAlternativasAsistencialesDTO;

import java.util.List;

/**
 * Created by TMR on 04/10/2018.
 */
public interface HojaAlternativasAsistencialesService {
    List<HojaAlternativasAsistencialesDTO> findListByHojaId(Long idhoja);
}
