import {Component, OnInit, ViewChild} from '@angular/core';
import {HojaMensualAcompaniamiento} from "../../../../model/hoja-mensual-acompaniamiento";
import {HojaMensualObservaciones} from "../../../../model/hoja-mensual-observaciones";
import {LoadingComponent} from "../../../../share-components/loading/loading.component";
import {MensualSeccionC4Data} from "../../../model/mensual-seccion-c4-data";
import {Acompaniamiento} from "../../../../model/acompaniamiento";
import {MensualSeccionCService} from "../../../services/mensual-seccion-c.service";
import {Router} from "@angular/router";
import {AcompaniamientoService} from "../../../services/acompaniamiento.service";
import {HeaderEvent} from "../../../../model/header-event";
import {NotifUtil} from "../../../utils/notif-util";
import {AppResponse} from "../../../../model/app-response";
import {UrlConstants} from "../../../services/UrlConstants";
declare var $:any;
@Component({
  selector: 'app-mensual-seccion-c4',
  templateUrl: './mensual-seccion-c4.component.html',
  styleUrls: ['./mensual-seccion-c4.component.css']
})
export class MensualSeccionC4Component implements OnInit {
  private readonlyControl: boolean = true;
  private formMessages: string[] = [];
  private errorSection: number = -1;
  private hojaId: number;
  @ViewChild(LoadingComponent) loadingComponent:LoadingComponent;
  private acompaniamientosEstPenalesAndTipoAcomp: Acompaniamiento[] = [];
  private acompaniamientosEstPenalesandTipoAct: Acompaniamiento[] = [];

  private mensualSeccionC4Data: MensualSeccionC4Data = new MensualSeccionC4Data;
  private hojaMensualAcompEstPenalesTipoAcompList: HojaMensualAcompaniamiento[] = [];
  private hojaMensualAcompEstPenalesTipoActividadesList: HojaMensualAcompaniamiento[] = [];
  private hojaMensualObservaciones: HojaMensualObservaciones = new HojaMensualObservaciones;

  constructor(private router: Router, private mensualSeccionCService: MensualSeccionCService, private acompaniamientoService: AcompaniamientoService) { }

  ngOnInit() {
    this.acompaniamientoService.findAllEstablecimientoPenalesComisariasAndTipoAcompaniamiento().subscribe(data => {
      this.acompaniamientosEstPenalesAndTipoAcomp = data;
      this.initHojaMensualAcompEstPenalesTipoAcompList();
    });
    this.acompaniamientoService.findAllEstablecimientoPenalesComisariasAndTipoActividades().subscribe(data => {
      this.acompaniamientosEstPenalesandTipoAct = data;
      this.initHojaMensualAcompEstPenalesTipoActividadesList();
    });
  }

  private initHojaMensualAcompEstPenalesTipoAcompList(){
    this.hojaMensualAcompEstPenalesTipoAcompList = [];
    this.completeHojaMensualAcompEstPenalesTipoAcompList();
  }

  private completeHojaMensualAcompEstPenalesTipoAcompList(){
    this.acompaniamientosEstPenalesAndTipoAcomp.forEach(ac => {
      if(this.hojaMensualAcompEstPenalesTipoAcompList.find(h => h.acompaniamiento.id == ac.id) == null) {
        let hojaMensual = new HojaMensualAcompaniamiento();
        hojaMensual.acompaniamiento = ac;
        this.hojaMensualAcompEstPenalesTipoAcompList.push(hojaMensual);
      }
    });
  }

  private initHojaMensualAcompEstPenalesTipoActividadesList(){
    this.hojaMensualAcompEstPenalesTipoActividadesList = [];
    this.completeHojaMensualAcompEstPenalesTipoActividadesList();
  }

  private completeHojaMensualAcompEstPenalesTipoActividadesList(){
    this.acompaniamientosEstPenalesandTipoAct.forEach(ac => {
      if(this.hojaMensualAcompEstPenalesTipoActividadesList.find(h => h.acompaniamiento.id == ac.id) == null) {
        let hojaMensual = new HojaMensualAcompaniamiento();
        hojaMensual.acompaniamiento = ac;
        this.hojaMensualAcompEstPenalesTipoActividadesList.push(hojaMensual);
      }
    });
  }

