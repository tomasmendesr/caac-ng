import {HttpClient} from "@angular/common/http";
import {DocumentFilter} from "../filters/document-filter";
import {Observable} from "rxjs/Observable";
import {Personal} from "../../model/personal";
import {UrlConstants} from "./UrlConstants";
import {Injectable} from "@angular/core";

@Injectable()
export class PersonalService {
  constructor(private http: HttpClient){}

  findByDocumento(filter: DocumentFilter): Observable<Personal>{
    return this.http.post<Personal>(UrlConstants.FIND_PERSONAL_BY_DOCUMENTO, filter);
  }
}
