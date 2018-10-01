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
  private acompaniamientos: Acompaniamiento[] = [];
  private acompaniamientosEstablecimientoProfSalud: Acompaniamiento[] = [];
  private mensualSeccionC5Data: MensualSeccionC5Data = new MensualSeccionC5Data;

  private hojaMensualAcompaniamientoEscuela: HojaMensualAcompaniamiento = new HojaMensualAcompaniamiento;
  private hojaMensualAcompaniamientoActividadPrevencion: HojaMensualAcompaniamiento = new HojaMensualAcompaniamiento;
  private hojaMensualAcompaniamientoApoyoEscolar: HojaMensualAcompaniamiento = new HojaMensualAcompaniamiento;
  private hojaMensualAcompaniamientoInclusionEducativa: HojaMensualAcompaniamiento = new HojaMensualAcompaniamiento;
  private hojaMensualAcompaniamientoEscuelaEnSede: HojaMensualAcompaniamiento = new HojaMensualAcompaniamiento;

  private hojaMensualObservaciones: HojaMensualObservaciones = new HojaMensualObservaciones;
  private hojaMensualRecursosList: HojaMensualRecurso[] = [];
  private hojaMensualAcompaniamientosEstablecimientoProfSaludList: HojaMensualAcompaniamiento[] = [];

  constructor(private router: Router, private recursoService: RecursoService,
              private acompaniamientoService: AcompaniamientoService, private mensualSeccionCService: MensualSeccionCService) { }

  ngOnInit() {
    this.recursoService.findAll().subscribe(data => {
      this.recursos = data;
      this.initHojaMensualRecursosList();
    });
    this.acompaniamientoService.findAll().subscribe(data => {
      this.acompaniamientos = data;
      this.acompaniamientosEstablecimientoProfSalud = this.acompaniamientos.filter(a => a.establecimiento == AcompaniamientoService.ESTABLECIMIENTO_PROF_SALUD);
      this.initHojaMensualAcompaniamientoProfSaludList();
    });
  }

  private initHojaMensualRecursosList(){
    this.hojaMensualRecursosList = [];
    this.recursos.forEach(recurso => {
      let hojaMensualRecurso = new HojaMensualRecurso;
      hojaMensualRecurso.recurso = recurso;
      this.hojaMensualRecursosList.push(hojaMensualRecurso);
    });
  }

  private initHojaMensualAcompaniamientoProfSaludList(){
    this.hojaMensualAcompaniamientosEstablecimientoProfSaludList = [];
    this.acompaniamientosEstablecimientoProfSalud.forEach(acomp => {
      let hojaMensual = new HojaMensualAcompaniamiento;
      hojaMensual.acompaniamiento = acomp;
      this.hojaMensualAcompaniamientosEstablecimientoProfSaludList.push(hojaMensual);
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
    this.initHojaMensualAcompaniamiento();
  }

  private bindDataToDTO() {
    this.mensualSeccionC5Data.hojaMensualRecursoList = this.hojaMensualRecursosList;
    this.addAHojaMensualAcompaniamientoToDTOList(this.mensualSeccionC5Data.hojaMensualAcompaniamientoList);
    this.hojaMensualAcompaniamientosEstablecimientoProfSaludList.forEach(hm => this.mensualSeccionC5Data.hojaMensualAcompaniamientoList.push(hm));
    this.mensualSeccionC5Data.hojaMensualObservaciones = this.hojaMensualObservaciones;
    this.setHojaIdToItems();
  }


  private addAHojaMensualAcompaniamientoToDTOList(list: any[]) {
    list.push(this.hojaMensualAcompaniamientoEscuela  );
    list.push(this.hojaMensualAcompaniamientoApoyoEscolar   );
    list.push(this.hojaMensualAcompaniamientoInclusionEducativa  );
    list.push(this.hojaMensualAcompaniamientoEscuelaEnSede   );
  }

  private setHojaIdToItems() {
    this.mensualSeccionC5Data.hojaMensualRecursoList.forEach(h => h.hoja.id = this.hojaId);
    this.mensualSeccionC5Data.hojaMensualAcompaniamientoList.forEach(h => h.hoja.id = this.hojaId);
    this.mensualSeccionC5Data.hojaMensualObservaciones.hoja.id = this.hojaId;
  }

  private initHojaMensualAcompaniamiento() {
    this.initHojaMensualAcompaniamientoProfSaludList();
    this.hojaMensualAcompaniamientoEscuela = new HojaMensualAcompaniamiento;
    this.hojaMensualAcompaniamientoActividadPrevencion = new HojaMensualAcompaniamiento;
    this.hojaMensualAcompaniamientoApoyoEscolar = new HojaMensualAcompaniamiento;
    this.hojaMensualAcompaniamientoInclusionEducativa = new HojaMensualAcompaniamiento;
    this.hojaMensualAcompaniamientoEscuelaEnSede = new HojaMensualAcompaniamiento;

    this.hojaMensualAcompaniamientoEscuela.acompaniamiento = this.acompaniamientoService.getAcompaniamientoById(this.acompaniamientos, AcompaniamientoService.ID_ACOMP_ESCUELA);
    this.hojaMensualAcompaniamientoActividadPrevencion.acompaniamiento = this.acompaniamientoService.getAcompaniamientoById(this.acompaniamientos, AcompaniamientoService.ID_ACTIVIDADES_PREVENCION);
    this.hojaMensualAcompaniamientoApoyoEscolar.acompaniamiento = this.acompaniamientoService.getAcompaniamientoById(this.acompaniamientos, AcompaniamientoService.ID_APOYO_ESCOLAR);
    this.hojaMensualAcompaniamientoInclusionEducativa.acompaniamiento = this.acompaniamientoService.getAcompaniamientoById(this.acompaniamientos, AcompaniamientoService.ID_INCLUSION);
    this.hojaMensualAcompaniamientoEscuelaEnSede.acompaniamiento = this.acompaniamientoService.getAcompaniamientoById(this.acompaniamientos, AcompaniamientoService.ID_ESCUELA_EN_SEDE);
  }

  private parseSeccionC5Data(data: MensualSeccionC5Data) {
    this.hojaMensualObservaciones = data.hojaMensualObservaciones ? data.hojaMensualObservaciones : new HojaMensualObservaciones;
    this.buildHojaMensualRecursos(data);
    this.buildHojaMensualAcompaniamientos(data);
  }

  private buildHojaMensualRecursos(data: MensualSeccionC5Data) {
    if (data.hojaMensualRecursoList) {
      this.hojaMensualRecursosList = data.hojaMensualRecursoList;
    } else {
      this.initHojaMensualRecursosList();
    }
    this.loadingComponent.hideLoading();
  }

  private getHojaMensualAcompaniamientoFromListByIdAcompaniamiento(list: HojaMensualAcompaniamiento[], id: number): HojaMensualAcompaniamiento {
    let hojMensualAcomp = list.find(a => a.acompaniamiento.id == id);
    if(hojMensualAcomp == null){
      hojMensualAcomp = new HojaMensualAcompaniamiento;
      hojMensualAcomp.acompaniamiento = this.acompaniamientoService.getAcompaniamientoById(this.acompaniamientos, id);
    }
    return hojMensualAcomp;
  }

  private buildHojaMensualAcompaniamientos(data: MensualSeccionC5Data) {
    if (data.hojaMensualAcompaniamientoList) {
      this.hojaMensualAcompaniamientosEstablecimientoProfSaludList = this.acompaniamientoService.filterByEstablecimiento(data.hojaMensualAcompaniamientoList, AcompaniamientoService.ESTABLECIMIENTO_PROF_SALUD);

      this.hojaMensualAcompaniamientoEscuela = this.getHojaMensualAcompaniamientoFromListByIdAcompaniamiento(data.hojaMensualAcompaniamientoList, AcompaniamientoService.ID_ACOMP_ESCUELA);
      this.hojaMensualAcompaniamientoActividadPrevencion = this.getHojaMensualAcompaniamientoFromListByIdAcompaniamiento(data.hojaMensualAcompaniamientoList, AcompaniamientoService.ID_ACTIVIDADES_PREVENCION);
      this.hojaMensualAcompaniamientoApoyoEscolar = this.getHojaMensualAcompaniamientoFromListByIdAcompaniamiento(data.hojaMensualAcompaniamientoList, AcompaniamientoService.ID_APOYO_ESCOLAR);
      this.hojaMensualAcompaniamientoInclusionEducativa = this.getHojaMensualAcompaniamientoFromListByIdAcompaniamiento(data.hojaMensualAcompaniamientoList, AcompaniamientoService.ID_INCLUSION);
      this.hojaMensualAcompaniamientoEscuelaEnSede = this.getHojaMensualAcompaniamientoFromListByIdAcompaniamiento(data.hojaMensualAcompaniamientoList, AcompaniamientoService.ID_ESCUELA_EN_SEDE);
    } else {
      this.initHojaMensualAcompaniamiento();
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
    this.mensualSeccionC5Data = new MensualSeccionC5Data;
  }


}
