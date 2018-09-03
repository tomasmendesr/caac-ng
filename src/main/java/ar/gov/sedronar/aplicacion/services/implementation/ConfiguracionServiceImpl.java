package ar.gov.sedronar.aplicacion.services.implementation;

import ar.gov.sedronar.aplicacion.dto.ConfiguracionDTO;
import ar.gov.sedronar.aplicacion.services.interfaces.ConfiguracionService;
import ar.gov.sedronar.aplicacion.util.ConfigProperties;
import ar.gov.sedronar.configuracion.Configuracion;
import ar.gov.sedronar.configuracion.ConfiguracionException;
import ar.gov.sedronar.configuracion.ConfiguracionStandaloneXML;
import ar.gov.sedronar.servicio.KeyCloakService;
import org.keycloak.representations.idm.ClientRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;


import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.ws.rs.core.Context;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by TMR on 12/07/2018.
 */
@Stateless
@DefaultServiceImpl
@Transactional
public class ConfiguracionServiceImpl implements ConfiguracionService {

    private String serverAddres = "";
    private String realm = "";
    private String client = "";
    private String redirectURL = "";

    @Context
    private HttpServletRequest servletRequest;

    @Inject
    KeyCloakService keyCloakService;


    @Override
    public ConfiguracionDTO getParametrosIniciales() {
        Configuracion config = new ConfiguracionStandaloneXML();

        try {
            serverAddres = config.getBaseAuthServerUrl();
            realm = config.getRealm();
            client = config.getClient();
            redirectURL = getAppURL();
        } catch (ConfiguracionException e) {
            e.printStackTrace();
        }

        ClientRepresentation clientRepresentation = getClientRepresentationByClientName(this.client);

        ConfiguracionDTO configuracionDTO = new ConfiguracionDTO();
        configuracionDTO.setIsLoguedIn(userLoguedIn());

        if(configuracionDTO.getIsLoguedIn()) {
            // LOGOUT URL
            String urlLogout = serverAddres + "/realms/" + realm + "/protocol/openid-connect/logout?redirect_uri=" + redirectURL;
            // PROFILE URL
            String urlPerfil = buildUrlProfile();
            // USERNAME
            String username = getCurrentUsername();

            configuracionDTO.setUrlLogout(urlLogout);
            configuracionDTO.setUrlProfile(urlPerfil);
            configuracionDTO.setUsername(username);
            configuracionDTO.setUsersRoles(getRolesCurrentUserByClient(clientRepresentation));
            configuracionDTO.setRolesAvailables(getRolesAvailableByClient(clientRepresentation));
        }

        configuracionDTO.setVersion(ConfigProperties.getInstance().getVersion());

        return configuracionDTO;
    }

    private boolean userLoguedIn(){
        return getCurrentIdUser() != null;
    }

    protected String getAppURL(){
        int port = servletRequest.getServerPort();

        String host = servletRequest.getServerName();
        String path =  servletRequest.getContextPath();

        if(host.endsWith("/") && path.startsWith("/")){
            path = path.replace("/", "");
        }
        if(path.endsWith("/") ){
            path = path.substring(0, path.length()-1);
        }
        return servletRequest.getScheme() + "://" + host + (port == 80 || port == -1 ? "" : ":" + port) + path;
    }

    protected String buildUrlProfile(){
        return serverAddres+"/realms/"+realm+"/account?referrer="+client+"&referrer_uri="+redirectURL;
    }

    protected String getCurrentIdUser() {
        return servletRequest.getUserPrincipal() != null ? servletRequest.getUserPrincipal().getName() : null;
    }

    protected String getCurrentUsername() {
        return keyCloakService.getCurrentUsername(getCurrentIdUser());
    }

    protected List<String> getRolesCurrentUserByClient(ClientRepresentation client){
        List<RoleRepresentation> listaRolesRepresentation = keyCloakService.getRolesCurrentUserByClient(client, getCurrentIdUser());
        return listaRolesRepresentation.stream().map(rol -> rol.getName()).collect(Collectors.toList());
    }

    protected ClientRepresentation getClientRepresentationByClientName(String clientName){
        return keyCloakService.getClientRepresentationByClientName(clientName);
    }

    protected List<String> getRolesAvailableByClient(ClientRepresentation client){
        List<RoleRepresentation> listaRolesRepresentation = keyCloakService.getRolesAvailableByClient(client);
        return listaRolesRepresentation.stream().map(rol -> rol.getName()).collect(Collectors.toList());
    }

}
