import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { MarcacionComponent } from './marcacion/marcacion.component';


const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'v1/home', component: HomeComponent },
  { path: 'v1/marcacion', component: MarcacionComponent },
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: '**', redirectTo: '/login' }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
