import {HojaMensualAcompaniamiento} from "../../model/hoja-mensual-acompaniamiento";
import {HojaMensualObservaciones} from "../../model/hoja-mensual-observaciones";
export class MensualSeccionC3Data {
  constructor(){
    this.hojaMensualAcompaniamientoTipoGestionList = [];
    this.hojaMensualAcompaniamientoEstablComuTerapeuticaList = [];
    this.hojaMensualAcompaniamientoEstablPatrocinioLegalList = [];
  }

  hojaMensualAcompaniamientoTipoGestionList: HojaMensualAcompaniamiento[];
  hojaMensualAcompaniamientoEstablComuTerapeuticaList: HojaMensualAcompaniamiento[];
  hojaMensualAcompaniamientoEstablPatrocinioLegalList: HojaMensualAcompaniamiento[];
  hojaMensualObservaciones: HojaMensualObservaciones;
}
