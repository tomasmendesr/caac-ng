import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import MainConstants from "../constants/main-constants";

@Injectable()
export class AppLoadService {

  constructor(private http: HttpClient) {}

  // This is the method you want to call at bootstrap
  // Important: It should return a Promise
  get_parametros_iniciales(): Promise<any> {
    localStorage.removeItem(MainConstants.LOCAL_STORAGE_HEADER_SIGESE_FORMS);
    // let self = this;
    // const promise = this.http.get(UrlConstants.GET_PARAMETROS_INICIALES)
    //   .toPromise()
    //   .then((configuracion: Configuracion) => {
    //     APP_SETTINGS.IS_LOGUED_IN = true;
    //     APP_SETTINGS.URL_PICS = environment.picsUrl;
    //     APP_SETTINGS.URL_LOGOUT = configuracion.urlLogout;
    //     APP_SETTINGS.URL_PROFILE = configuracion.urlProfile;
    //     APP_SETTINGS.USERNAME = configuracion.username;
    //     APP_SETTINGS.VERSION = configuracion.version;
    //     APP_SETTINGS.ROLES_AVAILABLES = configuracion.rolesAvailables;
    //     APP_SETTINGS.USER_ROLES = configuracion.usersRoles;
    //     return configuracion;
    //   })
    //   .catch((err: any) => {
    //     APP_SETTINGS.IS_LOGUED_IN = false;
    //     Promise.resolve();
    //   });
    //
    // return promise;

    return Promise.resolve();
  }
}
