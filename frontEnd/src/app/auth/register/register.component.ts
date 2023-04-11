import { Component } from '@angular/core';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
})
export class RegisterComponent {

  submit(e: Event) {
    e.preventDefault();
    this.register();
  }
  register() {
    console.log('register');
  }

}
