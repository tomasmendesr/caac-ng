import {Component, OnInit, ViewChild} from '@angular/core';
import {LoadingComponent} from "../../../../share-components/loading/loading.component";
import {HeaderEvent} from "../../../../model/header-event";
import {AppResponse} from "../../../../model/app-response";
import {NotifUtil} from "../../../utils/notif-util";
import {UrlConstants} from "../../../services/UrlConstants";
import {Router} from "@angular/router";
import {HojaMensualAcompaniamiento} from "../../../../model/hoja-mensual-acompaniamiento";
import {HojaMensualObservaciones} from "../../../../model/hoja-mensual-observaciones";
import {MensualSeccionC3Data} from "../../../model/mensual-seccion-c3-data";
import {MensualSeccionCService} from "../../../services/mensual-seccion-c.service";
import {Acompaniamiento} from "../../../../model/acompaniamiento";
import {AcompaniamientoService} from "../../../services/acompaniamiento.service";
declare var $:any;
@Component({
  selector: 'app-mensual-seccion-c3',
  templateUrl: './mensual-seccion-c3.component.html',
  styleUrls: ['./mensual-seccion-c3.component.css']
})
export class MensualSeccionC3Component implements OnInit {
  private readonlyControl: boolean = true;
  private formMessages: string[] = [];
  private errorSection: number = -1;
  private hojaId: number;
  @ViewChild(LoadingComponent) loadingComponent:LoadingComponent;
  private mensualSeccionC3Data: MensualSeccionC3Data = new MensualSeccionC3Data;
  private hojaMensualAcompaniamientoTipoGestionList: HojaMensualAcompaniamiento[] = [];
  private hojaMensualAcompaniamientoEstabComuTerapeuticaList: HojaMensualAcompaniamiento[] = [];;
  private hojaMensualAcompaniamientoEstabPatrocinioLegalList: HojaMensualAcompaniamiento[] = [];;
  private hojaMensualObservaciones: HojaMensualObservaciones = new HojaMensualObservaciones;
  private acompaniamientosTipoGestion: Acompaniamiento[] = [];
  private acompaniamientosEstabComuTerapeutica: Acompaniamiento[] = [];
  private acompaniamientosEstabPatrocinioLegal: Acompaniamiento[] = [];

  constructor(private router: Router, private mensualSeccionCService: MensualSeccionCService, private acompaniamientoService: AcompaniamientoService) { }

  ngOnInit() {
    this.acompaniamientoService.findAllEstablecimientosDeSaludAndTipoGestion().subscribe(data =>{
      this.acompaniamientosTipoGestion = data;
      this.initHojaMensualAcompaniamientoTipoGestionList();
    });
    this.acompaniamientoService.findAllEstablecimientosComunidadTerapeutica().subscribe(data => {
      this.acompaniamientosEstabComuTerapeutica = data;
      this.initHojaMensualAcompaniamientoEstabComuTerapeuticaList();
    });
    this.acompaniamientoService.findAllEstablecimientosPatrocinioLegal().subscribe(data => {
      this.acompaniamientosEstabPatrocinioLegal = data;
      this.initHojaMensualAcompaniamientoEstabPatrocinioLegalList();
    });
  }

  private initHojaMensualAcompaniamientoTipoGestionList(){
    this.hojaMensualAcompaniamientoTipoGestionList = [];
    this.completeHojaMensualAcompaniamientoTipoGestionList();
  }

  private completeHojaMensualAcompaniamientoTipoGestionList(){
    this.acompaniamientosTipoGestion.forEach(ac => {
      if(this.hojaMensualAcompaniamientoTipoGestionList.find(h => h.acompaniamiento.id == ac.id) == null) {
        let hojaMensual = new HojaMensualAcompaniamiento();
        hojaMensual.acompaniamiento = ac;
        this.hojaMensualAcompaniamientoTipoGestionList.push(hojaMensual);
      }
    });
  }

  private initHojaMensualAcompaniamientoEstabComuTerapeuticaList(){
    this.hojaMensualAcompaniamientoEstabComuTerapeuticaList = [];
    this.completeHojaMensualAcompaniamientoEstabComuTerapeuticaList();
  }

  private completeHojaMensualAcompaniamientoEstabComuTerapeuticaList(){
    this.acompaniamientosEstabComuTerapeutica.forEach(ac => {
      if(this.hojaMensualAcompaniamientoEstabComuTerapeuticaList.find(h => h.acompaniamiento.id == ac.id) == null) {
        let hojaMensual = new HojaMensualAcompaniamiento();
        hojaMensual.acompaniamiento = ac;
        this.hojaMensualAcompaniamientoEstabComuTerapeuticaList.push(hojaMensual);
      }
    });
  }

  private initHojaMensualAcompaniamientoEstabPatrocinioLegalList(){
    this.hojaMensualAcompaniamientoEstabPatrocinioLegalList = [];
    this.completeHojaMensualAcompaniamientoEstabPatrocinioLegalList();
  }

  private completeHojaMensualAcompaniamientoEstabPatrocinioLegalList(){
    this.acompaniamientosEstabPatrocinioLegal.forEach(ac => {
      if(this.hojaMensualAcompaniamientoEstabPatrocinioLegalList.find(h => h.acompaniamiento.id == ac.id) == null) {
        let hojaMensual = new HojaMensualAcompaniamiento();
        hojaMensual.acompaniamiento = ac;
        this.hojaMensualAcompaniamientoEstabPatrocinioLegalList.push(hojaMensual);
      }
    });
  }

