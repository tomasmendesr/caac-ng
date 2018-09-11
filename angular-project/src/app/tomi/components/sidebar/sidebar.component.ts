import { Component, OnInit } from '@angular/core';
import {UrlConstants} from "../../services/UrlConstants";

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
  selectedItem: string = 'inicio';

  constructor() { }

  ngOnInit() {
  }

  getUrlConsultas(): string {
    return "/" + UrlConstants.CONSULTAS;
  }

  getUrlMensualSeccionA(): string{
    return "/" + UrlConstants.MENSUAL_SECCION_A;
  }

  getUrlMensualSeccionB(): string {
    return "/" + UrlConstants.MENSUAL_SECCION_B;
  }

  getUrlMensualSeccionC1(): string {
    return "/" + UrlConstants.MENSUAL_SECCION_C1;
  }

  getUrlMensualSeccionC2(): string {
    return "/" + UrlConstants.MENSUAL_SECCION_C2;
  }

  getUrlMensualSeccionC3(): string {
    return "/" + UrlConstants.MENSUAL_SECCION_C3;
  }

  getUrlMensualSeccionC4(): string {
    return "/" + UrlConstants.MENSUAL_SECCION_C4;
  }

  getUrlMensualSeccionC5(): string {
    return "/" + UrlConstants.MENSUAL_SECCION_C5;
  }

  getUrlMensualSeccionC6(): string {
    return "/" + UrlConstants.MENSUAL_SECCION_C6;
  }

  getUrlMensualSeccionD(): string {
    return "/" + UrlConstants.MENSUAL_SECCION_D;
  }

  getUrlEstructuralSeccionA(): string {
    return "/" + UrlConstants.ESTRUCTURAL_SECCION_A;
  }

  getUrlEstructuralSeccionB(): string {
    return "/" + UrlConstants.ESTRUCTURAL_SECCION_B;
  }

  getUrlEstructuralSeccionCD(): string {
    return "/" + UrlConstants.ESTRUCTURAL_SECCION_C_D;
  }

  getUrlEstructuralSeccionE(): string {
    return "/" + UrlConstants.ESTRUCTURAL_SECCION_E;
  }
  getUrlEstructuralSeccionE2(): string {
    return "/" + UrlConstants.ESTRUCTURAL_SECCION_E2;
  }
  getUrlEstructuralSeccionE3(): string {
    return "/" + UrlConstants.ESTRUCTURAL_SECCION_E2;
  }
  getUrlEstructuralSeccionF(): string {
    return "/" + UrlConstants.ESTRUCTURAL_SECCION_F;
  }
  getUrlEstructuralSeccionG(): string {
    return "/" + UrlConstants.ESTRUCTURAL_SECCION_G;
  }
  getUrlEstructuralSeccionH(): string {
    return "/" + UrlConstants.ESTRUCTURAL_SECCION_H;
  }
  getUrlCierrePeriodo(): string {
    return "/" + UrlConstants.CIERRE_PERIODO;
  }
}
