import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {UrlConstants} from "./UrlConstants";
import {Alimentacion} from "../../model/alimentacion";

@Injectable()
export class AlimentacionService {
  static readonly ID_DESAYUNO = 1;
  static readonly ID_ALMUERZO = 2;
  static readonly ID_MERIENDA = 3;
  static readonly ID_CENA = 4;
  static readonly ID_OTRO_EN_SEDE = 5;
  static readonly ID_VIANDAS = 6;
  static readonly ID_BOLSONES = 7;
  static readonly ID_OTRO_FUERA_DE_SEDE = 8;

  constructor(private http: HttpClient) { }

  findAll(): Observable<Alimentacion[]>{
    return this.http.post<Alimentacion[]>(UrlConstants.FIND_ALL_ALIMENTACION, {});
  }

  getAlimentacionById(alimentaciones: Alimentacion[], id: number): Alimentacion {
    return alimentaciones.find(t => t.id == id);
  }
}
