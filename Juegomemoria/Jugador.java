/*
 * Autor: Nathalie Valle
 * Carné: 251290
 * Carrera: Ingeniería en Ciencia de los Datos
 * Curso: CC2008 – Programación Orientada a Objetos
 * Semestre II, 2025
 * Descripción: Clase que representa una ficha del juego de memoria, con su símbolo, estado de visibilidad y emparejamiento.
 /* */
package Juegomemoria;

public class Jugador {
    private String nombre;
    private int puntos;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntos = 0;
    }
    public void sumarPunto() {
        puntos++;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntos() {
        return puntos;
    }
}