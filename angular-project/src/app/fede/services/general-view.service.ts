import { Injectable } from '@angular/core';
import CaacLight from "../model/caac-light";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";

@Injectable()
export class GeneralViewService {

  constructor(private http: HttpClient) { }

  saveOrUpdate(caacLight: CaacLight): Observable<any> {
    //todo ver si tomi hizo el metodo save or update o lo tengo que hacer yo
    return null;
    //return this.http.post(SAVE_OR_UPDATE_CAAC, caacLight);
  }

}
