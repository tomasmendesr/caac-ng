import ProvinciaLight from "./provincia-light";
import LocalidadLight from "./localidad-light";
import DepartamentoLight from "./departamento-light";

export default class CaacLight {

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

  constructor() {
    this.provincia = new ProvinciaLight();
    this.localidad = new LocalidadLight();
    this.departamento = new DepartamentoLight();
  }

}
