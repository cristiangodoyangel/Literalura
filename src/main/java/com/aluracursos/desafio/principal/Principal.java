package com.aluracursos.desafio.principal;

import com.aluracursos.desafio.model.Datos;
import com.aluracursos.desafio.model.DatosLibros;
import com.aluracursos.desafio.service.ConsumoAPI;
import com.aluracursos.desafio.service.ConvierteDatos;

import java.util.DoubleSummaryStatistics;
import java.util.Optional;
import java.util.Scanner;

import java.util.Comparator;
import java.util.stream.Collectors;


// Clase principal que contiene la lógica del programa.
public class Principal {
    private static final String URL_BASE = "https://gutendex.com/books/"; // URL base de la API.
    private ConsumoAPI consumoAPI = new ConsumoAPI();                    // Instancia para consumir datos de la API.
    private ConvierteDatos conversor = new ConvierteDatos();             // Instancia para convertir JSON.
    private Scanner teclado = new Scanner(System.in);                    // Scanner para entrada del usuario.

    // Método que muestra el menú principal.
    public void muestraElMenu() {
        // Descarga datos iniciales desde la API.
        var json = consumoAPI.obtenerDatos(URL_BASE);

        // Convierte el JSON descargado a un objeto de tipo Datos.
        var datos = conversor.obtenerDatos(json, Datos.class);

        // Top 10 libros más descargados.
        System.out.println("Top 10 libros más descargados:");
        datos.resultados().stream() // Crea un Stream con los resultados.
                .sorted(Comparator.comparing(DatosLibros::numeroDeDescargas).reversed()) // Ordena por descargas en orden descendente.
                .limit(10) // Toma los 10 primeros resultados.
                .map(l -> l.titulo().toUpperCase()) // Convierte los títulos a mayúsculas.
                .forEach(System.out::println); // Imprime los títulos.

        // Búsqueda de libros por nombre.
        System.out.println("\nIngrese el nombre del libro que desea buscar:");
        var tituloLibro = teclado.nextLine(); // Lee el nombre del libro ingresado por el usuario.
        json = consumoAPI.obtenerDatos(URL_BASE + "?search=" + tituloLibro.replace(" ", "+")); // Ajusta la URL para la búsqueda.
        var datosBusqueda = conversor.obtenerDatos(json, Datos.class); // Convierte el JSON de búsqueda a objetos.

        // Filtra los resultados para encontrar el primer libro que coincida.
        Optional<DatosLibros> libroBuscado = datosBusqueda.resultados().stream()
                .filter(l -> l.titulo().toUpperCase().contains(tituloLibro.toUpperCase())) // Busca coincidencias en títulos.
                .findFirst(); // Toma el primer resultado.

        if (libroBuscado.isPresent()) { // Si se encuentra un libro.
            System.out.println("Libro encontrado:");
            System.out.println(libroBuscado.get()); // Imprime los datos del libro.
        } else { // Si no se encuentra un libro.
            System.out.println("Libro no encontrado.");
        }

        // Calcula estadísticas de descargas.
        DoubleSummaryStatistics est = datos.resultados().stream() // Crea un Stream con los resultados.
                .filter(d -> d.numeroDeDescargas() > 0) // Filtra los libros con más de 0 descargas.
                .collect(Collectors.summarizingDouble(DatosLibros::numeroDeDescargas)); // Calcula estadísticas.

        // Imprime estadísticas.
        System.out.println("\nEstadísticas de descargas:");
        System.out.println("Promedio de descargas: " + est.getAverage());
        System.out.println("Máximo de descargas: " + est.getMax());
        System.out.println("Mínimo de descargas: " + est.getMin());
        System.out.println("Cantidad de libros evaluados: " + est.getCount());
    }
}
