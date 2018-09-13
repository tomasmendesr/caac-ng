package ar.gov.sedronar.aplicacion.services.interfaces;

import ar.gov.sedronar.aplicacion.services.implementation.MockServiceImpl;
import ar.gov.sedronar.aplicacion.services.implementation.UserServiceProvider;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Created by TMR on 11/09/2018.
 */
@Stateless
@UserServiceProvider
public class UserServiceProviderImpl implements UsuarioService {

    @Inject
    @MockServiceImpl
    public UsuarioService servicio;

    @Override
    public String getCurrentUserId() {
        return servicio.getCurrentUserId();
    }

    @Override
    public String getCurrentUsername() {
        return servicio.getCurrentUsername();
    }
}
