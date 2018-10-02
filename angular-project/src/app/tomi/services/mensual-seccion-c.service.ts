import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {UrlConstants} from "./UrlConstants";
import {AppResponse} from "../../model/app-response";
import {MensualSeccionC1Data} from "../model/mensual-seccion-c1-data";
import {MensualSeccionC2Data} from "../model/mensual-seccion-c2-data";
import {MensualSeccionC3Data} from "../model/mensual-seccion-c3-data";
import {MensualSeccionC4Data} from "../model/mensual-seccion-c4-data";
import {MensualSeccionC5Data} from "../model/mensual-seccion-c5.data";
import {MensualSeccionC6Data} from "../model/mensual-seccion-c6-data";
import {HojaMensualActividades} from "../../model/hoja-mensual-actividades";

@Injectable()
export class MensualSeccionCService {

  constructor(private http: HttpClient) { }

  saveDataSeccionC1(data: MensualSeccionC1Data): Observable<AppResponse>{
    return this.http.post<AppResponse>(UrlConstants.SAVE_DATA_MENSUAL_SECCION_C1, data);
  }

  findDataSeccionC1ByHojaId(idHoja: number): Observable<MensualSeccionC1Data>{
    return this.http.post<MensualSeccionC1Data>(UrlConstants.GET_DATA_FOR_SECCION_C1_BY_HOJA_ID,idHoja);
  }

  saveDataSeccionC2(data: MensualSeccionC2Data): Observable<AppResponse>{
    return this.http.post<AppResponse>(UrlConstants.SAVE_DATA_MENSUAL_SECCION_C2, data);
  }

  findDataSeccionC2ByHojaId(idHoja: number): Observable<MensualSeccionC2Data>{
    return this.http.post<MensualSeccionC2Data>(UrlConstants.GET_DATA_FOR_SECCION_C2_BY_HOJA_ID,idHoja);
  }

  saveDataSeccionC3(data: MensualSeccionC3Data): Observable<AppResponse>{
    return this.http.post<AppResponse>(UrlConstants.SAVE_DATA_MENSUAL_SECCION_C3, data);
  }

  findDataSeccionC3ByHojaId(idHoja: number): Observable<MensualSeccionC3Data>{
    return this.http.post<MensualSeccionC3Data>(UrlConstants.GET_DATA_FOR_SECCION_C3_BY_HOJA_ID,idHoja);
  }

  saveDataSeccionC4(data: MensualSeccionC4Data): Observable<AppResponse>{
    return this.http.post<AppResponse>(UrlConstants.SAVE_DATA_MENSUAL_SECCION_C4, data);
  }

  findDataSeccionC4ByHojaId(idHoja: number): Observable<MensualSeccionC4Data>{
    return this.http.post<MensualSeccionC4Data>(UrlConstants.GET_DATA_FOR_SECCION_C4_BY_HOJA_ID,idHoja);
  }

  saveDataSeccionC5(data: MensualSeccionC5Data): Observable<AppResponse>{
    return this.http.post<AppResponse>(UrlConstants.SAVE_DATA_MENSUAL_SECCION_C5, data);
  }

  findDataSeccionC5ByHojaId(idHoja: number): Observable<MensualSeccionC5Data>{
    return this.http.post<MensualSeccionC5Data>(UrlConstants.GET_DATA_FOR_SECCION_C5_BY_HOJA_ID,idHoja);
  }

  saveDataSeccionC6(data: HojaMensualActividades[]): Observable<AppResponse>{
    return this.http.post<AppResponse>(UrlConstants.SAVE_DATA_MENSUAL_SECCION_C6, data);
  }

  findDataSeccionC6ByHojaId(idHoja: number): Observable<HojaMensualActividades[]>{
    return this.http.post<HojaMensualActividades[]>(UrlConstants.GET_DATA_FOR_SECCION_C6_BY_HOJA_ID,idHoja);
  }


}
