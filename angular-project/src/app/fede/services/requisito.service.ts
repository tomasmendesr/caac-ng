import { Injectable } from '@angular/core';
import Requisito from "../../model/requisito";
import {Observable} from "rxjs/Observable";
import {HttpClient} from "@angular/common/http";
import {UrlConstantsCaac} from "../constants/url-constants";

@Injectable()
export class RequisitoService {

  constructor(private http: HttpClient) { }

  saveOrUpdateRequisito(requisito: Requisito): Observable<boolean> {
    return this.http.post<boolean>(UrlConstantsCaac.SAVE_OR_UPDATE_REQUISITO, requisito);
  }
}
