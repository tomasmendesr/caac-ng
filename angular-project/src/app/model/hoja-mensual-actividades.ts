import {ActividadIntervencion} from "./actividad-intervencion";
import {Hoja} from "./hoja";
export class HojaMensualActividades {
  constructor(){
    this.hoja = new Hoja;
    this.isChecked = false;
  }
  hoja: Hoja;
  actividadIntervencion: ActividadIntervencion;
  descripcionActividad: string;
  isChecked: boolean;
}
