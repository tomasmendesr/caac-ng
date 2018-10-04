import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {AlternativaAsistencial} from "../../model/alternativa-asistencial";
import {Observable} from "rxjs/Observable";
import {UrlConstants} from "./UrlConstants";
@Injectable()
export class AlternativaAsistencialService {
  constructor(private http: HttpClient){}

  findAll(): Observable<AlternativaAsistencial[]> {
    return this.http.post<AlternativaAsistencial[]>(UrlConstants.FIND_ALL_ALTERNATIVAS_ASSISTENCIALES,{});
  }
}
