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
import {MatOptionSelectionChange} from "@angular/material";

@Component({
  selector: 'app-header-caac-selection',
  templateUrl: './header-caac-selection.component.html',
  styleUrls: ['./header-caac-selection.component.css']
})
export class HeaderCaacSelectionComponent implements OnInit {
  private headerSigeseForms: HeaderSigeseForms = new HeaderSigeseForms;
  private casaCtrl: FormControl = new FormControl();
  private casas: Casa[] = [];
  private filteredCasas: Observable<Casa[]>;
  private meses: Mes[] = [];
  private anios: number[] = [];
  private modificarValoresCarga: boolean = true;

  @Output()
  headerChanged: EventEmitter<any> = new EventEmitter();

  constructor(private casaService: CasaService, private mesService: MesService) { }

  ngOnInit() {
    this.initLists();
  }

  private initLists(){
    this.mesService.findAll().subscribe(data => this.meses = data);
    this.casaService.findAllDTO().subscribe(data => {
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
    if(value == null || !value) {
      this.selectedCasa(null,null);
      return this.casas;
    }
    const filterValue = value.toLowerCase();
    return this.casas.filter(casa => casa.nomcaac.toLowerCase().includes(filterValue));
  }

  private selectedCasa(event: MatOptionSelectionChange, casa: Casa){
    if(event != null && event.source.selected){
      this.headerSigeseForms.casa = casa;
      this.emitChanges(HeaderEvent.CASA);
    }else if(casa == null){
      this.headerSigeseForms.casa = null;
      this.emitChanges(HeaderEvent.CASA);
    }
  }

  private onChangeMesCarga(mes: any){
    this.headerSigeseForms.mesCarga = mes == -1 ? null : mes;
    this.emitChanges(HeaderEvent.MES_CARGA);
  }

  private onChangeAnioCarga($event: any){
    let anio = $event.target.value;
    this.headerSigeseForms.anioCarga = anio == -1 ? null : anio;
    this.emitChanges(HeaderEvent.ANIO_CARGA);
  }

  private habilitarEdicionCarga(){
    this.casaCtrl.enable();
    this.modificarValoresCarga = true;
  }

  private deshabilitarEdicionCarga(){
    this.modificarValoresCarga = false;
    this.casaCtrl.disable();
  }

  private emitChanges(atributoQueFueModificado: string){
    if(this.allInputsCargaSeted()) this.deshabilitarEdicionCarga();
    this.onChangeHeader(new HeaderEvent(atributoQueFueModificado, this.headerSigeseForms));
  }

  private allInputsCargaSeted(): boolean {
    return this.headerSigeseForms.casa && this.headerSigeseForms.mesCarga && this.headerSigeseForms.anioCarga != null;
  }

  onChangeHeader(headerEvent: HeaderEvent){
    this.headerChanged.emit(headerEvent);
  }

  private saveOrUpdate(){

  }
}
