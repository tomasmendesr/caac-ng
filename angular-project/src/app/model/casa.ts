import {Categoria} from "./categoria";
import {Departamento} from "./departamento";
import {Localidad} from "./localidad";
import {Provincia} from "./provincia";
export class Casa {
  id: number;
  nomcaac: string;
  perjuridica: string;
  cuit: string;
  dir: string;
  nomrepre: string;
  tel: string;
  mail: string;
  obser: string;
  obseradm: string;
  modal: string;
  cat: Categoria;
  fechaini: Date;
  fechacon: Date;
  expsed: string;
  req: string;
  provincia: Provincia;
  localidad: Localidad;
  departamento: Departamento;
  activa: boolean;
}
