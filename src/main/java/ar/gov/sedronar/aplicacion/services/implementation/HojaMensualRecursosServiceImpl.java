package ar.gov.sedronar.aplicacion.services.implementation;

import ar.gov.sedronar.aplicacion.dto.HojaMensualRecursosDTO;
import ar.gov.sedronar.aplicacion.services.interfaces.HojaMensualRecursosService;
import ar.gov.sedronar.util.app.AppResponse;

import javax.ejb.Stateless;
import javax.transaction.Transactional;
import java.util.ArrayList;
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
}
