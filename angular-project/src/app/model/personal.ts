import {Profesion} from "./profesion";
import {TipoDocumento} from "./tipo-documento";
export class Personal {
  id: number;
  profesion: Profesion;
  nombre: string;
  apellido: string;
  horasSemanales: number;
  rol: string;
  titulo: string;
  esRentado: string;
  estadoActual: string;
  tipoDocumento: TipoDocumento;
  numeroDocumento: number;
}
