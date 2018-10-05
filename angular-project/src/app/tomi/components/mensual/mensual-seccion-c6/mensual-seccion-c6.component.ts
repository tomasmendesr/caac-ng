import {Component, OnInit, ViewChild} from '@angular/core';
import {HeaderEvent} from "../../../../model/header-event";
import {LoadingComponent} from "../../../../share-components/loading/loading.component";
import {ActividadIntervencionService} from "../../../services/actividad-intervencion.service";
import {ActividadIntervencion} from "../../../../model/actividad-intervencion";
import {HojaMensualActividades} from "../../../../model/hoja-mensual-actividades";
import {MensualSeccionCService} from "../../../services/mensual-seccion-c.service";
import {Router} from "@angular/router";
import {AppResponse} from "../../../../model/app-response";
import {NotifUtil} from "../../../utils/notif-util";
import {UrlConstants} from "../../../services/UrlConstants";
declare var $: any;
@Component({
  selector: 'app-mensual-seccion-c6',
  templateUrl: './mensual-seccion-c6.component.html',
  styleUrls: ['./mensual-seccion-c6.component.css']
})
export class MensualSeccionC6Component implements OnInit {
  private readonlyControl: boolean = true;
  private formMessages: string[] = [];
  private hojaId: number;
  @ViewChild(LoadingComponent) loadingComponent:LoadingComponent;
  private actividadIntervencionList: ActividadIntervencion[] = [];
  private hojaMensualActividadesList: HojaMensualActividades[] = [];
  private otroIsChecked: boolean = false;
  private descripcionActividadOtroText: string;

  constructor(private actividadIntervencionService: ActividadIntervencionService, private mensualSeccionCService: MensualSeccionCService, private router: Router) { }

  ngOnInit() {
    this.actividadIntervencionService.findAllTipoActividad().subscribe(data => {
      this.actividadIntervencionList = data;
      this.initHojaMensualActividadesList();
    });
  }

  private initHojaMensualActividadesList(){
    this.hojaMensualActividadesList = [];
    this.completeHojaMensualActividadesList();
  }

  private completeHojaMensualActividadesList(){
    this.actividadIntervencionList.forEach(actInt => {
      if(this.hojaMensualActividadesList.find(h => h.actividadIntervencion.id == actInt.id) == null) {
        let hojaMensual = new HojaMensualActividades;
        hojaMensual.actividadIntervencion = actInt;
        this.hojaMensualActividadesList.push(hojaMensual);
      }
    });
  }

  private onChangeHeader(headerEvent: HeaderEvent) {
    if (headerEvent.evento == HeaderEvent.HOJA_ID) {
      this.readonlyControl = headerEvent.value.hojaId == null;
      this.hojaId = headerEvent.value.hojaId;
      if (headerEvent.value.hojaId) {
        this.loadingComponent.showLoading();
        this.mensualSeccionCService.findDataSeccionC6ByHojaId(headerEvent.value.hojaId).subscribe(data => this.parseSeccionC6Data(data));
      } else {
        this.initEmptyData();
      }
    }
  }

  private onClickGuardar() {
    this.bindDataToDTO();
    this.loadingComponent.showLoading();
    this.mensualSeccionCService.saveDataSeccionC6(this.hojaMensualActividadesList).subscribe(appResponse => {
      if(appResponse.code == AppResponse.SUCCESS){
        NotifUtil.notifSuccess("Guardado exitosamente");
        this.loadingComponent.hideLoading();
      }else{
        this.showErrorMsgs(appResponse);
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
    this.router.navigateByUrl(UrlConstants.MENSUAL_SECCION_D);
  }

  private onClickConfirmDialogSiguiente(){
    this.loadingComponent.showLoading();
    this.bindDataToDTO();
    this.mensualSeccionCService.saveDataSeccionC6(this.hojaMensualActividadesList).subscribe(appResponse => {
      if(appResponse.code == AppResponse.SUCCESS){
        this.loadingComponent.hideLoading();
        this.siguiente();
      }else{
        this.showErrorMsgs(appResponse);
      }
    }, (error) => this.notifError(error));
  }

  private initEmptyData() {
    this.initHojaMensualActividadesList();
  }

  private bindDataToDTO() {
    if(this.otroIsChecked) this.hojaMensualActividadesList.find(h => this.actividadIntervencionService.actividadIntervencionOtro(h.actividadIntervencion)).descripcionActividad = this.descripcionActividadOtroText;
    this.setHojaIdToItems();
  }


  private setHojaIdToItems() {
    this.hojaMensualActividadesList.forEach(h => h.hoja.id = this.hojaId);
  }


  private parseSeccionC6Data(data: HojaMensualActividades[]) {
    this.hojaMensualActividadesList = data;
    this.hojaMensualActividadesList.forEach(h => {
      h.isChecked = true;
      if(this.actividadIntervencionService.actividadIntervencionOtro(h.actividadIntervencion)){
        this.otroIsChecked = true;
        this.descripcionActividadOtroText = h.descripcionActividad;
      }
    });
    if(this.hojaMensualActividadesList.length != this.actividadIntervencionList.length){
      this.completeHojaMensualActividadesList();
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
    let formAlertId = "#formAlert";
    this.formMessages = appResponse.data;
    $(formAlertId).show();
  }

  private hideFormAlert() {
    let formAlertId = "#formAlert";
    $(formAlertId).hide();
  }

  private onChangeCheckbox(hojaMensual: HojaMensualActividades, $event: any) {
    $event.preventDefault();
    let cbValue = $event.target.checked;
    hojaMensual.isChecked = cbValue;
    if(!cbValue) hojaMensual.descripcionActividad = '';
    if(this.actividadIntervencionService.actividadIntervencionOtro(hojaMensual.actividadIntervencion)) {
      this.otroIsChecked = cbValue;
      if(!cbValue) this.descripcionActividadOtroText == '';
    }
  }

  private hojaMensualActividadesListWithoutOtro(): HojaMensualActividades[] {
    return this.hojaMensualActividadesList.filter(h => !this.actividadIntervencionService.actividadIntervencionOtro(h.actividadIntervencion));
  }


}
