import {Hoja} from "./hoja";
export class HojaMensualObservaciones {
  constructor(){
    this.hoja = new Hoja;
  }

  id: number;
  hoja: Hoja;
  otrosTramites: string;
  alimentacionEnSede: string;
  alimentacionFueraDeSede: string;
  actividadesFamiliares: string;
  intervencionCalleObservacion: string;
  acompaniamientoVisitasEstablecimientoSalud: string;
  gestionesEstablecimientoSalud: string;
  acompaniamientoCentroEspecial: string;
  asesoramientoLegal: string;
  actividadesTalleresComisaria: string;
  actividadesProductivasComisaria: string;
  actividadesCapacitacionComisaria: string;
  acompaniamientoProfesionalSalud: string;
  acompaniamientoTrayectoriaEducativa: string;
  mejorasInfraestructura: string;
  requerimientosFormacion: string;
}
