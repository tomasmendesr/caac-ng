import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {Casa} from "../../model/casa";
import {UrlConstants} from "./UrlConstants";

@Injectable()
export class CasaService {

  constructor(private http: HttpClient) {
  }

  findAllLight(): Observable<Casa[]> {
    return this.http.post<Casa[]>(UrlConstants.FIND_ALL_CASAS_LIGTH, {});
  }

  findAll(): Observable<Casa[]> {
    return this.http.post<Casa[]>(UrlConstants.FIND_ALL_CASAS, {});
  }

}

