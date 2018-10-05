package ar.gov.sedronar.aplicacion.services.implementation;

import ar.gov.sedronar.aplicacion.dao.hibernate.HibernateDAO;
import ar.gov.sedronar.aplicacion.dao.interfaces.HojaDAO;
import ar.gov.sedronar.aplicacion.dto.EstructuralSeccionAData;
import ar.gov.sedronar.aplicacion.dto.HojaAlternativasAsistencialesDTO;
import ar.gov.sedronar.aplicacion.model.HojaAlternativasAsistenciales;
import ar.gov.sedronar.aplicacion.services.interfaces.EstructuralService;
import ar.gov.sedronar.aplicacion.services.interfaces.HojaAlternativasAsistencialesService;
import ar.gov.sedronar.aplicacion.services.interfaces.HojaDatosInicialesService;
import ar.gov.sedronar.aplicacion.services.interfaces.HojaService;
import ar.gov.sedronar.util.app.AppResponse;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

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
        List<HojaAlternativasAsistencialesDTO> hojaAltAsistAGuardar = new ArrayList<>();
        for (HojaAlternativasAsistencialesDTO hojaAlternativasAsistencialesDTO : data.getHojaAlternativasAsistencialesList()) {
            if(data.getHoja().getId() != null && !hojaAlternativasAsistencialesDTO.getIsChecked()){
                HojaAlternativasAsistenciales hojaAltAsisABorrar = hojaAlternativasAsistencialesService.findByIdHojaIdAndAltAsisId(data.getHoja().getId(), hojaAlternativasAsistencialesDTO.getAlternativaAsistencial().getId());
                if(hojaAltAsisABorrar != null) hojaAlternativasAsistencialesService.deleteModel(hojaAltAsisABorrar);
            }
            else if (hojaAlternativasAsistencialesDTO.getIsChecked()) hojaAltAsistAGuardar.add(hojaAlternativasAsistencialesDTO);
        }

        if(data.getHoja().getId() == null){
            data.getHoja().setTipoHoja("E");
            Long idHoja = hojaService.saveOrUpdate(data.getHoja()); // guardo la hoja y la vinculo a hojaDatosIniciales
            data.getHojaDatosIniciales().getHoja().setId(idHoja);
            hojaAltAsistAGuardar.forEach(h -> h.getHoja().setId(idHoja));
        }

        for(HojaAlternativasAsistencialesDTO h : hojaAltAsistAGuardar) hojaAlternativasAsistencialesService.saveOrUpdate(h);
        hojaDatosInicialesService.saveOrUpdate(data.getHojaDatosIniciales());
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
