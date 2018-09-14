import {AfterViewInit, Component, OnInit} from '@angular/core';
import MainConstants from '../../constants/main-constants';
import {UrlConstants} from "../../tomi/services/UrlConstants";
import {fromEvent} from "rxjs/observable/fromEvent";
import {UrlConstantsCaac} from "../../fede/constants/url-constants";
import {SidebarUtils} from "../../sidebar-utils";

declare var $: any;

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.css']
})
export class InicioComponent implements OnInit, AfterViewInit {
  private navigateTo: string = '';
  constructor() { }

  ngOnInit() {
  }

  ngAfterViewInit() {
    const btnCaac = document.getElementById('btnCaac');
    const btnCaacClickEvent = fromEvent(btnCaac, 'click');

    btnCaacClickEvent.subscribe((e: any) => $('.caac-item').show());
  }

  caacTitle() {
    return MainConstants.CAAC;
  }

  caacSiglas() {
    return MainConstants.CAAC_SIGLAS;
  }

  sigeseTitle() {
    return MainConstants.SIGESE;
  }

  sigeseSiglas() {
    return MainConstants.SIGESE_SIGLAS;
  }

  getUrlCaacGeneral() {
    return UrlConstantsCaac.GENERAL_URL;
  }

  getUrlSigese(): string {
    return '/' + UrlConstants.CONSULTAS;
  }

  handleSidebar(){
    SidebarUtils.handleSidebar(this.navigateTo);
  }

}
