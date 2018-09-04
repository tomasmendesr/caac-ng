package ar.gov.sedronar.dao.hibernate;

import javax.ejb.Stateless;
import ar.gov.sedronar.dao.hibernate.AbstractDAOImpl;
import ar.gov.sedronar.dao.hibernate.HibernateDAO;
import ar.gov.sedronar.dao.interfaces.CategoriaDAO;
import ar.gov.sedronar.models.Categoria;

@Stateless
@HibernateDAO
public class CategoriaDAOImpl extends AbstractDAOImpl<Categoria> implements CategoriaDAO {
	
	
	public Categoria findById(String id){
		Categoria instance = entityManager.find(Categoria.class, id);
		return instance;
	}

}