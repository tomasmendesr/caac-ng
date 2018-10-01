import {HojaMensualAcompaniamiento} from "../../model/hoja-mensual-acompaniamiento";
import {HojaMensualObservaciones} from "../../model/hoja-mensual-observaciones";
import {HojaMensualRecurso} from "../../model/hoja-mensual-recurso";
export class MensualSeccionC5Data {
  constructor(){
    this.hojaMensualAcompaniamientoEstabTrayEducativaList = [];
    this.hojaMensualAcompaniamientoEstabProfSaludList = [];
    this.hojaMensualRecursoList = [];
  }
  hojaMensualObservaciones: HojaMensualObservaciones;
  hojaMensualAcompaniamientoEstabProfSaludList: HojaMensualAcompaniamiento[];
  hojaMensualAcompaniamientoEstabTrayEducativaList: HojaMensualAcompaniamiento[];
  hojaMensualRecursoList: HojaMensualRecurso[];
}
