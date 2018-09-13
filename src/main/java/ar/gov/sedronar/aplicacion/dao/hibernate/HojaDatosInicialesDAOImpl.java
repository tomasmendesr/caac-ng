package ar.gov.sedronar.aplicacion.dao.hibernate;

import ar.gov.sedronar.aplicacion.dao.interfaces.HojaDatosInicialesDAO;
import ar.gov.sedronar.aplicacion.model.HojaDatosIniciales;

import javax.ejb.Stateless;

/**
 * Created by TMR on 13/09/2018.
 */
@Stateless
@HibernateDAO
public class HojaDatosInicialesDAOImpl extends AbstractDAOImpl<HojaDatosIniciales> implements HojaDatosInicialesDAO {
}
