package ar.gov.sedronar.aplicacion.dao.hibernate;


import ar.gov.sedronar.aplicacion.dao.interfaces.CategoriaDAO;
import ar.gov.sedronar.aplicacion.model.Categoria;

import javax.ejb.Stateless;

@Stateless
@HibernateDAO
public class CategoriaDAOImpl extends AbstractDAOImpl<Categoria> implements CategoriaDAO {
	

}