import {AfterViewInit, Component, OnInit} from '@angular/core';
import {FormGroup} from "@angular/forms";
import {DataTableService} from "../../../services/data-table.service";
import CaacLight from "../../model/caac-light";
import Pago from "../../../model/pago";
import {UrlConstantsCaac} from "../../constants/url-constants";

declare var $: any;

@Component({
  selector: 'app-pagos-view',
  templateUrl: './pagos-view.component.html',
  styleUrls: ['./pagos-view.component.css']
})
export class PagosViewComponent implements OnInit, AfterViewInit {

  isLinear = false;
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  TABLE_PAGOS_CASAS_ID = 'tablePagosCasas';

  casaParaPagos: CaacLight;
  pagoDeCasa: Pago;

  constructor(private dataTableService: DataTableService) { }

  ngOnInit() {
  }

  ngAfterViewInit(): void {
    this.loadTable();
  }

  loadTable(): void {
    const self = this;
    const columns = [
      { data: 'casa.nomcaac', title: 'Nombre CAAC' },
      { data: 'casa.perjuridica', title: 'Personería Juridica' },
      { data: 'mes', title: 'Mes'},
      { data: 'anio', title: 'Año'},
      { data: 'numFac', title: 'N° de factura'},
      { data: 'numExp', title: 'N° Expediente de pago'},
      { data: 'fechPag', title: 'Fecha pago' },
      { data: 'monto', title: 'Monto' },
      { data: 'asistidos', title: 'Asistidos' },
      { data: 'atendidos', title: 'Atendidos' },
      { data: 'observaciones', title: 'Observaciones' }
    ];

    const table = this.dataTableService.buildTable(
      self.TABLE_PAGOS_CASAS_ID,
      self,
      columns,
      UrlConstantsCaac.FIND_ALL_CASAS_CON_PAGOS,
      (data) => JSON.stringify(data),
      [],
      false
    );

    $('#tablePagosCasas tbody').on('click', 'tr', function () {
      self.casaParaPagos = table.row(this).data();

      console.log(JSON.stringify(self.casaParaPagos));
    });
  }

}
