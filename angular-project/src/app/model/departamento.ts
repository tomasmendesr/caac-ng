import {Provincia} from "./provincia";

export class Departamento {
  id: number;
  provinciaId: number;
  nombre: string;
  provincia: Provincia;
}
