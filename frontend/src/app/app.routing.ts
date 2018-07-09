import {ModuleWithProviders} from '@angular/core';
import {RouterModule,Routes} from '@angular/router';
import { AuthGuard } from './usercontrol/aut.guard';

import { HomeComponent} from './components/home.component';
import { ProductosListComponent} from './components/productos-list.component';
import { ProductoAddComponent} from './components/producto-add.component';
import { ProductoDetailComponent} from './components/producto-detail.component';
import { ProductoUpdateComponent} from './components/producto-update.component';
import { UsersComponent} from './components/users.component';
import { ErrorComponent} from './components/error.component';
import { ListaCompraComponent } from './components/lista-compra.component';
import { FacturaComponent } from './components/factura.component';


const appRoutes:Routes = [
    {path:'',component:HomeComponent},
    {path:'home',component:HomeComponent},
    {path:'productos-list',component:ProductosListComponent},
    {path:'producto-add',component:ProductoAddComponent, canActivate: [AuthGuard]},
    {path:'producto/:id',component:ProductoDetailComponent},
    {path:'editar/:id',component:ProductoUpdateComponent},
    {path:'cesta',component:ListaCompraComponent},
    {path:'factura',component:FacturaComponent},
    {path:'users',component:UsersComponent, canActivate: [AuthGuard]},
    {path:'**',component:ErrorComponent}//esta ruta tienes que ser la ultima, es para rutas no validas
];

export const appRoutingProviders:any[] =[];
export const routing:ModuleWithProviders = RouterModule.forRoot(appRoutes);
