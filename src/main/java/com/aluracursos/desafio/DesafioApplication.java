
package com.aluracursos.desafio; // Define el paquete donde se encuentra esta clase.
import com.aluracursos.desafio.principal.Principal;// Importa la clase Principal.
import org.springframework.boot.CommandLineRunner; // Importa la interfaz CommandLineRunner.
import org.springframework.boot.SpringApplication; // Importa la clase para ejecutar la aplicación.
import org.springframework.boot.autoconfigure.SpringBootApplication; // Importa la anotación para configurar la aplicación.

// Indica que esta clase es la aplicación principal de Spring Boot.
@SpringBootApplication
public class DesafioApplication implements CommandLineRunner { // Implementa CommandLineRunner para ejecutar código al inicio.

	public static void main(String[] args) { // Método principal para iniciar la aplicación.
		SpringApplication.run(DesafioApplication.class, args); // Ejecuta la aplicación usando Spring Boot.
	}

	@Override
	public void run(String... args) throws Exception { // Método que se ejecuta al iniciar la aplicación.
		Principal principal = new Principal(); // Crea una instancia de la clase Principal.
		principal.muestraElMenu(); // Llama al método muestraElMenu() de Principal para iniciar el programa.
	}
}

