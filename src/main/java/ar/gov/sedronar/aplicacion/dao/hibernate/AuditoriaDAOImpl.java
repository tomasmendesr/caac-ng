package ar.gov.sedronar.aplicacion.dao.hibernate;


import ar.gov.sedronar.aplicacion.dao.interfaces.AuditoriaDAO;
import ar.gov.sedronar.aplicacion.model.Auditoria;

import javax.ejb.Stateless;

@Stateless
@HibernateDAO
public class AuditoriaDAOImpl extends AbstractDAOImpl<Auditoria> implements AuditoriaDAO {

}