  private onChangeHeader(headerEvent: HeaderEvent) {
    if (headerEvent.evento == HeaderEvent.HOJA_ID) {
      this.readonlyControl = headerEvent.value.hojaId == null;
      this.hojaId = headerEvent.value.hojaId;
      if (headerEvent.value.hojaId) {
        this.loadingComponent.showLoading();
        this.mensualSeccionCService.findDataSeccionC4ByHojaId(headerEvent.value.hojaId).subscribe(data => this.parseSeccionC4Data(data));
      } else {
        this.initEmptyData();
      }
    }
  }

  private onClickGuardar() {
    this.cleanData();
    this.bindDataToDTO();
    this.loadingComponent.showLoading();
    this.mensualSeccionCService.saveDataSeccionC4(this.mensualSeccionC4Data).subscribe(appResponse => {
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

  private siguiente(){
    this.router.navigateByUrl(UrlConstants.MENSUAL_SECCION_C5);
  }

  private onClickConfirmDialogSiguiente(){
    this.cleanData();
    this.bindDataToDTO();
    this.loadingComponent.showLoading();
    this.mensualSeccionCService.saveDataSeccionC4(this.mensualSeccionC4Data).subscribe(appResponse => {
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

  private onClickSiguiente(){
    this.showConfirmDialog('confirmDialogSiguiente');
  }

  private parseSeccionC4Data(data: MensualSeccionC4Data) {
    this.hojaMensualObservaciones = data.hojaMensualObservaciones ? data.hojaMensualObservaciones : new HojaMensualObservaciones;
    this.buildHojaMensualAcompaniamientoEstabPenalesAndTipoAcompList(data);
    this.buildHojaMensualAcompaniamientoEstabPenalesAndTipoActividadesList(data);
  }

  private buildHojaMensualAcompaniamientoEstabPenalesAndTipoAcompList(data: MensualSeccionC4Data) {
    this.hojaMensualAcompEstPenalesTipoAcompList = data.hojaMensualAcompEstPenalesTipoAcompList;
    if(this.hojaMensualAcompEstPenalesTipoAcompList.length != this.acompaniamientosEstPenalesAndTipoAcomp.length){
      this.completeHojaMensualAcompEstPenalesTipoAcompList();
    }
    this.loadingComponent.hideLoading();
  }

  private buildHojaMensualAcompaniamientoEstabPenalesAndTipoActividadesList(data: MensualSeccionC4Data) {
    this.hojaMensualAcompEstPenalesTipoActividadesList = data.hojaMensualAcompEstPenalesTipoActividadesList;
    if(this.hojaMensualAcompEstPenalesTipoActividadesList.length != this.acompaniamientosEstPenalesandTipoAct.length){
      this.completeHojaMensualAcompEstPenalesTipoActividadesList();
    }
    this.loadingComponent.hideLoading();
  }

  private initEmptyData() {
    this.hojaMensualObservaciones = new HojaMensualObservaciones;
    this.initHojaMensualAcompEstPenalesTipoAcompList();
    this.initHojaMensualAcompEstPenalesTipoActividadesList();
  }

  private cleanData(){
    this.hideFormAlert();
    this.mensualSeccionC4Data = new MensualSeccionC4Data;
  }

  private bindDataToDTO() {
    this.hojaMensualAcompEstPenalesTipoAcompList = this.mensualSeccionC4Data.hojaMensualAcompEstPenalesTipoAcompList;
    this.hojaMensualAcompEstPenalesTipoActividadesList = this.mensualSeccionC4Data.hojaMensualAcompEstPenalesTipoActividadesList;
    this.mensualSeccionC4Data.hojaMensualObservaciones = this.hojaMensualObservaciones;
    this.setHojaIdToItems();
  }


  private setHojaIdToItems() {
    this.mensualSeccionC4Data.hojaMensualAcompEstPenalesTipoAcompList.forEach(h => h.hoja.id = this.hojaId);
    this.mensualSeccionC4Data.hojaMensualAcompEstPenalesTipoActividadesList.forEach(h => h.hoja.id = this.hojaId);
    this.mensualSeccionC4Data.hojaMensualObservaciones.hoja.id = this.hojaId;
  }
}
