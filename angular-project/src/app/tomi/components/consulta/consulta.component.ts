import { Component, OnInit } from '@angular/core';
import {ConsultaFilter} from "../../filters/consulta-filter";
import {FormControl} from "@angular/forms";
import {Mes} from "../../../model/mes";
import {Casa} from "../../../model/casa";
import {MesService} from "../../services/mes.service";
import {NotifUtil} from "../../utils/notif-util";
import {UrlConstants} from "../../services/UrlConstants";
import {environment} from "../../../../environments/environment";
import {EventBusService} from "../../../services/event-bus.service";
import {CasaService} from "../../services/casa.service";
declare var $:any;
@Component({
  selector: 'app-consulta',
  templateUrl: './consulta.component.html',
  styleUrls: ['./consulta.component.css']
})
export class ConsultaComponent implements OnInit {
  filterConsulta: ConsultaFilter = new ConsultaFilter;
  casaCtrl: FormControl = new FormControl();
  casas: Casa[] = [];
  meses: Mes[] = [];
  anios: number[] = [];
  constructor(private mesService: MesService, private casaService: CasaService, private eventBusService: EventBusService) { }

  ngOnInit() {
    this.initLists();
    this.buildTable();
  }

  private initLists(){
    this.mesService.findAll().subscribe(data => this.meses = data);
    this.casaService.findAll().subscribe(data => this.casas = data);
    for(let i = 1990; i < 2019; i++){ // TODO - pedir a mati datos en bd
      this.anios.push(i);
    }
  }

  private updateTable() {
    $('#table').DataTable().ajax.reload();
  }

  private buildTable() {
    const self = this;
    $.fn.dataTable.ext.errMode = 'none';

    const table = $('#table').DataTable({
      columns: [// el atributo data se toma en el server para sacar la columna por la que se ordena
        {data: 'anio', title: 'Año'},
        {data: 'mes.id', title: 'Mes'},
        {data: 'casa.nomcaac', title: 'Nomre CAAC'},
        {data: 'tipoHoja', title: 'Tipo Informe'},
        {data: 'fechaCierre', title: 'Estado', render: function(data) {
          return data != null ? "Cerrado" : "Abierto";
        }},
        {
          data: null, title: 'Acciones', defaultContent: self.buildTableButtons(), orderable: false
        }
      ],
      processing: true,
      serverSide: true,
      searching: false,
      scrollX: true,
      ajax: {
        url: environment.apiUrl + UrlConstants.GET_HOJAS_FOR_TABLE,
        type: 'POST',
        contentType: 'application/json',
        data: function (d) {
          d.filter = self.filterConsulta;
          return JSON.stringify(d);
        },
        error: function (xhr, error, thrown) {
          if (xhr.responseJSON && xhr.responseJSON.code == 403) {
            NotifUtil.notifError(xhr.responseJSON.message)
          } else if (xhr.status === 401 || xhr.status === 0) {
            self.eventBusService.broadcast('http-error-auth', null);
          }
        }
      },
      language: {
        url: 'assets/datatable/spanish.json'
      }/*,
      select: true,
      dom: 'Blfrtip',
      buttons: [
        'copy',
        'excel',
        'csv',
        'pdf',
        'print'
      ]*/
    });
  }

  private buildTableButtons(): string {
    var html = "<button class='Button -sm -primary -raised -rounded'><span class='fas fa-edit'></span></button>";
    html = html + "  <button class='Button -sm -danger -raised -rounded'><span class='fas fa-trash'></span></button>";
    return html;
  }

}
