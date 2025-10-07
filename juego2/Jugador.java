package juego2;

import java.util.ArrayList;

/**
 * Clase Jugador - Representa a los participantes del juego
 * Autor: [Tu nombre]
 * Fecha: 05/09/2025
 */
class Jugador {
    private String nombre;
    private int puntuacion;
    private ArrayList<ArrayList<Ficha>> paresEncontrados;
    private int intentos;

    /**
     * Constructor que inicializa un jugador con puntuación de 0
     * @param nombre String nombre del jugador
     */
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntuacion = 0;
        this.paresEncontrados = new ArrayList<>();
        this.intentos = 0;
    }

    /**
     * Retorna el nombre del jugador
     * @return String nombre del jugador
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Retorna la puntuación actual del jugador
     * @return int puntuación actual
     */
    public int getPuntuacion() {
        return puntuacion;
    }

    /**
     * Aumenta la puntuación en uno cuando el jugador encuentra un par
     */
    public void incrementarPuntuacion() {
        puntuacion++;
    }

    /**
     * Añade un par a la lista de pares encontrados
     * @param par ArrayList<Ficha> par encontrado
     */
    public void agregarParEncontrado(ArrayList<Ficha> par) {
        paresEncontrados.add(par);
    }

    /**
     * Registra un intento del jugador
     * @param numeroIntentos int número de intentos
     */
    public void registrarIntento(int numeroIntentos) {
        this.intentos += numeroIntentos;
    }

    /**
     * Retorna el número total de intentos del jugador
     * @return int número de intentos
     */
    public int getIntentos() {
        return intentos;
    }

    /**
     * Retorna la lista de pares encontrados
     * @return ArrayList<ArrayList<Ficha>> pares encontrados
     */
    public ArrayList<ArrayList<Ficha>> getParesEncontrados() {
        return paresEncontrados;
    }
}