import { HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
})
export class LoginComponent {
  constructor(private authService: AuthService, private router: Router) { }

  email = '';
  password = '';
  errors = '';
  submit(loginForm: NgForm) {
    const thiss = this;
    const { email, password } = loginForm.value;
    const loginObserver = {
      next() {
      },
      error(err: HttpErrorResponse) {
        thiss.showAlert(err.error.message)
      },
      complete() {
        thiss.router.navigate(['/'])
        localStorage.setItem('token', 'true');
      }
    }
    this.authService.login(email, password).subscribe(loginObserver);
  }
  showAlert(msg: string) {
    this.errors = msg;
    setTimeout(() => this.errors = '', 3000);
  }
}

