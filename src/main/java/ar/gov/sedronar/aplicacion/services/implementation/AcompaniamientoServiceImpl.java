package ar.gov.sedronar.aplicacion.services.implementation;

import ar.gov.sedronar.aplicacion.dao.hibernate.HibernateDAO;
import ar.gov.sedronar.aplicacion.dao.interfaces.AcompaniamientoDAO;
import ar.gov.sedronar.aplicacion.dto.AcompaniamientoDTO;
import ar.gov.sedronar.aplicacion.model.Acompaniamiento;
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
    public static final String ESTABLECIMIENTO_DE_SALUD = "Establecimiento de Salud";
    public static final String COMUNIDAD_TERAPEUTICA = "Comunidad Terapéutica/Centro Especializado";
    public static final String PATROCINIO_LEGAL = "Patrocinio Legal";


    public static final Integer ID_EST_SALUD_INTERVENCION = 1;
    public static final Integer ID_ESTB_SALUD_CONSULTORIOS = 2;
    public static final Integer ID_ESTB_SALUD_EMERGENCIAS = 3;
    public static final Integer ID_ESTB_SALUD_DESINTOXICACION = 4;

    public static final Integer ID_ESTB_SALUD_GESTION_DE_TURNOS = 5;
    public static final Integer ID_ESTB_SALUD_GESTION_DE_TRAMITES = 6;
    public static final Integer ID_ESTB_SALUD_GESTION_DE_SERVICIOS = 7;

    public static final Integer ID_ACOMP_CENTRO_ESPECIALIZADO = 8;

    public static final Integer ID_GESTION_SIN_SUBSIDIO = 9;
    public static final Integer ID_GESTION_CON_SUBSIDIO = 10;

    public static final Integer ID_GESTION_EN_SEDE= 11;
    public static final Integer ID_GESTION_FUERA_DE_SEDE = 12;

    @Inject
    @HibernateDAO
    private AcompaniamientoDAO acompaniamientoDAO;


    @Override
    public List<AcompaniamientoDTO> findAllEstablecimientosDeSalud() {
        return DozerHelper.mapList(acompaniamientoDAO.findByEstablecimiento(ESTABLECIMIENTO_DE_SALUD), AcompaniamientoDTO.class);
    }

    @Override
    public List<AcompaniamientoDTO> findAll() {
        return DozerHelper.mapList(acompaniamientoDAO.findAll(Acompaniamiento.class), AcompaniamientoDTO.class);
    }
}
