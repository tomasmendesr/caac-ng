package ar.gov.sedronar.aplicacion.dao.hibernate;

import javax.ejb.Stateless;

import ar.gov.sedronar.aplicacion.dao.interfaces.VencimientoDAO;
import ar.gov.sedronar.aplicacion.model.Vencimiento;

@Stateless
@HibernateDAO
public class VencimientoDAOImpl extends AbstractDAOImpl<Vencimiento> implements VencimientoDAO {

}

