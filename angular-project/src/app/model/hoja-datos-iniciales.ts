import {Hoja} from "./hoja";
import {LocalidadLight} from "commons-model/model/geo/LocalidadLight";
import {Municipio} from "commons-model/model/geo/Municipio";
import {ProvinciaLight} from "commons-model/model/geo/ProvinciaLight";
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
  localidadLight: LocalidadLight;
  municipio: Municipio;
  provinciaLight: ProvinciaLight;
  anexo: string;
  direccionHorarioAnexos: string;
  caracteristicasGenerales: string;
  telefonoCaac: string;
  mailCaac: string;
  uum: string;
  fum: Date;
}
