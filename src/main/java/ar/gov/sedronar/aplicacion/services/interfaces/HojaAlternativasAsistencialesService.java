package ar.gov.sedronar.aplicacion.services.interfaces;

import ar.gov.sedronar.aplicacion.dto.HojaAlternativasAsistencialesDTO;
import ar.gov.sedronar.aplicacion.model.HojaAlternativasAsistenciales;

import java.util.List;

/**
 * Created by TMR on 04/10/2018.
 */
public interface HojaAlternativasAsistencialesService {
    List<HojaAlternativasAsistencialesDTO> findListByHojaId(Long idhoja);

    HojaAlternativasAsistenciales findByIdHojaIdAndAltAsisId(Long id, Integer id1);

    void deleteModel(HojaAlternativasAsistenciales hojaAltAsisABorrar);

    void saveOrUpdate(HojaAlternativasAsistencialesDTO h) throws Exception;
}
