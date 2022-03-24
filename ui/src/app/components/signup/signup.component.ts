import { DataService } from './../../services/data.service';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormBuilder, Validators } from '@angular/forms';
import { PasswordValidator } from './password.validator';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {
  emailFormControl = new FormControl('', [Validators.required, Validators.email]);
  passwordFormControl = new FormControl('',[Validators.required]);
  passwordCheckFormControl = new FormControl('',[Validators.required]);
  signupForm = this.fb.group({
    email : this.emailFormControl,
    password : this.passwordFormControl,
    confirmPassword: this.passwordCheckFormControl
  },{
    validator: PasswordValidator('password', 'confirmPassword')
  })
  constructor(private fb:FormBuilder,
    private router: Router,
    private dataService: DataService) { }

  ngOnInit(): void {
  }

  submit(){
    if(this.signupForm.invalid){
      return;
    }
    console.log(this.signupForm.value);
    this.dataService.signUpUser(this.signupForm.get('email')?.value,this.signupForm.get('password')?.value).subscribe(data=>{
      console.log('sign up is :'+data);
      if(data === 'valid'){
        this.router.navigate(['dashboard']);
      }
    })
  }
  gotoLogin(){
    this.router.navigate(['login']);
  }
}
