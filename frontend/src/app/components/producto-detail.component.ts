import {Component} from '@angular/core';
import {Router,ActivatedRoute,Params} from '@angular/router';
import {ProductoService} from '../services/producto.service';
import { Producto } from '../models/producto';
import {GLOBAL} from '../services/global';

@Component({
    selector: 'producto-detail',
    templateUrl: '../views/producto-detail.html',
    providers: [ProductoService]
})
export class ProductoDetailComponent{
    public titulo:string;
    public producto:Producto;
    public urlImages;

    constructor(
        private _route:ActivatedRoute,
        private _router:Router,
        private _service:ProductoService
    ){
        this.titulo = 'Detalle del Producto';
        this.urlImages = GLOBAL.urlImages+'uploads/';
    }

    ngOnInit(){
        console.log('Página ProductoDetail cargada');
        this._route.params.forEach((params:Params) => {
            let id = params['id'];
            this.getProducto(id);
        })
    } 

    getProducto(id){
        this._service.getProducto(id).subscribe(
            result =>{

                if(result.code == 200){
                    this.producto = result.lstProductos[0];
                }else{
                    this._router.navigate(['/productos-list']);
                    alert('El producto seleccionado no existe');
                }
                
            },
            error => {
                console.log(<any>error);
            }
        );
    }
}
