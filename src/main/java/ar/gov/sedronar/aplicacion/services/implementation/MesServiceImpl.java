package ar.gov.sedronar.aplicacion.services.implementation;

import ar.gov.sedronar.modulo.commonsModels.dao.hibernate.HibernateDAO;
import ar.gov.sedronar.aplicacion.services.interfaces.MesService;
import ar.gov.sedronar.modulo.commonsModels.dao.interfaces.MesDAO;
import ar.gov.sedronar.modulo.commonsModels.dto.MesDTO;
import ar.gov.sedronar.modulo.commonsModels.modelo.Mes;
import ar.gov.sedronar.util.dozer.DozerHelper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by TMR on 10/09/2018.
 */
@Transactional
@Stateless
@DefaultServiceImpl
public class MesServiceImpl implements MesService {

    @Inject
    @HibernateDAO
    private MesDAO mesDAO;

    @Override
    public List<MesDTO> findAll() {
        return DozerHelper.mapList(mesDAO.findAll(Mes.class), MesDTO.class);
    }
}
