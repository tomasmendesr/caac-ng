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
import { SigeseViewComponent } from './tomi/components/sigese-view/sigese-view.component';

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
    SigeseViewComponent
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
    UsuarioService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
