import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {UrlConstants} from "./UrlConstants";
import {HojaMensualAsistidos} from "../../model/hoja-mensual-asistidos";
import {AppResponse} from "../../model/app-response";

@Injectable()
export class HojaMensualAsistidosService {

  constructor(private http: HttpClient) { }

  saveOrUpdate(hojaMensualAsistidos: HojaMensualAsistidos): Observable<AppResponse>{
    return this.http.post<AppResponse>(UrlConstants.SAVE_OR_UPDATE_HOJA_MENSUAL_ASISTIDOS, hojaMensualAsistidos);
  }


  findById(hojaId: number): Observable<HojaMensualAsistidos> {
    return this.http.post<HojaMensualAsistidos>(UrlConstants.FIND_HOJA_MENSUAL_ASISTIDOS_BY_ID, hojaId);
  }
}
