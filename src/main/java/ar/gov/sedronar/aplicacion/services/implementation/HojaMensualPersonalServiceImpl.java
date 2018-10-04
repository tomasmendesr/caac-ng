package ar.gov.sedronar.aplicacion.services.implementation;

import ar.gov.sedronar.aplicacion.dao.hibernate.HibernateDAO;
import ar.gov.sedronar.aplicacion.dao.interfaces.HojaMensualPersonalDAO;
import ar.gov.sedronar.aplicacion.dao.interfaces.PersonalDAO;
import ar.gov.sedronar.aplicacion.dto.HojaDTO;
import ar.gov.sedronar.aplicacion.dto.HojaMensualPersonalDTO;
import ar.gov.sedronar.aplicacion.dto.PersonalDTO;
import ar.gov.sedronar.aplicacion.filters.AbstractTableFilter;
import ar.gov.sedronar.aplicacion.model.HojaMensualAlimentacionId;
import ar.gov.sedronar.aplicacion.model.HojaMensualPersonal;
import ar.gov.sedronar.aplicacion.model.HojaMensualPersonalId;
import ar.gov.sedronar.aplicacion.model.Personal;
import ar.gov.sedronar.aplicacion.services.interfaces.HojaMensualPersonalService;
import ar.gov.sedronar.aplicacion.services.interfaces.PersonalService;
import ar.gov.sedronar.aplicacion.services.interfaces.UsuarioService;
import ar.gov.sedronar.util.app.AppResponse;
import ar.gov.sedronar.util.dataTable.Column;
import ar.gov.sedronar.util.dataTable.ColumnOrder;
import ar.gov.sedronar.util.dataTable.DataTableObjectResponse;
import ar.gov.sedronar.util.dozer.DozerHelper;
import org.apache.poi.util.StringUtil;
import org.codehaus.plexus.util.StringUtils;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.*;

/**
 * Created by TMR on 02/10/2018.
 */
@Stateless
@DefaultServiceImpl
@Transactional
public class HojaMensualPersonalServiceImpl implements HojaMensualPersonalService{
    public static final String ALTA = "alta";
    public static final String BAJA = "baja";
    @Inject
    @HibernateDAO
    private HojaMensualPersonalDAO hojaMensualPersonalDAO;

    @Inject
    @UserServiceProvider
    private UsuarioService usuarioService;

    @Inject
    @DefaultServiceImpl
    private PersonalService personalService;

    @Override
    public DataTableObjectResponse getDataForTable(AbstractTableFilter filtro) {
        if(filtro.getFilter().getValue() == null) return new DataTableObjectResponse(new ArrayList<>(),filtro.getDraw(),0, 0);

        Map<String, Boolean> sortOrder = new HashMap<>();
        for (ColumnOrder order : filtro.getOrder()) {
            Column column = filtro.getColumns().get(order.getColumn());
            sortOrder.put(column.getData(), order.getDir().equals("asc"));
        }
        Collection<HojaMensualPersonalDTO> items = DozerHelper.mapList(hojaMensualPersonalDAO.findAll(filtro.getStart(), filtro.getLength(), sortOrder,filtro.getFilter()), HojaMensualPersonalDTO.class);
        Integer count = hojaMensualPersonalDAO.count( filtro.getFilter());
        return new DataTableObjectResponse(items,filtro.getDraw(),count, count);
    }

    @Override
    public AppResponse saveOrUpdateSeccionD(HojaMensualPersonalDTO dto) throws Exception {
        AppResponse validation = validateInputs(dto);
        if (validation.getCode() == AppResponse.ERROR) return validation;

        // update tabla personal
        if(dto.getPersonal().getId() == null) {
            PersonalDTO personal = personalService.findByDocumento(dto.getPersonal().getTipoDocumento(), dto.getPersonal().getNumeroDocumento());
            if (personal == null) personal = new PersonalDTO();
            personal.setNombre(dto.getNombre());
            personal.setApellido(dto.getApellido());
            personal.setEsRentado(dto.getEsRentado());
            personal.setNumeroDocumento(dto.getPersonal().getNumeroDocumento());
            personal.setTipoDocumento(dto.getPersonal().getTipoDocumento());
            personal.setRol(dto.getRol());
            personal.setTitulo(dto.getTitulo());
            personal.setEstadoActual(dto.getAltaBaja() == ALTA ? PersonalServiceImpl.ESTADO_ACTUAL_ACTIVO : PersonalServiceImpl.ESTADO_ACTUAL_INACTIVO);
            Integer idPersonal = personalService.saveOrUpdate(personal);
            personal = personalService.findById(idPersonal);
            dto.setPersonal(personal);
        }
        saveOrUpdate(dto);
        return new AppResponse();
    }

    @Override
    public void saveOrUpdate(HojaMensualPersonalDTO dto) throws Exception {
        if (dto == null) throw new Exception("Error creando la consulta");
        HojaMensualPersonal model;
        if(dto.getHoja().getId() != null && dto.getPersonal().getId() != null) model = hojaMensualPersonalDAO.findById(dto.getHoja().getId(), dto.getPersonal().getId());
        dto.setFum(new Date());
        dto.setUum(usuarioService.getCurrentUsername());
        model = DozerHelper.map(dto, HojaMensualPersonal.class);
        model.setId(new HojaMensualPersonalId(dto.getHoja().getId(), dto.getPersonal().getId()));
        hojaMensualPersonalDAO.merge(model);
    }

    private AppResponse validateInputs(HojaMensualPersonalDTO dto){
        List<String> messages = new ArrayList<>();
        if(dto.getNombre() == null || StringUtils.isBlank(dto.getNombre())){
            messages.add("Debe ingresar el nombre");
        }else if(dto.getNombre().length() > 100){
            messages.add("El nombre no puede tener más de 100 caracteres");
        }

        if(dto.getApellido() == null || StringUtils.isBlank(dto.getApellido())){
            messages.add("Debe ingresar el apellido");
        }else if(dto.getApellido().length() > 100){
            messages.add("El nombre no puede tener más de 100 caracteres");
        }

        if(dto.getPersonal().getTipoDocumento() == null){
            messages.add("Debe ingresar el tipo de documento");
        }

        if(dto.getPersonal().getNumeroDocumento() == null){
            messages.add("Debe ingresar el número de documento");
        }

        if(dto.getTitulo() == null || StringUtils.isBlank(dto.getTitulo())){
            messages.add("Debe ingresar el nombre");
        }else if(dto.getTitulo().length() > 100){
            messages.add("El título no puede tener más de 100 caracteres");
        }

        if(dto.getAltaBaja() == null || StringUtils.isBlank(dto.getAltaBaja())){
            messages.add("Debe indicar si es una alta o una baja");
        }else if(!dto.getAltaBaja().equals("alta") && !dto.getAltaBaja().equals("baja")){
            messages.add("Los valores posibles para Alta/Baja son 'alta' o 'baja'");
        }

        if(dto.getRol() == null || StringUtils.isBlank(dto.getRol())){
            messages.add("Debe ingresar el rol");
        }else if(dto.getRol().length() > 100){
            messages.add("El rol no puede tener más de 100 caracteres");
        }

        if(dto.getEsRentado() == null || StringUtils.isBlank(dto.getEsRentado())){
            messages.add("Debe indicar si es o no rentado");
        }else if(!dto.getEsRentado().equals("S") && !dto.getEsRentado().equals("N")){
            messages.add("Los valores posibles para 'Es Rentado' son 'S' o 'N'");
        }

        return messages.isEmpty() ? new AppResponse() : new AppResponse(AppResponse.ERROR, messages);
    }
}
