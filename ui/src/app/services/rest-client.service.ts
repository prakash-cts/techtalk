import { environment } from './../../environments/environment';
import { Injectable } from '@angular/core';
import { HttpClient, HttpEvent, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RestClientService {

  private serverUrl = environment.apiURL;

  constructor(private http: HttpClient) { }


  get<returnType>(path:string,opts?: Map<string,any>, headers?: Map<string, string>){
    const url=this.serverUrl+'/'+path;
    // const hs: HttpHeaders = new HttpHeaders(); 
    // hs.set('Content-Type', 'application/json');
    const options: any={
      headers: new HttpHeaders({})
    };
    if (opts) {
      opts.forEach((key, value) => {
        options[key]=value;
      });
    }
    if (headers) {
      if (!headers.has('Content-Type')) {
        options.headers=options.headers.set('Content-Type', 'application/json');
      } 
      headers.forEach((key,value)=>{
        options.headers=options.headers.set(value, key);
      })
    }
    return this.http.get<returnType>(url, options);
  }

  
}

