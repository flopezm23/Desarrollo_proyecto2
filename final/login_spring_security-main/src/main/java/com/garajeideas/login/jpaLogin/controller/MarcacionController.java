package com.garajeideas.login.jpaLogin.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/marcacion")
public class MarcacionController {

    @PostMapping("/registrar")
    public ResponseEntity<String> registrarMarcacion(@RequestBody MarcacionRequest request) {
        // Lógica para registrar la marcación
        return ResponseEntity.ok("Marcación de tipo " + request.getTipo() + " registrada correctamente.");
    }

    @GetMapping(produces = MediaType.TEXT_HTML_VALUE) // Especifica que devuelve HTML
    public ResponseEntity<String> obtenerMarcaciones() {
        String htmlResponse = "<html>" +
                "<head>" +
                "<title>Lista de Marcaciones</title>" +
                "<style>" +
                "body { font-family: Arial, sans-serif; background-color: #f4f4f4; color: #333; margin: 0; padding: 20px; }" +
                "h1 { text-align: center; }" +
                ".container { max-width: 800px; margin: auto; padding: 20px; background: white; border-radius: 5px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); }" +
                "table { width: 100%; border-collapse: collapse; margin-top: 20px; }" +
                "th, td { padding: 10px; text-align: left; border-bottom: 1px solid #ddd; }" +
                "th { background-color: #f2f2f2; }" +
                ".button { background-color: #4CAF50; color: white; padding: 10px 15px; border: none; border-radius: 5px; cursor: pointer; }" +
                ".button:hover { background-color: #45a049; }" +
                "</style>" +
                "</head>" +
                "<body>" +
                "<div class='container'>" +
                "<h1>Lista de Marcaciones</h1>" +
                "<button class='button' onclick=\"window.location.href='/v1/marcacion/registrar'\">Registrar Marcación</button>" +
                "<table>" +
                "<thead>" +
                "<tr>" +
                "<th>ID</th>" +
                "<th>Empleado</th>" +
                "<th>Fecha</th>" +
                "<th>Hora</th>" +
                "<th>Tipo</th>" +
                "</tr>" +
                "</thead>" +
                "<tbody>" +
                "<tr>" +
                "<td>1</td>" +
                "<td>Fernando</td>" + // Nombre del usuario
                "<td>2024-10-04</td>" + // Fecha de la marcación
                "<td>08:00 AM</td>" + // Hora de entrada
                "<td>Entrada</td>" + // Tipo de marcación
                "</tr>" +
                "</tbody>" +
                "</table>" +
                "</div>" +
                "</body>" +
                "</html>";
        return ResponseEntity.ok(htmlResponse);
    }

    // Clase para representar la respuesta
    class MarcacionResponse {
        private String message;

        public MarcacionResponse(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    class MarcacionRequest {
        private String tipo;

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }
    }
}