import {ProvinciaLight} from "commons-model/model/geo/ProvinciaLight";
import {DepartamentoLight} from "commons-model/model/geo/DepartamentoLight";
import {LocalidadLight} from "commons-model/model/geo/LocalidadLight";
export default class CaacLight {

  id;
  nomcaac;
  perjuridica;
  cuit;
  provincia: ProvinciaLight;
  dir;
  nomrepre;
  tel;
  mail;
  obser;
  localidad: LocalidadLight;
  departamento: DepartamentoLight;
  activa;
  expsed;
  req;
  modal;
  obseradm;
  cat;
  ncat;
  fechaini;
  fechacon;

  constructor() {
  }

}
