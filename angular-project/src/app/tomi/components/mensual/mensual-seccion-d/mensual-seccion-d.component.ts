import {Component, OnInit, ViewChild} from '@angular/core';
import {HeaderEvent} from "../../../../model/header-event";
import {LoadingComponent} from "../../../../share-components/loading/loading.component";
import {HojaMensualObservaciones} from "../../../../model/hoja-mensual-observaciones";

@Component({
  selector: 'app-mensual-seccion-d',
  templateUrl: './mensual-seccion-d.component.html',
  styleUrls: ['./mensual-seccion-d.component.css']
})
export class MensualSeccionDComponent implements OnInit {
  private readonlyControl: boolean = true;
  private formMessages: string[] = [];
  private errorSection: number = -1;
  private hojaId: number;
  @ViewChild(LoadingComponent) loadingComponent:LoadingComponent;

  private hojaMensualObservaciones: HojaMensualObservaciones = new HojaMensualObservaciones;

  constructor() { }

  ngOnInit() {
  }

  private onChangeHeader(headerEvent: HeaderEvent) {
    if (headerEvent.evento == HeaderEvent.HOJA_ID) {
      this.readonlyControl = headerEvent.value.hojaId == null;
      this.hojaId = headerEvent.value.hojaId;
      if (headerEvent.value.hojaId) {
        // this.loadingComponent.showLoading();
        // this.mensualSeccionCService.findDataSeccionC5ByHojaId(headerEvent.value.hojaId).subscribe(data => this.parseSeccionC5Data(data));
      } else {
        // this.initEmptyData();
      }
    }
  }

}
