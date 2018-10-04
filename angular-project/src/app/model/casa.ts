import {Categoria} from "./categoria";
import {ProvinciaLight} from "commons-model/model/geo/ProvinciaLight";
import {DepartamentoLight} from "commons-model/model/geo/DepartamentoLight";
import {LocalidadLight} from "commons-model/model/geo/LocalidadLight";
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
  provincia: ProvinciaLight;
  localidad: LocalidadLight;
  departamento: DepartamentoLight;
  activa: boolean;
}
