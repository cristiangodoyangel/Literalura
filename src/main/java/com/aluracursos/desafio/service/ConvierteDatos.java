package com.aluracursos.desafio.service;

import com.fasterxml.jackson.core.JsonProcessingException; // Importa la excepción de Jackson.
import com.fasterxml.jackson.databind.ObjectMapper; // Importa el mapeador de objetos JSON.

// Clase que implementa la conversión de JSON a objetos Java.
public class ConvierteDatos implements IConvierteDatos {
    private ObjectMapper mapper = new ObjectMapper(); // Crea una instancia de ObjectMapper para manejar JSON.

    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {
            // Convierte el JSON a un objeto de la clase especificada.
            return mapper.readValue(json, clase);
        } catch (JsonProcessingException e) { // Captura errores al procesar el JSON.
            throw new RuntimeException(e); // Lanza una excepción en caso de error.
        }
    }
}
