package com.aluracursos.desafio.model;


import com.fasterxml.jackson.annotation.JsonAlias; // Importa la anotación para mapear nombres de campos.
import com.fasterxml.jackson.annotation.JsonIgnoreProperties; // Importa la anotación para ignorar campos desconocidos.

import java.util.List; // Importa la clase para manejar listas.

// Clase que representa los datos de un libro.
@JsonIgnoreProperties(ignoreUnknown = true) // Ignora campos no especificados en esta clase.
public record DatosLibros(
        @JsonAlias("title") String titulo,               // Mapea el campo "title" del JSON al atributo titulo.
        @JsonAlias("authors") List<DatosAutor> autor,    // Lista de autores mapeada desde "authors".
        @JsonAlias("languages") List<String> idiomas,    // Lista de idiomas mapeada desde "languages".
        @JsonAlias("download_count") Double numeroDeDescargas // Número de descargas mapeado desde "download_count".
) {}
