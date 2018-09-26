import {AfterViewInit, Component, OnInit} from '@angular/core';
import { COLUMN_NOMBRE_CAAC,
  COLUMN_PERSONERIA_JURIDICA, COLUMN_CUIT, COLUMN_OBSERVACIONES,
  COLUMN_MODALIDAD_CONVENIO, COLUMN_CATEGORIA_INICIAL, COLUMN_NUEVA_CATEGORIA, COLUMN_FECHA_AUDITORIA_INICIAL,
  COLUMN_FECHA_INICIO_CONVENIO
} from "../../constants/commons-constants";
import {DataTableService} from "../../../services/data-table.service";
import {UrlConstantsCaac} from "../../constants/url-constants";
import AdministrativoFilter from "../../model/filters/administrativo-filter";
import CaacLight from "../../model/caac-light";
import {PicsService} from "../../../tomi/services/pics.service";
import {Departamento} from "../../../model/departamento";
import {Provincia} from "../../../model/provincia";
import {Localidad} from "../../../model/localidad";
import {Categoria} from "../../../model/categoria";
import {CategoriaService} from "../../../services/categoria.service";

declare var $: any;

@Component({
  selector: 'app-administrativo-view',
  templateUrl: './administrativo-view.component.html',
  styleUrls: ['./administrativo-view.component.css']
})
export class AdministrativoViewComponent implements OnInit, AfterViewInit {

  TITLE = 'Administrativo';
  TABLE_ID = 'tableAdministrativo';

  filter: AdministrativoFilter = new AdministrativoFilter();
  provincias: Provincia[];
  departamentos: Departamento[];
  localidades: Localidad[];
  categorias: Categoria[];

  caacParaPopup: CaacLight;

  constructor(private dataTableService: DataTableService, private picsService: PicsService, private categoriaService: CategoriaService) { }

  ngOnInit() {
  }

  ngAfterViewInit() {
    this.loadTable();
    this.picsService.findAllProvinciasCombo().subscribe(data => this.provincias = data);
    this.categoriaService.findAllCategorias().subscribe(data => this.categorias = data);
  }

  loadTable() {
    const self = this;
    const columns = [
      { data: COLUMN_NOMBRE_CAAC, title: 'Nombre CAAC' },
      { data: COLUMN_PERSONERIA_JURIDICA, title: 'Personería Juridica' },
      { data: COLUMN_CUIT, title: 'CUIT' },
      { data: COLUMN_MODALIDAD_CONVENIO, title: 'Modalidad del Convenio' },
      { data: COLUMN_CATEGORIA_INICIAL, title: 'Categoría Inicial', render: (item) => item.cat },
      { data: COLUMN_NUEVA_CATEGORIA, title: 'Nueva Categoría', render: (item) => item.cat },
      { data: COLUMN_FECHA_AUDITORIA_INICIAL, title: 'Fecha de Auditoría Inicial' },
      { data: COLUMN_FECHA_INICIO_CONVENIO, title: 'Fecha de Inicio de Convenio' },
      { data: COLUMN_OBSERVACIONES, title: 'Observaciones' },
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

    $('#tableAdministrativo tbody').on('click', 'tr', function () {
      const caac = table.row(this).data();

      self.caacParaPopup = caac;
      self.openModalForCaacEdit(self.caacParaPopup);
    });
  }

  onCatChange(cat) {
    this.caacParaPopup.cat = cat;
  }

  onNcatChange(ncat) {
    this.caacParaPopup.ncat = ncat;
  }

  openModalForCaacEdit(caacParaPopup) {
    this.picsService.findAllDepartamentosByProvincia(caacParaPopup.provincia).subscribe(data => this.departamentos = data);
    this.picsService.findAllLocalidadesByDepartamento(caacParaPopup.departamento).subscribe(data => this.localidades = data);
    this.openModal();
  }

  openModal() {
    // $('#form').show();
    $('#form').modal({
      backdrop: 'static',
      keyboard: false,
      show: true
    });
  }

  compareFunct(o1: any, o2: any): boolean {
    return o1 && o2 ? o1.id === o2.id : o1 === o2;
  }


}
