export class ConsultaFilter {
  nombreCasa: string;
  anioInicio: number;
  mesInicioId: number;
  anioFin: number;
  mesFinId: number;
  tipoInformacionEstructural: boolean ;
  tipoInformacionMensual: boolean ;

  constructor(){
    this.tipoInformacionEstructural = false;
    this.tipoInformacionMensual = false;
  }
}
