package ar.gov.sedronar.aplicacion.services.interfaces;

import ar.gov.sedronar.aplicacion.services.implementation.MockServiceImpl;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Created by TMR on 11/09/2018.
 */
@Stateless
public class UserServiceProvider implements UsuarioService {

    @Inject
    @MockServiceImpl
    public UsuarioService servicio;


    @Override
    public String getCurrentUserId() {
        return servicio.getCurrentUserId();
    }
}
