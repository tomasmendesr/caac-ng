package ar.gov.sedronar.aplicacion.services.implementation;

import ar.gov.sedronar.aplicacion.dao.hibernate.HibernateDAO;
import ar.gov.sedronar.aplicacion.dao.interfaces.HojaDAO;
import ar.gov.sedronar.aplicacion.dto.HojaDTO;
import ar.gov.sedronar.aplicacion.filters.ConsultaTableFilter;
import ar.gov.sedronar.aplicacion.model.Hoja;
import ar.gov.sedronar.aplicacion.services.interfaces.HojaService;
import ar.gov.sedronar.aplicacion.services.interfaces.UserServiceProviderImpl;
import ar.gov.sedronar.aplicacion.services.interfaces.UsuarioService;
import ar.gov.sedronar.util.app.AppResponse;
import ar.gov.sedronar.util.dataTable.Column;
import ar.gov.sedronar.util.dataTable.ColumnOrder;
import ar.gov.sedronar.util.dataTable.DataTableObjectResponse;
import ar.gov.sedronar.util.dozer.DozerHelper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.*;

/**
 * Created by TMR on 10/09/2018.
 */
@Transactional
@Stateless
@DefaultServiceImpl
public class HojaServiceImpl implements HojaService {

    @Inject @HibernateDAO
    private HojaDAO hojaDAO;

    @Inject @UserServiceProvider
    private UsuarioService usuarioService;

    @Override
    public DataTableObjectResponse getHojasForTable(ConsultaTableFilter filtro) {
        Map<String, Boolean> sortOrder = new HashMap<>();
        for (ColumnOrder order : filtro.getOrder()) {
            Column column = filtro.getColumns().get(order.getColumn());
            sortOrder.put(column.getData(), order.getDir().equals("asc"));
        }
        Collection<HojaDTO> items = DozerHelper.mapList(hojaDAO.findAll(filtro.getStart(), filtro.getLength(), sortOrder,filtro.getFilter()), HojaDTO.class);
        Integer count = hojaDAO.count( filtro.getFilter());
        return new DataTableObjectResponse(items,filtro.getDraw(),count, count);
    }

    @Override
    public Long saveOrUpdate(HojaDTO hojaDTO) throws Exception {
        if (hojaDTO == null) throw new Exception("Error creando la consulta");
        hojaDTO.setFum(new Date());
        hojaDTO.setUum(usuarioService.getCurrentUsername());
        Hoja hoja = DozerHelper.map(hojaDTO, Hoja.class);
        hoja = hojaDAO.merge(hoja);
        return hoja.getId();
    }

    @Override
    public AppResponse validateInputsDatosInicialesMensual(HojaDTO hojaDTO) {
        List<String> messages = new ArrayList<>();
        if(hojaDTO.getAnio() == null)
            messages.add("Debe seleccionar un año");
        if(hojaDTO.getMes() == null)
            messages.add("Debe seleccionar un mes");
        if(hojaDTO.getCasa() == null){
            messages.add("Debe seleccionar una CAAC");
        }
        if(hojaDTO.getTipoHoja() == null){
            messages.add("Debe indicar el tipo de hoja");
        }
        return messages.isEmpty() ? new AppResponse() : new AppResponse(AppResponse.ERROR, messages);
    }

    @Override
    public HojaDTO findById(Long idHoja) {
        return DozerHelper.map(hojaDAO.findById(Hoja.class, idHoja), HojaDTO.class);
    }
}
