import {AfterViewInit, Component, OnInit} from '@angular/core';
import Vencimiento from "../../../model/vencimiento";
import {COLUMN_NOMBRE_CAAC} from "../../constants/commons-constants";
import {UrlConstantsCaac} from "../../constants/url-constants";
import {DataTableService} from "../../../services/data-table.service";

declare var $: any;

@Component({
  selector: 'app-vencimiento-view',
  templateUrl: './vencimiento-view.component.html',
  styleUrls: ['./vencimiento-view.component.css']
})
export class VencimientoViewComponent implements OnInit, AfterViewInit {

  TITLE: string = 'Vencimientos';
  TABLE_ID: string = 'vencimientosTable';
  vencimientoParaPopup: Vencimiento;
  vencimientosPropertys: any[] = [
    {id1: 'asamrecib', id2: 'asambaja', id3: '', descripcion: 'Acta asamblea', textField: false },
    {id1: 'asamrecib', id2: 'asambaja', id3: '', descripcion: 'Acta asamblea', textField: false },
    {id1: 'autorirecib', id2: 'autoribaja', id3: '', descripcion: 'Acta Autoridades:', textField: false},
    {id1: 'afiprecib', id2: 'afipbaja', id3: '', descripcion: 'AFIP:', textField: false},
    {id1: 'responrecib', id2: 'responbaja', id3: '', descripcion: 'Seguro de Responsabilidad Civil:', textField: false},
    {id1: 'fechRecMala1', id2: 'fechVenMala1', id3: 'malapra1', descripcion: 'Seguro de Mala praxis 1:', textField: true},
    {id1: 'fechRecMala2', id2: 'fechVenMala2', id3: 'malapra2', descripcion: 'Seguro de Mala praxis 2:', textField: true},
    {id1: 'fechRecMala3', id2: 'fechVenMala3', id3: 'malapra3', descripcion: 'Seguro de Mala praxis 3:', textField: true},
    {id1: 'fechRecMala4', id2: 'fechVenMala4', id3: 'malapra4', descripcion: 'Seguro de Mala praxis 4:', textField: true},
    {id1: 'fechRecMala5', id2: 'fechVenMala5', id3: 'malapra5', descripcion: 'Seguro de Mala praxis 5:', textField: true},
    {id1: 'fechRecMala6', id2: 'fechVenMala6', id3: 'malapra6', descripcion: 'Seguro de Mala praxis 6:', textField: true},
    {id1: 'fechRecMala7', id2: 'fechVenMala7', id3: 'malapra7', descripcion: 'Seguro de Mala praxis 7:', textField: true},
    {id1: 'fechRecMala8', id2: 'fechVenMala8', id3: 'malapra8', descripcion: 'Seguro de Mala praxis 8:', textField: true},
    {id1: 'fechRecMala9', id2: 'fechVenMala9', id3: 'malapra9', descripcion: 'Seguro de Mala praxis 9:', textField: true},
    {id1: 'fechRecMala10', id2: 'fechVenMala10', id3: 'malapra10', descripcion: 'Seguro de Mala praxis 10:', textField: true},
  ];

  constructor(private dataTableService: DataTableService) { }

  ngOnInit() {
  }

  ngAfterViewInit() {
    this.loadDataTable();
  }

  loadDataTable() {
    const self = this;
    const columns = [
      { data: COLUMN_NOMBRE_CAAC, title: 'Nombre CAAC' },
      // { title: 'Acta Autoridades', render(item) },
      // { data: , title: 'Provincia', render: (item) => item.nombre },
    ];
    const table = this.dataTableService.buildTable(
      this.TABLE_ID,
      self,
      columns,
      UrlConstantsCaac.FIND_ALL_VENCIMIENTOS,
      (data) => JSON.stringify(data),
      [],
      false
    );

    $('#tablaInformacionGeneral tbody').on('click', 'tr', function () {
      const vencimiento = table.row(this).data();

      self.vencimientoParaPopup = vencimiento;
      self.openModalForVencimientoEdit(self.vencimientoParaPopup);
    });
  }

  openModalForVencimientoEdit(vencimientoParaPopup: Vencimiento) {

  }
}
