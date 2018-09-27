import {HojaMensualAcompaniamiento} from "../../model/hoja-mensual-acompaniamiento";
import {HojaMensualObservaciones} from "../../model/hoja-mensual-observaciones";
import {HojaMensualRecurso} from "../../model/hoja-mensual-recurso";
export class MensualSeccionC5Data {
  constructor(){
    this.hojaMensualAcompaniamientoList = [];
    this.hojaMensualRecursoList = [];
  }
  hojaMensualObservaciones: HojaMensualObservaciones;
  hojaMensualAcompaniamientoList: HojaMensualAcompaniamiento[];
  hojaMensualRecursoList: HojaMensualRecurso[];
}
