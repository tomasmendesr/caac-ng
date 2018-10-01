import {Component, OnInit, ViewChild} from '@angular/core';
import {HeaderEvent} from "../../../../model/header-event";
import {NotifUtil} from "../../../utils/notif-util";
import {HojaMensualAlimentacion} from "../../../../model/hoja-mensual-alimentacion";
import {HojaMensualTramites} from "../../../../model/hoja-mensual-tramites";
import {HojaMensualObservaciones} from "../../../../model/hoja-mensual-observaciones";
import {TramiteService} from "../../../services/tramite.service";
import {Tramite} from "../../../../model/tramite";
import {MensualSeccionC1Data} from "../../../model/mensual-seccion-c1-data";
import {AlimentacionService} from "../../../services/alimentacion.service";
import {MensualSeccionCService} from "../../../services/mensual-seccion-c.service";
import {AppResponse} from "../../../../model/app-response";
import {LoadingComponent} from "../../../../share-components/loading/loading.component";
import {Alimentacion} from "../../../../model/alimentacion";
import {UrlConstants} from "../../../services/UrlConstants";
import {Router} from "@angular/router";
declare var $:any;
@Component({
  selector: 'app-mensual-seccion-c1',
  templateUrl: './mensual-seccion-c1.component.html',
  styleUrls: ['./mensual-seccion-c1.component.css']
})
export class MensualSeccionC1Component implements OnInit {
  private readonlyControl: boolean = true;
  private formMessages: string[] = [];
  private errorSection: number = -1;
  private mensualSeccionC1Data: MensualSeccionC1Data = new MensualSeccionC1Data;
  private hojaId: number;
  @ViewChild(LoadingComponent) loadingComponent:LoadingComponent;
  private tramites: Tramite[] = [];
  private alimentacionesEnSede: Alimentacion[] = [];
  private alimentacionesFueraDeSede: Alimentacion[] = [];

  private hojaMensualObservaciones: HojaMensualObservaciones = new HojaMensualObservaciones;
  private hojaMensualTramitesList: HojaMensualTramites[] =  [];
  private hojaMensualAlimentacionEnSedeList: HojaMensualAlimentacion[] =  [];
  private hojaMensualAlimentacionFueraDeSedeList: HojaMensualAlimentacion[] =  [];


  constructor(private tramiteService: TramiteService, private alimentacionService: AlimentacionService,
              private mensualSeccionCService: MensualSeccionCService, private router: Router) {
  }

  ngOnInit() {
    this.tramiteService.findAll().subscribe(data => {
      this.tramites = data;
      this.initHojaMensualTramitesList();
    });
    this.alimentacionService.findAllEnSede().subscribe(data => {
      this.alimentacionesEnSede = data;
      this.initHojaMensualAlimentacionEnSedeList();
    });
    this.alimentacionService.findAllFueraDeSede().subscribe(data => {
      this.alimentacionesFueraDeSede = data;
      this.initHojaMensualAlimentacionFueraDeSedeList();
    });
  }

  private initHojaMensualTramitesList(){
    this.hojaMensualTramitesList = [];
    this.tramites.forEach(tramite => {
      let hojaMensual = new HojaMensualTramites;
      hojaMensual.tramite = tramite;
      this.hojaMensualTramitesList.push(hojaMensual);
    });
  }

  private initHojaMensualAlimentacionEnSedeList(){
    this.hojaMensualAlimentacionEnSedeList = [];
    this.alimentacionesEnSede.forEach(a => {
      let hojaMensual = new HojaMensualAlimentacion;
      hojaMensual.tipoAlimentacion = a;
      this.hojaMensualAlimentacionEnSedeList.push(hojaMensual);
    });
  }

  private initHojaMensualAlimentacionFueraDeSedeList(){
    this.hojaMensualAlimentacionFueraDeSedeList = [];
    this.alimentacionesFueraDeSede.forEach(a => {
      let hojaMensual = new HojaMensualAlimentacion;
      hojaMensual.tipoAlimentacion = a;
      this.hojaMensualAlimentacionFueraDeSedeList.push(hojaMensual);
    });
  }

