package ar.gov.sedronar.aplicacion.services.implementation;

import ar.gov.sedronar.aplicacion.dao.hibernate.HibernateDAO;
import ar.gov.sedronar.aplicacion.dao.interfaces.AcompaniamientoDAO;
import ar.gov.sedronar.aplicacion.dto.AcompaniamientoDTO;
import ar.gov.sedronar.aplicacion.services.interfaces.AcompaniamientoService;
import ar.gov.sedronar.util.dozer.DozerHelper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by TMR on 21/09/2018.
 */
@Stateless
@Transactional
@DefaultServiceImpl
public class AcompaniamientoServiceImpl implements AcompaniamientoService{
    private static final String ESTABLECIMIENTO_DE_SALUD = "Establecimiento de Salud";

    @Inject
    @HibernateDAO
    private AcompaniamientoDAO acompaniamientoDAO;


    @Override
    public List<AcompaniamientoDTO> findAllEstablecimientosDeSalud() {
        return DozerHelper.mapList(acompaniamientoDAO.findByEstablecimiento(ESTABLECIMIENTO_DE_SALUD), AcompaniamientoDTO.class);
    }
}
