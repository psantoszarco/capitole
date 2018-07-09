import {Component,ViewChild} from '@angular/core';
import {Router,ActivatedRoute,Params} from '@angular/router';
import {ProductoService} from '../services/producto.service';
import { Producto } from '../models/producto';
import {GLOBAL} from '../services/global';

@Component({
    selector: 'producto-update',
    templateUrl: '../views/producto-update.html',
    providers: [ProductoService]
})
export class ProductoUpdateComponent{
    public titulo:string;
    public producto:Producto;
    public urlImages;
    public urlPreview;
    public filesToUpload;
    public resultUpload;
    
    @ViewChild('uploader')
    uploader: any;

    constructor(
        private _route:ActivatedRoute,
        private _router:Router,
        private _service:ProductoService
    ){
        this.titulo = 'Modificación del Producto';
        this.urlImages = GLOBAL.urlImages+'uploads/';
    }

    ngOnInit(){
        console.log('Página ProductoUpdateComponent cargada');
        this._route.params.forEach((params:Params) => {
            let id = params['id'];
            this.getProducto(id);
        })
    } 

    onSubmit(){
        if(this.filesToUpload && this.filesToUpload.length >= 1){
            this._service.subirArchivo([],this.filesToUpload).then((result) => {
                    this.resultUpload =result;
                    this.guardarProducto(this.resultUpload.filename);
                },
                (error) => {
                console.log(<any>error);
                }
            );
        }else{
            this.guardarProducto("");
        }
        
    }


    guardarProducto(imagen:string){

        this.producto.imagen=imagen;
        console.log(this.producto);
        this._service.updateProducto(this.producto).subscribe(
            result =>{

                if(result.code == 200){
                   this._router.navigate(['/productos-list']);
                }else{
                   alert("Se ha producido un error");
                }
                
            },
            error => {
                console.log(<any>error);
            }
        );
    }

    limpiarImagen(){
        this.uploader.nativeElement.value = "";
        this.producto.imagen="";
        this.urlPreview="";
    }

    restaurar(){
        this.uploader.nativeElement.value = "";
        this.getProducto(this.producto.id);
        this.urlPreview="";
    }

    fileChangeEvent(fileInput:any){
        this.filesToUpload = <Array<File>> fileInput.target.files;
        if (this.filesToUpload && this.filesToUpload[0]) {
            var reader = new FileReader();
        
            reader.onload = (event:any) => {
              this.urlPreview = event.target.result;
            }
        
            reader.readAsDataURL(this.filesToUpload[0]);
          }
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

    borrarProducto(id){
        this._service.borrarProducto(id).subscribe(
            result =>{

                if(result.code == 200){
                    this._router.navigate(['/productos-list']);
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