package ar.gov.sedronar.security.filters;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class CORSFilter implements ContainerResponseFilter  {

	@Override
	public void filter(ContainerRequestContext creq, ContainerResponseContext cresp) throws IOException {
        cresp.getHeaders().putSingle("Access-Control-Allow-Origin", "*");
        cresp.getHeaders().putSingle("Access-Control-Allow-Credentials", "true");
        cresp.getHeaders().putSingle("Access-Control-Allow-Methods", "GET, POST, OPTIONS, DELETE, PUT, HEAD");
        cresp.getHeaders().putSingle("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, Authorization");
	
        if (creq.getMethod().equals("OPTIONS"))
        	cresp.setStatus(200);
	}



}
