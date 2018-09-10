import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Mes} from "../../model/mes";
import {Observable} from "rxjs/Observable";
import {UrlConstants} from "./UrlConstants";

@Injectable()
export class MesService {

  constructor(private http: HttpClient) { }

  findAll(): Observable<Mes[]>{
    return this.http.post<Mes[]>(UrlConstants.FIND_ALL_MESES, {});
  }


}
