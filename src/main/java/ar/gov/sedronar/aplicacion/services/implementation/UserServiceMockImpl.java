package ar.gov.sedronar.aplicacion.services.implementation;


import ar.gov.sedronar.aplicacion.services.interfaces.UsuarioService;
import ar.gov.sedronar.servicio.KeyCloakService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Transactional
@Stateless
@MockServiceImpl
public class UserServiceMockImpl  implements UsuarioService {
    private static final String TRIBEIRO_KEYLOAK_ID = "d4153ad8-de43-4102-a955-f92e7833f67d";

    @Override
    public String getCurrentUserId() {
        return TRIBEIRO_KEYLOAK_ID;
    }

    @Override
    public String getCurrentUsername() {
        return "mockUsername";
    }

}