  private onChangeHeader(headerEvent: HeaderEvent) {
    if (headerEvent.evento == HeaderEvent.HOJA_ID) {
      this.readonlyControl = headerEvent.value.hojaId == null;
      this.hojaId = headerEvent.value.hojaId;
      if (headerEvent.value.hojaId) {
        this.loadingComponent.showLoading();
        this.mensualSeccionCService.findDataSeccionC1ByHojaId(headerEvent.value.hojaId).subscribe(data => this.parseSeccionC1Data(data));
      } else {
        this.initEmptyData();
      }
    }
  }

  private onClickGuardar() {
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
    this.router.navigateByUrl(UrlConstants.MENSUAL_SECCION_C2);
  }

  private onClickConfirmDialogSiguiente(){
    this.loadingComponent.showLoading();
    this.mensualSeccionCService.saveDataSeccionC1(this.mensualSeccionC1Data).subscribe(appResponse => {
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
    this.initHojaMensualTramitesList();
    this.initHojaMensualAlimentacionEnSedeList();
    this.initHojaMensualAlimentacionFueraDeSedeList();
  }

  private bindDataToDTO() {
    this.mensualSeccionC1Data.hojaMensualTramitesList = this.hojaMensualTramitesList;
    this.mensualSeccionC1Data.hojaMensualAlimentacionEnSedeList = this.hojaMensualAlimentacionEnSedeList
    this.mensualSeccionC1Data.hojaMensualAlimentacionFueraDeSedeList = this.hojaMensualAlimentacionFueraDeSedeList
    this.mensualSeccionC1Data.hojaMensualObservaciones = this.hojaMensualObservaciones;
    this.setHojaIdToItems();
  }


  private setHojaIdToItems() {
    this.mensualSeccionC1Data.hojaMensualTramitesList.forEach(h => h.hoja.id = this.hojaId);
    this.mensualSeccionC1Data.hojaMensualAlimentacionEnSedeList.forEach(h => h.hoja.id = this.hojaId);
    this.mensualSeccionC1Data.hojaMensualAlimentacionFueraDeSedeList.forEach(h => h.hoja.id = this.hojaId);
    this.mensualSeccionC1Data.hojaMensualObservaciones.hoja.id = this.hojaId;
  }

  private parseSeccionC1Data(data: MensualSeccionC1Data) {
    this.hojaMensualObservaciones = data.hojaMensualObservaciones ? data.hojaMensualObservaciones : new HojaMensualObservaciones;
    this.buildHojaMensualTramites(data);
    this.buildHojaMensualAlimentacionEnSede(data);
    this.buildHojaMensualAlimentacionFueraDeSede(data);
  }

  private buildHojaMensualTramites(data: MensualSeccionC1Data) {
    if (data.hojaMensualTramitesList) {
      this.hojaMensualTramitesList = data.hojaMensualTramitesList;
    } else {
      this.initHojaMensualTramitesList();
    }
    this.loadingComponent.hideLoading();
  }


  private buildHojaMensualAlimentacionEnSede(data: MensualSeccionC1Data) {
    if (data.hojaMensualAlimentacionEnSedeList) {
      this.hojaMensualAlimentacionEnSedeList = data.hojaMensualAlimentacionEnSedeList;
    } else {
      this.initHojaMensualAlimentacionEnSedeList();
    }
  }

  private buildHojaMensualAlimentacionFueraDeSede(data: MensualSeccionC1Data) {
    if (data.hojaMensualAlimentacionFueraDeSedeList) {
      this.hojaMensualAlimentacionFueraDeSedeList = data.hojaMensualAlimentacionFueraDeSedeList;
    } else {
      this.initHojaMensualAlimentacionFueraDeSedeList();
    }
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
    this.mensualSeccionC1Data = new MensualSeccionC1Data;
  }

}
