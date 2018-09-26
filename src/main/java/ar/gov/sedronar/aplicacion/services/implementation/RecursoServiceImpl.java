package ar.gov.sedronar.aplicacion.services.implementation;

import ar.gov.sedronar.aplicacion.dao.hibernate.HibernateDAO;
import ar.gov.sedronar.aplicacion.dao.interfaces.RecursoDAO;
import ar.gov.sedronar.aplicacion.dto.RecursoDTO;
import ar.gov.sedronar.aplicacion.model.Recurso;
import ar.gov.sedronar.aplicacion.services.interfaces.RecursoService;
import ar.gov.sedronar.util.dozer.DozerHelper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by TMR on 26/09/2018.
 */
@DefaultServiceImpl
@Stateless
@Transactional
public class RecursoServiceImpl implements RecursoService{

    @Inject
    @HibernateDAO
    private RecursoDAO recursoDAO;

    @Override
    public List<RecursoDTO> findAll() {
        return DozerHelper.mapList(recursoDAO.findAll(Recurso.class), RecursoDTO.class);
    }
}
