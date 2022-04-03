import { DialogService } from './../../services/dialog.service';
import { DataService } from './../../services/data.service';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormBuilder, Validators, ValidatorFn, ValidationErrors, AbstractControl } from '@angular/forms';
import { PasswordValidator } from './password.validator';
import { delay } from "rxjs/operators";

export function forbiddenNameValidator(nameRe: string): ValidatorFn {
  return (control: AbstractControl): ValidationErrors | null => {
    const forbidden = RegExp(nameRe).test(control.value);
    return forbidden ? {forbiddenName: {value: control.value}} : null;
  };
}

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {
  emailFormControl = new FormControl('', [Validators.required, Validators.email,
    //forbiddenNameValidator('^[A-Za-z.]+@cognizant.com$')
  ]);
  passwordFormControl = new FormControl('',[Validators.required]);
  passwordCheckFormControl = new FormControl('',[Validators.required]);
  signupForm = this.fb.group({
    email : this.emailFormControl,
    password : this.passwordFormControl,
    confirmPassword: this.passwordCheckFormControl
  },{
    validator: PasswordValidator('password', 'confirmPassword')
  });
  regex!: string;
  validEmail: boolean = true;
  signUpValid = true;
  constructor(private fb:FormBuilder,
    private router: Router,
    private dataService: DataService,
    private dialogService: DialogService) { }

  ngOnInit(): void {
    this.dataService.getRegex().subscribe(data=>{
      this.regex=data;
      console.log('regex is :'+this.regex);
    })
  }

  submit(){
    if(this.signupForm.invalid){
      return;
    }
    const validate = RegExp(this.regex);
    if (validate.test(this.signupForm.get('email')?.value)) {
      this.validEmail = true;
      //this.emailFormControl.setErrors(null);
    } else {
      this.validEmail = false;
      //this.emailFormControl.setErrors({ validRegex: true });
      return;
    }
    console.log(this.signupForm.value);
    this.dataService.signUpUser(this.signupForm.get('email')?.value,this.signupForm.get('password')?.value).subscribe(data=>{
      console.log('sign up is :'+data);
      if(data === 'valid'){
        this.dialogService.openDialogWithNoTitleOkButton('User '+this.signupForm.get('email')?.value+' is regeistered succesfully').then(
          result=>{
            this.router.navigate(['dashboard']);
          }
        )
        
      }else{
        this.signUpValid = false;
      }
    })
  }
  gotoLogin(){
    this.router.navigate(['login']);
  }
}
