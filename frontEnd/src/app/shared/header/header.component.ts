import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
})
export class HeaderComponent implements OnInit {
  constructor(private router: Router) { }
  logged: boolean = false
  ngOnInit(): void {
    if (localStorage.getItem('token') == 'true') this.logged = true;
  }

  gotToLogin() {
    this.router.navigate(['/login'])
  }

  goToRegister() {
    this.router.navigate(['/register'])
  }


}
