import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {UrlConstants} from "./UrlConstants";
import {Acompaniamiento} from "../../model/acompaniamiento";
import {HojaMensualAcompaniamiento} from "../../model/hoja-mensual-acompaniamiento";

@Injectable()
export class AcompaniamientoService {

  constructor(private http: HttpClient) { }

  findAll(): Observable<Acompaniamiento[]>{
    return this.http.post<Acompaniamiento[]>(UrlConstants.FIND_ALL_ACOMPANIAMIENTOS, {});
  }

  findAllEstablecimientosDeSaludAndTipoAcompaniamiento(): Observable<Acompaniamiento[]>{
    return this.http.post<Acompaniamiento[]>(UrlConstants.FIND_ALL_ESTABLECIMIENTOS_DE_SALUD_TIPO_ACOMPANIAMIENTO, {});
  }

  findAllEstablecimientosDeSaludAndTipoGestion(): Observable<Acompaniamiento[]>{
    return this.http.post<Acompaniamiento[]>(UrlConstants.FIND_ALL_ESTABLECIMIENTOS_DE_SALUD_TIPO_GESTION, {});
  }

  findAllEstablecimientosDeSalud(): Observable<Acompaniamiento[]>{
    return this.http.post<Acompaniamiento[]>(UrlConstants.FIND_ALL_ESTABLECIMIENTOS_DE_SALUD, {});
  }

  findAllEstablecimientosPatrocinioLegal(): Observable<Acompaniamiento[]>{
    return this.http.post<Acompaniamiento[]>(UrlConstants.FIND_ALL_ESTABLECIMIENTOS_PATROCINIO_LEGAL, {});
  }

  findAllEstablecimientosComunidadTerapeutica(): Observable<Acompaniamiento[]>{
    return this.http.post<Acompaniamiento[]>(UrlConstants.FIND_ALL_ESTABLECIMIENTOS_COMUNIDAD_TERAPEUTICA, {});
  }

  findAllEstablecimientoPenalesComisariasAndTipoAcompaniamiento(): Observable<Acompaniamiento[]>{
    return this.http.post<Acompaniamiento[]>(UrlConstants.FIND_ALL_ESTABLECIMIENTO_PENALES_COMISARIAS_TIPO_ACOMPANIAMIENTO, {});
  }

  findAllEstablecimientoPenalesComisariasAndTipoActividades(): Observable<Acompaniamiento[]>{
    return this.http.post<Acompaniamiento[]>(UrlConstants.FIND_ALL_ESTABLECIMIENTO_PENALES_COMISARIAS_TIPO_ACTIVIDADES, {});
  }

  findAllEstablecimientosProfesionalDeSalud(): Observable<Acompaniamiento[]>{
    return this.http.post<Acompaniamiento[]>(UrlConstants.FIND_ALL_ESTABLECIMIENTO_PROFESIONAL_DE_SALUD, {});
  }

  findAllEstablecimientosTrayectoriasEducativas(): Observable<Acompaniamiento[]>{
    return this.http.post<Acompaniamiento[]>(UrlConstants.FIND_ALL_ESTABLECIMIENTO_TRAYECTORIAS_EDUCATIVAS, {});
  }
}
