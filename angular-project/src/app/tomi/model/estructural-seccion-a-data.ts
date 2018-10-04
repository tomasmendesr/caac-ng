import {HojaAlternativasAsistenciales} from "../../model/hoja-alternativas-asistenciales";
import {HojaDatosIniciales} from "../../model/hoja-datos-iniciales";
import {Hoja} from "../../model/hoja";
export class EstructuralSeccionAData {
  constructor(){
    this.hojaAlternativasAsistencialesList = [];
  }
  hojaAlternativasAsistencialesList: HojaAlternativasAsistenciales[];
  hojaDatosIniciales: HojaDatosIniciales;
  hoja: Hoja;
}
