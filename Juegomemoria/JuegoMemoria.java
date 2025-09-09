/*
 * Autor: Nathalie Valle
 * Carné: 251290
 * Carrera: Ingeniería en Ciencia de los Datos
 * Curso: CC2008 – Programación Orientada a Objetos
 * Semestre II, 2025
 * Descripción: Clase que representa una ficha del juego de memoria, con su símbolo, estado de visibilidad y emparejamiento.
 */

package Juegomemoria;


public class JuegoMemoria {

    public Tablero getTablero() {
        return tablero;
    }
    private Tablero tablero;
    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador turnoActual;

    public JuegoMemoria(Jugador j1, Jugador j2, Tablero tablero) {
        this.jugador1 = j1;
        this.jugador2 = j2;
        this.turnoActual = j1;
        this.tablero = tablero;
    }

    public boolean procesarTurno(int f1, int c1, int f2, int c2) {
        Ficha ficha1 = tablero.obtenerFicha(f1, c1);
        Ficha ficha2 = tablero.obtenerFicha(f2, c2);

        if (ficha1.estaEmparejada() || ficha2.estaEmparejada() || (f1 == f2 && c1 == c2)) {
            return false;
        }

        if (ficha1.esIgual(ficha2)) {
            ficha1.emparejar();
            ficha2.emparejar();
            turnoActual.sumarPunto();
            return true;
        } else {

            cambiarTurno();
            return false;
        }
    }
    public void ocultarSiNoPar(int f1, int c1, int f2, int c2) {
        Ficha ficha1 = tablero.obtenerFicha(f1, c1);
        Ficha ficha2 = tablero.obtenerFicha(f2, c2);
        if (!ficha1.estaEmparejada()) ficha1.ocultar();
        if (!ficha2.estaEmparejada()) ficha2.ocultar();
    }

    /**
     * Cambia el turno al otro jugador.
     */
    public void cambiarTurno() {
        turnoActual = (turnoActual == jugador1) ? jugador2 : jugador1;
    }

    public Jugador getTurnoActual() {
        return turnoActual;
    }

    public boolean juegoTerminado() {
        return tablero.todasEmparejadas();
    }

    public String obtenerVistaTablero() {
        return tablero.obtenerVistaTablero();
    }

    public String obtenerPuntajes() {
        return jugador1.getNombre() + ": " + jugador1.getPuntos() + " puntos\n" +
               jugador2.getNombre() + ": " + jugador2.getPuntos() + " puntos";
    }

    public String determinarGanador() {
        if (jugador1.getPuntos() > jugador2.getPuntos()) return "Ganó " + jugador1.getNombre();
        if (jugador2.getPuntos() > jugador1.getPuntos()) return "Ganó " + jugador2.getNombre();
        return "Empate";
    }
}