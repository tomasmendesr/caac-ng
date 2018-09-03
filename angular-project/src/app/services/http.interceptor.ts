import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import {HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';

import {EventBusService} from "./event-bus.service";
import { environment } from '../../environments/environment';

@Injectable()
export class AppHttpInterceptor  implements HttpInterceptor {
  constructor(private eventBusService: EventBusService) {}

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    let apiReq = req.clone({ url: this.getDevUrl() + req.url });
//    const token = localStorage.getItem('auth_token');
/*
    apiReq = apiReq.clone({
      setHeaders: {
        Authorization: `Bearer ${token}`
      }
    });
*/
    return next.handle(apiReq)
      .catch(err => {
        console.log('Caught error', err);
        if (err instanceof HttpErrorResponse) {
          if (err.status === 401 || err.status === 403) {
            this.eventBusService.broadcast('http-error-auth', err);
          }
        }
        return Observable.throw(err);
      });
  }


  private getDevUrl() {
    return environment.apiUrl;
  }
}
