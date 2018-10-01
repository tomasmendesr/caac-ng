import { Component, OnInit } from '@angular/core';
import {HeaderEvent} from "../../../../model/header-event";
import {Hoja} from "../../../../model/hoja";

@Component({
  selector: 'app-estructural-seccion-a',
  templateUrl: './estructural-seccion-a.component.html',
  styleUrls: ['./estructural-seccion-a.component.css']
})
export class EstructuralSeccionAComponent implements OnInit {
  private hoja: Hoja = new Hoja;
  private readonlyControl: boolean = true;

  constructor() { }

  ngOnInit() {
  }

  private onChangeHeader(headerEvent: HeaderEvent) {
  }

}
