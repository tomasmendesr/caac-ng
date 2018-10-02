import {Hoja} from "./hoja";
import {Personal} from "./personal";
export class HojaPersonal {
  constructor(){
    this.hoja = new Hoja;
  }
  hoja: Hoja;
  empleado: Personal;
  nombre: string;
  horasSemanales: number;
  apellido: string;
  rol: string;
  titulo: string;
  esRentado: string;
}
