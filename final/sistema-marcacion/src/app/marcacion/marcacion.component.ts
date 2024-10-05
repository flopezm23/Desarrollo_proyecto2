import { Component } from '@angular/core';
import { MarcacionService } from '../services/marcacion.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-marcacion',
  templateUrl: './marcacion.component.html',
  styleUrls: ['./marcacion.component.css'],
  standalone: true,
  imports: [FormsModule]
})
export class MarcacionComponent {
  tipo: string = "";

  constructor(private marcacionService: MarcacionService) {}

  registrarMarcacion() {
    if (this.tipo) {
      this.marcacionService.registrarMarcacion(this.tipo).subscribe(
        response => {
          console.log(response);
          alert(`Marcación de ${this.tipo} registrada correctamente.`);
        },
        error => {
          console.error('Error al registrar la marcación', error);
          alert('Error al registrar la marcación. Inténtalo de nuevo.');
        }
      );
    } else {
      alert('Por favor, selecciona un tipo de marcación.');
    }
  }
}
