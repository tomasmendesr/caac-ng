import {Hoja} from "./hoja";
import {Localidad} from "./localidad";
import {Municipio} from "./municipio";
import {Provincia} from "./provincia";
export class HojaDatosIniciales{
  id: number;
  hoja: Hoja;
  nombreCaac: string;
  organismoResponsable: string;
  personaResponsable: string;
  telefonoResponsable: string;
  mailResponsable: string;
  otrosReferentes: string;
  direccion: string;
  interseccion1: string;
  interseccion2: string;
  barrio: string;
  localidadLight: Localidad;
  municipio: Municipio;
  provinciaLight: Provincia;
  anexo: string;
  direccionHorarioAnexos: string;
  caracteristicasGenerales: string;
  telefonoCaac: string;
  mailCaac: string;
  uum: string;
  fum: Date;
}
