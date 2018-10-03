import {HttpClient} from "@angular/common/http";
import {UrlConstants} from "./UrlConstants";
import {Observable} from "rxjs/Observable";
import {AppResponse} from "../../model/app-response";
import {HojaMensualPersonal} from "../../model/hoja-mensual-personal";
import {Injectable} from "@angular/core";

@Injectable()
export class HojaMensualPersonalService {
  constructor(private http: HttpClient){}

  saveOrUpdate(hojaMensualPersonal: HojaMensualPersonal): Observable<AppResponse> {
    return this.http.post<AppResponse>(UrlConstants.FIND_ALL_RECURSOS, hojaMensualPersonal);
  }
}
