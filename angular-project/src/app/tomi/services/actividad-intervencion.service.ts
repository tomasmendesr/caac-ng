import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {UrlConstants} from "./UrlConstants";
import {ActividadIntervencion} from "../../model/actividad-intervencion";

@Injectable()
export class ActividadIntervencionService {
  static readonly OTRO = 'Otro';

  constructor(private http: HttpClient) { }

  findAllTipoActividad(): Observable<ActividadIntervencion[]>{
    return this.http.post<ActividadIntervencion[]>(UrlConstants.FIND_ALL_ACT_INT_TIPO_ACTIVIDAD, {});
  }

  findAllTipoFamilia(): Observable<ActividadIntervencion[]>{
    return this.http.post<ActividadIntervencion[]>(UrlConstants.FIND_ALL_ACT_INT_TIPO_FAMILIA, {});
  }

  findAllTipoIntervencion(): Observable<ActividadIntervencion[]>{
    return this.http.post<ActividadIntervencion[]>(UrlConstants.FIND_ALL_ACT_INT_TIPO_INTERVENCION, {});
  }

  actividadIntervencionOtro(actInt: ActividadIntervencion): boolean {
    return actInt.descripcionActividad == ActividadIntervencionService.OTRO;
  }


}
