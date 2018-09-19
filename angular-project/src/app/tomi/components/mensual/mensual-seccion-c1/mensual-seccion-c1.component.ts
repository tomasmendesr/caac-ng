import {Component, OnInit, ViewChild} from '@angular/core';
import {HeaderEvent} from "../../../../model/header-event";
import {NotifUtil} from "../../../utils/notif-util";
import {HojaMensualAlimentacion} from "../../../../model/hoja-mensual-alimentacion";
import {HojaMensualTramites} from "../../../../model/hoja-mensual-tramites";
import {HojaMensualObservaciones} from "../../../../model/hoja-mensual-observaciones";
import {TramiteService} from "../../../services/tramite.service";
import {Tramite} from "../../../../model/tramite";
import {MensualSeccionC1Data} from "../../../../model/mensual-seccion-c1-data";
import {AlimentacionService} from "../../../services/alimentacion.service";
import {MensualSeccionCService} from "../../../services/mensual-seccion-c.service";
import {AppResponse} from "../../../../model/app-response";
import {LoadingComponent} from "../../../../share-components/loading/loading.component";
import {Alimentacion} from "../../../../model/alimentacion";
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
  private alimentaciones: Alimentacion[] = [];

  private hojaMensualObservaciones: HojaMensualObservaciones = new HojaMensualObservaciones;

  private hojaMensualTramiteDNI: HojaMensualTramites = new HojaMensualTramites;
  private hojaMensualTramiteSubsidios: HojaMensualTramites = new HojaMensualTramites;
  private hojaMensualTramiteBecas: HojaMensualTramites = new HojaMensualTramites;
  private hojaMensualTramiteCertificadoDiscapacidad: HojaMensualTramites = new HojaMensualTramites;
  private hojaMensualTramiteInsercionLaboral: HojaMensualTramites = new HojaMensualTramites;
  private hojaMensualTramiteServiciosPrevisionales: HojaMensualTramites = new HojaMensualTramites;
  private hojaMensualTramiteGestiones: HojaMensualTramites = new HojaMensualTramites;
  private hojaMensualTramiteOtro: HojaMensualTramites = new HojaMensualTramites;

  private hojaMensualAlimentacionDesayuno: HojaMensualAlimentacion = new HojaMensualAlimentacion;
  private hojaMensualAlimentacionAlmuerzo: HojaMensualAlimentacion = new HojaMensualAlimentacion;
  private hojaMensualAlimentacionMerienda: HojaMensualAlimentacion = new HojaMensualAlimentacion;
  private hojaMensualAlimentacionCena: HojaMensualAlimentacion = new HojaMensualAlimentacion;
  private hojaMensualAlimentacionViandas: HojaMensualAlimentacion = new HojaMensualAlimentacion;
  private hojaMensualAlimentacionBolsones: HojaMensualAlimentacion = new HojaMensualAlimentacion;

  constructor(private tramiteService: TramiteService, private alimentacionService: AlimentacionService,
              private mensualSeccionCService: MensualSeccionCService) {
  }

  ngOnInit() {
    this.tramiteService.findAll().subscribe(data => this.tramites = data);
    this.alimentacionService.findAll().subscribe(data => this.alimentaciones = data);
  }

  private onChangeHeader(headerEvent: HeaderEvent) {
    if (headerEvent.evento == HeaderEvent.HOJA_ID) {
      this.hojaId = headerEvent.value.hojaId;
      if (headerEvent.value.hojaId) {
        this.readonlyControl = false;
        this.mensualSeccionCService.findDataByHojaId(headerEvent.value.hojaId).subscribe(data => this.parseSeccionC1Data(data));
      } else {
        this.initEmptyData();
        this.readonlyControl = true;
        if (headerEvent.value.casa && headerEvent.value.mesCarga && headerEvent.value.anioCarga) NotifUtil.notifError("No se encontró ninguna hoja para el período indicado");
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

  private initEmptyData() {
    this.hojaMensualObservaciones = new HojaMensualObservaciones;
    this.initHojaMensualTramites();
    this.initHojaMensualAlimentacion();
  }

  private bindDataToDTO() {
    this.addTramitesToDTOList();
    this.addAlimentacionToDTOList();
    this.mensualSeccionC1Data.hojaMensualObservaciones = this.hojaMensualObservaciones;
    this.setHojaIdToItems();
  }

  private addAlimentacionToDTOList() {
    this.mensualSeccionC1Data.hojaMensualAlimentacionList.push(this.hojaMensualAlimentacionDesayuno);
    this.mensualSeccionC1Data.hojaMensualAlimentacionList.push(this.hojaMensualAlimentacionCena);
    this.mensualSeccionC1Data.hojaMensualAlimentacionList.push(this.hojaMensualAlimentacionAlmuerzo);
    this.mensualSeccionC1Data.hojaMensualAlimentacionList.push(this.hojaMensualAlimentacionMerienda);
    this.mensualSeccionC1Data.hojaMensualAlimentacionList.push(this.hojaMensualAlimentacionViandas);
    this.mensualSeccionC1Data.hojaMensualAlimentacionList.push(this.hojaMensualAlimentacionBolsones);
  }

  private addTramitesToDTOList() {
    this.mensualSeccionC1Data.hojaMensualTramitesList.push(this.hojaMensualTramiteDNI);
    this.mensualSeccionC1Data.hojaMensualTramitesList.push(this.hojaMensualTramiteServiciosPrevisionales);
    this.mensualSeccionC1Data.hojaMensualTramitesList.push(this.hojaMensualTramiteBecas);
    this.mensualSeccionC1Data.hojaMensualTramitesList.push(this.hojaMensualTramiteGestiones);
    this.mensualSeccionC1Data.hojaMensualTramitesList.push(this.hojaMensualTramiteOtro);
    this.mensualSeccionC1Data.hojaMensualTramitesList.push(this.hojaMensualTramiteSubsidios);
    this.mensualSeccionC1Data.hojaMensualTramitesList.push(this.hojaMensualTramiteInsercionLaboral);
    this.mensualSeccionC1Data.hojaMensualTramitesList.push(this.hojaMensualTramiteCertificadoDiscapacidad);
  }

  private setHojaIdToItems() {
    this.mensualSeccionC1Data.hojaMensualTramitesList.forEach(h => h.hoja.id = this.hojaId);
    this.mensualSeccionC1Data.hojaMensualAlimentacionList.forEach(h => h.hoja.id = this.hojaId);
    this.hojaMensualObservaciones.hoja.id = this.hojaId;
  }

  private initHojaMensualTramites() {
    this.hojaMensualTramiteDNI = new HojaMensualTramites;
    this.hojaMensualTramiteSubsidios = new HojaMensualTramites;
    this.hojaMensualTramiteBecas = new HojaMensualTramites;
    this.hojaMensualTramiteCertificadoDiscapacidad = new HojaMensualTramites;
    this.hojaMensualTramiteInsercionLaboral = new HojaMensualTramites;
    this.hojaMensualTramiteServiciosPrevisionales = new HojaMensualTramites;
    this.hojaMensualTramiteGestiones = new HojaMensualTramites;
    this.hojaMensualTramiteOtro = new HojaMensualTramites;

    this.hojaMensualTramiteDNI.tramite = this.tramiteService.getTramiteById(this.tramites, TramiteService.ID_DNI);
    this.hojaMensualTramiteSubsidios.tramite = this.tramiteService.getTramiteById(this.tramites, TramiteService.ID_SUBSIDIOS);
    this.hojaMensualTramiteInsercionLaboral.tramite = this.tramiteService.getTramiteById(this.tramites, TramiteService.ID_INSERCION_LABORAL);
    this.hojaMensualTramiteServiciosPrevisionales.tramite = this.tramiteService.getTramiteById(this.tramites, TramiteService.ID_SERVICIOS_PREVISIONALES);
    this.hojaMensualTramiteBecas.tramite = this.tramiteService.getTramiteById(this.tramites, TramiteService.ID_BECAS);
    this.hojaMensualTramiteGestiones.tramite = this.tramiteService.getTramiteById(this.tramites, TramiteService.ID_GESTIONES);
    this.hojaMensualTramiteCertificadoDiscapacidad.tramite = this.tramiteService.getTramiteById(this.tramites, TramiteService.ID_CERTIFICADO_DISCAPACIDAD);
    this.hojaMensualTramiteOtro.tramite = this.tramiteService.getTramiteById(this.tramites, TramiteService.ID_OTROS);
  }

  private initHojaMensualAlimentacion() {
    this.hojaMensualAlimentacionDesayuno = new HojaMensualAlimentacion;
    this.hojaMensualAlimentacionAlmuerzo = new HojaMensualAlimentacion;
    this.hojaMensualAlimentacionMerienda = new HojaMensualAlimentacion;
    this.hojaMensualAlimentacionCena = new HojaMensualAlimentacion;
    this.hojaMensualAlimentacionViandas = new HojaMensualAlimentacion;
    this.hojaMensualAlimentacionBolsones = new HojaMensualAlimentacion;

    this.hojaMensualAlimentacionAlmuerzo.tipoAlimentacion = this.alimentacionService.getAlimentacionById(this.alimentaciones, AlimentacionService.ID_ALMUERZO);
    this.hojaMensualAlimentacionDesayuno.tipoAlimentacion = this.alimentacionService.getAlimentacionById(this.alimentaciones, AlimentacionService.ID_DESAYUNO);
    this.hojaMensualAlimentacionMerienda.tipoAlimentacion = this.alimentacionService.getAlimentacionById(this.alimentaciones, AlimentacionService.ID_MERIENDA);
    this.hojaMensualAlimentacionCena.tipoAlimentacion = this.alimentacionService.getAlimentacionById(this.alimentaciones, AlimentacionService.ID_CENA);
    this.hojaMensualAlimentacionViandas.tipoAlimentacion = this.alimentacionService.getAlimentacionById(this.alimentaciones, AlimentacionService.ID_VIANDAS);
    this.hojaMensualAlimentacionBolsones.tipoAlimentacion = this.alimentacionService.getAlimentacionById(this.alimentaciones, AlimentacionService.ID_BOLSONES);
  }

  private parseSeccionC1Data(data: MensualSeccionC1Data) {
    this.hojaMensualObservaciones = data.hojaMensualObservaciones ? data.hojaMensualObservaciones : new HojaMensualObservaciones;
    this.buildHojaMensualTramites(data);
    this.buildHojaMensualAlimentacion(data);
  }

  private buildHojaMensualTramites(data: MensualSeccionC1Data) {
    if (data.hojaMensualTramitesList) {
      this.hojaMensualTramiteDNI = this.getHojaMensualTramiteFromListByIdTramite(data.hojaMensualTramitesList, TramiteService.ID_DNI);
        this.hojaMensualTramiteSubsidios = this.getHojaMensualTramiteFromListByIdTramite(data.hojaMensualTramitesList, TramiteService.ID_SUBSIDIOS);
      this.hojaMensualTramiteCertificadoDiscapacidad = this.getHojaMensualTramiteFromListByIdTramite(data.hojaMensualTramitesList, TramiteService.ID_CERTIFICADO_DISCAPACIDAD);
      this.hojaMensualTramiteServiciosPrevisionales = this.getHojaMensualTramiteFromListByIdTramite(data.hojaMensualTramitesList, TramiteService.ID_SERVICIOS_PREVISIONALES);
      this.hojaMensualTramiteInsercionLaboral = this.getHojaMensualTramiteFromListByIdTramite(data.hojaMensualTramitesList, TramiteService.ID_INSERCION_LABORAL);
      this.hojaMensualTramiteGestiones = this.getHojaMensualTramiteFromListByIdTramite(data.hojaMensualTramitesList, TramiteService.ID_GESTIONES);
      this.hojaMensualTramiteBecas = this.getHojaMensualTramiteFromListByIdTramite(data.hojaMensualTramitesList, TramiteService.ID_BECAS);
      this.hojaMensualTramiteOtro = this.getHojaMensualTramiteFromListByIdTramite(data.hojaMensualTramitesList, TramiteService.ID_OTROS);
    } else {
      this.initHojaMensualTramites();
    }
  }

  private getHojaMensualTramiteFromListByIdTramite(list: HojaMensualTramites[], idTramite: number): HojaMensualTramites {
    let hojaMensualTramite = list.find(t => t.tramite.id == idTramite);
    if(hojaMensualTramite == null){
      hojaMensualTramite = new HojaMensualTramites;
      hojaMensualTramite.tramite = this.tramiteService.getTramiteById(this.tramites, idTramite);
    }
    return hojaMensualTramite;
  }

  private getHojaMensualAlimentacionFromListByIdAlimentacion(list: HojaMensualAlimentacion[], idAlimentacion: number): HojaMensualAlimentacion {
    let hojMensualAlimentacion = list.find(a => a.tipoAlimentacion.id == idAlimentacion);
    if(hojMensualAlimentacion == null){
      hojMensualAlimentacion = new HojaMensualAlimentacion;
      hojMensualAlimentacion.tipoAlimentacion = this.alimentacionService.getAlimentacionById(this.alimentaciones, idAlimentacion);
    }
    return hojMensualAlimentacion;
  }

  private buildHojaMensualAlimentacion(data: MensualSeccionC1Data) {
    if (data.hojaMensualAlimentacionList) {
      this.hojaMensualAlimentacionAlmuerzo = this.getHojaMensualAlimentacionFromListByIdAlimentacion(data.hojaMensualAlimentacionList, AlimentacionService.ID_ALMUERZO);
      this.hojaMensualAlimentacionDesayuno = this.getHojaMensualAlimentacionFromListByIdAlimentacion(data.hojaMensualAlimentacionList, AlimentacionService.ID_DESAYUNO);
      this.hojaMensualAlimentacionMerienda = this.getHojaMensualAlimentacionFromListByIdAlimentacion(data.hojaMensualAlimentacionList, AlimentacionService.ID_MERIENDA);
      this.hojaMensualAlimentacionCena = this.getHojaMensualAlimentacionFromListByIdAlimentacion(data.hojaMensualAlimentacionList, AlimentacionService.ID_CENA);
      this.hojaMensualAlimentacionViandas = this.getHojaMensualAlimentacionFromListByIdAlimentacion(data.hojaMensualAlimentacionList, AlimentacionService.ID_VIANDAS);
      this.hojaMensualAlimentacionBolsones = this.getHojaMensualAlimentacionFromListByIdAlimentacion(data.hojaMensualAlimentacionList, AlimentacionService.ID_BOLSONES);
    } else {
      this.initHojaMensualAlimentacion();
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
    this.mensualSeccionC1Data = new MensualSeccionC1Data;
  }

}
