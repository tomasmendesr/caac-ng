package ar.gov.sedronar.aplicacion.dao.hibernate;


import ar.gov.sedronar.aplicacion.dao.interfaces.CategoriaDAO;
import ar.gov.sedronar.aplicacion.model.Categoria;

import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
@HibernateDAO
public class CategoriaDAOImpl extends AbstractDAOImpl<Categoria> implements CategoriaDAO {




    @Override
    public Categoria findById(Integer id) { //horrible, robado del viejo caac
        String query = "SELECT * FROM [PICS].[caac].[categorias] WHERE valor = " + id.toString();
        Object[] result = (Object[]) entityManager.createNativeQuery(query).getSingleResult();

        Categoria categoria = new Categoria();
        categoria.setCat((String) result[0]);
        categoria.setValor((Integer) result[1]);

        return categoria;
    }
}