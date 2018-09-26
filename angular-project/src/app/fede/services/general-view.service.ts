import { Injectable } from '@angular/core';
import CaacLight from "../model/caac-light";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";

@Injectable()
export class GeneralViewService {

  constructor(private http: HttpClient) { }

}
