import {Component,ViewChild} from '@angular/core';
import {Router,ActivatedRoute,Params} from '@angular/router';
import {ProductoService} from '../services/producto.service';
import { Producto } from '../models/producto';

@Component({
    selector: 'productos-add',
    templateUrl: '../views/producto-add.html',
    providers: [ProductoService]
})
export class ProductoAddComponent{
    
    public titulo:string;
    public producto:Producto;
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
        this.titulo = 'Añadir Teléfono';
        this.producto = new Producto(0,'','','',0); 
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
        this._service.addProducto(this.producto).subscribe(
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
    ngOnInit(){
        console.log('Página ProductoAddComponent cargada');
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

    limpiarImagen(){
        this.uploader.nativeElement.value = "";
        this.urlPreview="";
    }
}
