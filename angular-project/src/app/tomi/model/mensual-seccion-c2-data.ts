import {HojaMensualAcompaniamiento} from "../../model/hoja-mensual-acompaniamiento";
import {HojaMensualActividad} from "../../model/hoja-mensual-actividad";
import {HojaMensualObservaciones} from "../../model/hoja-mensual-observaciones";
export class MensualSeccionC2Data {
  constructor(){
    this.hojaMensualAcompaniamientoList = [];
  }
 hojaMensualActividad: HojaMensualActividad;
 hojaMensualAcompaniamientoList: HojaMensualAcompaniamiento[];
 hojaMensualObservaciones: HojaMensualObservaciones;
}
