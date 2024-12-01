package com.aluracursos.desafio.service;

// Interfaz genérica para convertir JSON a objetos Java.
public interface IConvierteDatos {
//     Método que recibe un JSON como String y una clase, devolviendo un objeto del tipo especificado.
    <T> T obtenerDatos(String json, Class<T> clase);
}
