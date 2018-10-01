import {HojaMensualTramites} from "../../model/hoja-mensual-tramites";
import {HojaMensualObservaciones} from "../../model/hoja-mensual-observaciones";
import {HojaMensualAlimentacion} from "../../model/hoja-mensual-alimentacion";
export class MensualSeccionC1Data {
  constructor(){
    this.hojaMensualTramitesList = [];
    this.hojaMensualAlimentacionEnSedeList = [];
    this.hojaMensualAlimentacionFueraDeSedeList = [];
  }

  hojaMensualTramitesList: HojaMensualTramites[];
  hojaMensualAlimentacionFueraDeSedeList: HojaMensualAlimentacion[];
  hojaMensualAlimentacionEnSedeList: HojaMensualAlimentacion[];
  hojaMensualObservaciones: HojaMensualObservaciones;
}
