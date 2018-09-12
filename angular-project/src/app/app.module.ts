import { BrowserModule } from '@angular/platform-browser';
import {APP_INITIALIZER, NgModule} from '@angular/core';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {AppRoutingModule} from './services/app-routing.module';

import { AppComponent } from './app.component';
import { AppNavbarComponent } from './share-components/app-navbar/app-navbar.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { LocationStrategy } from '@angular/common';
import { HashLocationStrategy } from '@angular/common';
import { NgxPermissionsModule } from 'ngx-permissions';
import {EventBusService} from './services/event-bus.service';
import {NotificacionComponent} from './share-components/notificacion/notificacion.component';
import { SidebarComponent } from './tomi/components/sidebar/sidebar.component';
import {AppHttpInterceptor} from './services/http.interceptor';
import {SafePipe} from "./tomi/utils/safe-pipe";
import {BlankComponent} from "./share-components/blank/blank.component";
import {ErrorPageComponent} from "./share-components/error-page/error-page.component";
import {AppLoadService} from "./services/app-load.service";
import {InicioComponent} from "./share-components/inicio/inicio.component";
import { AbmUsuariosComponent } from './share-components/abm-usuarios/abm-usuarios.component';
import {UsuarioService} from "./tomi/services/usuario.service";
import {LoadingComponent} from "./share-components/loading/loading.component";
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import {MatAutocompleteModule, MatFormFieldModule, MatInputModule, MatSelectModule} from "@angular/material";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import { CaacViewComponent } from './fede/components/caac-view/caac-view.component';
import { ConsultaComponent } from './tomi/components/consulta/consulta.component';
import {MesService} from "./tomi/services/mes.service";
import {CasaService} from "./tomi/services/casa.service";
import { MensualSeccionAComponent } from './tomi/components/mensual/mensual-seccion-a/mensual-seccion-a.component';
import { MensualSeccionBComponent } from './tomi/components/mensual/mensual-seccion-b/mensual-seccion-b.component';
import { MensualSeccionC1Component } from './tomi/components/mensual/mensual-seccion-c1/mensual-seccion-c1.component';
import { MensualSeccionC2Component } from './tomi/components/mensual/mensual-seccion-c2/mensual-seccion-c2.component';
import { MensualSeccionC3Component } from './tomi/components/mensual/mensual-seccion-c3/mensual-seccion-c3.component';
import { MensualSeccionC4Component } from './tomi/components/mensual/mensual-seccion-c4/mensual-seccion-c4.component';
import { MensualSeccionC5Component } from './tomi/components/mensual/mensual-seccion-c5/mensual-seccion-c5.component';
import { MensualSeccionC6Component } from './tomi/components/mensual/mensual-seccion-c6/mensual-seccion-c6.component';
import { MensualSeccionDComponent } from './tomi/components/mensual/mensual-seccion-d/mensual-seccion-d.component';
import { CierrePeriodoComponent } from './tomi/components/cierre-periodo/cierre-periodo.component';
import { EstructuralSeccionAComponent } from './tomi/components/estructural/estructural-seccion-a/estructural-seccion-a.component';
import { EstructuralSeccionBComponent } from './tomi/components/estructural/estructural-seccion-b/estructural-seccion-b.component';
import { EstructuralSeccionEComponent } from './tomi/components/estructural/estructural-seccion-e/estructural-seccion-e.component';
import { EstructuralSeccionE2Component } from './tomi/components/estructural/estructural-seccion-e2/estructural-seccion-e2.component';
import { EstructuralSeccionE3Component } from './tomi/components/estructural/estructural-seccion-e3/estructural-seccion-e3.component';
import { EstructuralSeccionFComponent } from './tomi/components/estructural/estructural-seccion-f/estructural-seccion-f.component';
import { EstructuralSeccionGComponent } from './tomi/components/estructural/estructural-seccion-g/estructural-seccion-g.component';
import { EstructuralSeccionHComponent } from './tomi/components/estructural/estructural-seccion-h/estructural-seccion-h.component';
import { EstructuralSeccionCdComponent } from './tomi/components/estructural/estructural-seccion-cd/estructural-seccion-cd.component';
import { GeneralViewComponent } from './fede/components/general-view/general-view.component';
import { AdministrativoViewComponent } from './fede/components/administrativo-view/administrativo-view.component';
import { VencimientoViewComponent } from './fede/components/vencimientos-view/vencimiento-view.component';
import { AuditoriaViewComponent } from './fede/components/auditoria-view/auditoria-view.component';
import { PagosViewComponent } from './fede/components/pagos-view/pagos-view.component';
import { ReportesViewComponent } from './fede/components/reportes-view/reportes-view.component';

// npm install --save @angular/material @angular/cdk @angular/animations

export function get_parametros_iniciales(appLoader: AppLoadService) {
  return () => appLoader.get_parametros_iniciales();
}

@NgModule({
  declarations: [
    AppComponent,
    AppNavbarComponent,
    NotificacionComponent,
    SidebarComponent,
    BlankComponent,
    ErrorPageComponent,
    SafePipe,
    InicioComponent,
    AbmUsuariosComponent,
    LoadingComponent,
    CaacViewComponent,
    ConsultaComponent,
    MensualSeccionAComponent,
    MensualSeccionBComponent,
    MensualSeccionC1Component,
    MensualSeccionC2Component,
    MensualSeccionC3Component,
    MensualSeccionC4Component,
    MensualSeccionC5Component,
    MensualSeccionC6Component,
    MensualSeccionDComponent,
    CierrePeriodoComponent,
    EstructuralSeccionAComponent,
    EstructuralSeccionBComponent,
    EstructuralSeccionEComponent,
    EstructuralSeccionE2Component,
    EstructuralSeccionE3Component,
    EstructuralSeccionFComponent,
    EstructuralSeccionGComponent,
    EstructuralSeccionHComponent,
    EstructuralSeccionCdComponent,
    GeneralViewComponent,
    AdministrativoViewComponent,
    VencimientoViewComponent,
    AuditoriaViewComponent,
    PagosViewComponent,
    ReportesViewComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    MatFormFieldModule,
    MatSelectModule,
    MatAutocompleteModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatInputModule,
    NgbModule.forRoot(),
    NgxPermissionsModule.forRoot(),
    MatProgressSpinnerModule
  ],
  providers: [
    { provide: LocationStrategy, useClass: HashLocationStrategy },
    {provide: HTTP_INTERCEPTORS, useClass: AppHttpInterceptor, multi: true},
    AppLoadService,
    { provide: APP_INITIALIZER, useFactory: get_parametros_iniciales, deps: [AppLoadService], multi: true},
    EventBusService,
    UsuarioService,
    MesService,
    CasaService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
