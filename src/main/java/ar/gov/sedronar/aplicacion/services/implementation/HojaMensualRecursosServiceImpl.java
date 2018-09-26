package ar.gov.sedronar.aplicacion.services.implementation;

import ar.gov.sedronar.aplicacion.dao.hibernate.HibernateDAO;
import ar.gov.sedronar.aplicacion.dao.interfaces.HojaMensualRecursosDAO;
import ar.gov.sedronar.aplicacion.dto.HojaMensualRecursosDTO;
import ar.gov.sedronar.aplicacion.model.HojaMensualAcompaniamiento;
import ar.gov.sedronar.aplicacion.model.HojaMensualAcompaniamientoId;
import ar.gov.sedronar.aplicacion.model.HojaMensualRecursos;
import ar.gov.sedronar.aplicacion.model.HojaMensualRecursosId;
import ar.gov.sedronar.aplicacion.services.interfaces.HojaMensualRecursosService;
import ar.gov.sedronar.aplicacion.services.interfaces.RecursoService;
import ar.gov.sedronar.aplicacion.services.interfaces.UsuarioService;
import ar.gov.sedronar.util.app.AppResponse;
import ar.gov.sedronar.util.dozer.DozerHelper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by TMR on 26/09/2018.
 */
@Stateless
@DefaultServiceImpl
@Transactional
public class HojaMensualRecursosServiceImpl implements HojaMensualRecursosService {

    public static final Integer ID_MEDICAMENTO = 1;
    public static final Integer ID_ANTICONCEPTIVO = 2;
    public static final Integer ID_UTILES_ESCOLARES = 3;
    public static final Integer ID_GASTOS_TRANSPORTE = 4;
    public static final Integer ID_ROPA = 5;
    public static final Integer ID_MATERIAL = 6;
    public static final Integer ID_HIGIENE = 7;

    @Inject
    @HibernateDAO
    private HojaMensualRecursosDAO hojaMensualRecursosDAO;

    @Inject
    @DefaultServiceImpl
    private RecursoService recursoService;

    @Inject
    @UserServiceProvider
    private UsuarioService usuarioService;

    @Override
    public AppResponse validateInputs(List<HojaMensualRecursosDTO> hojaMensualRecursoList) {
       List<String> messages = new ArrayList<>();
       hojaMensualRecursoList.forEach(r -> this.addErrorMsgToList(r, messages));
       return messages.isEmpty() ? new AppResponse() : new AppResponse(AppResponse.ERROR, messages);
    }

    private void addErrorMsgToList(HojaMensualRecursosDTO hojaMensualRecursosDTO, List<String> messages){
        if(hojaMensualRecursosDTO.getCantidadPersonas() == null){
            messages.add("Debe indicar la cantidad de personas para el recurso: " + hojaMensualRecursosDTO.getRecurso().getDetalle());
        }
    }

    @Override
    public void saveOrUpdate(HojaMensualRecursosDTO dto) throws Exception {
        if (dto == null) throw new Exception("Error creando la consulta");
        HojaMensualRecursos model;
        if(dto.getHoja() != null && dto.getRecurso() != null) model = hojaMensualRecursosDAO.findById(dto.getHoja().getId(), dto.getRecurso().getId());
        dto.setFum(new Date());
        dto.setUum(usuarioService.getCurrentUsername());
        model = DozerHelper.map(dto, HojaMensualRecursos.class);
        model.setId(new HojaMensualRecursosId(dto.getHoja().getId(), dto.getRecurso().getId()));
        hojaMensualRecursosDAO.merge(model);
    }

    @Override
    public List<HojaMensualRecursosDTO> findByHojaId(Long idHoja) {
        List<HojaMensualRecursosDTO> list = new ArrayList<>();
        recursoService.findAll().forEach(r -> findAndAddIfExists(idHoja, list, r.getId()));
        return list;
    }

    private void findAndAddIfExists(Long idHoja, List<HojaMensualRecursosDTO> list, Integer idRecurso) {
        HojaMensualRecursos hojaMensualRecursos = hojaMensualRecursosDAO.findById(idHoja, idRecurso);
        if(hojaMensualRecursos != null) list.add(DozerHelper.map(hojaMensualRecursos, HojaMensualRecursosDTO.class));
    }
}
