import {Provincia} from "../../model/provincia";
import {Departamento} from "../../model/departamento";
import {Localidad} from "../../model/localidad";

export default class CaacLight {

  nomcaac;
  perjuridica;
  cuit;
  provincia: Provincia;
  dir;
  nomrepre;
  tel;
  mail;
  obser;
  localidad: Localidad;
  departamento: Departamento;

  constructor() {
    this.provincia = new Provincia();
    this.localidad = new Localidad();
    this.departamento = new Departamento();
  }

}
