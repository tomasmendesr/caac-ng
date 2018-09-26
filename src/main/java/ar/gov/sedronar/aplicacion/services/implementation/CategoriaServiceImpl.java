package ar.gov.sedronar.aplicacion.services.implementation;

import ar.gov.sedronar.aplicacion.dao.hibernate.HibernateDAO;
import ar.gov.sedronar.aplicacion.dao.interfaces.CategoriaDAO;
import ar.gov.sedronar.aplicacion.dto.CategoriaDTO;
import ar.gov.sedronar.aplicacion.model.Categoria;
import ar.gov.sedronar.aplicacion.services.interfaces.CategoriaService;
import ar.gov.sedronar.util.dozer.DozerHelper;
import org.apache.log4j.lf5.viewer.categoryexplorer.CategoryNodeRenderer;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Stateless
@DefaultServiceImpl
public class CategoriaServiceImpl implements CategoriaService {

    @Inject
    @HibernateDAO
    private CategoriaDAO categoriaDAO;

    @Override
    public List<CategoriaDTO> findAllCategorias() {
        return DozerHelper.mapList(categoriaDAO.findAll(Categoria.class), CategoriaDTO.class);
    }
}
