import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {UrlConstants} from "../tomi/services/UrlConstants";
import {ErrorPageComponent} from "../share-components/error-page/error-page.component";
import {InicioComponent} from "../share-components/inicio/inicio.component";
import {BlankComponent} from "../share-components/blank/blank.component";
import {CaacViewComponent} from "../fede/components/caac-view/caac-view.component";
import {ConsultaComponent} from "../tomi/components/consulta/consulta.component";
import {MensualSeccionAComponent} from "../tomi/components/mensual/mensual-seccion-a/mensual-seccion-a.component";
import {MensualSeccionBComponent} from "../tomi/components/mensual/mensual-seccion-b/mensual-seccion-b.component";
import {MensualSeccionC1Component} from "../tomi/components/mensual/mensual-seccion-c1/mensual-seccion-c1.component";
import {MensualSeccionC2Component} from "../tomi/components/mensual/mensual-seccion-c2/mensual-seccion-c2.component";
import {MensualSeccionC3Component} from "../tomi/components/mensual/mensual-seccion-c3/mensual-seccion-c3.component";
import {MensualSeccionC4Component} from "../tomi/components/mensual/mensual-seccion-c4/mensual-seccion-c4.component";
import {MensualSeccionC5Component} from "../tomi/components/mensual/mensual-seccion-c5/mensual-seccion-c5.component";
import {MensualSeccionC6Component} from "../tomi/components/mensual/mensual-seccion-c6/mensual-seccion-c6.component";
import {CierrePeriodoComponent} from "../tomi/components/cierre-periodo/cierre-periodo.component";
import {EstructuralSeccionAComponent} from "../tomi/components/estructural/estructural-seccion-a/estructural-seccion-a.component";
import {MensualSeccionDComponent} from "../tomi/components/mensual/mensual-seccion-d/mensual-seccion-d.component";
import {EstructuralSeccionBComponent} from "../tomi/components/estructural/estructural-seccion-b/estructural-seccion-b.component";
import {EstructuralSeccionCdComponent} from "../tomi/components/estructural/estructural-seccion-cd/estructural-seccion-cd.component";
import {EstructuralSeccionEComponent} from "../tomi/components/estructural/estructural-seccion-e/estructural-seccion-e.component";
import {EstructuralSeccionE2Component} from "../tomi/components/estructural/estructural-seccion-e2/estructural-seccion-e2.component";
import {EstructuralSeccionE3Component} from "../tomi/components/estructural/estructural-seccion-e3/estructural-seccion-e3.component";
import {EstructuralSeccionFComponent} from "../tomi/components/estructural/estructural-seccion-f/estructural-seccion-f.component";
import {EstructuralSeccionGComponent} from "../tomi/components/estructural/estructural-seccion-g/estructural-seccion-g.component";
import {EstructuralSeccionHComponent} from "../tomi/components/estructural/estructural-seccion-h/estructural-seccion-h.component";

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
    path: UrlConstants.CAAC_VIEW,
    component: CaacViewComponent
  },
  {
    path: UrlConstants.CONSULTAS,
    component: ConsultaComponent
  },
  {
    path: UrlConstants.MENSUAL_SECCION_A,
    component: MensualSeccionAComponent
  },
  {
    path: UrlConstants.MENSUAL_SECCION_B,
    component: MensualSeccionBComponent
  },
  {
    path: UrlConstants.MENSUAL_SECCION_C1,
    component: MensualSeccionC1Component
  },
  {
    path: UrlConstants.MENSUAL_SECCION_C2,
    component: MensualSeccionC2Component
  },
  {
    path: UrlConstants.MENSUAL_SECCION_C3,
    component: MensualSeccionC3Component
  },
  {
    path: UrlConstants.MENSUAL_SECCION_C4,
    component: MensualSeccionC4Component
  },
  {
    path: UrlConstants.MENSUAL_SECCION_C5,
    component: MensualSeccionC5Component
  },
  {
    path: UrlConstants.MENSUAL_SECCION_C6,
    component: MensualSeccionC6Component
  },
  {
    path: UrlConstants.MENSUAL_SECCION_D,
    component: MensualSeccionDComponent
  },
  {
    path: UrlConstants.CIERRE_PERIODO,
    component: CierrePeriodoComponent
  },
  {
    path: UrlConstants.ESTRUCTURAL_SECCION_A,
    component: EstructuralSeccionAComponent
  },
  {
    path: UrlConstants.ESTRUCTURAL_SECCION_B,
    component: EstructuralSeccionBComponent
  },
  {
    path: UrlConstants.ESTRUCTURAL_SECCION_C_D,
    component: EstructuralSeccionCdComponent
  },
  {
    path: UrlConstants.ESTRUCTURAL_SECCION_E,
    component: EstructuralSeccionEComponent
  },
  {
    path: UrlConstants.ESTRUCTURAL_SECCION_E2,
    component: EstructuralSeccionE2Component
  },
  {
    path: UrlConstants.ESTRUCTURAL_SECCION_E3,
    component: EstructuralSeccionE3Component
  },
  {
    path: UrlConstants.ESTRUCTURAL_SECCION_F,
    component: EstructuralSeccionFComponent
  },
  {
    path: UrlConstants.ESTRUCTURAL_SECCION_G,
    component: EstructuralSeccionGComponent
  },
  {
    path: UrlConstants.ESTRUCTURAL_SECCION_H,
    component: EstructuralSeccionHComponent
  }

];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [ RouterModule]
})
export class AppRoutingModule { }
