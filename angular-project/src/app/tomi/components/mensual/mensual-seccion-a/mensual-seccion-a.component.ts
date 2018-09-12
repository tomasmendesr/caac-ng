import {ChangeDetectorRef, Component, Input, OnInit, ViewChild} from '@angular/core';
import {Observable} from "rxjs/Observable";
import {Provincia} from "../../../../model/provincia";
import {FormControl} from "@angular/forms";
import {PicsService} from "../../../services/pics.service";
import {map, startWith} from "rxjs/operators";
import {Hoja} from "../../../../model/hoja";
import {HeaderEvent} from "../../../../model/header-event";

@Component({
  selector: 'app-mensual-seccion-a',
  templateUrl: './mensual-seccion-a.component.html',
  styleUrls: ['./mensual-seccion-a.component.css']
})
export class MensualSeccionAComponent implements OnInit {
  hoja: Hoja = new Hoja;
  provinciaCtrl: FormControl = new FormControl();
  provincias: Provincia[] = [];
  filteredProvincias: Observable<Provincia[]>;
  readonlyControl: boolean = true;

  constructor(private picsService: PicsService) { }

  ngOnInit() {
    this.initLists();
    this.provinciaCtrl.disable();
  }

  private initLists(){
    this.picsService.findAllProvinciasCombo().subscribe(data => {
      this.provincias = data;
      this.filteredProvincias = this.provinciaCtrl.valueChanges
        .debounceTime(400)
        .distinctUntilChanged()
        .pipe(
          startWith(''),
          map(value => this.searchProvincia(value))
        );
    });
  }

  private searchProvincia(value: string): Provincia[] {
    if(value == null || !value) return this.provincias;
    const filterValue = value.toLowerCase();
    return this.provincias.filter(prov => prov.nombre.toLowerCase().includes(filterValue));
  }

  selectedProvincia(provincia: Provincia){
    this.hoja.casa.provincia = provincia;
  }

  onChangeHeader(headerEvent: HeaderEvent){
    console.log(headerEvent);
    this.readonlyControl = false;
    if(headerEvent.evento == HeaderEvent.CASA){
      this.provinciaCtrl.enable();
      this.hoja.casa = headerEvent.value[headerEvent.evento];
    } else if(headerEvent.evento == HeaderEvent.MES_CARGA){
      this.hoja.mes = headerEvent.value[headerEvent.evento];
    } else if(headerEvent.evento == HeaderEvent.ANIO_CARGA){
      this.hoja.anio = headerEvent.value[headerEvent.evento];
    }
    this.readonlyControl = true;
  }


}
