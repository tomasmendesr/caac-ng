import {AfterViewChecked, AfterViewInit, Component, OnInit} from '@angular/core';
import {fromEvent} from "rxjs/observable/fromEvent";
import {Observable} from "rxjs/Observable";

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
}
