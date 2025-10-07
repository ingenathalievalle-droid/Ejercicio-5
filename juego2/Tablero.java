package juego2;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Clase Tablero - Maneja la estructura bidimensional del juego
 * Autor: [Tu nombre]
 * Fecha: 05/09/2025
 */
class Tablero {
    private Ficha[][] fichas;
    private int filas;
    private int columnas;
    private char[] simbolosDisponibles = {'☺','☹','♥','♦','♣','♠','♪','♫','☀','☁','☂','★','☆','✓','✗','☮','☯','⚑','☕','⚡'};
    
    /**
     * Constructor que crea el tablero con las dimensiones especificadas
     * @param filas número de filas del tablero
     * @param columnas número de columnas del tablero
     */
    public Tablero(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.fichas = new Ficha[filas][columnas];
        inicializarFichas();
    }
    
    /**
     * Crea y distribuye aleatoriamente los pares de fichas en todo el tablero
     */
    public void inicializarFichas() {
        ArrayList<String> simbolos = new ArrayList<>();
        int totalFichas = filas * columnas;
        
        // Agregar pares de símbolos
        for (int i = 0; i < totalFichas / 2; i++) {
            String simbolo = String.valueOf(simbolosDisponibles[i % simbolosDisponibles.length]);
            simbolos.add(simbolo);
            simbolos.add(simbolo);
        }
        
        // Mezclar símbolos aleatoriamente
        Collections.shuffle(simbolos);
        
        // Asignar símbolos a las fichas
        int index = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                fichas[i][j] = new Ficha(simbolos.get(index++));
            }
        }
    }
    
    /**
     * Presenta el estado actual del tablero
     */
    public void mostrarTablero() {
    System.out.print("   ");
    for (int j = 0; j < columnas; j++) {
        System.out.print("  " + (j + 1));
    }
    System.out.println();

    for (int i = 0; i < filas; i++) {
        System.out.print((i + 1) + "  ");
        for (int j = 0; j < columnas; j++) {
            if (fichas[i][j].esRevelada() || fichas[i][j].esEmparejada()) {
                System.out.print(fichas[i][j].getSimbolo() + "  ");
            } else {
                System.out.print("X  ");
            }
        }
        System.out.println();
    }
}

    
    /**
     * Valida si la selección es permitida
     * @param fila coordenada de fila
     * @param columna coordenada de columna
     * @return boolean si la jugada es válida
     */
    public boolean jugadaValida(int fila, int columna) {
        if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas) {
            return false;
        }
        return !fichas[fila][columna].esEmparejada() && !fichas[fila][columna].esRevelada();
    }
    
    /**
     * Cambia el estado de ficha a revelada
     * @param fila coordenada de fila
     * @param columna coordenada de columna
     */
    public void revelarFicha(int fila, int columna) {
        fichas[fila][columna].setRevelada(true);
    }
    
    /**
     * Cambia el estado de ficha a oculta
     * @param fila coordenada de fila
     * @param columna coordenada de columna
     */
    public void ocultarFicha(int fila, int columna) {
        fichas[fila][columna].setRevelada(false);
    }
    
    /**
     * Marca un par de fichas como emparejadas permanentemente
     * @param fila1 coordenada de fila de la primera ficha
     * @param columna1 coordenada de columna de la primera ficha
     * @param fila2 coordenada de fila de la segunda ficha
     * @param columna2 coordenada de columna de la segunda ficha
     */
    public void marcarEmparejadas(int fila1, int columna1, int fila2, int columna2) {
        fichas[fila1][columna1].setEmparejada(true);
        fichas[fila2][columna2].setEmparejada(true);
    }

    
    
    /**
     * Retorna una ficha en las coordenadas específicas
     * @param fila coordenada de fila
     * @param columna coordenada de columna
     * @return Ficha in the specified position
     */
    public Ficha getFicha(int fila, int columna) {
        return fichas[fila][columna];
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }
}