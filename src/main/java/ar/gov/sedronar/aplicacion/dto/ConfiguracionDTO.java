package ar.gov.sedronar.aplicacion.dto;

import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.RolesRepresentation;

import java.util.List;

/**
 * Created by TMR on 12/07/2018.
 */
public class ConfiguracionDTO {
    private String urlLogout;
    private String urlProfile;
    private String urlPics;
    private String username;
    private String version;
    private List<String> usersRoles;
    private List<String> rolesAvailables;
    private String tokenLectura;
    private Boolean isLoguedIn;

    public String getUrlLogout() {
        return urlLogout;
    }

    public void setUrlLogout(String urlLogout) {
        this.urlLogout = urlLogout;
    }

    public String getUrlProfile() {
        return urlProfile;
    }

    public void setUrlProfile(String urlProfile) {
        this.urlProfile = urlProfile;
    }

    public String getUrlPics() {
        return urlPics;
    }

    public void setUrlPics(String urlPics) {
        this.urlPics = urlPics;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<String> getUsersRoles() { return usersRoles; }

    public void setUsersRoles(List<String> usersRoles) { this.usersRoles = usersRoles; }

    public List<String> getRolesAvailables() { return rolesAvailables; }

    public void setRolesAvailables(List<String> rolesAvailables) { this.rolesAvailables = rolesAvailables; }


    public String getTokenLectura() { return tokenLectura; }

    public void setTokenLectura(String tokenLectura) { this.tokenLectura = tokenLectura; }

    public Boolean getIsLoguedIn(){
        return isLoguedIn;
    }

    public void setIsLoguedIn(Boolean isLoguedIn){
        this.isLoguedIn = isLoguedIn;
    }
}
