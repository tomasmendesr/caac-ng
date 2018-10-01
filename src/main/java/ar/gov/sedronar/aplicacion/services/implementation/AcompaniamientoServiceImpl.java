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
    public static final String ESTABLECIMIENTO_PROFESIONAL_DE_SALUD = "Profesional de Salud";
    public static final String ESTABLECIMIENTO_TRAYECTORIAS_EDUCATIVAS = "Trayectorias Educativas";
    public static final String ESTABLECIMIENTO_COMUNIDAD_TERAPEUTICA = "Comunidad Terapéutica/Centro Especializado";
    public static final String ESTABLECIMIENTO_PATROCINIO_LEGAL = "Patrocinio Legal";
    public static final String ESTABLECIMIENTO_PENALES_COMISARIAS = "Penales o Comisarías";

    public static final String TIPO_ACOMPANIAMIENTO = "Acompañamiento";
    public static final String TIPO_ACOMPANIAMIENTO_VISITA = "Acompañamiento/Visita";
    public static final String TIPO_ACTIVIDADES = "Actividades";
    public static final String TIPO_GESTION = "Gestión";

    @Inject
    @HibernateDAO
    private AcompaniamientoDAO acompaniamientoDAO;


    @Override
    public List<AcompaniamientoDTO> findAllEstablecimientosDeSalud() {
        return DozerHelper.mapList(acompaniamientoDAO.findByEstablecimiento(ESTABLECIMIENTO_DE_SALUD), AcompaniamientoDTO.class);
    }

    @Override
    public List<AcompaniamientoDTO> findAllEstablecimientosPatrocinioLegal() {
        return DozerHelper.mapList(acompaniamientoDAO.findByEstablecimiento(ESTABLECIMIENTO_PATROCINIO_LEGAL), AcompaniamientoDTO.class);
    }

    @Override
    public List<AcompaniamientoDTO> findAllEstablecimientosComunuidadTerapeutica() {
        return DozerHelper.mapList(acompaniamientoDAO.findByEstablecimiento(ESTABLECIMIENTO_COMUNIDAD_TERAPEUTICA), AcompaniamientoDTO.class);
    }

    @Override
    public List<AcompaniamientoDTO> findAllEstablecimientoPenalesComisarias() {
        return DozerHelper.mapList(acompaniamientoDAO.findByEstablecimiento(ESTABLECIMIENTO_PENALES_COMISARIAS), AcompaniamientoDTO.class);
    }

    @Override
    public List<AcompaniamientoDTO> findAll() {
        return DozerHelper.mapList(acompaniamientoDAO.findAll(Acompaniamiento.class), AcompaniamientoDTO.class);
    }

    @Override
    public List<AcompaniamientoDTO> findAllEstablecimientosDeSaludAndTipoAcompaniamiento() {
        return DozerHelper.mapList(acompaniamientoDAO.findByEstablecimientoAndTipo(ESTABLECIMIENTO_DE_SALUD, TIPO_ACOMPANIAMIENTO_VISITA), AcompaniamientoDTO.class);
    }

    @Override
    public List<AcompaniamientoDTO> findAllEstablecimientosPenalesAndTipoAcompaniamiento() {
        return DozerHelper.mapList(acompaniamientoDAO.findByEstablecimientoAndTipo(ESTABLECIMIENTO_PENALES_COMISARIAS, TIPO_ACOMPANIAMIENTO), AcompaniamientoDTO.class);
    }

    @Override
    public List<AcompaniamientoDTO> findAllEstablecimientosPenalesAndTipoActividades() {
        return DozerHelper.mapList(acompaniamientoDAO.findByEstablecimientoAndTipo(ESTABLECIMIENTO_PENALES_COMISARIAS, TIPO_ACTIVIDADES), AcompaniamientoDTO.class);
    }

    @Override
    public List<AcompaniamientoDTO> findAllEstablecimientosDeSaludAndTipoGestion() {
        return DozerHelper.mapList(acompaniamientoDAO.findByEstablecimientoAndTipo(ESTABLECIMIENTO_DE_SALUD, TIPO_GESTION), AcompaniamientoDTO.class);
    }

    @Override
    public List<AcompaniamientoDTO> findAllEstablecimientoProfesionalDeSalud() {
        return DozerHelper.mapList(acompaniamientoDAO.findByEstablecimiento(ESTABLECIMIENTO_PROFESIONAL_DE_SALUD), AcompaniamientoDTO.class);
    }

    @Override
    public List<AcompaniamientoDTO> findAllEstablecimientoTrayectoriasEducativas() {
        return DozerHelper.mapList(acompaniamientoDAO.findByEstablecimiento(ESTABLECIMIENTO_TRAYECTORIAS_EDUCATIVAS), AcompaniamientoDTO.class);
    }
}
