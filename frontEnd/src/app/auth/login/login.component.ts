import { Component } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  submit(e: Event) {
    e.preventDefault();
  }
  login() {
    console.log('login');
  }
}

