import { StorageService } from './services/storage.service';
import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError, of } from 'rxjs';




const TOKEN_HEADER_KEY = 'Authorization';
const AUTH_TOKEN = 'AuthToken';

@Injectable()
export class Interceptor implements HttpInterceptor {

  constructor(private storageService:StorageService) { }

  intercept(req: HttpRequest<any>, next: HttpHandler):
    Observable<HttpEvent<any>> {
    let authReq = req;
    console.log('auth token is :'+ this.storageService.get(AUTH_TOKEN));
    console.log('check headers :'+JSON.stringify(req));
    if (this.storageService.get(AUTH_TOKEN) !== undefined && this.storageService.get(AUTH_TOKEN) !== null) {
      authReq = req.clone({ headers: req.headers.set(TOKEN_HEADER_KEY, 'Bearer'+this.storageService.get(AUTH_TOKEN))});
    }
    return next.handle(authReq);
  }
}
