package ar.gov.sedronar.aplicacion.services.implementation;

import ar.gov.sedronar.aplicacion.dao.hibernate.HibernateDAO;
import ar.gov.sedronar.aplicacion.dao.interfaces.HojaAlternativasAsistencialesDAO;
import ar.gov.sedronar.aplicacion.dto.HojaAlternativasAsistencialesDTO;
import ar.gov.sedronar.aplicacion.model.HojaAlternativasAsistenciales;
import ar.gov.sedronar.aplicacion.services.interfaces.AlternativaAsistencialService;
import ar.gov.sedronar.aplicacion.services.interfaces.HojaAlternativasAsistencialesService;
import ar.gov.sedronar.util.dozer.DozerHelper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by TMR on 04/10/2018.
 */
@Stateless
@DefaultServiceImpl
@Transactional
public class HojaAlternativasAsistencialesServiceImpl implements HojaAlternativasAsistencialesService{

    @Inject
    @DefaultServiceImpl
    private AlternativaAsistencialService alternativaAsistencialService;

    @Inject
    @HibernateDAO
    private HojaAlternativasAsistencialesDAO hojaAlternativasAsistencialesDAO;

    @Override
    public List<HojaAlternativasAsistencialesDTO> findListByHojaId(Long idhoja) {
        List<HojaAlternativasAsistencialesDTO> list = new ArrayList<>();
        List<Integer> idsAlternativas = alternativaAsistencialService.findAll().stream().map(a -> a.getId()).collect(Collectors.toList());
        idsAlternativas.forEach(id -> findAndAddIfExists(idhoja, id,list));
        return list;
    }

    private void findAndAddIfExists(Long idhoja, Integer id, List<HojaAlternativasAsistencialesDTO> list) {
        HojaAlternativasAsistenciales hoja = hojaAlternativasAsistencialesDAO.findByIdHojaAndIdAlternativaAsistencial(idhoja,id);
        if(hoja != null) list.add(DozerHelper.map(hoja, HojaAlternativasAsistencialesDTO.class));
    }
}
