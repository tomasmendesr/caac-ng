import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {UrlConstants} from "./UrlConstants";
import {Acompaniamiento} from "../../model/acompaniamiento";

@Injectable()
export class AcompaniamientoService {
  static readonly ID_ESTB_SALUD_INTERNACION = 1;
  static readonly ID_ESTB_SALUD_CONSULTORIOS = 2;
  static readonly ID_ESTB_SALUD_EMERGENCIAS = 3;
  static readonly ID_ESTB_SALUD_DESINTOXICACION = 4;

  static readonly ID_ESTB_SALUD_GESTION_DE_TURNOS = 5;
  static readonly ID_ESTB_SALUD_GESTION_DE_TRAMITES = 6;
  static readonly ID_ESTB_SALUD_GESTION_DE_SERVICIOS = 7;

  static readonly ID_ACOMP_CENTRO_ESPECIALIZADO = 8;

  static readonly ID_GESTION_SIN_SUBSIDIO = 9;
  static readonly ID_GESTION_CON_SUBSIDIO = 10;

  static readonly ID_GESTION_EN_SEDE= 11;
  static readonly ID_GESTION_FUERA_DE_SEDE = 12;

  constructor(private http: HttpClient) { }

  findAll(): Observable<Acompaniamiento[]>{
    return this.http.post<Acompaniamiento[]>(UrlConstants.FIND_ALL, {});
  }

  findAllEstablecimientosDeSalud(): Observable<Acompaniamiento[]>{
    return this.http.post<Acompaniamiento[]>(UrlConstants.FIND_ALL_ESTABLECIMIENTOS_DE_SALUD, {});
  }

  getAcompaniamientoById(acompaniamientos: Acompaniamiento[], id: number): Acompaniamiento {
    return acompaniamientos.find(t => t.id == id);
  }
}
