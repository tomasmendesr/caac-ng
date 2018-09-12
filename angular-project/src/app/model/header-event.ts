import {HeaderSigeseForms} from "./header-sigese-forms";
export class HeaderEvent {
  evento: string;
  value: HeaderSigeseForms;

  constructor(ev: string, value: HeaderSigeseForms){
    this.evento = ev;
    this.value = value;
  }

  static readonly CASA = 'casa';
  static readonly ANIO_CARGA = 'anioCarga';
  static readonly MES_CARGA = 'mesCarga';
  static readonly ANIO_RECUPERACION_DATOS = 'anioRecuperacionDatos';
  static readonly MES_RECUPERACION_DATOS = 'mesRecuperacionDatos';

}
