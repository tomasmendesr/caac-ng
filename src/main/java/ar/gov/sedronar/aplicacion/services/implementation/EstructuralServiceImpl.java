package ar.gov.sedronar.aplicacion.services.implementation;

import ar.gov.sedronar.aplicacion.dao.hibernate.HibernateDAO;
import ar.gov.sedronar.aplicacion.dao.interfaces.HojaDAO;
import ar.gov.sedronar.aplicacion.dto.EstructuralSeccionAData;
import ar.gov.sedronar.aplicacion.model.HojaAlternativasAsistenciales;
import ar.gov.sedronar.aplicacion.services.interfaces.EstructuralService;
import ar.gov.sedronar.aplicacion.services.interfaces.HojaAlternativasAsistencialesService;
import ar.gov.sedronar.aplicacion.services.interfaces.HojaDatosInicialesService;
import ar.gov.sedronar.aplicacion.services.interfaces.HojaService;
import ar.gov.sedronar.util.app.AppResponse;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 * Created by TMR on 04/10/2018.
 */
@Stateless
@DefaultServiceImpl
@Transactional
public class EstructuralServiceImpl implements EstructuralService {
    @Inject
    @DefaultServiceImpl
    private HojaService hojaService;

    @Inject
    @DefaultServiceImpl
    private HojaDatosInicialesService hojaDatosInicialesService;

    @Inject
    @DefaultServiceImpl
    private HojaAlternativasAsistencialesService hojaAlternativasAsistencialesService;

    @Override
    public AppResponse saveOrUpdateSeccionA(EstructuralSeccionAData data) throws Exception {
        return new AppResponse();
    }

    @Override
    public EstructuralSeccionAData findDataSeccionAByHojaId(Long idhoja) {
        EstructuralSeccionAData data = new EstructuralSeccionAData();
        data.setHojaDatosIniciales(hojaDatosInicialesService.findByHojaId(idhoja));
        data.setHoja(hojaService.findById(idhoja));
        data.setHojaAlternativasAsistencialesList(hojaAlternativasAsistencialesService.findListByHojaId(idhoja));
        return data;
    }
}
