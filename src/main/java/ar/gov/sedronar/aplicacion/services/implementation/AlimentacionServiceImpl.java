package ar.gov.sedronar.aplicacion.services.implementation;

import ar.gov.sedronar.aplicacion.dao.hibernate.HibernateDAO;
import ar.gov.sedronar.aplicacion.dao.interfaces.AlimentacionDAO;
import ar.gov.sedronar.aplicacion.dto.AlimentacionDTO;
import ar.gov.sedronar.aplicacion.model.Alimentacion;
import ar.gov.sedronar.aplicacion.services.interfaces.AlimentacionService;
import ar.gov.sedronar.util.dozer.DozerHelper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by TMR on 18/09/2018.
 */
@Stateless
@Transactional
@DefaultServiceImpl
public class AlimentacionServiceImpl implements AlimentacionService {

    @Inject
    @HibernateDAO
    private AlimentacionDAO alimentacionDAO;

    @Override
    public List<AlimentacionDTO> findAll() {
        return DozerHelper.mapList(alimentacionDAO.findAll(Alimentacion.class), AlimentacionDTO.class);
    }
}
