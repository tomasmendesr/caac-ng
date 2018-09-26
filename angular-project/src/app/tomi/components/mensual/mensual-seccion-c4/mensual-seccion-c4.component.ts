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
  private mensualSeccionC4Data: MensualSeccionC4Data = new MensualSeccionC4Data;
  private acompaniamientos: Acompaniamiento[] = [];

  private hojaMensualAcompaniamientoComisarias: HojaMensualAcompaniamiento = new HojaMensualAcompaniamiento;
  private hojaMensualAcompaniamientoPenales: HojaMensualAcompaniamiento = new HojaMensualAcompaniamiento;
  private hojaMensualAcompaniamientoTalleres: HojaMensualAcompaniamiento = new HojaMensualAcompaniamiento;
  private hojaMensualAcompaniamientoActividadesProductivas: HojaMensualAcompaniamiento = new HojaMensualAcompaniamiento;
  private hojaMensualAcompaniamientoCapacitacion: HojaMensualAcompaniamiento = new HojaMensualAcompaniamiento;
  private hojaMensualObservaciones: HojaMensualObservaciones = new HojaMensualObservaciones;

  constructor(private router: Router, private mensualSeccionCService: MensualSeccionCService, private acompaniamientoService: AcompaniamientoService) { }

  ngOnInit() {
    this.acompaniamientoService.findAllEstablecimientoPenalesComisarias().subscribe(data => this.acompaniamientos = data);
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
    this.loadingComponent.showLoading();
    this.cleanData();
    this.bindDataToDTO();
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
    this.buildHojaMensualAcompaniamientoList(data);
  }

  private buildHojaMensualAcompaniamientoList(data: MensualSeccionC4Data) {
    if (data.hojaMensualAcompaniamientoList) {
      this.hojaMensualAcompaniamientoComisarias = this.getHojaMensualAcompaniamientoFromListByIdAcompaniamiento(data.hojaMensualAcompaniamientoList, AcompaniamientoService.ID_ACOMPAÑAMIENTO_COMISARIAS);
      this.hojaMensualAcompaniamientoPenales = this.getHojaMensualAcompaniamientoFromListByIdAcompaniamiento(data.hojaMensualAcompaniamientoList, AcompaniamientoService.ID_ACOMPAÑAMIENTO_PENALES);
      this.hojaMensualAcompaniamientoTalleres = this.getHojaMensualAcompaniamientoFromListByIdAcompaniamiento(data.hojaMensualAcompaniamientoList, AcompaniamientoService.ID_PENALES_COMISARIAS_TALLERES);
      this.hojaMensualAcompaniamientoActividadesProductivas = this.getHojaMensualAcompaniamientoFromListByIdAcompaniamiento(data.hojaMensualAcompaniamientoList, AcompaniamientoService.ID_PENALES_COMISARIAS_ACT_PROD);
      this.hojaMensualAcompaniamientoCapacitacion = this.getHojaMensualAcompaniamientoFromListByIdAcompaniamiento(data.hojaMensualAcompaniamientoList, AcompaniamientoService.ID_PENALES_COMISARIAS_CAPACITACION);
    } else {
      this.initHojaMensualAcompaniamientos();
    }
    this.loadingComponent.hideLoading();
  }

  private getHojaMensualAcompaniamientoFromListByIdAcompaniamiento(list: HojaMensualAcompaniamiento[], idAcompaniamiento: number): HojaMensualAcompaniamiento {
    let hojaMensualAcompaniamiento = list.find(a => a.acompaniamiento.id == idAcompaniamiento);
    if(hojaMensualAcompaniamiento == null){
      hojaMensualAcompaniamiento = new HojaMensualAcompaniamiento;
      hojaMensualAcompaniamiento.acompaniamiento = this.acompaniamientoService.getAcompaniamientoById(this.acompaniamientos, idAcompaniamiento);
    }
    return hojaMensualAcompaniamiento;
  }

  private initEmptyData() {
    this.hojaMensualObservaciones = new HojaMensualObservaciones;
    this.initHojaMensualAcompaniamientos();
  }

  private initHojaMensualAcompaniamientos() {
    this.hojaMensualAcompaniamientoComisarias = new HojaMensualAcompaniamiento;
    this.hojaMensualAcompaniamientoPenales = new HojaMensualAcompaniamiento;
    this.hojaMensualAcompaniamientoTalleres = new HojaMensualAcompaniamiento;
    this.hojaMensualAcompaniamientoActividadesProductivas = new HojaMensualAcompaniamiento;
    this.hojaMensualAcompaniamientoCapacitacion = new HojaMensualAcompaniamiento;

    this.hojaMensualAcompaniamientoComisarias.acompaniamiento = this.acompaniamientoService.getAcompaniamientoById(this.acompaniamientos, AcompaniamientoService.ID_ACOMPAÑAMIENTO_COMISARIAS);
    this.hojaMensualAcompaniamientoPenales.acompaniamiento = this.acompaniamientoService.getAcompaniamientoById(this.acompaniamientos, AcompaniamientoService.ID_ACOMPAÑAMIENTO_PENALES);
    this.hojaMensualAcompaniamientoTalleres.acompaniamiento = this.acompaniamientoService.getAcompaniamientoById(this.acompaniamientos, AcompaniamientoService.ID_PENALES_COMISARIAS_TALLERES);
    this.hojaMensualAcompaniamientoActividadesProductivas.acompaniamiento = this.acompaniamientoService.getAcompaniamientoById(this.acompaniamientos, AcompaniamientoService.ID_PENALES_COMISARIAS_ACT_PROD);
    this.hojaMensualAcompaniamientoCapacitacion.acompaniamiento = this.acompaniamientoService.getAcompaniamientoById(this.acompaniamientos, AcompaniamientoService.ID_PENALES_COMISARIAS_CAPACITACION);
  }

  private cleanData(){
    this.hideFormAlert();
    this.mensualSeccionC4Data = new MensualSeccionC4Data;
  }

  private bindDataToDTO() {
    this.addAcompaniamientosToDTOList();
    this.mensualSeccionC4Data.hojaMensualObservaciones = this.hojaMensualObservaciones;
    this.setHojaIdToItems();
  }

  private addAcompaniamientosToDTOList() {
    this.mensualSeccionC4Data.hojaMensualAcompaniamientoList.push(this.hojaMensualAcompaniamientoComisarias);
    this.mensualSeccionC4Data.hojaMensualAcompaniamientoList.push(this.hojaMensualAcompaniamientoPenales);
    this.mensualSeccionC4Data.hojaMensualAcompaniamientoList.push(this.hojaMensualAcompaniamientoTalleres);
    this.mensualSeccionC4Data.hojaMensualAcompaniamientoList.push(this.hojaMensualAcompaniamientoActividadesProductivas);
    this.mensualSeccionC4Data.hojaMensualAcompaniamientoList.push(this.hojaMensualAcompaniamientoCapacitacion);
  }

  private setHojaIdToItems() {
    this.mensualSeccionC4Data.hojaMensualAcompaniamientoList.forEach(h => h.hoja.id = this.hojaId);
    this.mensualSeccionC4Data.hojaMensualObservaciones.hoja.id = this.hojaId;
  }
}
