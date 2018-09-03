package ar.gov.sedronar.security.services;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by TMR on 05/04/2018.
 */
@Path("/security")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@PermitAll
public class SecurityService {

    @GET
    @Path("/getPermisos")
    public List<String> getPermisos(@Context SecurityContext securityContext) {
        List<String> allRoles = Arrays.asList("USUARIO","ADMIN"); // TODO esta hardcodeado

        List<String> userPermissions = allRoles.stream()
                .filter(roleName -> securityContext.isUserInRole(roleName))
                .collect(Collectors.toList());

        return userPermissions;
    }

}
