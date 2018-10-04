import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import Vencimiento from "../../model/vencimiento";
import {Observable} from "rxjs/Observable";
import {UrlConstantsCaac} from "../constants/url-constants";

@Injectable()
export class VencimientoService {

  constructor(private http: HttpClient) { }

  saveVencimiento(vencimiento: Vencimiento): Observable<any> {
    return this.http.post<any>(UrlConstantsCaac.SAVE_OR_UPDATE_VENCIMIENTO, vencimiento);
  }


}
