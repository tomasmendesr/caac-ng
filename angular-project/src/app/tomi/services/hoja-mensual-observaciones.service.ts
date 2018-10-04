import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {UrlConstants} from "./UrlConstants";
import {HojaMensualObservaciones} from "../../model/hoja-mensual-observaciones";
import {AppResponse} from "../../model/app-response";

@Injectable()
export class HojaMensualObservacionesService {

  constructor(private http: HttpClient) {
  }

  findByHojaId(hojaId: number): Observable<HojaMensualObservaciones> {
    return this.http.post<HojaMensualObservaciones>(UrlConstants.FIND_HOJA_MENSUAL_OBSERVACIONES_BY_HOJA_ID, hojaId);
  }

  saveOrUpdateSeccionD(hojaMensualObservaciones: HojaMensualObservaciones): Observable<AppResponse> {
    return this.http.post<AppResponse>(UrlConstants.SAVE_OR_UPDATE_MENSUAL_OBSERVACIONES_SECCION_D, hojaMensualObservaciones);
  }
}
