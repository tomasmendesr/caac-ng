import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {AppResponse} from "../model/app-response";
import {UrlConstants} from "./UrlConstants";
import {Usuario} from "../model/usuario";

@Injectable()
export class UsuarioService {

  constructor(private http: HttpClient) { }

  validateInputs(item: Usuario): Observable<any | AppResponse>{
    return this.http.post<AppResponse>(UrlConstants.VALIDATE_USER_INPUTS, item);
  }

  saveOrUpdate(item: Usuario): Observable<any> {
    return this.http.post(UrlConstants.SAVE_USER, item);
  }

  delete(item: Usuario): Observable<any> {
    return this.http.post(UrlConstants.DELETE_USER, item);
  }

  isInUse(item: Usuario): Observable<any | AppResponse>{
    return this.http.post<AppResponse>(UrlConstants.USER_IN_USE, item);
  }
}
