import { Component, OnInit} from '@angular/core';
import {LoginService} from '../services/login.service';
import {Router,ActivatedRoute,Params} from '@angular/router';
import { AuthGuard } from '../usercontrol/aut.guard';
import { User } from '../models/user';

@Component({
    selector: 'users',
    templateUrl: '../views/users.html',
    providers: [LoginService]
})
export class UsersComponent implements OnInit {

    public titulo:string;
    public data: any[];
    public filterQuery = "";
    public rowsOnPage = 5;
    public sortBy = "id";
    public sortOrder = "asc";
    public user:User;
    public esNuevo:boolean;

    constructor(private _service:LoginService,private _route:ActivatedRoute,
        private _router:Router,private _auth:AuthGuard){
            this.titulo = "Gestión de Usuarios";
            this.user = new User(-1,"","","","");
            this.esNuevo=false;
      }

      ngOnInit(): void {
        this._service.getAllUsers().subscribe(
            result =>{

                if(result.code == 200){
                    this.data = result.lstUsuarios;
                }else{
                    alert('Se ha producido un error');
                    this._router.navigate(['/home']);
                }
                
            },
            error => {
                console.log(<any>error);
            }
        );
    }

    editar(item){
        this.esNuevo=false;
        this.user = new User(item.id,item.nombre,"","","");
    }

    borrar(item){
        alert(item.nombre);
    }

    nuevo(){
        this.esNuevo=true;
        this.user = new User(-1,"","","","");
    }
}