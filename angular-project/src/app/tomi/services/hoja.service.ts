import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {UrlConstants} from "./UrlConstants";
import {AppResponse} from "../../model/app-response";
import {Hoja} from "../../model/hoja";
import {HeaderSigeseForms} from "../../model/header-sigese-forms";

@Injectable()
export class HojaService {

  constructor(private http: HttpClient) { }

  validateInputs(hoja: Hoja): Observable<AppResponse>{
    return this.http.post<AppResponse>(UrlConstants.VALIDATE_INPUTS_HOJA_MENSUAL_SECCION_A_MENSUAL, hoja);
  }

  saveOrUpdate(hoja: Hoja): Observable<any> {
    return this.http.post(UrlConstants.SAVE_OR_UPDATE_HOJA, hoja);
  }


  findByPeriodoAndCasa(headerSigeseForms: HeaderSigeseForms): Observable<any> {
    return this.http.post(UrlConstants.FIND_HOJA_BY_CASA_AND_PERIODO, headerSigeseForms);
  }
}
