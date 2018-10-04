import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {EstructuralSeccionAData} from "../model/estructural-seccion-a-data";
import {Observable} from "rxjs/Observable";
import {AppResponse} from "../../model/app-response";
import {UrlConstants} from "./UrlConstants";

@Injectable()
export class EstructuralService {
  constructor(private http: HttpClient){}


  saveDataSeccioA(estructuralSeccionAData: EstructuralSeccionAData): Observable<AppResponse> {
    return this.http.post<AppResponse>(UrlConstants.SAVE_DATA_ESTRUCTURAL_SECCION_A,estructuralSeccionAData);
  }

  findDataSeccionAByHojaId(hojaId: number): Observable<EstructuralSeccionAData> {
    return this.http.post<EstructuralSeccionAData>(UrlConstants.GET_DATA_ESTRUCTURAL_SECCION_A_BY_HOJA_ID,hojaId);
  }
}
