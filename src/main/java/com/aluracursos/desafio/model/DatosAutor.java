package com.aluracursos.desafio.model;


import com.fasterxml.jackson.annotation.JsonAlias; // Importa la anotación para mapear nombres de campos.
import com.fasterxml.jackson.annotation.JsonIgnoreProperties; // Importa la anotación para ignorar campos desconocidos.

// Clase que representa los datos de un autor.
@JsonIgnoreProperties(ignoreUnknown = true) // Ignora campos no especificados en esta clase.
public record DatosAutor(
        @JsonAlias("name") String nombre,               // Mapea el campo "name" del JSON al atributo nombre.
        @JsonAlias("birth_year") String fechaDeNacimiento // Mapea el campo "birth_year" al atributo fechaDeNacimiento.
) {}
