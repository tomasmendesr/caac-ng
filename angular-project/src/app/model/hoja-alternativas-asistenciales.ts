import {Hoja} from "./hoja";
import {AlternativaAsistencial} from "./alternativa-asistencial";
export class HojaAlternativasAsistenciales{
  constructor(){
    this.hoja = new Hoja;
    this.isChecked = false;
  }
  hoja: Hoja;
  alternativaAsistencial: AlternativaAsistencial;
  descripcion: string;

  isChecked: boolean;
}
