import {Component, OnInit, ViewChild} from '@angular/core';
import {HeaderEvent} from "../../../../model/header-event";
import {HojaMensualAsistidos} from "../../../../model/hoja-mensual-asistidos";
import {LoadingComponent} from "../../../../share-components/loading/loading.component";
import {NotifUtil} from "../../../utils/notif-util";
import {AppResponse} from "../../../../model/app-response";
import {HojaMensualAsistidosService} from "../../../services/hoja-mensual-asistidos.service";
import {UrlConstants} from "../../../services/UrlConstants";
import {Router} from "@angular/router";

declare var $:any;
@Component({
  selector: 'app-mensual-seccion-b',
  templateUrl: './mensual-seccion-b.component.html',
  styleUrls: ['./mensual-seccion-b.component.css']
})
export class MensualSeccionBComponent implements OnInit {
  hojaMensualAsistidos: HojaMensualAsistidos = new HojaMensualAsistidos;
  private formMessages: string[] = [];
  private readonlyControl: boolean = true;
  @ViewChild(LoadingComponent) loadingComponent:LoadingComponent;

  constructor(private hojaMensualAsistidosService: HojaMensualAsistidosService, private router: Router) { }

  ngOnInit() {
  }

  private onClickGuardar(){
    if(this.validationOk()){
      this.saveOrUpdateMensual();
    }
  }

  private validationOk(){
    let mssgs = [];
    if(this.hojaMensualAsistidos.asistidosVarones == null) mssgs.push("Debe ingresar la cantidad de varones asistidos");
    if(this.hojaMensualAsistidos.asistidosMujeres == null) mssgs.push("Debe ingresar la cantidad de mujeres asistidas");
    if(this.hojaMensualAsistidos.asistidosOtroGenero == null) mssgs.push("Debe ingresar la cantidad de asistidos de otro género");
    if(this.hojaMensualAsistidos.asistidosCantidad == null) mssgs.push("Debe ingresar la cantidad de atendidos");
    if(mssgs.length == 0) return true;
    else this.showErrorMsgs(mssgs);
  }

  private onChangeHeader(headerEvent: HeaderEvent) {
    if(headerEvent.evento == HeaderEvent.HOJA_ID){
      if(headerEvent.value.hojaId) {
        this.readonlyControl = false;
        this.hojaMensualAsistidosService.findById(headerEvent.value.hojaId).subscribe(data => {
          if (data != null) this.hojaMensualAsistidos = data;
          else this.hojaMensualAsistidos = new HojaMensualAsistidos;
          this.hojaMensualAsistidos.hoja.id = headerEvent.value.hojaId;
        });
      } else { // Si seleccionó los tres y no encontroó ninguna hoja
        this.readonlyControl = true;
        if(headerEvent.value.casa && headerEvent.value.mesCarga && headerEvent.value.anioCarga) NotifUtil.notifError("No se encontró ninguna hoja para el período indicado");
      }
    }
  }

  private saveOrUpdateMensual(){
    this.loadingComponent.showLoading();
    this.hojaMensualAsistidosService.saveOrUpdate(this.hojaMensualAsistidos).subscribe(appResponse => {
      if(appResponse.code == AppResponse.SUCCESS){
        NotifUtil.notifSuccess("Guardado exitosamente");
        this.loadingComponent.hideLoading();
        this.hojaMensualAsistidos.id = <number> appResponse.data;
      }else{
        this.showErrorMsgs(appResponse.data);
      }
    }, (error) => this.notifError(error));
  }

  private notifError(error){
    // let errorResponse = JSON.parse(error.error);
    NotifUtil.notifError(error.error.message);
    this.loadingComponent.hideLoading();
  }

  private showErrorMsgs(messages: string[]){
    this.loadingComponent.hideLoading();
    this.formMessages = messages;
    $('#formAlert').show();
  }

  private onClickSiguiente(){
    if(this.validationOk()) {
      this.showConfirmDialog('confirmDialogSiguiente');
    }
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
    this.router.navigateByUrl(UrlConstants.MENSUAL_SECCION_C1);
  }

  private onClickConfirmDialogSiguiente(){
    this.loadingComponent.showLoading();
    this.hojaMensualAsistidosService.saveOrUpdate(this.hojaMensualAsistidos).subscribe(appResponse => {
      if(appResponse.code == AppResponse.SUCCESS){
        this.loadingComponent.hideLoading();
        this.siguiente();
      }else{
        this.showErrorMsgs(appResponse.data);
      }
    }, (error) => this.notifError(error));
  }

}
