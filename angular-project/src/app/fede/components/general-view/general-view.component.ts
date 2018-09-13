import {AfterViewInit, Component, OnInit} from '@angular/core';
import {
  COLUMN_CUIT, COLUMN_DIRECCION, COLUMN_MAIL, COLUMN_NOMBRE_CAAC, COLUMN_NOMBRE_REPRESENTANTE, COLUMN_OBSERVACIONES,
  COLUMN_PERSONERIA_JURIDICA, COLUMN_PROVINCIA, COLUMN_TELEFONO
} from "./general-view-constants";
import {Casa} from "../../../model/casa";
import {UrlConstants} from "../../../tomi/services/UrlConstants";
import {NotifUtil} from "../../../tomi/utils/notif-util";
import {environment} from "../../../../environments/environment";
import {EventBusService} from "../../../services/event-bus.service";
import GeneralFilter from "../../model/filters/general-filter";
import {DataTableService} from "../../../services/data-table.service";
import {UrlConstantsCaac} from "../../constants/url-constants";

declare var $: any;

@Component({
  selector: 'app-general-view',
  templateUrl: './general-view.component.html',
  styleUrls: ['./general-view.component.css']
})
export class GeneralViewComponent implements OnInit, AfterViewInit {

  TITLE: string = 'Información General';
  TABLE_ID: string = 'tablaInformacionGeneral';
  filter: GeneralFilter = new GeneralFilter();

  constructor(private eventBusService: EventBusService, private dataTableService: DataTableService) { }

  ngOnInit() {
  }

  ngAfterViewInit() {
    this.loadDataTable();

  }

  private loadDataTable() {
    const self = this;
    const columns = [
      { data: COLUMN_NOMBRE_CAAC, title: 'Nombre CAAC' },
      { data: COLUMN_PERSONERIA_JURIDICA, title: 'Personería Juridica' },
      { data: COLUMN_CUIT, title: 'CUIT' },
      { data: COLUMN_PROVINCIA, title: 'Provincia', render: (item) => item.nombre },
      { data: COLUMN_DIRECCION, title: 'Dirección' },
      { data: COLUMN_NOMBRE_REPRESENTANTE, title: 'Nombre Representante' },
      { data: COLUMN_TELEFONO, title: 'Teléfono' },
      { data: COLUMN_MAIL, title: 'Mail' },
      { data: COLUMN_OBSERVACIONES, title: 'Observaciones' },
      { defaultContent: "<button>Editar</button>" }
    ];
    const table = this.dataTableService.buildTable(
      this.TABLE_ID,
      self,
      columns,
      UrlConstantsCaac.FIND_ALL_CASAS_GENERAL,
      this.filter,
      [],
      true
    );

    $('#' + this.TABLE_ID + ' tbody').on( 'click', 'button', () => {
      alert(JSON.stringify(table));
      var data = table.row($(self).parents('tr') ).data();
      alert( 'Nombre caac : ' + data[0]);
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
