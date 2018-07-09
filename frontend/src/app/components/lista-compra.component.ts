import {Component} from '@angular/core';
import {ActivatedRoute,Params, Router} from '@angular/router';
import {ProductoService} from '../services/producto.service';
import {GLOBAL} from '../services/global';
import { AuthGuard } from '../usercontrol/aut.guard';
import { forEach } from '@angular/router/src/utils/collection';
import { Factura } from '../models/factura';

@Component({
    selector: 'productos-list',
    templateUrl: '../views/lista-compra.html',
    providers: [ProductoService]
})
export class ListaCompraComponent{
    public titulo:string;
    public confirmado;
    public logado:boolean;

    public factura: Factura;

    public cestaCompra = new Array<String>();

    constructor(
        private _route:ActivatedRoute,
        private _router:Router,
        private _service:ProductoService,
        private _auth:AuthGuard
    ){
        this.titulo = 'Cesta de la compra';
        
        this.logado=false;
        this.factura = new Factura('','','',null);
    }

    ngOnInit(){
        console.log('Página ListaCompra cargada');
        this._route.queryParams.subscribe(params => {
            this.cestaCompra = params['items'];
      });
    }

    onSubmit(){
        this.factura.listadoTelefonos = this.cestaCompra;
        this._router.navigate(['/factura'], { queryParams: { name: this.factura.nombre, 
                                                             apellido: this.factura.apellidos, 
                                                             email: this.factura.email, 
                                                             tel: this.factura.listadoTelefonos } });
        
    } 
}
