import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {HojaDatosIniciales} from "../../model/hoja-datos-iniciales";
import {AppResponse} from "../../model/app-response";
import {Observable} from "rxjs/Observable";
import {UrlConstants} from "./UrlConstants";
import {Hoja} from "../../model/hoja";

@Injectable()
export class HojaDatosInicialesService {

  constructor(private http: HttpClient) {
  }

  saveOrUpdateMensual(hoja: Hoja, hojaDatosIniciales: HojaDatosIniciales): Observable<AppResponse>{
    // ojo con el nombre de los key del objecto a enviar
    return this.http.post<AppResponse>(UrlConstants.SAVE_OR_UPDATE_DATOS_INICIALES_MENSUAL, {hojaDTO: hoja, hojaDatosInicialesDTO: hojaDatosIniciales});
  }


}

