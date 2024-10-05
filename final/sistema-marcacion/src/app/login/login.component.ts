import { Component } from '@angular/core';

@Component({
  selector: 'app-login',
  template: '',
  standalone: true,
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  constructor() {
    window.location.href = 'http://localhost:8081/login'; // Redirigir al login del backend
  }
}

