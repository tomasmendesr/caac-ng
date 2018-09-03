import {Injectable} from '@angular/core';
import {CanActivate, Router} from '@angular/router';


@Injectable()
export class EnsureAuthenticated implements CanActivate {
  constructor(private routerr: Router) {

  }

  canActivate(): boolean {
    if (localStorage.getItem('role_user') == null) { // TODO a constantes
      return true;
    }
    else {
      this.routerr.navigateByUrl('usuarios'); //TODO pagina de no permisos
      return false;
    }
  }
}
