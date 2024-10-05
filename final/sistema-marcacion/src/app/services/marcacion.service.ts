import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MarcacionService {
  private baseUrl = 'http://localhost:8081/v1/marcacion';

  constructor(private http: HttpClient) {}

  registrarMarcacion(tipo: string): Observable<string> {
    return this.http.post<string>(`${this.baseUrl}/registrar`, { tipo });
  }

  obtenerMarcaciones(): Observable<any> {
    return this.http.get<any>(this.baseUrl);
  }
}
