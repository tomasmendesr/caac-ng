import { Component,  OnInit, ViewChild} from '@angular/core';
import {Observable} from "rxjs/Observable";
import {Provincia} from "../../../../model/provincia";
import {FormControl} from "@angular/forms";
import {PicsService} from "../../../services/pics.service";
import {map, startWith} from "rxjs/operators";
import {Hoja} from "../../../../model/hoja";
import {HeaderEvent} from "../../../../model/header-event";
import {MatOptionSelectionChange} from "@angular/material";
import {LoadingComponent} from "../../../../share-components/loading/loading.component";
import {HojaDatosInicialesService} from "../../../services/hoja-datos-iniciales.service";
import {HojaDatosIniciales} from "../../../../model/hoja-datos-iniciales";
import {Casa} from "../../../../model/casa";
import {AppResponse} from "../../../../model/app-response";
import {NotifUtil} from "../../../utils/notif-util";
import {HojaService} from "../../../services/hoja.service";
import {TipoHoja} from "../../../../fede/constants/tipo-hoja";
declare var $: any;
@Component({
  selector: 'app-mensual-seccion-a',
  templateUrl: './mensual-seccion-a.component.html',
  styleUrls: ['./mensual-seccion-a.component.css']
})
export class MensualSeccionAComponent implements OnInit {
  private hoja: Hoja = new Hoja;
  private hojaDatosIniciales: HojaDatosIniciales = new HojaDatosIniciales;
  private casaRecibidaDelHeader: Casa;
  private provinciaCtrl: FormControl = new FormControl();
  private provincias: Provincia[] = [];
  private filteredProvincias: Observable<Provincia[]>;
  private readonlyControl: boolean = true;
  private formMessages: string[] = [];
  @ViewChild(LoadingComponent) loadingComponent:LoadingComponent;

  constructor(private picsService: PicsService, private hojaService: HojaService, private hojaDatosInicialesService: HojaDatosInicialesService) { }

  ngOnInit() {
    this.initLists();
    this.provinciaCtrl.disable();
    this.hoja.tipoHoja = TipoHoja.MENSUAL;
  }

  private initLists(){
    this.picsService.findAllProvinciasCombo().subscribe(data => {
      this.provincias = data;
      this.filteredProvincias = this.provinciaCtrl.valueChanges
        .debounceTime(400)
        .distinctUntilChanged()
        .pipe(
          startWith(''),
          map(value => this.searchProvincia(value))
        );
    });
  }

  private searchProvincia(value: string): Provincia[] {
    if(value == null || !value) return this.provincias;
    const filterValue = value.toLowerCase();
    return this.provincias.filter(prov => prov.nombre.toLowerCase().includes(filterValue));
  }

  private selectedProvincia(event: MatOptionSelectionChange , provincia: Provincia){
    if(event.source.selected) this.hojaDatosIniciales.provinciaLight = provincia;
  }

  private onChangeHeader(headerEvent: HeaderEvent){
    this.readonlyControl = false;
    if(headerEvent.evento == HeaderEvent.CASA){
      this.casaRecibidaDelHeader = headerEvent.value[headerEvent.evento];
      this.hoja.casa = this.casaRecibidaDelHeader;
      if(this.hoja.casa) {
        this.hojaDatosIniciales.nombreCaac = this.hoja.casa.nomcaac;
        if(this.hoja.casa.provincia) {
          this.provinciaCtrl.setValue(this.hoja.casa.provincia.nombre);
          this.hojaDatosIniciales.provinciaLight = this.hoja.casa.provincia;
        }
        this.provinciaCtrl.enable();
      }
      else this.provinciaCtrl.disable();
    } else if(headerEvent.evento == HeaderEvent.MES_CARGA){
      this.hoja.mes = headerEvent.value[headerEvent.evento];
    } else if(headerEvent.evento == HeaderEvent.ANIO_CARGA){
      this.hoja.anio = headerEvent.value[headerEvent.evento];
    }
    this.readonlyControl = true;
  }

  private onClickGuardar() {
    if(this.validationOk()) {
      if (this.seDetectaronCambiosEnLaCaac()) {
        this.showConfirmDialog();
      } else {
        this.saveOrUpdateMensual();
      }
    }
  }

  private validationOk(): boolean {
    let errorMsgs: string[] = [];
    if(this.hoja.casa == null) errorMsgs.push("Debe seleccionar una CAAC");
    if(this.hoja.anio == null) errorMsgs.push("Debe seleccionar el año");
    if(this.hoja.mes == null) errorMsgs.push("Debe seleccionar el mes");
    if(errorMsgs.length == 0) return true;
    else this.showErrorMsgs(errorMsgs);
  }

  private seDetectaronCambiosEnLaCaac() {
    return (this.casaRecibidaDelHeader.provincia.id != this.hojaDatosIniciales.provinciaLight.id) ||
      (this.hojaDatosIniciales.nombreCaac != this.casaRecibidaDelHeader.nomcaac);
  }

  private onClickConfirmDialog(){
    this.hideConfirmDialog();
    this.saveOrUpdateMensual();
  }

  private saveOrUpdateMensual(){
    this.loadingComponent.showLoading();
    this.hojaDatosInicialesService.saveOrUpdateMensual(this.hoja, this.hojaDatosIniciales).subscribe(appResponse => {
      if(appResponse.code == AppResponse.SUCCESS){
        NotifUtil.notifSuccess("Guardado exitosamente");
        this.loadingComponent.hideLoading();
        this.hojaDatosIniciales = <HojaDatosIniciales> appResponse.data;
        this.hoja = this.hojaDatosIniciales.hoja;
      }else{
        this.showErrorMsgs(appResponse.data);
      }
    }, (error) => this.notifError(error));
  }

  private hideFormAlert() {
    $('#formAlert').hide();
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

  private showConfirmDialog(){
    $("#confirmDialog").modal({
      backdrop: 'static',
      keyboard: false,
      show: true
    });
  }

  private hideConfirmDialog(){
    $("#confirmDialog").modal('hide');
  }
}
