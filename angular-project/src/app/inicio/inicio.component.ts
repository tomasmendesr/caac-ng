import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import MainConstants from './../constants/main-constants';
import {UrlConstants} from "../tomi/services/UrlConstants";

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.css']
})

export class InicioComponent implements OnInit {
  selectedItem: string;


  constructor(private router: Router) { }

  ngOnInit() {
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

  getUrlCaac() {
    return '/' + UrlConstants.CAAC_VIEW;
  }

  getUrlSigese() {
    return '/' + UrlConstants.SIGESE_VIEW;
  }
}
