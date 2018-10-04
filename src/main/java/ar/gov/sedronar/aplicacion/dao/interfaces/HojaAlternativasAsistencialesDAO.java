package ar.gov.sedronar.aplicacion.dao.interfaces;

import ar.gov.sedronar.aplicacion.model.HojaAlternativasAsistenciales;

/**
 * Created by TMR on 04/10/2018.
 */
public interface HojaAlternativasAsistencialesDAO extends AbstractDAO<HojaAlternativasAsistenciales> {
    HojaAlternativasAsistenciales findByIdHojaAndIdAlternativaAsistencial(Long idHoja, Integer idAlt);
}
