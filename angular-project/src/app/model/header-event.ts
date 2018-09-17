import {HeaderSigeseForms} from "./header-sigese-forms";
import {Hoja} from "./hoja";
export class HeaderEvent {
  evento: string;
  value: HeaderSigeseForms;
  hoja: Hoja;

  constructor(ev: string, value: HeaderSigeseForms){
    this.evento = ev;
    this.value = value;
  }

  static readonly CASA = 'casa';
  static readonly HOJA_ID = 'hojaId';
  static readonly ANIO_CARGA = 'anioCarga';
  static readonly MES_CARGA = 'mesCarga';
  static readonly ANIO_RECUPERACION_DATOS = 'anioRecuperacionDatos';
  static readonly MES_RECUPERACION_DATOS = 'mesRecuperacionDatos';

}
