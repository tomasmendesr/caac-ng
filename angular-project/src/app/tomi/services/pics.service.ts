import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {UrlConstants} from "./UrlConstants";
import {Observable} from "rxjs/Observable";
import {TipoDocumento} from "../../model/tipo-documento";
import {ProvinciaLight} from "commons-model/model/geo/ProvinciaLight";
import {DepartamentoLight} from "commons-model/model/geo/DepartamentoLight";
import {LocalidadLight} from "commons-model/model/geo/LocalidadLight";
import {Municipio} from "commons-model/model/geo/Municipio";

@Injectable()
export class PicsService {

  constructor(private http: HttpClient) { }

  findAllProvinciasCombo(): Observable<ProvinciaLight[]>{
    return this.http.post<ProvinciaLight[]>(UrlConstants.FIND_PROVINCIAS_COMBO,{});
  }


  findAllLocalidades(): Observable<LocalidadLight[]> {
    return this.http.post<LocalidadLight[]>(UrlConstants.FIND_LOCALIDADES, {});
  }

  findAllDepartamentos(): Observable<DepartamentoLight[]> {
    return this.http.post<DepartamentoLight[]>(UrlConstants.FIND_DEPARTAMENTOS, {});
  }

  findAllDepartamentosByProvincia(provincia): Observable<DepartamentoLight[]> {
    return this.http.post<DepartamentoLight[]>(UrlConstants.FIND_DEPARTAMENTOS_BY_PROVINCIA, provincia);
  }

  findAllLocalidadesByDepartamento(departamento): Observable<LocalidadLight[]> {
    return this.http.post<LocalidadLight[]>(UrlConstants.FIND_LOCALIDADES_BY_DEPARTAMENTO, departamento);
  }

  findAllTiposDocumento(): Observable<TipoDocumento[]>{
    return this.http.post<TipoDocumento[]>(UrlConstants.FIND_ALL_TIPOS_DOCUMENTO,{});
  }

  findMunicipiosByDepartamentoId(idDepto: number):Observable<Municipio[]> {
    return this.http.post<Municipio[]>(UrlConstants.FIND_MUNICIPIOS_BY_DPTO_ID,{});
  }
}
