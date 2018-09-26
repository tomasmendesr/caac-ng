import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {UrlConstants} from "./UrlConstants";
import {Recurso} from "../../model/recurso";

@Injectable()
export class RecursoService {
  static readonly ID_MEDICAMENTO = 1;
  static readonly ID_ANTICONCEPTIVO = 2;
  static readonly ID_UTILES_ESCOLARES = 3;
  static readonly ID_GASTOS_TRANSPORTE = 4;
  static readonly ID_ROPA = 5;
  static readonly ID_MATERIAL = 6;
  static readonly ID_HIGIENE = 7;

  constructor(private http: HttpClient) {
  }

  findAll(): Observable<Recurso[]> {
    return this.http.post<Recurso[]>(UrlConstants.FIND_ALL_RECURSOS, {});
  }

  getRecursoById(recursos: Recurso[], id: number): Recurso {
    return recursos.find(t => t.id == id);
  }
}
