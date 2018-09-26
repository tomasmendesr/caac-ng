import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {UrlConstants} from "./UrlConstants";
import {Recurso} from "../../model/recurso";

@Injectable()
export class RecursoService {

  constructor(private http: HttpClient) {
  }

  findAll(): Observable<Recurso[]> {
    return this.http.post<Recurso[]>(UrlConstants.FIND_ALL_RECURSOS, {});
  }

}
