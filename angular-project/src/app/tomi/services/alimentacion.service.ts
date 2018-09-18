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
  private alimentacion: Alimentacion[];

  constructor(private http: HttpClient) { }

  findAll(): Observable<Alimentacion[]>{
    return this.http.post<Alimentacion[]>(UrlConstants.FIND_ALL_ALIMENTACION, {});
  }

  getAlimentaciones(): Alimentacion[] {
    if(this.alimentacion) return this.alimentacion;
    else {
      this.findAll().subscribe(data => {
        this.alimentacion = data;
        return this.alimentacion;
      })
    }
  }

  getAlimentacionById(id: number): Alimentacion {
    return this.getAlimentaciones().find(t => t.id == id);
  }
}
