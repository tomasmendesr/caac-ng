import {HojaMensualTramites} from "./hoja-mensual-tramites";
import {HojaMensualObservaciones} from "./hoja-mensual-observaciones";
import {HojaMensualAlimentacion} from "./hoja-mensual-alimentacion";
export class MensualSeccionC1Data {
  constructor(){
    this.hojaMensualTramitesList = [];
    this.hojaMensualAlimentacionList = [];
  }

  hojaMensualTramitesList: HojaMensualTramites[];
  hojaMensualAlimentacionList: HojaMensualAlimentacion[];
  hojaMensualObservaciones: HojaMensualObservaciones;
}
