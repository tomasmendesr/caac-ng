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

  static readonly ID_ACOMPAÑAMIENTO_COMISARIAS = 13;
  static readonly ID_ACOMPAÑAMIENTO_PENALES = 14;
  static readonly ID_PENALES_COMISARIAS_TALLERES = 15;
  static readonly ID_PENALES_COMISARIAS_ACT_PROD = 16;
  static readonly ID_PENALES_COMISARIAS_CAPACITACION = 17;

  static readonly ID_TERAPIA_INDIVIDUAL = 18;
  static readonly ID_TERAPIA_FAMILIAR = 19;
  static readonly ID_REUNION_MULTIFAMILIAR = 20;
  static readonly ID_INFORME_SOCIAL = 21;
  static readonly ID_ORIENTACION_VOCACIONAL = 22;
  static readonly ID_EVALUACION = 23;
  static readonly ID_CONTROL_MEDICO = 24;
  static readonly ID_SEGUIMIENTO_FARMACOLOGICO = 25;
  static readonly ID_GRUPOS_TERAPEUTICOS = 26;

  static readonly ID_ACOMP_ESCUELA = 27;
  static readonly ID_ACTIVIDADES_PREVENCION = 27;
  static readonly ID_APOYO_ESCOLAR = 27;
  static readonly ID_INCLUSION = 27;
  static readonly ID_ESCUELA_EN_SEDE = 27;

  constructor(private http: HttpClient) { }

  findAll(): Observable<Acompaniamiento[]>{
    return this.http.post<Acompaniamiento[]>(UrlConstants.FIND_ALL_ACOMPANIAMIENTOS, {});
  }

  findAllEstablecimientosDeSalud(): Observable<Acompaniamiento[]>{
    return this.http.post<Acompaniamiento[]>(UrlConstants.FIND_ALL_ESTABLECIMIENTOS_DE_SALUD, {});
  }

  findAllEstablecimientoPenalesComisarias(): Observable<Acompaniamiento[]>{
    return this.http.post<Acompaniamiento[]>(UrlConstants.FIND_ALL_ESTABLECIMIENTO_PENALES_COMISARIAS, {});
  }

  getAcompaniamientoById(acompaniamientos: Acompaniamiento[], id: number): Acompaniamiento {
    return acompaniamientos.find(t => t.id == id);
  }
}
