import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {UrlConstants} from "../caac/services/UrlConstants";
import {ErrorPageComponent} from "../caac/components/error-page/error-page.component";
import {InicioComponent} from "../caac/components/inicio/inicio.component";
import {BlankComponent} from "../caac/components/blank/blank.component";
import {AbmUsuariosComponent} from "../caac/components/abm-usuarios/abm-usuarios.component";

const routes: Routes = [
  {
    path: '',
    redirectTo: UrlConstants.INICIO,
    pathMatch: 'full'},
  {
    path: UrlConstants.ERROR_PAGE,
    component: ErrorPageComponent
  },
  {
    path: UrlConstants.INICIO,
    component: InicioComponent
  },
  {
    path: UrlConstants.BLANK,
    component: BlankComponent
  },
  {
    path: UrlConstants.ABM_USUARIOS_VIEW,
    component: AbmUsuariosComponent
  }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [ RouterModule]
})
export class AppRoutingModule { }
