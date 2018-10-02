package ar.gov.sedronar.aplicacion.services.implementation;

import ar.gov.sedronar.aplicacion.dao.hibernate.HibernateDAO;
import ar.gov.sedronar.aplicacion.dao.interfaces.ActividadIntervencionDAO;
import ar.gov.sedronar.aplicacion.dto.ActividadIntervencionDTO;
import ar.gov.sedronar.aplicacion.services.interfaces.ActividadIntervencionService;
import ar.gov.sedronar.util.dozer.DozerHelper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by TMR on 02/10/2018.
 */
@Stateless
@DefaultServiceImpl
@Transactional
public class ActividadIntervencionServiceImpl implements ActividadIntervencionService {

    public static final String TIPO_ACTIVIDAD = "Actividad";
    public static final String TIPO_FAMILIA = "Familia";
    public static final String TIPO_INTERVENCION = "Intervencion";

    @Inject
    @HibernateDAO
    private ActividadIntervencionDAO actividadIntervencionDAO;

    @Override
    public List<ActividadIntervencionDTO> findAllTipoActividad() {
        return DozerHelper.mapList(actividadIntervencionDAO.findByTipo(TIPO_ACTIVIDAD), ActividadIntervencionDTO.class);
    }

    @Override
    public List<ActividadIntervencionDTO> findAllTipoFamilia() {
        return DozerHelper.mapList(actividadIntervencionDAO.findByTipo(TIPO_FAMILIA), ActividadIntervencionDTO.class);
    }

    @Override
    public List<ActividadIntervencionDTO> findAllTipoIntervencion() {
        return DozerHelper.mapList(actividadIntervencionDAO.findByTipo(TIPO_INTERVENCION), ActividadIntervencionDTO.class);
    }
}
