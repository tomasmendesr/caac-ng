import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {UrlConstants} from "./UrlConstants";
import {Observable} from "rxjs/Observable";
import {Provincia} from "../../model/provincia";

@Injectable()
export class PicsService {

  constructor(private http: HttpClient) { }


  findAllProvinciasCombo(): Observable<Provincia[]>{
    return this.http.post<Provincia[]>(UrlConstants.FIND_PROVINCIAS_COMBO,{});
  }




}
