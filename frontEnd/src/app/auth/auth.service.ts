import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  baseApi: string = 'http://localhost:8080/auth/';

  constructor(private http: HttpClient) { }

  login(email: string, password: string) {
    return this.http.post(this.baseApi + 'login', {
      email: email,
      password: password
    });
  }

  register(email: string, username: string, password: string) {
    return this.http.post(this.baseApi + 'register', {
      email: email,
      username: username,
      password: password
    });
  }
}
