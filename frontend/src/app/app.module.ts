import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import {DataTableModule} from "angular2-datatable";

import { AppComponent } from './app.component';
import { HomeComponent} from './components/home.component';
import { ProductosListComponent} from './components/productos-list.component';
import { ProductoAddComponent} from './components/producto-add.component';
import { ProductoDetailComponent} from './components/producto-detail.component';
import { ProductoUpdateComponent} from './components/producto-update.component';
import { ErrorComponent} from './components/error.component';
import { UsersComponent} from './components/users.component';
import { routing,appRoutingProviders} from './app.routing';
import {ModalModule} from "ng2-modal";
import { AuthGuard } from './usercontrol/aut.guard';

import { RecaptchaModule } from 'ng-recaptcha';
import { ListaCompraComponent } from './components/lista-compra.component';
import { FacturaComponent } from './components/factura.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ProductosListComponent,
    ProductoAddComponent,
    ProductoDetailComponent,
    ProductoUpdateComponent,
    ListaCompraComponent,
    FacturaComponent,
    UsersComponent,
    ErrorComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routing,
    ModalModule,
    DataTableModule,
    RecaptchaModule.forRoot()
 ],
  providers: [appRoutingProviders,AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
