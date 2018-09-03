package ar.gov.sedronar.util.app;

import javax.ejb.EJBAccessException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable ex) {
		AppResponse response = new AppResponse(500, ex.getMessage());
		if(ex.getClass() == EJBAccessException.class){
			response = new AppResponse(403, "No tiene permisos para realizar esta acción");
		}
		ex.printStackTrace();
		return Response.serverError().entity(response).type(MediaType.APPLICATION_JSON).build();
	}

}
