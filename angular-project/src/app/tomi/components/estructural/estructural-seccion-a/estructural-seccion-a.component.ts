import {Component, OnInit, ViewChild} from '@angular/core';
import {HeaderEvent} from "../../../../model/header-event";
import {ProvinciaLight} from "commons-model/model/geo/ProvinciaLight";
import {Observable} from "rxjs/Observable";
import {FormControl} from "@angular/forms";
import {Municipio} from "commons-model/model/geo/Municipio";
import {DepartamentoLight} from "commons-model/model/geo/DepartamentoLight";
import {LocalidadLight} from "commons-model/model/geo/LocalidadLight";
import {MatOptionSelectionChange} from "@angular/material";
import {AlternativaAsistencial} from "../../../../model/alternativa-asistencial";
import {AlternativaAsistencialService} from "../../../services/alternativa-asistencial.service";
import {HojaDatosIniciales} from "../../../../model/hoja-datos-iniciales";
import {HojaAlternativasAsistenciales} from "../../../../model/hoja-alternativas-asistenciales";
import {EstructuralService} from "../../../services/estructural.service";
import {EstructuralSeccionAData} from "../../../model/estructural-seccion-a-data";
import {LoadingComponent} from "../../../../share-components/loading/loading.component";
import {AppResponse} from "../../../../model/app-response";
import {NotifUtil} from "../../../utils/notif-util";
import {UrlConstants} from "../../../services/UrlConstants";
import {Router} from "@angular/router";
import {Hoja} from "../../../../model/hoja";
import {TipoHoja} from "../../../../fede/constants/tipo-hoja";
import {Casa} from "../../../../model/casa";
import {PicsService} from "../../../services/pics.service";
import {map, startWith} from "rxjs/operators";
declare var $:any;
@Component({
  selector: 'app-estructural-seccion-a',
  templateUrl: './estructural-seccion-a.component.html',
  styleUrls: ['./estructural-seccion-a.component.css']
})
export class EstructuralSeccionAComponent implements OnInit {
  private readonlyControl: boolean = true;
  private formMessages: string[] = [];
  private estructuralSeccionAData: EstructuralSeccionAData = new EstructuralSeccionAData;
  private hoja: Hoja = new Hoja;
  @ViewChild(LoadingComponent) loadingComponent:LoadingComponent;

  private provincias: ProvinciaLight[] = [];
  private filteredProvincias: Observable<ProvinciaLight[]>;
  private provinciaCtrl: FormControl = new FormControl();

  private municipios: Municipio[] = [];
  private filteredMunicipios: Observable<Municipio[]>;
  private municipioCtrl: FormControl = new FormControl();

  private departamentos: DepartamentoLight[] = [];
  private filteredDepartamentos: Observable<DepartamentoLight[]>;
  private departamentoCtrl: FormControl = new FormControl();

  private localidades: LocalidadLight[] = [];
  private filteredLocalidades: Observable<LocalidadLight[]>;
  private localidadCtrl: FormControl = new FormControl();

  private alternativasAsistenciales: AlternativaAsistencial[] = [];
  private hojaDatosIniciales: HojaDatosIniciales = new HojaDatosIniciales;
  private hojaAlternativasAsistencialesList: HojaAlternativasAsistenciales[] = [];

  private cbAnexosChecked: boolean = false;
  private otroIsChecked: boolean = false;
  private alternativaAsistencialOtroDescripcion: string = '';

  constructor(private alternativaAsistencialService: AlternativaAsistencialService, private estructuralService: EstructuralService,
              private router: Router, private picsService: PicsService) { }

  ngOnInit() {
    this.hoja.tipoHoja = TipoHoja.ESTRUCTURAL;
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
    this.alternativaAsistencialService.findAll().subscribe(data => {
      this.alternativasAsistenciales = data;
      this.initHojaAlternativasAsistencialesList();
    } );
    this.disableAllGeoInputs();
  }

