import {Component, OnInit, ViewChild} from '@angular/core';
import {UsuarioService} from "../../services/usuario.service";
import {LoadingComponent} from "../loading/loading.component";
import {EventBusService} from "../../../services/event-bus.service";
import {Usuario} from "../../model/usuario";
import {Subject} from "rxjs/Subject";
import {DefaultFilter} from "../../filters/default-filter";
import {NotifUtil} from "../../utils/notif-util";
import {AppResponse} from "../../model/app-response";
import {environment} from "../../../../environments/environment";
import {UrlConstants} from "../../services/UrlConstants";

declare var $: any; // jquery

@Component({
  selector: 'app-abm-usuarios',
  templateUrl: './abm-usuarios.component.html',
  styleUrls: ['./abm-usuarios.component.css']
})
export class AbmUsuariosComponent implements OnInit {
  @ViewChild(LoadingComponent) loadingComponent:LoadingComponent;
  usuarioEnEdicion: Usuario = new Usuario;
  filter: DefaultFilter = new DefaultFilter;
  formMessages: string[] = [];
  keyUp = new Subject<any>();

  constructor(private usuarioService: UsuarioService, private eventBusService: EventBusService) { }

  ngOnInit() {
    this.captureCloseModalEvent();
    this.buildTable();
  }

  private updateTable() {
    $('#table').DataTable().ajax.reload();
  }

  private buildTable() {
    const self = this;
    $.fn.dataTable.ext.errMode = 'none';

    const table = $('#table').DataTable({
      columns: [// el atributo data se toma en el server para sacar la columna por la que se ordena
        {data: 'id', title: 'Id'},
        {data: 'nombre', title: 'Nombre'},
        {data: 'apellido', title: 'Apellido'},
        {data: 'username', title: 'Username'},
        {data: 'fechaDeNacimiento', title: 'Fecha de nacimiento', render: function(data){
          let date = new Date();
          date.setTime(data);
          return date.getDate() + "/"+  (date.getMonth() + 1) + "/" + date.getFullYear();
        }},
        {
          data: null, title: 'Acciones', defaultContent: self.buildTableButtons(),
          orderable: false, width: 90
        }
      ],
      processing: true,
      serverSide: true,
      searching: false,
      scrollX: true,
      ajax: {
        url: environment.apiUrl + UrlConstants.GET_USERS_FOR_TABLE,
        type: 'POST',
        contentType: 'application/json',
        data: function (d) {
          d.filter = self.filter;
          return JSON.stringify(d);
        },
        error: function (xhr, error, thrown) {
          if(xhr.responseJSON && xhr.responseJSON.code == 403){
            NotifUtil.notifError(xhr.responseJSON.message)
          } else if (xhr.status === 401 || xhr.status === 0) {
            self.eventBusService.broadcast('http-error-auth', null);
          }
        }
      },
      language: {
        url: 'assets/datatable/spanish.json'
      },
      select: true,
      dom: 'Blfrtip',
      buttons: [
            'copy',
            'excel',
            'csv',
            'pdf',
            'print'
      ]/*,
       / responsive: opcional. Oculta columnas al achicar la pantalla
       responsive: {
       details: {
       display: $.fn.dataTable.Responsive.display.modal({
       header: function (row) {
       var data = row.data();
       return 'Detalles de ' + data.titulo;
       }
       }),
       renderer: $.fn.dataTable.Responsive.renderer.tableAll({
       tableClass: 'table'
       })
       }
       }*/
    });

    $('#table tbody').on('click', '.edit', function () {
      self.usuarioEnEdicion = table.row($(this).parents('tr').first()).data();
      self.openModal();
    });

    $('#table tbody').on('click', '.delete', function () {
      self.usuarioEnEdicion = table.row($(this).parents('tr').first()).data();
      self.usuarioService.isInUse(self.usuarioEnEdicion).subscribe(appResponse => {
        if(appResponse.data){
          self.resetUser();
          NotifUtil.notifError("El registro no se puede eliminar porque se encuentra en uso");
        }
        else self.showConfirmDialog();
      }, (error) => {
        let errorResponse = JSON.parse(error.error);
          NotifUtil.notifError(errorResponse.message);
      });
    });
  }

  private buildTableButtons(): string {
    var html = "<button class='btn btn-success'><span class='fas fa-edit'></span></button>";
    html = html + "  <button class='btn btn-danger'><span class='fas fa-trash'></span></button>";
    return html;
  }

  onClickAceptar(event: any) {
    this.loadingComponent.showLoading();
    event.preventDefault();
    this.usuarioService.validateInputs(this.usuarioEnEdicion).subscribe(appResponse => this.onSuccess(appResponse));
  }

  private onSuccess(appResponse: any) {
    if (appResponse.code == AppResponse.SUCCESS) {
      this.usuarioService.saveOrUpdate(this.usuarioEnEdicion).subscribe(response => {
        this.loadingComponent.hideLoading();
        this.updateTable();
      },(error) => {
        let errorResponse = JSON.parse(error.error);
          console.log(errorResponse.error);
          NotifUtil.notifError(errorResponse.message);
          this.loadingComponent.hideLoading();
      });
      this.closeModal();
    } else {
      this.loadingComponent.hideLoading();
      this.formMessages = <string[]> appResponse.data;
      $('#formAlert').show();
    }
  }

  private initSearchBox(){
    this.keyUp.map(event => event.target.value)
      .debounceTime(300)
      .distinctUntilChanged()
      .subscribe(r => this.updateTable());
  }

  private captureCloseModalEvent() {
    var self = this;
    $("#form").on("hidden.bs.modal", function () {
      self.resetUser();
    });
    this.hideFormAlert();
  }

  hideFormAlert() {
    $('#formAlert').hide();
  }

  onClickConfirmarEliminacion(event: any){
    this.usuarioService.delete(this.usuarioEnEdicion).subscribe(
      response => {
        this.updateTable();
        NotifUtil.notifSuccess("El usuario '" + this.usuarioEnEdicion.username + "' fue eliminado con éxito");
        this.resetUser();
      });
    $("#confirmDialog").modal('hide');
  }

  showConfirmDialog(){
    $("#confirmDialog").modal({
      backdrop: 'static',
      keyboard: false,
      show: true
    });
  }

  resetUser(){
    this.usuarioEnEdicion = new Usuario;
  }

  openModal() {
    $('#form').modal({
      backdrop: 'static',
      keyboard: false,
      show: true
    });
  }

  closeModal() {
    $("#form").modal('hide');
    this.hideFormAlert();
  }

}
