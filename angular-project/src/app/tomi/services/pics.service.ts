import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {UrlConstants} from "./UrlConstants";
import {Observable} from "rxjs/Observable";
import {Provincia} from "../../model/provincia";
import {Localidad} from "../../model/localidad";
import {Departamento} from "../../model/departamento";
import {TipoDocumento} from "../../model/tipo-documento";

@Injectable()
export class PicsService {

  constructor(private http: HttpClient) { }

  findAllProvinciasCombo(): Observable<Provincia[]>{
    return this.http.post<Provincia[]>(UrlConstants.FIND_PROVINCIAS_COMBO,{});
  }


  findAllLocalidades(): Observable<Localidad[]> {
    return this.http.post<Localidad[]>(UrlConstants.FIND_LOCALIDADES, {});
  }

  findAllDepartamentos(): Observable<Departamento[]> {
    return this.http.post<Departamento[]>(UrlConstants.FIND_DEPARTAMENTOS, {});
  }

  findAllDepartamentosByProvincia(provincia): Observable<Departamento[]> {
    return this.http.post<Departamento[]>(UrlConstants.FIND_DEPARTAMENTOS_BY_PROVINCIA, provincia);
  }

  findAllLocalidadesByDepartamento(departamento): Observable<Localidad[]> {
    return this.http.post<Localidad[]>(UrlConstants.FIND_LOCALIDADES_BY_DEPARTAMENTO, departamento);
  }

  findAllTiposDocumento(): Observable<TipoDocumento[]>{
    return this.http.post<TipoDocumento[]>(UrlConstants.FIND_ALL_TIPOS_DOCUMENTO,{});
  }

}
