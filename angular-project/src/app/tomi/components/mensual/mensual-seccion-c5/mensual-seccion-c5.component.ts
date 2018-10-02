import {Component, OnInit, ViewChild} from '@angular/core';
import {HojaMensualAcompaniamiento} from "../../../../model/hoja-mensual-acompaniamiento";
import {HojaMensualObservaciones} from "../../../../model/hoja-mensual-observaciones";
import {LoadingComponent} from "../../../../share-components/loading/loading.component";
import {HojaMensualRecurso} from "../../../../model/hoja-mensual-recurso";
import {HeaderEvent} from "../../../../model/header-event";
import {Router} from "@angular/router";
import {RecursoService} from "../../../services/recurso.service";
import {AcompaniamientoService} from "../../../services/acompaniamiento.service";
import {Recurso} from "../../../../model/recurso";
import {Acompaniamiento} from "../../../../model/acompaniamiento";
import {MensualSeccionCService} from "../../../services/mensual-seccion-c.service";
import {AppResponse} from "../../../../model/app-response";
import {NotifUtil} from "../../../utils/notif-util";
import {UrlConstants} from "../../../services/UrlConstants";
import {MensualSeccionC5Data} from "../../../model/mensual-seccion-c5.data";
declare var $:any;
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
  private recursos: Recurso[] = [];
  private acompaniamientosEstablecimientoProfSalud: Acompaniamiento[] = [];
  private acompaniamientosEstablecimientoTrayEducativa: Acompaniamiento[] = [];
  private mensualSeccionC5Data: MensualSeccionC5Data = new MensualSeccionC5Data;

  private hojaMensualObservaciones: HojaMensualObservaciones = new HojaMensualObservaciones;
  private hojaMensualRecursosList: HojaMensualRecurso[] = [];
  private hojaMensualAcompaniamientosEstablecimientoProfSaludList: HojaMensualAcompaniamiento[] = [];
  private hojaMensualAcompaniamientosEstablecimientoTrayEducativaList: HojaMensualAcompaniamiento[] = [];

  constructor(private router: Router, private recursoService: RecursoService,
              private acompaniamientoService: AcompaniamientoService, private mensualSeccionCService: MensualSeccionCService) { }

  ngOnInit() {
    this.recursoService.findAll().subscribe(data => {
      this.recursos = data;
      this.initHojaMensualRecursosList();
    });
    this.acompaniamientoService.findAllEstablecimientosProfesionalDeSalud().subscribe(data => {
      this.acompaniamientosEstablecimientoProfSalud = data;
      this.initHojaMensualAcompaniamientoProfSaludList();
    });
    this.acompaniamientoService.findAllEstablecimientosTrayectoriasEducativas().subscribe(data => {
      this.acompaniamientosEstablecimientoTrayEducativa = data;
      this.initHojaMensualAcompaniamientoTrayectoriaEducativadList();
    });
  }

  private initHojaMensualRecursosList(){
    this.hojaMensualRecursosList = [];
    this.completeHojaMensualRecursosList();
  }

  private completeHojaMensualRecursosList(){
    this.recursos.forEach(recurso => {
      if(this.hojaMensualRecursosList.find(h => h.recurso.id == recurso.id) == null) {
        let hojaMensualRecurso = new HojaMensualRecurso;
        hojaMensualRecurso.recurso = recurso;
        this.hojaMensualRecursosList.push(hojaMensualRecurso);
      }
    });
  }

  private initHojaMensualAcompaniamientoTrayectoriaEducativadList(){
    this.hojaMensualAcompaniamientosEstablecimientoTrayEducativaList = [];
    this.completeHojaMensualAcompaniamientosTrayEducativaList();
  }

  private completeHojaMensualAcompaniamientosTrayEducativaList(){
    this.acompaniamientosEstablecimientoTrayEducativa.forEach(acomp => {
      if(this.hojaMensualAcompaniamientosEstablecimientoTrayEducativaList.find(h => h.acompaniamiento.id == acomp.id) == null) {
        let hojaMensual = new HojaMensualAcompaniamiento;
        hojaMensual.acompaniamiento = acomp;
        this.hojaMensualAcompaniamientosEstablecimientoTrayEducativaList.push(hojaMensual);
      }
    });
  }

  private initHojaMensualAcompaniamientoProfSaludList(){
    this.hojaMensualAcompaniamientosEstablecimientoProfSaludList = [];
    this.completeHojaMensualAcompaniamientosProfSaludList();
  }

  private completeHojaMensualAcompaniamientosProfSaludList(){
    this.acompaniamientosEstablecimientoProfSalud.forEach(acomp => {
      if(this.hojaMensualAcompaniamientosEstablecimientoProfSaludList.find(h => h.acompaniamiento.id == acomp.id) == null) {
        let hojaMensual = new HojaMensualAcompaniamiento;
        hojaMensual.acompaniamiento = acomp;
        this.hojaMensualAcompaniamientosEstablecimientoProfSaludList.push(hojaMensual);
      }
    });
  }

  private onChangeHeader(headerEvent: HeaderEvent) {
    if (headerEvent.evento == HeaderEvent.HOJA_ID) {
      this.readonlyControl = headerEvent.value.hojaId == null;
      this.hojaId = headerEvent.value.hojaId;
      if (headerEvent.value.hojaId) {
        this.loadingComponent.showLoading();
        this.mensualSeccionCService.findDataSeccionC5ByHojaId(headerEvent.value.hojaId).subscribe(data => this.parseSeccionC5Data(data));
      } else {
        this.initEmptyData();
      }
    }
  }

  private onClickGuardar() {
    this.cleanData();
    this.bindDataToDTO();
    this.loadingComponent.showLoading();
    this.mensualSeccionCService.saveDataSeccionC5(this.mensualSeccionC5Data).subscribe(appResponse => {
      if(appResponse.code == AppResponse.SUCCESS){
        NotifUtil.notifSuccess("Guardado exitosamente");
        this.loadingComponent.hideLoading();
        this.cleanData();
      }else{
        this.showErrorMsgs(appResponse.data);
      }
    }, (error) => this.notifError(error));
  }

  private onClickSiguiente(){
    this.showConfirmDialog('confirmDialogSiguiente');
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
    this.router.navigateByUrl(UrlConstants.MENSUAL_SECCION_C6);
  }

  private onClickConfirmDialogSiguiente(){
    this.loadingComponent.showLoading();
    this.mensualSeccionCService.saveDataSeccionC5(this.mensualSeccionC5Data).subscribe(appResponse => {
      if(appResponse.code == AppResponse.SUCCESS){
        this.loadingComponent.hideLoading();
        this.siguiente();
      }else{
        this.showErrorMsgs(appResponse.data);
      }
    }, (error) => this.notifError(error));
  }

  private initEmptyData() {
    this.hojaMensualObservaciones = new HojaMensualObservaciones;
    this.initHojaMensualRecursosList();
    this.initHojaMensualAcompaniamientoProfSaludList();
    this.initHojaMensualAcompaniamientoTrayectoriaEducativadList();
  }

  private bindDataToDTO() {
    this.mensualSeccionC5Data.hojaMensualRecursoList = this.hojaMensualRecursosList;
    this.mensualSeccionC5Data.hojaMensualAcompaniamientoEstabProfSaludList = this.hojaMensualAcompaniamientosEstablecimientoProfSaludList;
    this.mensualSeccionC5Data.hojaMensualAcompaniamientoEstabTrayEducativaList = this.hojaMensualAcompaniamientosEstablecimientoTrayEducativaList;
    this.mensualSeccionC5Data.hojaMensualObservaciones = this.hojaMensualObservaciones;
    this.setHojaIdToItems();
  }


  private setHojaIdToItems() {
    this.mensualSeccionC5Data.hojaMensualRecursoList.forEach(h => h.hoja.id = this.hojaId);
    this.mensualSeccionC5Data.hojaMensualAcompaniamientoEstabProfSaludList.forEach(h => h.hoja.id = this.hojaId);
    this.mensualSeccionC5Data.hojaMensualAcompaniamientoEstabTrayEducativaList.forEach(h => h.hoja.id = this.hojaId);
    this.mensualSeccionC5Data.hojaMensualObservaciones.hoja.id = this.hojaId;
  }


  private parseSeccionC5Data(data: MensualSeccionC5Data) {
    this.hojaMensualObservaciones = data.hojaMensualObservaciones ? data.hojaMensualObservaciones : new HojaMensualObservaciones;
    this.buildHojaMensualRecursos(data);
    this.buildHojaMensualAcompaniamientosEstabProfSalud(data);
    this.buildHojaMensualAcompaniamientosEstabTrayEducativa(data);
  }

  private buildHojaMensualRecursos(data: MensualSeccionC5Data) {
    this.hojaMensualRecursosList = data.hojaMensualRecursoList;
    if(this.hojaMensualRecursosList.length != this.recursos.length){
      this.completeHojaMensualRecursosList();
    }
  }

  private buildHojaMensualAcompaniamientosEstabProfSalud(data: MensualSeccionC5Data) {
    this.hojaMensualAcompaniamientosEstablecimientoProfSaludList = data.hojaMensualAcompaniamientoEstabProfSaludList;
    if(this.hojaMensualAcompaniamientosEstablecimientoProfSaludList.length != this.acompaniamientosEstablecimientoProfSalud.length){
      this.completeHojaMensualAcompaniamientosProfSaludList();
    }
    this.loadingComponent.hideLoading();
  }

  private buildHojaMensualAcompaniamientosEstabTrayEducativa(data: MensualSeccionC5Data) {
    this.hojaMensualAcompaniamientosEstablecimientoTrayEducativaList = data.hojaMensualAcompaniamientoEstabTrayEducativaList;
    if(this.hojaMensualAcompaniamientosEstablecimientoTrayEducativaList.length != this.acompaniamientosEstablecimientoTrayEducativa.length){
      this.completeHojaMensualAcompaniamientosTrayEducativaList();
    }
    this.loadingComponent.hideLoading();
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

  private cleanData(){
    this.hideFormAlert();
    this.mensualSeccionC5Data = new MensualSeccionC5Data;
  }


}
