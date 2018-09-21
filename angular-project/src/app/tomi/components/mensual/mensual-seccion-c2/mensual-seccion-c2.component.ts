import {Component, OnInit, ViewChild} from '@angular/core';
import {LoadingComponent} from "../../../../share-components/loading/loading.component";
import {NotifUtil} from "../../../utils/notif-util";
import {HeaderEvent} from "../../../../model/header-event";
import {AppResponse} from "../../../../model/app-response";
import {UrlConstants} from "../../../services/UrlConstants";
import {Router} from "@angular/router";
import {MensualSeccionC2Data} from "../../../model/mensual-seccion-c2-data";
import {HojaMensualActividad} from "../../../../model/hoja-mensual-actividad";
import {HojaMensualAcompaniamiento} from "../../../../model/hoja-mensual-acompaniamiento";
import {HojaMensualObservaciones} from "../../../../model/hoja-mensual-observaciones";
declare var $:any;
@Component({
  selector: 'app-mensual-seccion-c2',
  templateUrl: './mensual-seccion-c2.component.html',
  styleUrls: ['./mensual-seccion-c2.component.css']
})
export class MensualSeccionC2Component implements OnInit {
  private readonlyControl: boolean = true;
  private formMessages: string[] = [];
  private errorSection: number = -1;
  private hojaId: number;
  @ViewChild(LoadingComponent) loadingComponent:LoadingComponent;

  private mensualSeccionC2Data: MensualSeccionC2Data = new MensualSeccionC2Data;
  private hojaMensualActividad: HojaMensualActividad = new HojaMensualActividad;
  private hojaMensualObservaciones: HojaMensualObservaciones = new HojaMensualObservaciones;

  private hojaMensualAcompaniamientoInternacion: HojaMensualAcompaniamiento = new HojaMensualAcompaniamiento;
  private hojaMensualAcompaniamientoConsultorios: HojaMensualAcompaniamiento = new HojaMensualAcompaniamiento;
  private hojaMensualAcompaniamientoEmergencias: HojaMensualAcompaniamiento = new HojaMensualAcompaniamiento;
  private hojaMensualAcompaniamientoDesintoxicacion: HojaMensualAcompaniamiento = new HojaMensualAcompaniamiento;


  constructor(private router: Router) { }

  ngOnInit() {
  }

  private onChangeHeader(headerEvent: HeaderEvent) {
    if (headerEvent.evento == HeaderEvent.HOJA_ID) {
      this.readonlyControl = headerEvent.value.hojaId == null;
      this.hojaId = headerEvent.value.hojaId;
      if (headerEvent.value.hojaId) {
        // this.mensualSeccionCService.findDataByHojaId(headerEvent.value.hojaId).subscribe(data => this.parseSeccionC1Data(data));
      } else {
        // this.initEmptyData();
      }
    }
  }

  private onClickGuardar() {/*
    this.cleanData();
    this.bindDataToDTO();
    this.loadingComponent.showLoading();
    this.mensualSeccionCService.saveDataSeccionC1(this.mensualSeccionC1Data).subscribe(appResponse => {
      if(appResponse.code == AppResponse.SUCCESS){
        NotifUtil.notifSuccess("Guardado exitosamente");
        this.loadingComponent.hideLoading();
        this.cleanData();
      }else{
        this.showErrorMsgs(appResponse.data);
      }
    }, (error) => this.notifError(error));
  */}

  private showConfirmDialog(id: string){
    $("#"+id).modal({
      backdrop: 'static',
      keyboard: false,
      show: true
    });
  }

  private hideConfirmDialog(id: string){
    $("#"+id).modal('hide');
  }

  private siguiente(){
    this.router.navigateByUrl(UrlConstants.MENSUAL_SECCION_C3);
  }

  private onClickConfirmDialogSiguiente(){
    //this.loadingComponent.showLoading();
    /*this.mensualSeccionCService.saveDataSeccionC1(this.mensualSeccionC1Data).subscribe(appResponse => {
      if(appResponse.code == AppResponse.SUCCESS){
        this.loadingComponent.hideLoading();
        this.siguiente();
      }else{
        this.showErrorMsgs(appResponse.data);
      }
    }, (error) => this.notifError(error));*/
  }

  private notifError(error){
    NotifUtil.notifError(error.error.message);
    this.loadingComponent.hideLoading();
  }

  private showErrorMsgs(appResponse: AppResponse){
    this.loadingComponent.hideLoading();
    NotifUtil.notifError("Ocurrieron errores de validación. Verifique los formularios");
    this.errorSection = appResponse.code;
    let formAlertId = "#formAlert" + this.errorSection;
    this.formMessages = appResponse.data;
    $(formAlertId).show();
  }

  private hideFormAlert() {
    let formAlertId = "#formAlert" + this.errorSection;
    $(formAlertId).hide();
    this.errorSection = -1;
  }

}
