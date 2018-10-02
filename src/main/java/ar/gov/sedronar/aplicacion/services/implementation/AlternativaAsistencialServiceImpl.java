package ar.gov.sedronar.aplicacion.services.implementation;

import ar.gov.sedronar.aplicacion.dao.hibernate.HibernateDAO;
import ar.gov.sedronar.aplicacion.dao.interfaces.AlternativaAsistencialDAO;
import ar.gov.sedronar.aplicacion.dto.AlternativaAsistencialDTO;
import ar.gov.sedronar.aplicacion.model.AlternativaAsistencial;
import ar.gov.sedronar.aplicacion.services.interfaces.AlternativaAsistencialService;
import ar.gov.sedronar.util.dozer.DozerHelper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by TMR on 01/10/2018.
 */
@Stateless
@DefaultServiceImpl
@Transactional
public class AlternativaAsistencialServiceImpl implements AlternativaAsistencialService {

    @Inject
    @HibernateDAO
    private AlternativaAsistencialDAO alternativaAsistencialDAO;

    @Override
    public List<AlternativaAsistencialDTO> findAll() {
        return DozerHelper.mapList(alternativaAsistencialDAO.findAll(AlternativaAsistencial.class), AlternativaAsistencialDTO.class);
    }
}
