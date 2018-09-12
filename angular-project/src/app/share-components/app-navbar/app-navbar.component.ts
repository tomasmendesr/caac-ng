import {AfterViewChecked, AfterViewInit, Component, OnInit} from '@angular/core';
import {fromEvent} from "rxjs/observable/fromEvent";
import {Observable} from "rxjs/Observable";
import {UrlConstantsCaac} from "../../fede/constants/url-constants";

declare var $: any;

@Component({
  selector: 'app-navbar',
  templateUrl: './app-navbar.component.html',
  styleUrls: ['./app-navbar.component.css']
})
export class AppNavbarComponent implements OnInit {

  TITLE = "CAAC";

  constructor() { }

  ngOnInit() {
    this.setupEvents();
    this.hideAllNavBarItems();
  }

  hideAllNavBarItems() {
    $('.caac-item').hide();
    $('.sigese-item').hide();
  }


  setupEvents() {
    const navBarTitle = document.getElementById('nav-bar-title');
    const navBarClick = fromEvent(navBarTitle, 'click');

    navBarClick.subscribe((e) => this.hideAllNavBarItems());
  }

  getGeneralLink() {
    return UrlConstantsCaac.GENERAL_URL;
  }

  getAdministrativoLink() {
    return UrlConstantsCaac.ADMINISTRATIVO_URL;
  }

  getVencimientosLink() {
    return UrlConstantsCaac.VENCIMIENTOS_URL;
  }

  getAuditoriaLink() {
    return UrlConstantsCaac.AUDITORIA_URL;
  }

  getPagosLink() {
    return UrlConstantsCaac.PAGOS_URL;
  }

  getReportesLink() {
    return UrlConstantsCaac.REPORTES_URL;
  }
}
