import { Component,ViewChild, ElementRef } from '@angular/core';
import {LoginService} from './services/login.service';
import { User } from './models/user';
import {GLOBAL} from './services/global';
import {ModalModule} from "ng2-modal";
import {Router,ActivatedRoute,Params} from '@angular/router';
import { AuthGuard } from './usercontrol/aut.guard';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [LoginService]
})
export class AppComponent {
  
  @ViewChild('closeBtn') closeBtn: ElementRef;

  public title = 'Gestión de teléfonos';
  public user:User;
  public token: string;
  public errMensaje: string;
  public logado:boolean;
  public captchaOk:boolean;

  constructor(private _service:LoginService,private _route:ActivatedRoute,
    private _router:Router,private _auth:AuthGuard){
      this._router.routeReuseStrategy.shouldReuseRoute = function(){
        return false;
     }
    this.user = new User(-1,"","","","");
    this.errMensaje="";
    this.logado=false;
    this.captchaOk=false;
  }

  ngOnInit(){
    this.comprobarUsuario();
  }

  comprobarUsuario(){
    this.logado=this._auth.canActivate();
    if(this.logado){
      this.user = new User(-1,this._auth.getNombreUsuario(),"","","");
    }else{
      this.user = new User(-1,"","","","");
    }
  }

  onSubmit(){
    this.errMensaje="";
    this._service.login(this.user).subscribe(
        result =>{
            // set token property
            let json = result.json();
            this.token = json.access_token;
            // store username and jwt token in local storage to keep user logged in between page refreshes
            localStorage.setItem('currentUser', JSON.stringify({ username: this.user.userName, token: this.token }));
            this.closePopUp();
            this.comprobarUsuario();
            this._router.navigated = false;
            this._router.navigate(['/home']);
        },
        error => {
          this.errMensaje="El usuario / contraseña introducidos no son correctos.";
          console.log(<any>error);
        }
    );
  }
 
  resolved(captchaResponse: string) {
    this.captchaOk = true;
    console.log(`Resolved captcha with response ${captchaResponse}:`);
  }

  closePopUp(){
    this.closeBtn.nativeElement.click();
  }

  logIn(){
    this.captchaOk=false;
  }
  
  logout(): void {
    // clear token remove user from local storage to log user out
    this.token = null;
    localStorage.removeItem('currentUser');
    this.comprobarUsuario();
    this._router.navigated = false;
    this._router.navigate(['/home']);
}
  
}
