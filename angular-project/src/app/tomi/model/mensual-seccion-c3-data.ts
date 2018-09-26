import {HojaMensualAcompaniamiento} from "../../model/hoja-mensual-acompaniamiento";
import {HojaMensualObservaciones} from "../../model/hoja-mensual-observaciones";
export class MensualSeccionC3Data {
  constructor(){
    this.hojaMensualAcompaniamientoList = [];
  }

  hojaMensualAcompaniamientoList: HojaMensualAcompaniamiento[];
  hojaMensualObservaciones: HojaMensualObservaciones;
}
