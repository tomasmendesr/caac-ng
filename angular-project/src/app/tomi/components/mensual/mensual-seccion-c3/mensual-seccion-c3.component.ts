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
  private hojaMensualAcompaniamientoGestionTurnos: HojaMensualAcompaniamiento = new HojaMensualAcompaniamiento;
  private hojaMensualAcompaniamientoGestionTramitesMedicacion: HojaMensualAcompaniamiento = new HojaMensualAcompaniamiento;
  private hojaMensualAcompaniamientoGestionServicios: HojaMensualAcompaniamiento = new HojaMensualAcompaniamiento;
  private hojaMensualAcompaniamientoCentroTratamientoEspecializado: HojaMensualAcompaniamiento = new HojaMensualAcompaniamiento;
  private hojaMensualAcompaniamientoCentroTratamientoSinSubsidioSedronar: HojaMensualAcompaniamiento = new HojaMensualAcompaniamiento;
  private hojaMensualAcompaniamientoCentroTratamientoConSubsidioSedronar: HojaMensualAcompaniamiento = new HojaMensualAcompaniamiento;
  private hojaMensualAcompaniamientoEnSede: HojaMensualAcompaniamiento = new HojaMensualAcompaniamiento;
  private hojaMensualAcompaniamientoFueraDeSede: HojaMensualAcompaniamiento = new HojaMensualAcompaniamiento;
  private hojaMensualObservaciones: HojaMensualObservaciones = new HojaMensualObservaciones;
  private acompaniamientos: Acompaniamiento[] = [];

  constructor(private router: Router, private mensualSeccionCService: MensualSeccionCService, private acompaniamientoService: AcompaniamientoService) { }

  ngOnInit() {
    this.acompaniamientoService.findAll().subscribe(data => this.acompaniamientos = data);
  }

  private onChangeHeader(headerEvent: HeaderEvent) {
    if (headerEvent.evento == HeaderEvent.HOJA_ID) {
      this.readonlyControl = headerEvent.value.hojaId == null;
      this.hojaId = headerEvent.value.hojaId;
      if (headerEvent.value.hojaId) {
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

  private parseSeccionC3Data(data: MensualSeccionC3Data) {
    this.hojaMensualObservaciones = data.hojaMensualObservaciones ? data.hojaMensualObservaciones : new HojaMensualObservaciones;
    this.buildHojaMensualAcompaniamientoList(data);
  }

  private buildHojaMensualAcompaniamientoList(data: MensualSeccionC3Data) {
    if (data.hojaMensualAcompaniamientoList) {
      this.hojaMensualAcompaniamientoGestionTurnos = this.getHojaMensualAcompaniamientoFromListByIdAcompaniamiento(data.hojaMensualAcompaniamientoList, AcompaniamientoService.ID_ESTB_SALUD_GESTION_DE_TURNOS);
      this.hojaMensualAcompaniamientoGestionTramitesMedicacion = this.getHojaMensualAcompaniamientoFromListByIdAcompaniamiento(data.hojaMensualAcompaniamientoList, AcompaniamientoService.ID_ESTB_SALUD_GESTION_DE_TRAMITES);
      this.hojaMensualAcompaniamientoGestionServicios = this.getHojaMensualAcompaniamientoFromListByIdAcompaniamiento(data.hojaMensualAcompaniamientoList, AcompaniamientoService.ID_ESTB_SALUD_GESTION_DE_SERVICIOS);
      this.hojaMensualAcompaniamientoCentroTratamientoEspecializado = this.getHojaMensualAcompaniamientoFromListByIdAcompaniamiento(data.hojaMensualAcompaniamientoList, AcompaniamientoService.ID_ACOMP_CENTRO_ESPECIALIZADO);
      this.hojaMensualAcompaniamientoCentroTratamientoSinSubsidioSedronar = this.getHojaMensualAcompaniamientoFromListByIdAcompaniamiento(data.hojaMensualAcompaniamientoList, AcompaniamientoService.ID_GESTION_SIN_SUBSIDIO);
      this.hojaMensualAcompaniamientoCentroTratamientoConSubsidioSedronar = this.getHojaMensualAcompaniamientoFromListByIdAcompaniamiento(data.hojaMensualAcompaniamientoList, AcompaniamientoService.ID_GESTION_CON_SUBSIDIO);
      this.hojaMensualAcompaniamientoEnSede = this.getHojaMensualAcompaniamientoFromListByIdAcompaniamiento(data.hojaMensualAcompaniamientoList, AcompaniamientoService.ID_GESTION_EN_SEDE);
      this.hojaMensualAcompaniamientoFueraDeSede = this.getHojaMensualAcompaniamientoFromListByIdAcompaniamiento(data.hojaMensualAcompaniamientoList, AcompaniamientoService.ID_GESTION_FUERA_DE_SEDE);
    } else {
      this.initHojaMensualAcompaniamientos();
    }
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
    this.hojaMensualAcompaniamientoGestionTurnos = new HojaMensualAcompaniamiento;
    this.hojaMensualAcompaniamientoGestionTramitesMedicacion = new HojaMensualAcompaniamiento;
    this.hojaMensualAcompaniamientoGestionServicios = new HojaMensualAcompaniamiento;
    this.hojaMensualAcompaniamientoCentroTratamientoEspecializado = new HojaMensualAcompaniamiento;
    this.hojaMensualAcompaniamientoCentroTratamientoSinSubsidioSedronar = new HojaMensualAcompaniamiento;
    this.hojaMensualAcompaniamientoCentroTratamientoConSubsidioSedronar = new HojaMensualAcompaniamiento;
    this.hojaMensualAcompaniamientoEnSede = new HojaMensualAcompaniamiento;
    this.hojaMensualAcompaniamientoFueraDeSede = new HojaMensualAcompaniamiento;

    this.hojaMensualAcompaniamientoGestionTurnos.acompaniamiento = this.acompaniamientoService.getAcompaniamientoById(this.acompaniamientos, AcompaniamientoService.ID_ESTB_SALUD_GESTION_DE_TURNOS);
    this.hojaMensualAcompaniamientoGestionTramitesMedicacion.acompaniamiento = this.acompaniamientoService.getAcompaniamientoById(this.acompaniamientos, AcompaniamientoService.ID_ESTB_SALUD_GESTION_DE_TRAMITES);
    this.hojaMensualAcompaniamientoGestionServicios.acompaniamiento = this.acompaniamientoService.getAcompaniamientoById(this.acompaniamientos, AcompaniamientoService.ID_ESTB_SALUD_GESTION_DE_SERVICIOS);
    this.hojaMensualAcompaniamientoCentroTratamientoEspecializado.acompaniamiento = this.acompaniamientoService.getAcompaniamientoById(this.acompaniamientos, AcompaniamientoService.ID_ACOMP_CENTRO_ESPECIALIZADO);
    this.hojaMensualAcompaniamientoCentroTratamientoSinSubsidioSedronar.acompaniamiento = this.acompaniamientoService.getAcompaniamientoById(this.acompaniamientos, AcompaniamientoService.ID_GESTION_SIN_SUBSIDIO);
    this.hojaMensualAcompaniamientoCentroTratamientoConSubsidioSedronar.acompaniamiento = this.acompaniamientoService.getAcompaniamientoById(this.acompaniamientos, AcompaniamientoService.ID_GESTION_CON_SUBSIDIO);
    this.hojaMensualAcompaniamientoEnSede.acompaniamiento = this.acompaniamientoService.getAcompaniamientoById(this.acompaniamientos, AcompaniamientoService.ID_GESTION_EN_SEDE);
    this.hojaMensualAcompaniamientoFueraDeSede.acompaniamiento = this.acompaniamientoService.getAcompaniamientoById(this.acompaniamientos, AcompaniamientoService.ID_GESTION_FUERA_DE_SEDE);
  }

  private cleanData(){
    this.hideFormAlert();
    this.mensualSeccionC3Data = new MensualSeccionC3Data;
  }

  private bindDataToDTO() {
    this.addAcompaniamientosToDTOList();
    this.mensualSeccionC3Data.hojaMensualObservaciones = this.hojaMensualObservaciones;
    this.setHojaIdToItems();
  }

  private addAcompaniamientosToDTOList() {
    this.mensualSeccionC3Data.hojaMensualAcompaniamientoList.push(this.hojaMensualAcompaniamientoGestionTurnos);
    this.mensualSeccionC3Data.hojaMensualAcompaniamientoList.push(this.hojaMensualAcompaniamientoGestionTramitesMedicacion);
    this.mensualSeccionC3Data.hojaMensualAcompaniamientoList.push(this.hojaMensualAcompaniamientoGestionServicios);
    this.mensualSeccionC3Data.hojaMensualAcompaniamientoList.push(this.hojaMensualAcompaniamientoCentroTratamientoEspecializado);
    this.mensualSeccionC3Data.hojaMensualAcompaniamientoList.push(this.hojaMensualAcompaniamientoCentroTratamientoSinSubsidioSedronar);
    this.mensualSeccionC3Data.hojaMensualAcompaniamientoList.push(this.hojaMensualAcompaniamientoCentroTratamientoConSubsidioSedronar);
    this.mensualSeccionC3Data.hojaMensualAcompaniamientoList.push(this.hojaMensualAcompaniamientoEnSede);
    this.mensualSeccionC3Data.hojaMensualAcompaniamientoList.push(this.hojaMensualAcompaniamientoFueraDeSede);
  }

  private setHojaIdToItems() {
    this.mensualSeccionC3Data.hojaMensualAcompaniamientoList.forEach(h => h.hoja.id = this.hojaId);
    this.mensualSeccionC3Data.hojaMensualObservaciones.hoja.id = this.hojaId;
  }

}
