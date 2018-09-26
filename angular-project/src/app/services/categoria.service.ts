import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Categoria} from "../model/categoria";
import {Observable} from "rxjs/Observable";
import {UrlConstantsCaac} from "../fede/constants/url-constants";

@Injectable()
export class CategoriaService {

  constructor(private http: HttpClient) { }

  findAllCategorias(): Observable<Categoria[]> {
    return this.http.post<Categoria[]>(UrlConstantsCaac.FIND_ALL_CATEGORIAS, {});
  }

}
