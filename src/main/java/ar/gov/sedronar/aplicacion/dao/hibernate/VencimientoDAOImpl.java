package ar.gov.sedronar.aplicacion.dao.hibernate;

import ar.gov.sedronar.aplicacion.dao.interfaces.VencimientoDAO;
import ar.gov.sedronar.aplicacion.model.Vencimiento;

import javax.ejb.Stateless;

@Stateless
@HibernateDAO
public class VencimientoDAOImpl extends AbstractDAOImpl<Vencimiento> implements VencimientoDAO {

}

