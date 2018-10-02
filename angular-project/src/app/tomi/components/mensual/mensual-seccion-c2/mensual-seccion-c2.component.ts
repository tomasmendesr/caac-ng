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
import {AcompaniamientoService} from "../../../services/acompaniamiento.service";
import {MensualSeccionCService} from "../../../services/mensual-seccion-c.service";
import {Acompaniamiento} from "../../../../model/acompaniamiento";

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
  private acompaniamientos: Acompaniamiento[] = [];
  private hojaMensualActividad: HojaMensualActividad = new HojaMensualActividad;
  private hojaMensualObservaciones: HojaMensualObservaciones = new HojaMensualObservaciones;
  private hojaMensualAcompaniamientoList: HojaMensualAcompaniamiento[] = [];


  constructor(private router: Router, private acompaniamientoService: AcompaniamientoService, private mensualSeccionCService: MensualSeccionCService) { }

  ngOnInit() {
    this.acompaniamientoService.findAllEstablecimientosDeSaludAndTipoAcompaniamiento().subscribe(data => {
      this.acompaniamientos = data;
      this.initHojaMensualAcompaniamientoList();
    });
  }

  private initHojaMensualAcompaniamientoList(){
    this.hojaMensualAcompaniamientoList = [];
    this.completeHojaMensualAcompaniamientoList();
  }

  private completeHojaMensualAcompaniamientoList(){
    this.acompaniamientos.forEach(ac => {
      if(this.hojaMensualAcompaniamientoList.find(h => h.acompaniamiento.id == ac.id) == null) {
        let hojaMensual = new HojaMensualAcompaniamiento();
        hojaMensual.acompaniamiento = ac;
        this.hojaMensualAcompaniamientoList.push(hojaMensual);
      }
    });
  }

  private onChangeHeader(headerEvent: HeaderEvent) {
    if (headerEvent.evento == HeaderEvent.HOJA_ID) {
      this.readonlyControl = headerEvent.value.hojaId == null;
      this.hojaId = headerEvent.value.hojaId;
      if (headerEvent.value.hojaId) {
        this.loadingComponent.showLoading();
        this.mensualSeccionCService.findDataSeccionC2ByHojaId(headerEvent.value.hojaId).subscribe(data => this.parseSeccionC2Data(data));
      } else {
        this.initEmptyData();
      }
    }
  }

  private onClickGuardar() {
    this.cleanData();
    this.bindDataToDTO();
    this.loadingComponent.showLoading();
    this.mensualSeccionCService.saveDataSeccionC2(this.mensualSeccionC2Data).subscribe(appResponse => {
      if(appResponse.code == AppResponse.SUCCESS){
        NotifUtil.notifSuccess("Guardado exitosamente");
        this.loadingComponent.hideLoading();
        this.cleanData();
      }else{
        this.showErrorMsgs(appResponse.data);
      }
    }, (error) => this.notifError(error));
  }

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

  private onClickSiguiente(){
    this.showConfirmDialog('confirmDialogSiguiente');
  }

  private siguiente(){
    this.router.navigateByUrl(UrlConstants.MENSUAL_SECCION_C3);
  }

  private onClickConfirmDialogSiguiente(){
    this.loadingComponent.showLoading();
    this.cleanData();
    this.bindDataToDTO();
    this.mensualSeccionCService.saveDataSeccionC2(this.mensualSeccionC2Data).subscribe(appResponse => {
      if(appResponse.code == AppResponse.SUCCESS){
        this.loadingComponent.hideLoading();
        this.siguiente();
      }else{
        this.showErrorMsgs(appResponse.data);
      }
    }, (error) => this.notifError(error));
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

  private parseSeccionC2Data(data: MensualSeccionC2Data) {
    this.hojaMensualObservaciones = data.hojaMensualObservaciones ? data.hojaMensualObservaciones : new HojaMensualObservaciones;
    this.hojaMensualActividad = data.hojaMensualActividad ? data.hojaMensualActividad : new HojaMensualActividad;
    this.buildHojaMensualAcompaniamientoList(data);
  }

  private buildHojaMensualAcompaniamientoList(data: MensualSeccionC2Data) {
    this.hojaMensualAcompaniamientoList = data.hojaMensualAcompaniamientoList;
    if(this.hojaMensualAcompaniamientoList.length != this.acompaniamientos.length){
      this.completeHojaMensualAcompaniamientoList();
    }
    this.loadingComponent.hideLoading();
  }


  private initEmptyData() {
    this.hojaMensualObservaciones = new HojaMensualObservaciones;
    this.hojaMensualActividad = new HojaMensualActividad;
    this.initHojaMensualAcompaniamientoList();
  }

  private cleanData(){
    this.hideFormAlert();
    this.mensualSeccionC2Data = new MensualSeccionC2Data;
  }

  private bindDataToDTO() {
    this.mensualSeccionC2Data.hojaMensualAcompaniamientoList = this.hojaMensualAcompaniamientoList;
    this.mensualSeccionC2Data.hojaMensualObservaciones = this.hojaMensualObservaciones;
    this.mensualSeccionC2Data.hojaMensualActividad = this.hojaMensualActividad;
    this.setHojaIdToItems();
  }


  private setHojaIdToItems() {
    this.mensualSeccionC2Data.hojaMensualAcompaniamientoList.forEach(h => h.hoja.id = this.hojaId);
    this.mensualSeccionC2Data.hojaMensualActividad.hoja.id = this.hojaId;
    this.mensualSeccionC2Data.hojaMensualObservaciones.hoja.id = this.hojaId;
  }

}
