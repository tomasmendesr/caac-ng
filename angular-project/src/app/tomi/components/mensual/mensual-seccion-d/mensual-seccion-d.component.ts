import {Component, OnInit, ViewChild} from '@angular/core';
import {HeaderEvent} from "../../../../model/header-event";
import {LoadingComponent} from "../../../../share-components/loading/loading.component";
import {HojaMensualObservaciones} from "../../../../model/hoja-mensual-observaciones";
import {HojaMensualPersonal} from "../../../../model/hoja-mensual-personal";
import {EventBusService} from "../../../../services/event-bus.service";
import {environment} from "../../../../../environments/environment";
import {UrlConstants} from "../../../services/UrlConstants";
import {DocumentFilter} from "../../../filters/document-filter";
import {TipoDocumento} from "../../../../model/tipo-documento";
import {PicsService} from "../../../services/pics.service";
import {DefaultFilter} from "../../../filters/default-filter";
import {HojaMensualObservacionesService} from "../../../services/hoja-mensual-observaciones.service";
import {HojaMensualPersonalService} from "../../../services/hoja-mensual-personal.service";
import {AppResponse} from "../../../../model/app-response";
import {NotifUtil} from "../../../utils/notif-util";
import {Router} from "@angular/router";
import {PersonalService} from "../../../services/personal.service";
import {Personal} from "../../../../model/personal";
declare var $:any;
@Component({
  selector: 'app-mensual-seccion-d',
  templateUrl: './mensual-seccion-d.component.html',
  styleUrls: ['./mensual-seccion-d.component.css']
})
export class MensualSeccionDComponent implements OnInit {
  private readonlyControl: boolean = true;
  private formMessages: string[] = [];
  private hojaId: number;
  @ViewChild(LoadingComponent) loadingComponent:LoadingComponent;
  private hojaMensualObservaciones: HojaMensualObservaciones = new HojaMensualObservaciones;
  private personalMensual: HojaMensualPersonal = new HojaMensualPersonal;
  documentFilter: DocumentFilter = new DocumentFilter;
  private tiposDocumento: TipoDocumento[] = [];
  filter: DefaultFilter = new DefaultFilter;

  constructor(private eventBusService: EventBusService, private picsService: PicsService, private router: Router, private personalService: PersonalService,
              private hojaMensualObservacionesService: HojaMensualObservacionesService, private hojaMensualPersonalService: HojaMensualPersonalService) { }

  ngOnInit() {
    this.buildTable();
    this.picsService.findAllTiposDocumento().subscribe(data => this.tiposDocumento = data);
  }

  private onChangeHeader(headerEvent: HeaderEvent) {
    if (headerEvent.evento == HeaderEvent.HOJA_ID) {
      this.readonlyControl = headerEvent.value.hojaId == null;
      this.hojaId = headerEvent.value.hojaId;
      this.filter.value = this.hojaId ? this.hojaId.toString() : null;
      this.updateTable();
      if(this.hojaId) this.hojaMensualObservacionesService.findByHojaId(headerEvent.value.hojaId).subscribe(data => this.hojaMensualObservaciones = data);
    }
  }

  private updateTable() {
    $('#table').DataTable().ajax.reload();
  }

  private buildTable(){
    const self = this;
    $.fn.dataTable.ext.errMode = 'none';

    const table = $('#table').DataTable({
      columns: [// el atributo data se toma en el server para sacar la columna por la que se ordena
        {data: 'apellido', title: 'Apellido'},
        {data: 'nombre', title: 'Nombre'},
        {data: 'altaBaja', title: 'Alta/Baja'},
        {data: 'rol', title: 'Rol'},
        {data: 'titulo', title: 'Título'},
        {data: 'esRentado', title: 'Rentado/No Rentado', render: function(data){
          return data != null && data == "S" ? "Si" : "No";
        }},
        {
          data: null, title: 'Editar', defaultContent: self.buildTableButtons(), orderable: false, width: 90
        }
      ],
      processing: true,
      serverSide: true,
      searching: false,
      scrollX: true,
      ajax: {
        url: environment.apiUrl + UrlConstants.GET_HOJA_MENSUAL_PERSONAL_FOR_TABLE,
        type: 'POST',
        contentType: 'application/json',
        data: function (d) {
          d.filter = self.filter;
          return JSON.stringify(d);
        },
        error: function (xhr, error, thrown) {
          if (xhr.status === 401 || xhr.status === 0) {
            self.eventBusService.broadcast('http-error-auth', null);
          }
        }
      },
      language: {
        url: 'assets/datatable/spanish.json'
      }
    });

    $('#table tbody').on('click', '.edit', function () {
      self.personalMensual = table.row($(this).parents('tr').first()).data();
      self.openModal();
    });
  }

