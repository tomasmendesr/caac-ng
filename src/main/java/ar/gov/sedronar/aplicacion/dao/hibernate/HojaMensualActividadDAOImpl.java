package ar.gov.sedronar.aplicacion.dao.hibernate;

import ar.gov.sedronar.aplicacion.dao.interfaces.HojaMensualActividadDAO;
import ar.gov.sedronar.aplicacion.model.HojaMensualActividad;

import javax.ejb.Stateless;

/**
 * Created by TMR on 21/09/2018.
 */
@Stateless
@HibernateDAO
public class HojaMensualActividadDAOImpl extends AbstractDAOImpl<HojaMensualActividad> implements HojaMensualActividadDAO{
}
