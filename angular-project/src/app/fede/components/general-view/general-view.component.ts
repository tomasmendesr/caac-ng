import {AfterViewInit, Component, OnInit} from '@angular/core';
import {
  COLUMN_CUIT, COLUMN_DIRECCION, COLUMN_MAIL, COLUMN_NOMBRE_CAAC, COLUMN_NOMBRE_REPRESENTANTE, COLUMN_OBSERVACIONES,
  COLUMN_PERSONERIA_JURIDICA, COLUMN_PROVINCIA, COLUMN_TELEFONO
} from "../../constants/commons-constants";
import {EventBusService} from "../../../services/event-bus.service";
import GeneralFilter from "../../model/filters/general-filter";
import {DataTableService} from "../../../services/data-table.service";
import {UrlConstantsCaac} from "../../constants/url-constants";
import CaacLight from "../../model/caac-light";
import {PicsService} from "../../../tomi/services/pics.service";
import {Localidad} from "../../../model/localidad";
import {Departamento} from "../../../model/departamento";
import {Provincia} from "../../../model/provincia";
import {GeneralViewService} from "../../services/general-view.service";

declare var $: any;

@Component({
  selector: 'app-general-view',
  templateUrl: './general-view.component.html',
  styleUrls: ['./general-view.component.css']
})
export class GeneralViewComponent implements OnInit, AfterViewInit {

  TITLE: string = 'Información General';
  EDICION_CAAC: string = 'Edición CAAC';
  TABLE_ID: string = 'tablaInformacionGeneral';
  filter: GeneralFilter = new GeneralFilter();

  caacParaPopup: CaacLight;

  provincias: Provincia[];
  departamento: Departamento[];
  localidad: Localidad[];

  constructor(private eventBusService: EventBusService, private dataTableService: DataTableService, private picsService: PicsService, private generalService: GeneralViewService) { }

  ngOnInit() {
  }

  ngAfterViewInit() {
    this.loadDataTable();
    this.loadProvinciasDeparamentosLocalidades();
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
      { defaultContent: "<button class='btnEditar'>Editar</button>" }
    ];
    const table = this.dataTableService.buildTable(
      this.TABLE_ID,
      self,
      columns,
      UrlConstantsCaac.FIND_ALL_CASAS_GENERAL,
      this.filter,
      [],
      false
    );

    $('#tablaInformacionGeneral tbody').on('click', '.btnEditar', function () {
      self.caacParaPopup = table.row($(this).parents('tr').first()).data();

      self.openModal();
    });
  }

  openModal() {
    $('#form').modal({
      backdrop: 'static',
      keyboard: false,
      show: true
    });
  }

  onClickGuardar() {
    alert(JSON.stringify(this.caacParaPopup));
    this.generalService.saveOrUpdate(this.caacParaPopup).subscribe(success => { if(!success) console.log('error') }); //todo ver como se implementa esta excepcion
  }

  onAniadirClick() {
    this.caacParaPopup = new CaacLight();
    this.openModal();
  }

  loadProvinciasDeparamentosLocalidades() {
    this.picsService.findAllProvinciasCombo().subscribe(data => this.provincias = data);
    this.picsService.findAllLocalidades().subscribe(data => this.localidad = data);
    this.picsService.findAllDepartamentos().subscribe(data => this.departamento = data);
  }
}