  private onChangeHeader(headerEvent: HeaderEvent) {
    this.readonlyControl = !(headerEvent.value.anioCarga && headerEvent.value.mesCarga != null && headerEvent.value.casa != null);
    if(headerEvent.evento == HeaderEvent.CASA){
      this.bindCasa(headerEvent.value[headerEvent.evento]);
    } else if(headerEvent.evento == HeaderEvent.MES_CARGA){
      this.hoja.mes = headerEvent.value[headerEvent.evento];
    } else if(headerEvent.evento == HeaderEvent.ANIO_CARGA){
      this.hoja.anio = headerEvent.value[headerEvent.evento];
    } else if(headerEvent.evento == HeaderEvent.HOJA_ID){
      this.hoja.id = headerEvent.value.hojaId;
      if(this.hoja.id) this.estructuralService.findDataSeccionAByHojaId(headerEvent.value.hojaId).subscribe(data => this.parseData(data));
    }
  }

  private bindCasa(casa: Casa){
    this.hoja.casa = casa;
    if(this.hoja.casa != null) {
      this.hojaDatosIniciales.nombreCaac = this.hoja.casa.nomcaac;
      this.provinciaCtrl.enable();
      if(this.hoja.casa.provincia) {
        this.provinciaCtrl.setValue(this.hoja.casa.provincia.nombre);
        this.hojaDatosIniciales.provinciaLight = this.hoja.casa.provincia;
        this.provinciaCtrl.disable();
        this.municipioCtrl.enable();
      }
    }
  }

  private initHojaAlternativasAsistencialesList(){
    this.hojaAlternativasAsistencialesList = [];
    this.completeHojaAlternativasAsistencialesList();
  }

  private completeHojaAlternativasAsistencialesList(){
    this.alternativasAsistenciales.forEach(alt => {
      if(this.hojaAlternativasAsistencialesList.find(h => h.alternativaAsistencial.id == alt.id) == null) {
        let hoja = new HojaAlternativasAsistenciales;
        hoja.alternativaAsistencial = alt;
        this.hojaAlternativasAsistencialesList.push(hoja);
      }
    });
  }

  private onClickGuardar() {
    this.cleanData();
    this.bindDataToDTO();
    this.loadingComponent.showLoading();
    this.estructuralService.saveDataSeccioA(this.estructuralSeccionAData).subscribe(appResponse => {
      if(appResponse.code == AppResponse.SUCCESS){
        NotifUtil.notifSuccess("Guardado exitosamente");
        this.loadingComponent.hideLoading();
        this.cleanData();
      }else{
        this.showErrorMsgs(appResponse.data);
      }
    }, (error) => this.notifError(error));
  }

  private bindDataToDTO() {
    this.estructuralSeccionAData.hojaDatosIniciales = this.hojaDatosIniciales;
    this.estructuralSeccionAData.hojaAlternativasAsistencialesList = this.hojaAlternativasAsistencialesList;
    this.estructuralSeccionAData.hojaAlternativasAsistencialesList.forEach(h => {
      h.descripcion = h.alternativaAsistencial.descripcion;
      if(this.otroIsChecked && this.alternativaAsistencialService.isOptionOtro(h.alternativaAsistencial)) h.descripcion = this.alternativaAsistencialOtroDescripcion;
    });
    this.estructuralSeccionAData.hoja = this.hoja;
  }

  private parseData(data: EstructuralSeccionAData) {
    this.hojaDatosIniciales = data.hojaDatosIniciales ? data.hojaDatosIniciales : new HojaDatosIniciales;
    this.hoja = data.hoja ? data.hoja : new Hoja;
    this.buildHojaAlternativasAsistenciales(data);
  }

  private buildHojaAlternativasAsistenciales(data: EstructuralSeccionAData) {
    this.hojaAlternativasAsistencialesList = data.hojaAlternativasAsistencialesList;
    this.hojaAlternativasAsistencialesList.forEach(h => {
      h.isChecked = true;
      if(this.alternativaAsistencialService.isOptionOtro(h.alternativaAsistencial)){
        this.otroIsChecked = true;
        this.alternativaAsistencialOtroDescripcion = h.descripcion;
      }
    });
    if(this.hojaAlternativasAsistencialesList.length != this.alternativasAsistenciales.length){
      this.completeHojaAlternativasAsistencialesList();
    }
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
    this.router.navigateByUrl(UrlConstants.ESTRUCTURAL_SECCION_B);
  }

