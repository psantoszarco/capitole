import {Component} from '@angular/core';
import { AuthGuard } from '../usercontrol/aut.guard';

@Component({
    selector: 'home',
    templateUrl: '../views/home.html'
})
export class HomeComponent{
    public titulo:string;
    public logado:boolean;
    constructor(private _auth:AuthGuard){
        this.titulo = 'Página de Teléfonos';
        this.logado=false;
    }

    ngOnInit(){
        console.log('Página Home cargada');
        this.logado=this._auth.canActivate();
    }
}
