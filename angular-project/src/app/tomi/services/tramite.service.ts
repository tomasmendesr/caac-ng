import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {UrlConstants} from "./UrlConstants";
import {Tramite} from "../../model/tramite";

@Injectable()
export class TramiteService {
  static readonly ID_DNI = 1;
  static readonly ID_SUBSIDIOS = 2;
  static readonly ID_BECAS = 3;
  static readonly ID_CERTIFICADO_DISCAPACIDAD = 4;
  static readonly ID_INSERCION_LABORAL = 5;
  static readonly ID_SERVICIOS_PREVISIONALES = 6;
  static readonly ID_GESTIONES = 7;
  static readonly ID_OTROS = 8;

  private tramites: Tramite[];

  constructor(private http: HttpClient) { }

  findAll(): Observable<Tramite[]>{
    return this.http.post<Tramite[]>(UrlConstants.FIND_ALL_TRAMITES, {});
  }

  getTramites(): Tramite[] {
    if(this.tramites) return this.tramites;
    else {
      this.findAll().subscribe(data => {
        this.tramites = data;
        return this.tramites;
      })
    }
  }

  getTramiteById(id: number): Tramite {
    return this.getTramites().find(t => t.id == id);
  }
}
