import {Hoja} from "./hoja";
import {Tramite} from "./tramite";
export class HojaMensualTramites {
  constructor(){
    this.hoja = new Hoja;
  }
  hoja: Hoja;
  tramite: Tramite;
  cantidad: number;
}
