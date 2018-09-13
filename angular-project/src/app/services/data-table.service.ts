import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {NotifUtil} from "../tomi/utils/notif-util";

declare var $:any;

@Injectable()
export class DataTableService {

  constructor() { }

  public buildTable(tableId: string, controller: any, columns: any[], requestUrl: string, filter: any, exportButtons: string[], selectable: boolean): any {
    const self = controller;
    $.fn.dataTable.ext.errMode = 'none';

    return $('#' + tableId).DataTable({
      columns: columns,
      processing: true,
      serverSide: true,
      searching: false,
      scrollX: true,
      ajax: {
        url: environment.apiUrl + requestUrl,
        type: 'POST',
        contentType: 'application/json',
        data: (data) => {
          data.filter = filter;

          return JSON.stringify(data);
        },
        error: (xhr, error, thrown) => {
          if (xhr.responseJSON && xhr.responseJSON.code == 403) {
            NotifUtil.notifError(xhr.responseJSON.message)
          } else if (xhr.status === 401 || xhr.status === 0) {
            self.eventBusService.broadcast('http-error-auth', null);
          }
        }
      },
      language: {
        url: 'assets/datatable/spanish.json'
      },
      select: selectable,
      buttons: exportButtons/*[
        'copy',
        'excel',
        'csv',
        'pdf',
        'print'
      ]*/
      //, dom: 'Blfrtip'
    });
  }

}
