import {Hoja} from "./hoja";
import {Personal} from "./personal";
export class HojaMensualPersonal {
  constructor(){
    this.hoja = new Hoja;
    this.personal = new Personal;
  }
  hoja: Hoja;
  personal: Personal;
  nombre: string;
  horasSemanales: number;
  apellido: string;
  rol: string;
  titulo: string;
  esRentado: string;
  altaBaja: string;


}
