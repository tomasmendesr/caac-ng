import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {UrlConstants} from "../tomi/services/UrlConstants";
import {ErrorPageComponent} from "../tomi/components/error-page/error-page.component";
import {InicioComponent} from "../inicio/inicio.component";
import {BlankComponent} from "../tomi/components/blank/blank.component";
import {AbmUsuariosComponent} from "../tomi/components/abm-usuarios/abm-usuarios.component";
import {CaacViewComponent} from "../fede/components/caac-view/caac-view.component";
import {SigeseViewComponent} from "../tomi/components/sigese-view/sigese-view.component";

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
  },
  {
    path: UrlConstants.CAAC_VIEW,
    component: CaacViewComponent
  },
  {
    path: UrlConstants.SIGESE_VIEW,
    component: SigeseViewComponent
  }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [ RouterModule]
})
export class AppRoutingModule { }
