import CaacLight from "../fede/model/caac-light";

export default class Pago {

  id: number;
  anio: number;
  asistidos: number;
  atendidos: number;
  fechPag: Date;
  fechResep: Date;
  mes: string;
  monto: number;
  numExp: string;
  numFac: string;
  observaciones: string;
  casa: CaacLight;

}
