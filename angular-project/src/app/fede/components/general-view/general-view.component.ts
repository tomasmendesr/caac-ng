import {AfterViewInit, Component, OnInit} from '@angular/core';
import {
  COLUMN_CUIT, COLUMN_DEPARTAMENTO, COLUMN_DIRECCION, COLUMN_LOCALIDAD, COLUMN_MAIL, COLUMN_NOMBRE_CAAC,
  COLUMN_NOMBRE_REPRESENTANTE,
  COLUMN_OBSERVACIONES,
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
import {CasaService} from "../../../tomi/services/casa.service";
import {Casa} from "../../../model/casa";
import {NotifUtil} from "../../../tomi/utils/notif-util";

declare var $: any;

@Component({
  selector: 'app-general-view',
  templateUrl: './general-view.component.html',
  styleUrls: ['./general-view.component.css']
})
export class GeneralViewComponent implements OnInit, AfterViewInit {

  TITLE: string = 'Información General';
  CAAC_POPUP_TITLE: string;
  TABLE_ID: string = 'tablaInformacionGeneral';
  filter: GeneralFilter = new GeneralFilter();

  caacParaPopup: CaacLight;

  provincias: Provincia[];
  departamentos: Departamento[];
  localidades: Localidad[];


  constructor(private eventBusService: EventBusService, private dataTableService: DataTableService, private picsService: PicsService, private casaService: CasaService) { }

  ngOnInit() {
  }

  ngAfterViewInit() {
    this.loadDataTable();
    this.picsService.findAllProvinciasCombo().subscribe(data => this.provincias = data);
  }

  loadDataTable() {
    const self = this;
    const columns = [
      { data: COLUMN_NOMBRE_CAAC, title: 'Nombre CAAC' },
      { data: COLUMN_PERSONERIA_JURIDICA, title: 'Personería Juridica' },
      { data: COLUMN_CUIT, title: 'CUIT' },
      { data: COLUMN_PROVINCIA, title: 'Provincia', render: (item) => item.nombre },
      { data: COLUMN_DEPARTAMENTO, title: 'Departamento', render: (item) => item.nombre },
      { data: COLUMN_LOCALIDAD, title: 'Localidad', render: (item) => item.nombre },
      { data: COLUMN_DIRECCION, title: 'Dirección' },
      { data: COLUMN_NOMBRE_REPRESENTANTE, title: 'Nombre Representante' },
      { data: COLUMN_TELEFONO, title: 'Teléfono' },
      { data: COLUMN_MAIL, title: 'Mail' },
      { data: COLUMN_OBSERVACIONES, title: 'Observaciones' },
      // { defaultContent: "<button class='btnEditar'>Editar</button>" }
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

    $('#tablaInformacionGeneral tbody').on('click', 'tr', function () {
      const caac = table.row(this).data();

      self.caacParaPopup = caac;
      self.openModalForCaacEdit(self.caacParaPopup);
    });
  }

  openModal() {
    $('#form').show();
    $('#form').modal({
      backdrop: 'static',
      keyboard: false,
      show: true
    });
  }

  openModalForNewCaac() {
    this.CAAC_POPUP_TITLE = 'Nueva CAAC';
    this.picsService.findAllProvinciasCombo();
    this.openModal();
  }

  openModalForCaacEdit(caacParaPopup) {
    this.CAAC_POPUP_TITLE = 'Edición CAAC';
    this.picsService.findAllDepartamentosByProvincia(caacParaPopup.provincia).subscribe(data => this.departamentos = data);
    this.picsService.findAllLocalidadesByDepartamento(caacParaPopup.departamento).subscribe(data => this.localidades = data);
    this.openModal();
  }

  closeModal() {
    $('#form').modal({
      backdrop: 'static',
      keyboard: false,
      show: false
    });
    $('#form').hide();
  }

  onClickGuardar() {
    const self = this;
    this.casaService.saveOrUpdateCasaGeneral(<Casa> this.caacParaPopup).subscribe(success => {
      NotifUtil.notifSuccess('Guardado exitosamente');
      self.closeModal();
    }, (error) => {
      console.error(error)
      NotifUtil.notifError('Error al guardar, ingrese los datos correctamente');
    });
  }

  onAniadirClick() {
    this.caacParaPopup = new CaacLight();
    this.openModalForNewCaac();
  }

  onProvinciaChange(provincia) { //para bindear
    this.caacParaPopup.provincia = provincia;
    this.picsService.findAllDepartamentosByProvincia(provincia).subscribe(data => this.departamentos = data);
  }

  onDepartamentoChange(departamento) {
    this.caacParaPopup.departamento = departamento;
    this.picsService.findAllLocalidadesByDepartamento(departamento).subscribe(data => this.localidades = data);
  }

  onLocalidadChange(localidad) {
    this.caacParaPopup.localidad = localidad;
  }

  compareFunct(o1: any, o2: any): boolean {
    return o1 && o2 ? o1.id === o2.id : o1 === o2;
  }
}
