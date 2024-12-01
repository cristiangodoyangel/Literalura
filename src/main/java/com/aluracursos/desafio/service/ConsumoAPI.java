
package com.aluracursos.desafio.service; // Define el paquete del servicio.

import java.io.IOException; // Importa la excepción IOException.
import java.net.URI; // Importa la clase para representar URIs.
import java.net.http.HttpClient; // Importa la clase para crear un cliente HTTP.
import java.net.http.HttpRequest; // Importa la clase para construir solicitudes HTTP.
import java.net.http.HttpResponse; // Importa la clase para manejar respuestas HTTP.

// Clase encargada de consumir datos desde una API.
public class ConsumoAPI {
    // Método que recibe una URL y devuelve el contenido JSON como String.
    public String obtenerDatos(String url) {
        HttpClient client = HttpClient.newHttpClient(); // Crea un cliente HTTP.

        // Crea una solicitud HTTP con la URL proporcionada.
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url)) // Define la URI desde la URL dada.
                .build(); // Construye la solicitud.

        HttpResponse<String> response = null; // Inicializa la variable para almacenar la respuesta.
        try {
            // Envía la solicitud y obtiene la respuesta.
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) { // Captura excepciones posibles.
            throw new RuntimeException(e); // Lanza una excepción en caso de error.
        }

        // Devuelve el cuerpo de la respuesta (el JSON como String).
        return response.body();
    }
}
