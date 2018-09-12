import {Mes} from "./mes";
import {Casa} from "./casa";
export class Hoja {

  constructor(){
    this.mes = new Mes;
    this.casa = new Casa;
  }

  id: number;
  anio: number;
  mes: Mes;
  casa: Casa;
  tipoHoja: string;
  fechaCierre: Date;
  uum: string;
  fum: Date;
}
