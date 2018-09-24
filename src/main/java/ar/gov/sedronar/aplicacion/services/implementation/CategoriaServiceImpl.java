package ar.gov.sedronar.aplicacion.services.implementation;

import ar.gov.sedronar.aplicacion.dao.hibernate.HibernateDAO;
import ar.gov.sedronar.aplicacion.dao.interfaces.CategoriaDAO;
import ar.gov.sedronar.aplicacion.model.Categoria;
import ar.gov.sedronar.aplicacion.services.interfaces.CategoriaService;
import org.apache.log4j.lf5.viewer.categoryexplorer.CategoryNodeRenderer;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Transactional
@Stateless
@DefaultServiceImpl
public class CategoriaServiceImpl implements CategoriaService {

    @Inject
    @HibernateDAO
    private CategoriaDAO categoriaDAO;

    @Override
    public Categoria findByDescripcion(String descripcion) {
        Integer id = null;

        if(descripcion == "A")
            id = 1;
        else
            id = -1;


        return categoriaDAO.findById(Categoria.class, id);
    }
}
