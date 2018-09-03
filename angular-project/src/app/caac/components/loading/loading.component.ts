import { Component, OnInit } from '@angular/core';

declare var $: any;

@Component({
  selector: 'app-loading',
  templateUrl: './loading.component.html',
  styleUrls: ['./loading.component.css']
})
export class LoadingComponent implements OnInit {
  constructor(){}

  ngOnInit() {
  }

  showLoading(){
    $('#loadingModal').modal({
      backdrop: 'static',
      keyboard: false,
      show: true
    });
  }

  hideLoading(){
     $('#loadingModal').modal('hide');
  }
}