  private onClickConfirmDialogSiguiente(){
    this.cleanData();
    this.bindDataToDTO();
    this.loadingComponent.showLoading();
    this.estructuralService.saveDataSeccioA(this.estructuralSeccionAData).subscribe(appResponse => {
      if(appResponse.code == AppResponse.SUCCESS){
        this.loadingComponent.hideLoading();
        this.siguiente();
      }else{
        this.showErrorMsgs(appResponse.data);
      }
    }, (error) => this.notifError(error));
  }

  private disableAllGeoInputs(){
    this.provinciaCtrl.disable();
    this.municipioCtrl.disable();
    this.departamentoCtrl.disable();
    this.localidadCtrl.disable();
  }

  private selectedProvincia(event: MatOptionSelectionChange , provincia: ProvinciaLight){
    if(event.source.selected) {
      this.picsService.findAllDepartamentosByProvincia(provincia).subscribe(data =>{
        this.departamentos = data;
        this.filteredDepartamentos = this.departamentoCtrl.valueChanges
          .debounceTime(400)
          .distinctUntilChanged()
          .pipe(
            startWith(''),
            map(value => this.searchDepartamento(value))
          );
      });
      this.departamentoCtrl.enable();
    }
  }

  private searchProvincia(value: string): ProvinciaLight[] {
    if(value == null || !value) return this.provincias;
    const filterValue = value.toLowerCase();
    return this.provincias.filter(prov => prov.nombre.toLowerCase().includes(filterValue));
  }

  private selectedDepartamento(event: MatOptionSelectionChange , departamento: DepartamentoLight){
    this.hojaDatosIniciales.departamentoLight = null;
    if(event.source.selected) {
      this.hojaDatosIniciales.departamentoLight = departamento;
      this.localidadCtrl.enable();
      this.municipioCtrl.enable();
      this.picsService.findMunicipiosByDepartamentoId(departamento.id).subscribe(data =>{
        this.municipios = data;
        this.filteredMunicipios = this.municipioCtrl.valueChanges
          .debounceTime(400)
          .distinctUntilChanged()
          .pipe(
            startWith(''),
            map(value => this.searchMunicipio(value))
          );
      });
      this.picsService.findAllLocalidadesByDepartamento(departamento).subscribe(data => {
        this.localidades = data;
        this.filteredLocalidades = this.localidadCtrl.valueChanges
          .debounceTime(400)
          .distinctUntilChanged()
          .pipe(
            startWith(''),
            map(value => this.searchLocalidad(value))
          );
      });
    }
  }

  private searchDepartamento(value: string): DepartamentoLight[] {
    if(value == null || !value) return this.departamentos;
    const filterValue = value.toLowerCase();
    return this.departamentos.filter(e => e.nombre.toLowerCase().includes(filterValue));
  }

  private selectedMunicipio(event: MatOptionSelectionChange , municipio: Municipio){
    this.hojaDatosIniciales.municipio = null;
    if(event.source.selected) {
      this.hojaDatosIniciales.municipio = municipio;
    }
  }

  private searchMunicipio(value: string): Municipio[] {
    if(value == null || !value) return this.municipios;
    const filterValue = value.toLowerCase();
    return this.municipios.filter(e => e.nombre.toLowerCase().includes(filterValue));
  }

  private selectedLocalidad(event: MatOptionSelectionChange , localidad: LocalidadLight){
    this.hojaDatosIniciales.localidadLight = null;
    if(event.source.selected) {
      this.hojaDatosIniciales.localidadLight = localidad;
    }
  }

  private searchLocalidad(value: string): LocalidadLight[] {
    if(value == null || !value) return this.localidades;
    const filterValue = value.toLowerCase();
    return this.localidades.filter(e => e.nombre.toLowerCase().includes(filterValue));
  }

  private hideFormAlert() {
    let formAlertId = "#formAlert";
    $(formAlertId).hide();
  }

  private cleanData(){
    this.hideFormAlert();
    this.estructuralSeccionAData = new EstructuralSeccionAData;
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

  private onChangeCheckbox(hojaAltAsist: HojaAlternativasAsistenciales, $event: any) {
    $event.preventDefault();
    let cbValue = $event.target.checked;
    hojaAltAsist.isChecked = cbValue;
    if(this.alternativaAsistencialService.isOptionOtro(hojaAltAsist.alternativaAsistencial)) {
      this.otroIsChecked = cbValue;
      if(!cbValue) this.alternativaAsistencialOtroDescripcion == '';
    }
  }


}
