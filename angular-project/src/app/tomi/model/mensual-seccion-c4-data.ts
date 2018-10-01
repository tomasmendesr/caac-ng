import {HojaMensualObservaciones} from "../../model/hoja-mensual-observaciones";
import {HojaMensualAcompaniamiento} from "../../model/hoja-mensual-acompaniamiento";
export class MensualSeccionC4Data {
  constructor(){
    this.hojaMensualAcompEstPenalesTipoAcompList = [];
    this.hojaMensualAcompEstPenalesTipoActividadesList = [];
  }

  hojaMensualAcompEstPenalesTipoAcompList: HojaMensualAcompaniamiento[];
  hojaMensualAcompEstPenalesTipoActividadesList: HojaMensualAcompaniamiento[];
  hojaMensualObservaciones: HojaMensualObservaciones;
}
