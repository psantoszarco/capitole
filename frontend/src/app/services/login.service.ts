import {Injectable} from '@angular/core';
import {Http,Response,Headers,RequestOptions} from '@angular/http';
import 'rxjs/add/operator/map';
import {Observable} from 'rxjs/Observable';
import {User} from '../models/user';
import {GLOBAL} from './global';
import { reject } from 'q';

@Injectable()
export class LoginService{

    public urlLogin:string;
    public urlUsers:string;

    constructor(
        public _http:Http
    ){
        this.urlLogin = GLOBAL.urlLogin;
        this.urlUsers = GLOBAL.urlUsers;
    }

    login(user:User){
        let values = { username: user.userName, password: user.password,grant_type: 'password' };
        let headers = new Headers({'Content-type':'application/x-www-form-urlencoded',
                                   'Authorization': 'Basic cHJ1ZWJhOnNlY3JldC1wcnVlYmE='});
        return this._http.post(this.urlLogin,this.getFormUrlEncoded(values),{headers:headers});
    }

    getFormUrlEncoded(toConvert) {
		const formBody = [];
		for (const property in toConvert) {
			const encodedKey = encodeURIComponent(property);
			const encodedValue = encodeURIComponent(toConvert[property]);
			formBody.push(encodedKey + '=' + encodedValue);
		}
		return formBody.join('&');
	}

    singIn(user:User){
        var llamada:string = this.urlUsers+'sign-in'; 
        let json = JSON.stringify(user);
        let token = localStorage.getItem('currentUser');
        let headers = new Headers({'Content-type':'application/json;charset=UTF-8',
                                    'Authorization':  this.obtenerToken(token)});

        return this._http.post(llamada,json,{headers:headers}).map(res=>res.json());
    }

    getAllUsers(){
        var llamada:string = this.urlUsers+'user-list'; 
        let token = localStorage.getItem('currentUser');
        let headers = new Headers({'Content-type':'application/json;charset=UTF-8',
                                    'Authorization':  this.obtenerToken(token)});

        return this._http.get(llamada,{headers:headers}).map(res=>res.json());
    }

    obtenerToken(valorLocalStorage){
        let json = JSON.parse(valorLocalStorage);
        return 'Bearer '+json.token;
    }
}