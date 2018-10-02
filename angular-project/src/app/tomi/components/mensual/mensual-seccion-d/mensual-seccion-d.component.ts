import {Component, OnInit, ViewChild} from '@angular/core';
import {HeaderEvent} from "../../../../model/header-event";
import {LoadingComponent} from "../../../../share-components/loading/loading.component";
import {HojaMensualObservaciones} from "../../../../model/hoja-mensual-observaciones";
import {HojaMensualPersonal} from "../../../../model/hoja-mensual-personal";
import {EventBusService} from "../../../../services/event-bus.service";
import {environment} from "../../../../../environments/environment";
import {UrlConstants} from "../../../services/UrlConstants";
declare var $:any;
@Component({
  selector: 'app-mensual-seccion-d',
  templateUrl: './mensual-seccion-d.component.html',
  styleUrls: ['./mensual-seccion-d.component.css']
})
export class MensualSeccionDComponent implements OnInit {
  private readonlyControl: boolean = true;
  private formMessages: string[] = [];
  private errorSection: number = -1;
  private hojaId: number;
  @ViewChild(LoadingComponent) loadingComponent:LoadingComponent;
  private hojaMensualObservaciones: HojaMensualObservaciones = new HojaMensualObservaciones;
  private personalMensual: HojaMensualPersonal = new HojaMensualPersonal;

  constructor(private eventBusService: EventBusService) { }

  ngOnInit() {
    this.buildTable();
  }

  private onChangeHeader(headerEvent: HeaderEvent) {
    if (headerEvent.evento == HeaderEvent.HOJA_ID) {
      this.readonlyControl = headerEvent.value.hojaId == null;
      this.hojaId = headerEvent.value.hojaId;
      if (headerEvent.value.hojaId) {
        // this.loadingComponent.showLoading();
        // this.mensualSeccionCService.findDataSeccionC5ByHojaId(headerEvent.value.hojaId).subscribe(data => this.parseSeccionC5Data(data));
      } else {
        // this.initEmptyData();
      }
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
          // d.filter = self.filter;
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
  }

  private captureCloseModalEvent() {
    var self = this;
    $("#form").on("hidden.bs.modal", function () {
      self.personalMensual = new HojaMensualPersonal;
    });
    this.hideFormAlert();
  }

  hideFormAlert() {
    this.formMessages = [];
    $('#formAlert').hide();
    $('#formAlertPopup').hide();
  }


}
