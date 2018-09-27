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
import Requisito from "../../../model/requisito";
import {CasaService} from "../../../tomi/services/casa.service";
import {Casa} from "../../../model/casa";
import {NotifUtil} from "../../../tomi/utils/notif-util";

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
  requisitosColumna1: any[] = [
    {id: 'actaasa', descripcion: 'Acta última asamblea'}, {id: 'crondiayh', descripcion: 'Cronograma días y horarios personales'},
    {id: 'altbanca', descripcion: 'Alta de cuenta bancaria en el tesoro'}, {id: 'cronalimen', descripcion: 'Cronograma alimentación'},
    {id: 'cronmerc', descripcion: 'Cronograma entrega de mercadería'}, {id: 'cronparad', descripcion: 'Cronograma parador'},
    {id: 'cvsliscom', descripcion: 'CVs listado completo'}, {id: 'desaut', descripcion: 'Acta designación autoridades'},
    {id: 'fotodni', descripcion: 'Fotocopia de DNI'},

  ];
  requisitosColumna2: any[] = [
    {id: 'forafip', descripcion: 'Formulario inscipción Afip'},
    {id: 'lisrrhh', descripcion: 'Listado RRHH'}, {id: 'organi', descripcion: 'Organigrama'},
    {id: 'perjur', descripcion: 'Personería jurídica'}, {id: 'prodesex', descripcion: 'Programa descriptivo y explicativo'},
    {id: 'segmalpra', descripcion: 'Seguro de mala praxis'}, {id: 'segrescivil', descripcion: 'Seguro de responsabilidad civil'},
    {id: 'soliform', descripcion: 'Solicitud formal'}, {id: 'statuto', descripcion: 'Estatuto'}
  ];

  caacParaPopup: CaacLight;
  requisitoParaPopup: Requisito;

  constructor(private dataTableService: DataTableService, private picsService: PicsService, private categoriaService: CategoriaService, private casaService: CasaService) { }

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
      { data: COLUMN_FECHA_AUDITORIA_INICIAL, title: 'Fecha de Auditoría Inicial', render: (item) => this.dateFormat(new Date(item)) },
      { data: COLUMN_FECHA_INICIO_CONVENIO, title: 'Fecha de Inicio de Convenio', render: (item) => this.dateFormat(new Date(item))  },
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
      var caac = table.row(this).data();
      caac.fechaini = new Date(caac.fechaini); //no se porque trae los dates como milisegundos
      caac.fechacon = new Date(caac.fechacon);

      self.caacParaPopup = caac;
      self.openModalForCaacEdit(self.caacParaPopup);
    });
  }

  onChange(propertyId, value) {
    this.caacParaPopup[propertyId] = value;

    if(propertyId === 'provincia') {
      this.picsService.findAllDepartamentosByProvincia(value).subscribe(data => {
        this.departamentos = data;
        this.caacParaPopup.departamento = data[0];
      }, (error)=> console.error(error), () =>
        this.picsService.findAllLocalidadesByDepartamento(this.caacParaPopup.departamento).subscribe(data => {
          this.localidades = data;
          this.caacParaPopup.localidad = data[0];
        }));
    } else if(propertyId === 'departamento') {
      this.picsService.findAllLocalidadesByDepartamento(value).subscribe(data => {
        this.localidades = data;
        this.caacParaPopup.localidad = data[0];
      });
    }

    const i = 0;
  }

  onClickGuardar(event) {
    const self = this;
    this.casaService.saveOrUpdateCasaGeneral(<Casa> this.caacParaPopup).subscribe(success => {
      NotifUtil.notifSuccess('Guardado exitosamente');
      self.closeModal();
    }, (error) => {
      console.error(error);
      NotifUtil.notifError('Error al guardar, ingrese los datos correctamente');
    });
  }

  openModalForCaacEdit(caacParaPopup) {
    this.requisitoParaPopup = new Requisito();
    this.picsService.findAllDepartamentosByProvincia(caacParaPopup.provincia).subscribe(data => this.departamentos = data);
    this.picsService.findAllLocalidadesByDepartamento(caacParaPopup.departamento).subscribe(data => this.localidades = data);
    this.openModal();
  }

  openModal() {
    $('#form').modal({
      backdrop: 'static',
      keyboard: false,
      show: true
    });
  }

  closeModal() {
    $('#form').modal({
      backdrop: 'static',
      keyboard: false,
      show: false
    });
  }

  compareFunct(o1: any, o2: any): boolean {
    return o1 && o2 ? o1.id === o2.id : o1 === o2;
  }

  compareCat(c1: Categoria, c2: Categoria) {
    return c1 && c2 ? c1.cat === c2.cat : c1 === c2;
  }

  dateFormat(date) {
    var dd = date.getDate();
    var mm = date.getMonth()+1;
    var yyyy = date.getFullYear();

    if (dd < 10)
      dd = '0' + dd;
    if(mm < 10)
      mm = '0' + mm;

    return dd + '/' + mm + '/' + yyyy;
  }
}
