import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {UrlConstants} from "../tomi/services/UrlConstants";
import {ErrorPageComponent} from "../share-components/error-page/error-page.component";
import {InicioComponent} from "../share-components/inicio/inicio.component";
import {BlankComponent} from "../share-components/blank/blank.component";
import {AbmUsuariosComponent} from "../share-components/abm-usuarios/abm-usuarios.component";
import {CaacViewComponent} from "../fede/components/caac-view/caac-view.component";
import {ConsultaComponent} from "../tomi/components/consulta/consulta.component";

const routes: Routes = [
  {
    path: '',
    redirectTo: UrlConstants.INICIO,
    pathMatch: 'full'
  },
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
    path: UrlConstants.CONSULTAS,
    component: ConsultaComponent
  }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [ RouterModule]
})
export class AppRoutingModule { }
