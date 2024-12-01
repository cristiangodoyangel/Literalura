package com.aluracursos.desafio.model;

// Define el paquete del modelo.

import com.fasterxml.jackson.annotation.JsonAlias; // Importa la anotación para mapear nombres de campos.
import com.fasterxml.jackson.annotation.JsonIgnoreProperties; // Importa la anotación para ignorar campos desconocidos.

import java.util.List; // Importa la clase para manejar listas.

// Clase que representa los datos generales de la API.
@JsonIgnoreProperties(ignoreUnknown = true) // Ignora campos no especificados en esta clase.
public record Datos(
        @JsonAlias("results") // Mapea el campo "results" del JSON a la propiedad resultados.
        List<DatosLibros> resultados // Lista de resultados (libros).
) {}
