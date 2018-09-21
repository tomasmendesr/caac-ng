package ar.gov.sedronar.aplicacion.services.implementation;

import ar.gov.sedronar.aplicacion.dto.HojaMensualActividadDTO;
import ar.gov.sedronar.aplicacion.services.interfaces.HojaMensualActividadService;
import ar.gov.sedronar.util.app.AppResponse;

import javax.ejb.Stateless;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TMR on 21/09/2018.
 */
@Stateless
@Transactional
@DefaultServiceImpl
public class HojaMensualActividadServiceImpl implements HojaMensualActividadService {
    @Override
    public AppResponse validateInputsActividadesFamiliares(HojaMensualActividadDTO hojaMensualActividadDTO) {
        List<String> messages = new ArrayList<>();
        if(hojaMensualActividadDTO.getCantidadVisitasDomiciliarias() == null){
            messages.add("Debe ingresar la cantidad de visitas domiciliarias");
        } else if(hojaMensualActividadDTO.getCantidadVisitasDomiciliarias() < 0){
            messages.add("El valor de la cantidad de visitas domiciliarias debe ser mayor o igual a 0");
        }

        if(hojaMensualActividadDTO.getPersonasVisitasDomiciliarias() == null){
            messages.add("Debe ingesar la cantidad de personas que asistieron a las visitas domiciliarias");
        } else if(hojaMensualActividadDTO.getPersonasVisitasDomiciliarias() < 0){
            messages.add("El valor de la cantidad de personas en visitas domiciliarias debe ser mayor o igual a 0");
        }

        if(hojaMensualActividadDTO.getCantidadOrientaciones() == null){
            messages.add("Debe ingresar la cantidad de orientaciones familiares");
        } else if(hojaMensualActividadDTO.getCantidadOrientaciones() < 0){
            messages.add("El valor de la cantidad de orientaciones familiares debe ser mayor o igual a 0");
        }

        if(hojaMensualActividadDTO.getPersonasOrientaciones() == null){
            messages.add("Debe ingesar la cantidad de personas que asistieron a las orientaciones familiares");
        } else if(hojaMensualActividadDTO.getPersonasOrientaciones() < 0){
            messages.add("El valor de cantidad de personas en orientaciones familiares debe ser mayor o igual a 0");
        }

        if(hojaMensualActividadDTO.getCantidadGrupos() == null){
            messages.add("Debe ingresar la cantidad de grupos familiares");
        } else if(hojaMensualActividadDTO.getCantidadGrupos() < 0){
            messages.add("El valor de cantidad de grupos familiares debe ser mayor o igual a 0");
        }

        if(hojaMensualActividadDTO.getPersonasGrupos() == null){
            messages.add("Debe ingesar la cantidad de personas que asistieron a los grupos familiares");
        } else if(hojaMensualActividadDTO.getPersonasGrupos() < 0){
            messages.add("El valor de cantidad de personas en grupos familiares debe ser mayor o igual a 0");
        }

        if(hojaMensualActividadDTO.getCantidadEntrevistas() == null){
            messages.add("Debe ingresar la cantidad de entrevistas vinculares");
        } else if(hojaMensualActividadDTO.getCantidadEntrevistas() < 0){
            messages.add("El valor de la cantidad de entrevistas vinculares debe ser mayor o igual a 0");
        }

        if(hojaMensualActividadDTO.getPersonasEntrevistas() == null){
            messages.add("Debe ingesar la cantidad de personas que asistieron a las entrevistas vinculares");
        } else if(hojaMensualActividadDTO.getPersonasEntrevistas() < 0){
            messages.add("El valor de la cantidad de personas en entrevistas vinculares debe ser mayor o igual a 0");
        }
        return messages.isEmpty() ? new AppResponse() : new AppResponse(AppResponse.ERROR, messages);
    }

    @Override
    public AppResponse validateInputsIntervencionEnCalle(HojaMensualActividadDTO hojaMensualActividadDTO) {
        List<String> messages = new ArrayList<>();
        if(hojaMensualActividadDTO.getCantidadOrientacionesCalle() == null){
            messages.add("Debe ingresar la cantidad de personas alcanzadas en orientación en calle");
        } else if(hojaMensualActividadDTO.getPersonasEntrevistas() < 0){
            messages.add("El valor de la cantidad de personas en orientación en calle debe ser mayor o igual a 0");
        }

        if(hojaMensualActividadDTO.getCantidadAcompaniamientoCalle() == null){
            messages.add("Debe ingresar la cantidad de personas alcanzadas en acompañamiento en calle");
        } else if(hojaMensualActividadDTO.getPersonasEntrevistas() < 0){
            messages.add("El valor de la cantidad de personas en acompañamiento en calle debe ser mayor o igual a 0");
        }

        return messages.isEmpty() ? new AppResponse() : new AppResponse(AppResponse.ERROR, messages);

    }
}