  buildTableButtons(): string {
    var html = "<div class='slideContainer'><button class='Button -sm -primary -raised -rounded edit'><span class='fas fa-edit'></span></button>";
    return html;
  }

  private openModal() {
    $('#form').modal({
      backdrop: 'static',
      keyboard: false,
      show: true
    });
  }

  private closeModal() {
    $("#form").modal('hide');
    this.hideFormAlert();
    this.personalMensual = new HojaMensualPersonal;
    this.cleanFilter();
  }

  private captureCloseModalEvent() {
    var self = this;
    $("#form").on("hidden.bs.modal", function () {
      self.personalMensual = new HojaMensualPersonal;
      self.closeModal();
    });
  }

  hideFormAlert() {
    this.formMessages = [];
    $('#formAlert').hide();
    $('#formAlertPopup').hide();
  }

  private cleanFilter(){
    this.documentFilter = new DocumentFilter;
    this.personalMensual.personal = new Personal;
  }

  compare(t1: any, t2: any): boolean {
    return  t1 === t2;
  }

  compareTipoDoc(o1: any, o2: any): boolean {
    return o1 && o2 ? o1.idTipoDoc === o2.idTipoDoc : o1 === o2;
  }

  private findPersonal(){
    this.personalService.findByDocumento(this.documentFilter).subscribe(p => {
      if(p){
        this.personalMensual.personal = p;
        this.personalMensual.nombre = p.nombre;
        this.personalMensual.apellido = p.apellido;
        this.personalMensual.rol = p.rol;
        this.personalMensual.titulo = p.titulo;
        this.personalMensual.esRentado = p.esRentado;
      }else{
        this.personalMensual.personal = new Personal;
        NotifUtil.notifError("No se encontró ningún empleado");
      }
    });
  }

  private onChangeTipoDocumento(tipoDoc: any){
    this.documentFilter.tipoDocumento = tipoDoc ? tipoDoc : null;
  }

  onClickAceptarPopup(event: any) {
    event.preventDefault();
    // this.loadingComponent.showLoading(); // no sé por qué buguea el modal
    this.personalMensual.hoja.id = this.hojaId;
    this.hojaMensualPersonalService.saveOrUpdateSeccionD(this.personalMensual).subscribe(appResponse => {
      if (appResponse.code == AppResponse.SUCCESS) {
        NotifUtil.notifSuccess("Guardado exitosamente");
        this.loadingComponent.hideLoading();
        this.closeModal();
        this.updateTable();
      } else {
        this.showErrorMsgs(appResponse, "formAlertPopup");
      }
    }, (error) => this.notifError(error));
  }

  private onClickGuardar() {
    this.loadingComponent.showLoading();
    this.hojaMensualObservaciones.hoja.id = this.hojaId;
    this.hojaMensualObservacionesService.saveOrUpdateSeccionD(this.hojaMensualObservaciones).subscribe(appResponse => {
      if(appResponse.code == AppResponse.SUCCESS){
        NotifUtil.notifSuccess("Guardado exitosamente");
        this.loadingComponent.hideLoading();
      }else{
        this.showErrorMsgs(appResponse, "formAlert");
      }
    }, (error) => this.notifError(error));
  }

  private notifError(error){
    NotifUtil.notifError(error.error.message);
    this.loadingComponent.hideLoading();
  }

  private showErrorMsgs(appResponse: AppResponse, idFormAlert: string){
    this.loadingComponent.hideLoading();
    NotifUtil.notifError("Ocurrieron errores de validación. Verifique los formularios.");
    this.formMessages = appResponse.data;
    $("#"+idFormAlert).show();
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
    this.hojaMensualObservaciones.hoja.id = this.hojaId;
    this.hojaMensualObservacionesService.saveOrUpdateSeccionD(this.hojaMensualObservaciones).subscribe(appResponse => {
      if(appResponse.code == AppResponse.SUCCESS){
        this.loadingComponent.hideLoading();
        this.siguiente();
      }else{
        this.showErrorMsgs(appResponse, "formAlert");
      }
    }, (error) => this.notifError(error));
  }
}
