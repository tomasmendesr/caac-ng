package ar.gov.sedronar.aplicacion.services.interfaces;


//@Path("/usuario")
//@Consumes(MediaType.APPLICATION_JSON)
//@Produces(MediaType.APPLICATION_JSON)
public interface UsuarioService {

	/**
	 *
	 * @return Retorna el id de Keycloak
	 */
	String getCurrentUserId();



}
