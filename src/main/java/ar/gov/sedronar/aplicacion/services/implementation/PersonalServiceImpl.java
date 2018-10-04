package ar.gov.sedronar.aplicacion.services.implementation;

import ar.gov.sedronar.aplicacion.dao.hibernate.HibernateDAO;
import ar.gov.sedronar.aplicacion.dao.interfaces.PersonalDAO;
import ar.gov.sedronar.aplicacion.dto.PersonalDTO;
import ar.gov.sedronar.aplicacion.filters.DocumentFilter;
import ar.gov.sedronar.aplicacion.model.Personal;
import ar.gov.sedronar.aplicacion.services.interfaces.PersonalService;
import ar.gov.sedronar.aplicacion.services.interfaces.UsuarioService;
import ar.gov.sedronar.modulo.commonsModels.dto.TipoDocumentoDTO;
import ar.gov.sedronar.util.dozer.DozerHelper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Date;

/**
 * Created by TMR on 03/10/2018.
 */
@Stateless
@DefaultServiceImpl
@Transactional
public class PersonalServiceImpl implements PersonalService {
    public static final String ESTADO_ACTUAL_ACTIVO = "activo";
    public static final String ESTADO_ACTUAL_INACTIVO = "inactivo";

    @Inject
    @HibernateDAO
    private PersonalDAO personalDAO;

    @Inject
    @UserServiceProvider
    private UsuarioService usuarioService;

    @Override
    public Integer saveOrUpdate(PersonalDTO dto) throws Exception {
        if (dto == null) throw new Exception("Error creando la consulta");
        Personal model;
        if(dto.getId() != null) model = personalDAO.findById(Personal.class, dto.getId());
        dto.setFum(new Date());
        dto.setUum(usuarioService.getCurrentUsername());
        model = DozerHelper.map(dto, Personal.class);
        return personalDAO.merge(model).getId();
    }

    @Override
    public PersonalDTO findByDocumento(TipoDocumentoDTO tipoDocumento, Integer numeroDocumento) {
        if(tipoDocumento == null || numeroDocumento == null) return null;
        Personal personal = personalDAO.findByDocumento(tipoDocumento.getIdTipoDoc(), numeroDocumento);
        return personal != null ? DozerHelper.map(personal, PersonalDTO.class) : null;
    }

    @Override
    public PersonalDTO findById(Integer idPersonal) {
        Personal personal = personalDAO.findById(Personal.class, idPersonal);
        return personal != null ? DozerHelper.map(personal, PersonalDTO.class) : null;    }

    @Override
    public PersonalDTO findByDocumento(DocumentFilter documentFilter) {
        return findByDocumento(documentFilter.getTipoDocumento(), documentFilter.getNumeroDocumento());
    }
}
