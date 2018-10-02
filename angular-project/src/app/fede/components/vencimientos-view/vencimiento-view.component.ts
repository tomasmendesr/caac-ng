import {AfterViewInit, Component, OnInit} from '@angular/core';
import Vencimiento from "../../../model/vencimiento";
import {COLUMN_NOMBRE_CAAC} from "../../constants/commons-constants";
import {UrlConstantsCaac} from "../../constants/url-constants";
import {DataTableService} from "../../../services/data-table.service";
import {DateService} from "../../../services/date.service";
import {VencimientoService} from "../../services/vencimiento.service";
import {NotifUtil} from "../../../tomi/utils/notif-util";

declare var $: any;

@Component({
  selector: 'app-vencimiento-view',
  templateUrl: './vencimiento-view.component.html',
  styleUrls: ['./vencimiento-view.component.css']
})
export class VencimientoViewComponent implements OnInit, AfterViewInit {

  //TODO que las columnas queden mas lindas y que se marquen celdas en rojo cuando hay un vencimiento que supera la fecha actual
  //todo deshabilitar sorting de columnas de vencimientos
  //todo popup mas comprimido

  TITLE: string = 'Vencimientos';
  TABLE_ID: string = 'vencimientosTable';
  vencimientoParaPopup: Vencimiento;
  vencimientosPropertys: any[] = [
    {recibido: 'asamrecib',     vencimiento: 'asambaja',      otro: '', descripcion: 'Acta asamblea', textField: false },
    {recibido: 'autorirecib',   vencimiento: 'autoribaja',    otro: '', descripcion: 'Acta Autoridades:', textField: false},
    {recibido: 'afiprecib',     vencimiento: 'afipbaja',      otro: '', descripcion: 'AFIP:', textField: false},
    {recibido: 'responrecib',   vencimiento: 'responbaja',    otro: '', descripcion: 'Seguro de Responsabilidad Civil:', textField: false},
    {recibido: 'fechRecMala1',  vencimiento: 'fechVenMala1',  otro: 'malapra1', descripcion: 'Seguro de Mala praxis 1:', textField: true},
    {recibido: 'fechRecMala2',  vencimiento: 'fechVenMala2',  otro: 'malapra2', descripcion: 'Seguro de Mala praxis 2:', textField: true},
    {recibido: 'fechRecMala3',  vencimiento: 'fechVenMala3',  otro: 'malapra3', descripcion: 'Seguro de Mala praxis 3:', textField: true},
    {recibido: 'fechRecMala4',  vencimiento: 'fechVenMala4',  otro: 'malapra4', descripcion: 'Seguro de Mala praxis 4:', textField: true},
    {recibido: 'fechRecMala5',  vencimiento: 'fechVenMala5',  otro: 'malapra5', descripcion: 'Seguro de Mala praxis 5:', textField: true},
    {recibido: 'fechRecMala6',  vencimiento: 'fechVenMala6',  otro: 'malapra6', descripcion: 'Seguro de Mala praxis 6:', textField: true},
    {recibido: 'fechRecMala7',  vencimiento: 'fechVenMala7',  otro: 'malapra7', descripcion: 'Seguro de Mala praxis 7:', textField: true},
    {recibido: 'fechRecMala8',  vencimiento: 'fechVenMala8',  otro: 'malapra8', descripcion: 'Seguro de Mala praxis 8:', textField: true},
    {recibido: 'fechRecMala9',  vencimiento: 'fechVenMala9',  otro: 'malapra9', descripcion: 'Seguro de Mala praxis 9:', textField: true},
    {recibido: 'fechRecMala10', vencimiento: 'fechVenMala10', otro: 'malapra10', descripcion: 'Seguro de Mala praxis 10:', textField: true},
  ];

  constructor(private dataTableService: DataTableService, private dateService: DateService, private vencimientoService: VencimientoService) { }

  ngOnInit() {
  }

  ngAfterViewInit() { this.loadDataTable(); }

  loadDataTable() {
    const self = this;

    var columns = this.generateColumns();

    const table = this.dataTableService.buildTable(
      this.TABLE_ID,
      self,
      columns,
      UrlConstantsCaac.FIND_ALL_VENCIMIENTOS,
      (data) => JSON.stringify(data),
      [],
      false
    );

    $('#vencimientosTable tbody').on('click', 'tr', function () {
      self.vencimientoParaPopup = table.row(this).data();
      self.showDatesForPopup();
      self.openModalForVencimientoEdit();
    });
  }

  renderRecibidoVencimiento(item1, item2) {
    return 'Recibido: ' + this.dateService.dateFormat(new Date(item1)) + ' | Vencimiento: ' + this.dateService.dateFormat(new Date(item2));
  }

  openModalForVencimientoEdit() {
    // this.showDatesForPopup();

    this.openModal()
  }

  generateColumns(): any[] {
    var columns = [
      { data: 'casa', title: 'Nombre CAAC', render: (item) => item.nomcaac },
      { data: null, title: 'Acta Asamblea', render: (data, type, row: Vencimiento) => this.renderRecibidoVencimiento(row.asamrecib, row.asambaja),  },
      { data: null, title: 'Acta Autoridades', render: (data, type, row: Vencimiento) => this.renderRecibidoVencimiento(row.autorirecib, row.autoribaja) },
      { data: null, title: 'AFIP', render: (data, type, row: Vencimiento) => this.renderRecibidoVencimiento(row.afiprecib, row.afipbaja) },
      { data: null, title: 'Seguro de Responsabilidad Civil', render: (data, type, row: Vencimiento) => this.renderRecibidoVencimiento(row.responrecib, row.responbaja) }
    ];
    var malaPraxis = [];
    for(let i = 1; i <= 10; i++)
      malaPraxis.push({ data: null, title: 'Seguro de Malapraxis ' + i,
        render:(data, type, row: Vencimiento) => row['malapra' + i] + ' | ' + this.dateService.dateFormat(new Date(row['fechVenMala' + i])) });

    columns.push.apply(columns, malaPraxis);

    return columns
  }

  openModal() {
    $('#form').show();
    $('#form').modal({
      backdrop: 'static',
      keyboard: false,
      show: true
    });
  }

  closeModal() {
    $('#form').hide();
    $('#form').modal({
      backdrop: 'static',
      keyboard: false,
      show: false
    });
    this.vencimientoParaPopup = null;
  }

  onClickGuardar() {
    const self = this;
    this.vencimientoService.saveVencimiento(this.vencimientoParaPopup).subscribe(data => {
      NotifUtil.notifSuccess('Guardado exitosamente');
      self.reloadTable();
      self.closeModal();
    }, (error) => {
      console.error(error);
      NotifUtil.notifError('Error al guardar');
    });
  }

  reloadTable() {
    const table = $('#vencimientosTable').DataTable();

    table.ajax.reload();
  }

  private showDatesForPopup(): void {

    for(let i = 1; i <= 10; i++) {
      this.vencimientoParaPopup['fechRecMala' + i] = new Date(this.vencimientoParaPopup['fechRecMala' + i]);
      this.vencimientoParaPopup['fechVenMala' + i] = new Date(this.vencimientoParaPopup['fechVenMala' + i]);
    }
    ['afip', 'asam', 'autori', 'respon'].forEach(elem => {
      this.vencimientoParaPopup[elem + 'recib'] = new Date(this.vencimientoParaPopup[elem + 'recib']);
      this.vencimientoParaPopup[elem + 'baja'] = new Date(this.vencimientoParaPopup[elem + 'baja']);
    })
  }
}
