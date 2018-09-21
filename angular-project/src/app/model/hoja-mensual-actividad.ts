import {Hoja} from "./hoja";
export class HojaMensualActividad{
  constructor(){
    this.hoja = new Hoja;
  }
  id: number;
  hoja: Hoja;
  cantidadVisitasDomiciliarias: number;
  cantidadOrientaciones: number;
  cantidadGrupos: number;
  cantidadEntrevistas: number;
  personasVisitasDomiciliarias: number;
  personasOrientaciones: number;
  personasGrupos: number;
  personasEntrevistas: number;
  cantidadOrientacionesCalle: number;
  cantidadAcompaniamientoCalle: number;
}
