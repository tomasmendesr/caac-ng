import {Component, OnInit, ViewChild} from '@angular/core';
import {HeaderEvent} from "../../../../model/header-event";
import {LoadingComponent} from "../../../../share-components/loading/loading.component";

@Component({
  selector: 'app-mensual-seccion-c6',
  templateUrl: './mensual-seccion-c6.component.html',
  styleUrls: ['./mensual-seccion-c6.component.css']
})
export class MensualSeccionC6Component implements OnInit {
  private readonlyControl: boolean = true;
  private formMessages: string[] = [];
  private errorSection: number = -1;
  private hojaId: number;
  @ViewChild(LoadingComponent) loadingComponent:LoadingComponent;

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
