/*
 * Autor: Nathalie Valle
 * Carné: 251290
 * Carrera: Ingeniería en Ciencia de los Datos
 * Curso: CC2008 – Programación Orientada a Objetos
 * Semestre II, 2025
 * Descripción: Clase que representa una ficha del juego de memoria, con su símbolo, estado de visibilidad y emparejamiento.
 /* */
package Juegomemoria;

import java.util.*;

public class Tablero {
    private int filas;
    private int columnas;
    private Ficha[][] matriz;

    public Tablero(int filas, int columnas, List<String> simbolos) {
        this.filas = filas;
        this.columnas = columnas;
        this.matriz = new Ficha[filas][columnas];
        inicializar(simbolos);
    }

    private void inicializar(List<String> simbolos) {
        List<String> pares = new ArrayList<>();
        for (int i = 0; i < (filas * columnas) / 2; i++) {
            pares.add(simbolos.get(i));
            pares.add(simbolos.get(i));
        }
        Collections.shuffle(pares);

        int index = 0;
        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < columnas; c++) {
                matriz[f][c] = new Ficha(pares.get(index++));
            }
        }
    }

    public Ficha obtenerFicha(int f, int c) {
        return matriz[f][c];
    }

    public boolean todasEmparejadas() {
        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < columnas; c++) {
                if (!matriz[f][c].estaEmparejada()) return false;
            }
        }
        return true;
    }

    public String obtenerVistaTablero() {
        StringBuilder sb = new StringBuilder();
        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < columnas; c++) {
                sb.append(matriz[f][c].getSimbolo()).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}