import { Component, OnInit } from '@angular/core';
import {Casa} from "../../../model/casa";
import {CasaService} from "../../services/casa.service";
import {MesService} from "../../services/mes.service";
import {FormControl} from "@angular/forms";
import {Observable} from "rxjs/Observable";
import {Mes} from "../../../model/mes";
import {ConsultaComponent} from "../consulta/consulta.component";
import {map, startWith} from 'rxjs/operators';

@Component({
  selector: 'app-header-caac-selection',
  templateUrl: './header-caac-selection.component.html',
  styleUrls: ['./header-caac-selection.component.css']
})
export class HeaderCaacSelectionComponent implements OnInit {
  nombreCasaSeleccionada: string;
  anioCarga: number;
  mesCarga: number;

  anioRecuperacionDatos: number;
  mesRecuperacionDatos: number;

  casaCtrl: FormControl = new FormControl();
  casas: Casa[] = [];
  filteredCasas: Observable<Casa[]>;
  meses: Mes[] = [];
  anios: number[] = [];



  constructor(private casaService: CasaService, private mesService: MesService) { }

  ngOnInit() {
    this.initLists();
  }

  private initLists(){
    this.mesService.findAll().subscribe(data => this.meses = data);
    this.casaService.findAllLight().subscribe(data => {
      this.casas = data;
      this.filteredCasas = this.casaCtrl.valueChanges
        .debounceTime(400)
        .distinctUntilChanged()
        .pipe(
          startWith(''),
          map(value => this.searchCasa(value))
        );
    });
    let now = new Date;
    for(let i = ConsultaComponent.FROM_YEAR_FILTER; i <= now.getFullYear(); i++){
      this.anios.push(i);
    }
  }

  private searchCasa(value: string): Casa[] {
    if(value == null || !value) return this.casas;
    const filterValue = value.toLowerCase();
    return this.casas.filter(casa => casa.nomcaac.toLowerCase().includes(filterValue));
  }
}
