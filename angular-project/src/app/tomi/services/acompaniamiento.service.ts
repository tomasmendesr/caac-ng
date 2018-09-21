import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {UrlConstants} from "./UrlConstants";
import {Acompaniamiento} from "../../model/acompaniamiento";
import {Alimentacion} from "../../model/alimentacion";

@Injectable()
export class AcompaniamientoService {
  static readonly ID_ESTB_SALUD_INTERNACION = 1;
  static readonly ID_ESTB_SALUD_CONSULTORIOS = 2;
  static readonly ID_ESTB_SALUD_EMERGENCIAS = 3;
  static readonly ID_ESTB_SALUD_DESINTOXICACION = 4;

  constructor(private http: HttpClient) { }

  findAll(): Observable<Acompaniamiento[]>{
    return this.http.post<Acompaniamiento[]>(UrlConstants.FIND_ALL_ALIMENTACION, {});
  }

  getAlimentacionById(acompaniamientos: Acompaniamiento[], id: number): Acompaniamiento {
    return acompaniamientos.find(t => t.id == id);
  }
}