  private onChangeHeader(headerEvent: HeaderEvent) {
    if (headerEvent.evento == HeaderEvent.HOJA_ID) {
      this.readonlyControl = headerEvent.value.hojaId == null;
      this.hojaId = headerEvent.value.hojaId;
      if (headerEvent.value.hojaId) {
        this.loadingComponent.showLoading();
        this.mensualSeccionCService.findDataSeccionC3ByHojaId(headerEvent.value.hojaId).subscribe(data => this.parseSeccionC3Data(data));
      } else {
        this.initEmptyData();
      }
    }
  }

  private onClickGuardar() {
    this.cleanData();
    this.bindDataToDTO();
    this.loadingComponent.showLoading();
    this.mensualSeccionCService.saveDataSeccionC3(this.mensualSeccionC3Data).subscribe(appResponse => {
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
    this.router.navigateByUrl(UrlConstants.MENSUAL_SECCION_C4);
  }

  private onClickConfirmDialogSiguiente(){
    this.loadingComponent.showLoading();
    this.cleanData();
    this.bindDataToDTO();
    this.mensualSeccionCService.saveDataSeccionC3(this.mensualSeccionC3Data).subscribe(appResponse => {
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

  private parseSeccionC3Data(data: MensualSeccionC3Data) {
    this.hojaMensualObservaciones = data.hojaMensualObservaciones ? data.hojaMensualObservaciones : new HojaMensualObservaciones;
    this.buildHojaMensualAcompaniamientoTipoGestionList(data);
    this.buildHojaMensualAcompaniamientoEstabComuTerapeuticaList(data);
    this.buildHojaMensualAcompaniamientoEstabPatrocinioLegalList(data);
  }

  private buildHojaMensualAcompaniamientoTipoGestionList(data: MensualSeccionC3Data) {
    this.hojaMensualAcompaniamientoTipoGestionList = data.hojaMensualAcompaniamientoTipoGestionList;
    if(this.hojaMensualAcompaniamientoTipoGestionList.length != this.acompaniamientosTipoGestion.length){
      this.completeHojaMensualAcompaniamientoTipoGestionList();
    }
    this.loadingComponent.hideLoading();
  }

  private buildHojaMensualAcompaniamientoEstabPatrocinioLegalList(data: MensualSeccionC3Data) {
    this.hojaMensualAcompaniamientoEstabPatrocinioLegalList = data.hojaMensualAcompaniamientoEstablPatrocinioLegalList;
    if(this.hojaMensualAcompaniamientoEstabPatrocinioLegalList.length != this.acompaniamientosEstabPatrocinioLegal.length){
      this.completeHojaMensualAcompaniamientoEstabPatrocinioLegalList();
    }
    this.loadingComponent.hideLoading();
  }

  private buildHojaMensualAcompaniamientoEstabComuTerapeuticaList(data: MensualSeccionC3Data) {
    this.hojaMensualAcompaniamientoEstabComuTerapeuticaList = data.hojaMensualAcompaniamientoEstablComuTerapeuticaList;
    if(this.hojaMensualAcompaniamientoEstabComuTerapeuticaList.length != this.acompaniamientosEstabComuTerapeutica.length){
      this.completeHojaMensualAcompaniamientoEstabComuTerapeuticaList();
    }
    this.loadingComponent.hideLoading();
  }

  private initEmptyData() {
    this.hojaMensualObservaciones = new HojaMensualObservaciones;
    this.initHojaMensualAcompaniamientoTipoGestionList();
    this.initHojaMensualAcompaniamientoEstabComuTerapeuticaList();
    this.initHojaMensualAcompaniamientoEstabPatrocinioLegalList();
  }


  private cleanData(){
    this.hideFormAlert();
    this.mensualSeccionC3Data = new MensualSeccionC3Data;
  }

  private bindDataToDTO() {
    this.mensualSeccionC3Data.hojaMensualAcompaniamientoTipoGestionList = this.hojaMensualAcompaniamientoTipoGestionList;
    this.mensualSeccionC3Data.hojaMensualAcompaniamientoEstablComuTerapeuticaList = this.hojaMensualAcompaniamientoEstabComuTerapeuticaList;
    this.mensualSeccionC3Data.hojaMensualAcompaniamientoEstablPatrocinioLegalList = this.hojaMensualAcompaniamientoEstabPatrocinioLegalList;
    this.mensualSeccionC3Data.hojaMensualObservaciones = this.hojaMensualObservaciones;
    this.setHojaIdToItems();
  }


  private setHojaIdToItems() {
    this.mensualSeccionC3Data.hojaMensualAcompaniamientoTipoGestionList.forEach(h => h.hoja.id = this.hojaId);
    this.mensualSeccionC3Data.hojaMensualAcompaniamientoEstablComuTerapeuticaList.forEach(h => h.hoja.id = this.hojaId);
    this.mensualSeccionC3Data.hojaMensualAcompaniamientoEstablPatrocinioLegalList.forEach(h => h.hoja.id = this.hojaId);
    this.mensualSeccionC3Data.hojaMensualObservaciones.hoja.id = this.hojaId;
  }

}
