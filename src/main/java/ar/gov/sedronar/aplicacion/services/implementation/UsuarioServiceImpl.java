package ar.gov.sedronar.aplicacion.services.implementation;

import ar.gov.sedronar.aplicacion.services.interfaces.UsuarioService;
import ar.gov.sedronar.servicio.KeyCloakService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.ws.rs.core.Context;


@Transactional
@Stateless
@DefaultServiceImpl
public class UsuarioServiceImpl implements UsuarioService {

	@Inject
	KeyCloakService keyCloakService;

	@Context // TODO - esto va a venir desde otro servicio
	private HttpServletRequest httpRequest;

	@Override
	public String getCurrentUserId() {
		return null; // TODO - acceder a keycloak
	}

	@Override
	public String getCurrentUsername() {
		return null; // TODO
	}

}

