import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {Casa} from "../../model/casa";
import {UrlConstants} from "./UrlConstants";
import {UrlConstantsCaac} from "../../fede/constants/url-constants";

@Injectable()
export class CasaService {

  constructor(private http: HttpClient) {
  }

  findAllLight(): Observable<Casa[]> {
    return this.http.post<Casa[]>(UrlConstants.FIND_ALL_CASAS_LIGTH, {});
  }

  findAll(): Observable<Casa[]> {
    return this.http.post<Casa[]>(UrlConstantsCaac.FIND_ALL_CASAS_GENERAL, {});
  }

  findAllDTO(): Observable<Casa[]> {
    return this.http.post<Casa[]>(UrlConstants.FIND_ALL_CASAS_DTO, {});
  }

  saveOrUpdate(casa: Casa): Observable<any> {
    return this.http.post<any>(UrlConstants.SAVE_OR_UPDATE_CASA, casa)
  }

  saveOrUpdateCasaGeneral(casa: Casa): Observable<any> {
    return this.http.post<any>(UrlConstants.SAVE_OR_UPDATE_CASA_GENERAL, casa)
  }

}

