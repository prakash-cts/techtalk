import { StorageService } from './../../services/storage.service';
import { Router, RouterModule } from '@angular/router';
import { DataService } from './../../services/data.service';
import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  emailFormControl = new FormControl('', [Validators.required, Validators.email]);
  passwordFormControl = new FormControl('',[Validators.required]);
  loginForm = this.fb.group({
    email : this.emailFormControl,
    password : this.passwordFormControl
  })
  message!: string;
  
  constructor(private dataService : DataService,
    private fb: FormBuilder,
    private router: Router,
    private storageService:StorageService) { }

  ngOnInit(): void {
    
      this.dataService.getUserData().subscribe(data=>{
        this.storageService.set('AuthToken',data);
        console.log('the AuthToken is :'+data);
      })
  }
  submit(){
    if(this.loginForm.invalid){
      return;
    }
    console.log(this.loginForm.value);
    this.dataService.signUpUser(this.loginForm.get('email')?.value,this.loginForm.get('password')?.value).subscribe(data=>{
      console.log('login is :'+data);
      if(data === 'valid'){
        this.router.navigate(['dashboard']);
      }
    })
  }
  register(){
    this.router.navigate(['signup']);
  }

}
