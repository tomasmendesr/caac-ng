package ar.gov.sedronar.aplicacion.dao.hibernate;


import ar.gov.sedronar.aplicacion.dao.interfaces.CasaDAO;
import ar.gov.sedronar.aplicacion.model.Casa;

import javax.ejb.Stateless;

@Stateless
@HibernateDAO
public class CasaDAOImpl extends AbstractDAOImpl<Casa> implements CasaDAO {
	

}