package juego2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase JuegoMemoria - Controladora de la lógica del juego
 * Autor: [Tu nombre]
 * Fecha: 05/09/2025
 */
class JuegoMemoria {
    private Tablero tablero;
    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador jugadorActual;
    private boolean juegoTerminado;
    private int paresRestantes;
    
    /**
     * Constructor que inicializa el juego completo con tablero y jugadores
     * @param filas número de filas del tablero
     * @param columnas número de columnas del tablero
     * @param nombreJugador1 nombre del primer jugador
     * @param nombreJugador2 nombre del segundo jugador
     */
    public JuegoMemoria(int filas, int columnas, String nombreJugador1, String nombreJugador2) {
        this.tablero = new Tablero(filas, columnas);
        this.jugador1 = new Jugador(nombreJugador1);
        this.jugador2 = new Jugador(nombreJugador2);
        this.jugadorActual = jugador1;
        this.juegoTerminado = false;
        this.paresRestantes = (filas * columnas) / 2;
    }
    
    public JuegoMemoria(Tablero tablero2, Jugador jugador12, Jugador jugador22) {
        //TODO Auto-generated constructor stub
    }

    /**
     * Método principal que ejecuta el bucle del juego hasta que el jugador decida
     */
    public void jugar() {
        // El juego se maneja desde Principal
        // Esta clase solo procesa la lógica
    }
    
    /**
     * Maneja la lógica de un turno completo de un jugador
     */
    public void procesarTurno() {
        // La entrada de datos se maneja desde Principal
        // Este método procesa las jugadas recibidas
    }
    
    /**
     * Procesa una jugada específica con coordenadas dadas
     * @param fila1 coordenada de fila de la primera ficha
     * @param columna1 coordenada de columna de la primera ficha
     * @param fila2 coordenada de fila de la segunda ficha
     * @param columna2 coordenada de columna de la segunda ficha
     */
    public void procesarJugada(int fila1, int columna1, int fila2, int columna2) {
    // Registrar intento
    jugadorActual.registrarIntento(1);

    // Revelar las fichas seleccionadas
    tablero.revelarFicha(fila1, columna1);
    tablero.revelarFicha(fila2, columna2);

    // Mostrar tablero con fichas visibles
    System.out.println("\n--- Fichas reveladas ---");
    tablero.mostrarTablero();

    // Esperar que el jugador vea las fichas
    System.out.println("Presiona ENTER para continuar...");
    new Scanner(System.in).nextLine(); // pausa hasta ENTER

    // Evaluar coincidencia
    if (evaluarJugada(fila1, columna1, fila2, columna2)) {
        System.out.println("¡Correcto! " + jugadorActual.getNombre() + " encontró un par.");
        jugadorActual.incrementarPuntuacion();
        tablero.marcarEmparejadas(fila1, columna1, fila2, columna2);

        // Guardar par
        ArrayList<Ficha> par = new ArrayList<>();
        par.add(tablero.getFicha(fila1, columna1));
        par.add(tablero.getFicha(fila2, columna2));
        jugadorActual.agregarParEncontrado(par);

        paresRestantes--;
    } else {
        System.out.println("No coinciden. Turno perdido.");
        // Ocultar si no es par
        tablero.ocultarFicha(fila1, columna1);
        tablero.ocultarFicha(fila2, columna2);
        cambiarTurno();
    }
}

    
    /**
     * Pide al usuario las coordenadas de las dos fichas a revelar y las valida
     * @return int[] array con las coordenadas [fila1, columna1, fila2, columna2]
     */
    public int[] solicitarJugada() {
        // Este método ahora solo retorna las coordenadas
        // La lógica de entrada se maneja desde Principal
        return new int[4];
    }
    
    /**
     * Determina si las dos fichas coinciden
     * @param fila1 coordenada de fila de la primera ficha
     * @param columna1 coordenada de columna de la primera ficha
     * @param fila2 coordenada de fila de la segunda ficha
     * @param columna2 coordenada de columna de la segunda ficha
     * @return boolean si las fichas coinciden
     */
    public boolean evaluarJugada(int fila1, int columna1, int fila2, int columna2) {
        return tablero.getFicha(fila1, columna1).getSimbolo().equals(
               tablero.getFicha(fila2, columna2).getSimbolo());
    }
    
    /**
     * Alterna el jugador activo y gestiona que alteren los turnos
     */
    public void cambiarTurno() {
        jugadorActual = (jugadorActual == jugador1) ? jugador2 : jugador1;
    }
    
    /**
     * Determina si todas las fichas ya son visibles
     * @return boolean si el juego ha terminado
     */
    public boolean verificarFinJuego() {
        return paresRestantes == 0;
    }
    
    /**
     * Presenta la puntuación final y declara al ganador
     */
    public void mostrarResultados() {
        System.out.println("\n=== JUEGO TERMINADO ===");
        System.out.println("Resultados finales:");
        System.out.println(jugador1.getNombre() + ": " + jugador1.getIntentos() + " pares encontrados, " + jugador1.getIntentos() + " intentos");
        System.out.println(jugador2.getNombre() + ": " + jugador2.getIntentos() + " pares encontrados, " + jugador2.getIntentos() + " intentos");
        
        if (jugador1.getIntentos() > jugador2.getIntentos()) {
            System.out.println("¡Ganador: " + jugador1.getNombre() + "!");
        } else if (jugador2.getIntentos() > jugador1.getIntentos()) {
            System.out.println("¡Ganador: " + jugador2.getNombre() + "!");
        } else {
            System.out.println("¡Empate!");
        }
    }
    
    /**
     * Reinicia el estado del juego para una nueva partida
     */
    public void reiniciarJuego() {
        jugador1 = new Jugador(jugador1.getNombre());
        jugador2 = new Jugador(jugador2.getNombre());
        jugadorActual = jugador1;
        juegoTerminado = false;
        paresRestantes = (tablero.getFilas() * tablero.getColumnas()) / 2;
        tablero.inicializarFichas();
    }
    
    /**
     * Retorna el jugador actual
     * @return Jugador jugador actual
     */
    public Jugador getJugadorActual() {
        return jugadorActual;
    }
    
    /**
     * Retorna el primer jugador
     * @return Jugador primer jugador
     */
    public Jugador getJugador1() {
        return jugador1;
    }
    
    /**
     * Retorna el segundo jugador
     * @return Jugador segundo jugador
     */
    public Jugador getJugador2() {
        return jugador2;
    }
    
    /**
     * Retorna el tablero
     * @return Tablero tablero actual
     */
    public Tablero getTablero() {
        return tablero;
    }
    
    /**
     * Verifica si una jugada es válida
     * @param fila coordenada de fila
     * @param columna coordenada de columna
     * @return boolean si la jugada es válida
     */
    public boolean esJugadaValida(int fila, int columna) {
        return tablero.jugadaValida(fila, columna);
    }
}