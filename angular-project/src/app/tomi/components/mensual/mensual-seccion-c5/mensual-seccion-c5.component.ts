import {Component, OnInit, ViewChild} from '@angular/core';
import {HojaMensualAcompaniamiento} from "../../../../model/hoja-mensual-acompaniamiento";
import {HojaMensualObservaciones} from "../../../../model/hoja-mensual-observaciones";
import {LoadingComponent} from "../../../../share-components/loading/loading.component";
import {HojaMensualRecurso} from "../../../../model/hoja-mensual-recurso";
import {HeaderEvent} from "../../../../model/header-event";

@Component({
  selector: 'app-mensual-seccion-c5',
  templateUrl: './mensual-seccion-c5.component.html',
  styleUrls: ['./mensual-seccion-c5.component.css']
})
export class MensualSeccionC5Component implements OnInit {
  private readonlyControl: boolean = true;
  private formMessages: string[] = [];
  private errorSection: number = -1;
  private hojaId: number;
  @ViewChild(LoadingComponent) loadingComponent:LoadingComponent;

  private hojaMensualAcompaniamientoTerapiaIndividual: HojaMensualAcompaniamiento = new HojaMensualAcompaniamiento;
  private hojaMensualAcompaniamientoTerapiaGrupal: HojaMensualAcompaniamiento = new HojaMensualAcompaniamiento;
  private hojaMensualAcompaniamientoReunion: HojaMensualAcompaniamiento = new HojaMensualAcompaniamiento;
  private hojaMensualAcompaniamientoInforme: HojaMensualAcompaniamiento = new HojaMensualAcompaniamiento;
  private hojaMensualAcompaniamientoOrientacion: HojaMensualAcompaniamiento = new HojaMensualAcompaniamiento;
  private hojaMensualAcompaniamientoEvaluacion: HojaMensualAcompaniamiento = new HojaMensualAcompaniamiento;
  private hojaMensualAcompaniamientoSeguimiento: HojaMensualAcompaniamiento = new HojaMensualAcompaniamiento;
  private hojaMensualAcompaniamientoGrupos: HojaMensualAcompaniamiento = new HojaMensualAcompaniamiento;

  private hojaMensualObservaciones: HojaMensualObservaciones = new HojaMensualObservaciones;

  private hojaMensualRecursoMedicamentos: HojaMensualRecurso = new HojaMensualRecurso;
  private hojaMensualRecursoAnticonceptivo: HojaMensualRecurso = new HojaMensualRecurso;
  private hojaMensualRecursoUtilesEscolares: HojaMensualRecurso = new HojaMensualRecurso;
  constructor() { }

  ngOnInit() {
  }

  private onChangeHeader(headerEvent: HeaderEvent) {
    // if (headerEvent.evento == HeaderEvent.HOJA_ID) {
    //   this.readonlyControl = headerEvent.value.hojaId == null;
    //   this.hojaId = headerEvent.value.hojaId;
    //   if (headerEvent.value.hojaId) {
    //     this.loadingComponent.showLoading();
    //     this.mensualSeccionCService.findDataSeccionC2ByHojaId(headerEvent.value.hojaId).subscribe(data => this.parseSeccionC2Data(data));
    //   } else {
    //     this.initEmptyData();
    //   }
    // }
  }

}
