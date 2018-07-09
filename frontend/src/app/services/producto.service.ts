import {Injectable} from '@angular/core';
import {Http,Response,Headers,RequestOptions} from '@angular/http';
import 'rxjs/add/operator/map';
import {Observable} from 'rxjs/Observable';
import {Producto} from '../models/producto';
import {GLOBAL} from './global';
import { reject } from 'q';
import { Factura } from '../models/factura';


@Injectable()
export class ProductoService{

    public urlProductos:string;

    public urlImagenes:string;

    constructor(
        public _http:Http
    ){
        this.urlProductos = GLOBAL.urlProductos;
        this.urlImagenes = GLOBAL.urlImages;
    }

    getProductos(){
        var llamada:string = this.urlProductos+'productos'; 
        return this._http.get(llamada).map(res=>res.json());
    }

    getProducto(id){
        var llamada:string = this.urlProductos+'producto/'+id; 
        return this._http.get(llamada).map(res=>res.json());
    }

    addProducto(producto:Producto){
        var llamada:string = this.urlProductos+'save-producto'; 
        let json = JSON.stringify(producto);
        let token = localStorage.getItem('currentUser');
        let headers = new Headers({'Content-type':'application/json;charset=UTF-8',
                                    'Authorization':  this.obtenerToken(token)});

        return this._http.post(llamada,json,{headers:headers}).map(res=>res.json());
    }

    updateProducto(producto:Producto){
        var llamada:string = this.urlProductos+'update-producto'; 
        let json = JSON.stringify(producto);
        let token = localStorage.getItem('currentUser');
        let headers = new Headers({'Content-type':'application/json;charset=UTF-8',
                                    'Authorization':  this.obtenerToken(token)});

        return this._http.post(llamada,json,{headers:headers}).map(res=>res.json());
    }

    borrarProducto(id){
        var llamada:string = this.urlProductos+'delete-producto/'+id; 
        let token = localStorage.getItem('currentUser');
        let headers = new Headers({'Content-type':'application/json;charset=UTF-8',
                                    'Authorization': this.obtenerToken(token)});
        return this._http.get(llamada,{headers:headers}).map(res=>res.json());
    }

    subirArchivo(params:Array<string>,files:Array<File>){
        let url :string = this.urlImagenes+'upload-file'; 
        let token = localStorage.getItem('currentUser');
        return new Promise((resolve,reject) => {
            var formData:any = new FormData();
            var xhr = new XMLHttpRequest();

            for(var i=0; i < files.length ; i++){
                formData.append('file',files[i],files[i].name);
            }

            xhr.onreadystatechange = function(){
                if(xhr.readyState == 4){
                    if(xhr.status == 200){
                        resolve(JSON.parse(xhr.response));
                    }else{
                        reject(xhr.response);
                    }

                }
            };
            xhr.open("POST",url,true);
            xhr.setRequestHeader('Authorization', this.obtenerToken(token));
            xhr.send(formData);
        });
    }

    calcularFactura(factura:Factura){
        var llamada:string = this.urlProductos+'get-factura'; 
        let json = JSON.stringify(factura);
        let token = localStorage.getItem('currentUser');
        let headers = new Headers({'Content-type':'application/json;charset=UTF-8',
                                    'Authorization':  this.obtenerToken(token)});

        return this._http.post(llamada,json,{headers:headers}).map(res=>res.json());
    }

    obtenerToken(valorLocalStorage){
        let json = JSON.parse(valorLocalStorage);
        return 'Bearer '+json.token;
    }
}
