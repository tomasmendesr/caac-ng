import {Hoja} from "./hoja";
export class HojaMensualAsistidos {

  constructor(){
    this.hoja = new Hoja;
    this.asistidosOtroGenero = parseFloat('0');
    this.asistidosMujeres = 0;
    this.asistidosVarones = 0;
    this.asistidosCantidad = 0;
  }

  id: number;
  hoja: Hoja;
  asistidosVarones: number;
  asistidosMujeres: number;
  asistidosOtroGenero: number;
  asistidosCantidad: number;
}
