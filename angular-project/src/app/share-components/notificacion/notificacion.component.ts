import {Component, OnInit} from '@angular/core';
import {EventBusService} from '../../services/event-bus.service';
import {Router} from '@angular/router';
import { environment } from '../../../environments/environment';

declare var $: any;

@Component({
  selector: 'app-notificacion',
  templateUrl: './notificacion.component.html',
  styleUrls: ['./notificacion.component.css']
})
export class NotificacionComponent implements OnInit {
  titulo: string = "Alerta";
  aceptar: string = "Aceptar";
  cancelar: string = "Cancelar";
  body: string = "";
  aceptarFunction: () => void;
  cancelarFunction: () => void;

  constructor(private eventBusService: EventBusService, private router: Router){

    var self = this;
    self.eventBusService.on('http-error-auth', function (error) {
      self.body = "Su sesión ha expirado. Vuelva a iniciar sesión.";

      $("#myModal").modal('show');

      self.aceptarFunction = function(){
        $("#myModal").modal('hide');
        window.location.href = environment.apiUrl;
      };

      self.cancelarFunction = function(){
        $("#myModal").modal('hide');
      };
    });
  }

  ngOnInit() {}

  onClickAceptar(event) {
    event.preventDefault();
    this.aceptarFunction();
  }

  onClickCancelar(event) {
    event.preventDefault();
    this.cancelarFunction();
  }

}
