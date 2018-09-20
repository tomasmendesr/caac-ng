import {AfterViewInit, Component, OnInit} from '@angular/core';
import { COLUMN_NOMBRE_CAAC,
  COLUMN_PERSONERIA_JURIDICA, COLUMN_CUIT, COLUMN_OBSERVACIONES,
  COLUMN_MODALIDAD_CONVENIO, COLUMN_CATEGORIA_INICIAL, COLUMN_NUEVA_CATEGORIA, COLUMN_FECHA_AUDITORIA_INICIAL,
  COLUMN_FECHA_INICIO_CONVENIO
} from "../../constants/commons-constants";
import {DataTableService} from "../../../services/data-table.service";
import {UrlConstantsCaac} from "../../constants/url-constants";
import AdministrativoFilter from "../../model/filters/administrativo-filter";

@Component({
  selector: 'app-administrativo-view',
  templateUrl: './administrativo-view.component.html',
  styleUrls: ['./administrativo-view.component.css']
})
export class AdministrativoViewComponent implements OnInit, AfterViewInit {

  TITLE = 'Administrativo';
  TABLE_ID = 'tableAdministrativo';

  filter: AdministrativoFilter = new AdministrativoFilter();

  constructor(private dataTableService: DataTableService) { }

  ngOnInit() {
  }

  ngAfterViewInit() {
    this.loadTable();
  }

  loadTable() {
    const self = this;
    const columns = [
      { data: COLUMN_NOMBRE_CAAC, title: 'Nombre CAAC' },
      { data: COLUMN_PERSONERIA_JURIDICA, title: 'Personería Juridica' },
      { data: COLUMN_CUIT, title: 'CUIT' },
      { data: COLUMN_MODALIDAD_CONVENIO, title: 'Modalidad del Convenio', render: (item) => item.cat },
      { data: COLUMN_CATEGORIA_INICIAL, title: 'Categoría Inicial', render: (item) => item.cat },
      { data: COLUMN_NUEVA_CATEGORIA, title: 'Nueva Categoría' },
      { data: COLUMN_FECHA_AUDITORIA_INICIAL, title: 'Fecha de Auditoría Inicial' },
      { data: COLUMN_FECHA_INICIO_CONVENIO, title: 'Fecha de Inicio de Convenio' },
      { data: COLUMN_OBSERVACIONES, title: 'Observaciones' },
      { defaultContent: "<button class='btnEditar'>Editar</button>" }
    ];
    const table = this.dataTableService.buildTable(
      this.TABLE_ID,
      self,
      columns,
      UrlConstantsCaac.FIND_ALL_CASAS_ADMINISTRATIVO,
      this.filter,
      [],
      false
    );
  }

}
