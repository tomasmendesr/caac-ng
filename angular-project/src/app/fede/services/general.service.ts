import { Injectable } from '@angular/core';
import {Observable} from "rxjs/Observable";
import {HttpClient} from "@angular/common/http";
import {Casa} from "../../model/casa";
import {UrlConstantsCaac} from "../constants/url-constants";
import {UrlConstants} from "../../tomi/services/UrlConstants";

@Injectable()
export class GeneralService {

  constructor(private httpClient: HttpClient) { }

  getData(): Observable<Casa[]> {
    return this.httpClient.post<Casa[]>(UrlConstants.FIND_ALL_CASAS, {});
  }

}
