import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {UrlConstants} from "./UrlConstants";
import {AppResponse} from "../../model/app-response";
import {MensualSeccionC1Data} from "../../model/mensual-seccion-c1-data";

@Injectable()
export class MensualSeccionCService {

  constructor(private http: HttpClient) { }

  saveDataSeccionC1(data: MensualSeccionC1Data): Observable<AppResponse>{
    return this.http.post<AppResponse>(UrlConstants.SAVE_DATA_MENSUAL_SECCION_C1, data);
  }

  findDataByHojaId(idHoja: number): Observable<MensualSeccionC1Data>{
    return this.http.post<MensualSeccionC1Data>(UrlConstants.GET_DATA_FOR_SECCION_C1_BY_HOJA_ID,idHoja);
  }


}
