import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  private serverUrl = 'http://localhost:8080/';
  constructor(
    private http : HttpClient) { }

    // httpOptions = {
    //   headers: new HttpHeaders({
    //     //'Content-Type': 'application/json',
    //     'text':'responseType'
    //   }),
    // };

  getUserData(): Observable<string> {
    return this.http.get(this.serverUrl+'token',{responseType: 'text'});
  } 
  signUpUser(email: string, password: string): Observable<string> {
    const signUpBodyMap: any = {
      'email': email,
      'password': password
    };
    return this.http.post(this.serverUrl+'user', signUpBodyMap, {responseType: 'text'});
  }
  login(email: string, password: string): Observable<string> {
    const body: any = {
      'email': email,
      'password': password
    };
    return this.http.post(this.serverUrl+'user/login', body, {responseType: 'text'});
  }

  getRegex():Observable<string>{
    return this.http.get(this.serverUrl+'user/regex',{responseType: 'text'});
  }
  
  

}
