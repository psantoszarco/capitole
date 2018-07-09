import {Component} from '@angular/core';
import {ActivatedRoute,Params, Router} from '@angular/router';
import {ProductoService} from '../services/producto.service';
import {GLOBAL} from '../services/global';
import { AuthGuard } from '../usercontrol/aut.guard';
import { forEach } from '@angular/router/src/utils/collection';
import { Factura } from '../models/factura';

@Component({
    selector: 'productos-list',
    templateUrl: '../views/factura.html',
    providers: [ProductoService]
})
export class FacturaComponent{
    public titulo:string;
    public model: any = {};
    public factura: Factura = new Factura('','','',null);

    constructor(
        private _route:ActivatedRoute,
        private _service:ProductoService,
        private _auth:AuthGuard
    ){
        this.titulo = 'Factura';
    }

    ngOnInit(){
        console.log('Página Factura cargada');
        this._route.queryParams.subscribe(params => {
            this.factura.nombre = params['name'];
            this.factura.email = params['email'];
            this.factura.listadoTelefonos = params['tel'];

            this.generarFactura();
      });
    }     

    generarFactura() {
        this._service.calcularFactura(this.factura).subscribe(
            result =>{
                if(result.code == 200){
                    this.model.nombre = result.name;
                    this.model.email = result.email;
                    this.model.telefonos = result.lstProductos;
                    this.model.total = result.total;
                }else{
                    alert('Se ha producido un error');
                }
                
            },
            error => {
                console.log(<any>error);
            }
        ); 
    }
}
