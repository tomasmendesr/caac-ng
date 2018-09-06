import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {UrlConstants} from "../tomi/services/UrlConstants";
import {ErrorPageComponent} from "../tomi/components/error-page/error-page.component";
import {InicioComponent} from "../tomi/components/inicio/inicio.component";
import {BlankComponent} from "../tomi/components/blank/blank.component";
import {AbmUsuariosComponent} from "../tomi/components/abm-usuarios/abm-usuarios.component";

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
