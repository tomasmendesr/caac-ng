import {Hoja} from "./hoja";
import {Alimentacion} from "./alimentacion";
export class HojaMensualAlimentacion {
  constructor(){
    this.hoja = new Hoja;
  }
  hoja: Hoja;
  tipoAlimentacion: Alimentacion;
  cantidadPersonas: number;
  cantidadPrestaciones: number;
}
