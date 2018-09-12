import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Casa} from "../../../model/casa";
import {CasaService} from "../../services/casa.service";
import {MesService} from "../../services/mes.service";
import {FormControl} from "@angular/forms";
import {Observable} from "rxjs/Observable";
import {Mes} from "../../../model/mes";
import {ConsultaComponent} from "../consulta/consulta.component";
import {map, startWith} from 'rxjs/operators';
import {HeaderSigeseForms} from "../../../model/header-sigese-forms";
import {HeaderEvent} from "../../../model/header-event";
import {MatAutocompleteSelectedEvent} from "@angular/material";

@Component({
  selector: 'app-header-caac-selection',
  templateUrl: './header-caac-selection.component.html',
  styleUrls: ['./header-caac-selection.component.css']
})
export class HeaderCaacSelectionComponent implements OnInit {
  headerSigeseForms: HeaderSigeseForms = new HeaderSigeseForms;

  private casaCtrl: FormControl = new FormControl();
  private casas: Casa[] = [];
  private filteredCasas: Observable<Casa[]>;
  private meses: Mes[] = [];
  private anios: number[] = [];

  @Output()
  headerChanged: EventEmitter<any> = new EventEmitter();

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

  selectedCasa(casa: Casa){
    this.headerSigeseForms.casa = casa;
    this.emitChanges(HeaderEvent.CASA);
  }

  onChangeMesCarga(mes: any){
    if(mes != null && mes != 'undefined') {
      this.headerSigeseForms.mesCarga = mes;
      this.emitChanges(HeaderEvent.MES_CARGA);
    }
  }

  onChangeAnioCarga($event: any){
    let anio = $event.target.value;
    if(anio != null && anio != 'undefined') {
      this.headerSigeseForms.anioCarga = anio;
      this.emitChanges(HeaderEvent.ANIO_CARGA);
    }
  }

  emitChanges(atributoQueFueModificado: string){
    this.onChangeHeader(new HeaderEvent(atributoQueFueModificado, this.headerSigeseForms));
  }

  private onChangeHeader(headerEvent: HeaderEvent){
    this.headerChanged.emit(headerEvent);
  }
}
