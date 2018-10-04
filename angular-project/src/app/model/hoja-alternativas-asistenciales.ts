import {Hoja} from "./hoja";
import {AlternativaAsistencial} from "./alternativa-asistencial";
export class HojaAlternativasAsistenciales{
  constructor(){
    this.hoja = new Hoja;
  }
  hoja: Hoja;
  alternativaAsistencial: AlternativaAsistencial;
  descripcion: string;
}
