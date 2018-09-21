import {Acompaniamiento} from "./acompaniamiento";
import {Hoja} from "./hoja";

export class HojaMensualAcompaniamiento {
  constructor(){
    this.hoja = new Hoja;
  }
  hoja: Hoja;
  acompaniamiento: Acompaniamiento;
  cantidadGestiones: number;
  cantidadPersonas: number;
}
