package ar.gov.sedronar.aplicacion.services.implementation;

import ar.gov.sedronar.aplicacion.dao.hibernate.HibernateDAO;
import ar.gov.sedronar.aplicacion.dao.interfaces.TramiteDAO;
import ar.gov.sedronar.aplicacion.dto.TramiteDTO;
import ar.gov.sedronar.aplicacion.model.Tramite;
import ar.gov.sedronar.aplicacion.services.interfaces.TramiteService;
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
public class TramiteServiceImpl implements TramiteService {
    @Inject
    @HibernateDAO
    private TramiteDAO tramiteoDAO;

    @Override
    public List<TramiteDTO> findAll() {
        return DozerHelper.mapList(tramiteoDAO.findAll(Tramite.class), TramiteDTO.class);
    }
}
