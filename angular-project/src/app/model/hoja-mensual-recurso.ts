import {Recurso} from "./recurso";
import {Hoja} from "./hoja";
export class HojaMensualRecurso {
  constructor(){
    this.hoja = new Hoja;
  }
  recurso: Recurso;
  hoja: Hoja;
  cantidadPersonas: number;
}
