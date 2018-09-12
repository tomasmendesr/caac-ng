import {AfterViewInit, Component, OnInit} from '@angular/core';
import {GeneralService} from "../../services/general.service";
import {
  COLUMN_CUIT, COLUMN_DIRECCION, COLUMN_MAIL, COLUMN_NOMBRE_CAAC, COLUMN_NOMBRE_REPRESENTANTE, COLUMN_OBSERVACIONES,
  COLUMN_PERSONERIA_JURIDICA, COLUMN_PROVINCIA, COLUMN_TELEFONO
} from "./general-view-constants";
import {Casa} from "../../../model/casa";
import {UrlConstants} from "../../../tomi/services/UrlConstants";
import {NotifUtil} from "../../../tomi/utils/notif-util";
import {environment} from "../../../../environments/environment";
import {EventBusService} from "../../../services/event-bus.service";
import {DefaultFilter} from "../../../tomi/filters/default-filter";

declare var $: any;

@Component({
  selector: 'app-general-view',
  templateUrl: './general-view.component.html',
  styleUrls: ['./general-view.component.css']
})
export class GeneralViewComponent implements OnInit, AfterViewInit {

  TITLE: string = 'Información General';
  TABLE_ID: string = 'tablaInformacionGeneral';
  filter: DefaultFilter = new DefaultFilter;


  constructor(private generalService: GeneralService, private eventBusService: EventBusService) { }

  ngOnInit() {
  }

  ngAfterViewInit() {
    this.loadDataTable();
  }

  private loadDataTable() {
    const self = this;
    $('#' + this.TABLE_ID).DataTable({
        columns: [
          { data: COLUMN_NOMBRE_CAAC, title: 'Nombre CAAC' },
          { data: COLUMN_PERSONERIA_JURIDICA, title: 'Personería Juridica' },
          { data: COLUMN_CUIT, title: 'CUIT' },
          { data: COLUMN_PROVINCIA, title: 'Provincia' },
          { data: COLUMN_DIRECCION, title: 'Dirección' },
          { data: COLUMN_NOMBRE_REPRESENTANTE, title: 'Nombre Representante' },
          { data: COLUMN_TELEFONO, title: 'Teléfono' },
          { data: COLUMN_MAIL, title: 'Mail' },
          { data: COLUMN_OBSERVACIONES, title: 'Observaciones' }
        ],
        ajax: {
          url: environment.apiUrl + UrlConstants.FIND_ALL_CASAS, //todo ver que onda el environment
          type: 'POST',
          contentType: 'application/json',
          /*data: (data) => {
            data.filter = self.filter;

            return JSON.stringify(data);
          },*/
          /*error: (xhr, error, thrown) => {
            if(xhr.responseJSON && xhr.responseJSON.code == 403){
              NotifUtil.notifError(xhr.responseJSON.message)
            } else if (xhr.status === 401 || xhr.status === 0) {
              self.eventBusService.broadcast('http-error-auth', null);
            }
          }*/
        },
        processing: true,
        serverSide: true,
        searching: false,
        scrollX: true,
      } );

  }

  private adaptarACasaTabla(casa: Casa): any {
    return {
      nombreCaac: casa.nomcaac,
      personeriaJuridica: casa.perjuridica,
      cuit: casa.cuit,
      provincia: casa.provincia,
      direccion: casa.dir,
      nombreRepresentante: casa.nomrepre,
      telefono: casa.tel,
      mail: casa.mail,
      observaciones: casa.obser
    };
  }

}
